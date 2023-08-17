package com.acceptiondevtest.ws.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acceptiondevtest.ws.entities.Agendamento;
import com.acceptiondevtest.ws.entities.Pagamento;
import com.acceptiondevtest.ws.entities.Venda;
import com.acceptiondevtest.ws.entities.enums.TipoTransacao;
import com.acceptiondevtest.ws.repositories.AgendamentoRepository;
import com.acceptiondevtest.ws.repositories.PagamentoRepository;
import com.acceptiondevtest.ws.repositories.PedidoRepository;
import com.acceptiondevtest.ws.repositories.VendaRepository;

@Service
public class PagamentoService {
	
	@Autowired 
	PagamentoRepository repository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	VendaRepository vendaRepository;
	
	@Autowired
	AgendamentoRepository agendamentoRepository;
	
	public List<Pagamento> getValidPagamentos() {
		
		List<Pagamento> validPagamentos = new ArrayList<>();
		
		List<Venda> vendas = vendaRepository.findAll();
		
		for(Venda venda: vendas) {
			validPagamentos.add(repository.findOneBycodigoAutorizacao(venda.getCodigoAutorizacao()));
		}
		
		return validPagamentos;
	}
	
	public void setAgendamentos() {
		List <Pagamento> pagamentos = new ArrayList<>();
		List <Agendamento> agendamentos = new ArrayList<>();
		
		
		pagamentos = getValidPagamentos();
		
		for(Pagamento pagamento: pagamentos) {
			
			Venda venda = vendaRepository.findByNsu(pagamento.getNsu());
			
			if (pagamento.getParcelas() > 0) {
				for(int i = 1; i <= pagamento.getParcelas(); i++) {
					LocalDate convertedDate = convertToValidDate(pagamento.getPedido().getData(), pagamento.getTipoTransacao(), i);
					double valor = setValueByInstallment(i, pagamento, venda);
							
					agendamentos.add(new Agendamento(null, pagamento.getTipoTransacao(), convertedDate, i, valor, pagamento));
				}
			}
			
			if (pagamento.getParcelas() == 0) {
				double valor = setValueByInstallment(0, pagamento, venda);
				LocalDate convertedDate = convertToValidDate(pagamento.getPedido().getData(), pagamento.getTipoTransacao(), 0);
				agendamentos.add(new Agendamento(null, pagamento.getTipoTransacao(), convertedDate, 0, valor, pagamento));
			}
		};
		
		agendamentoRepository.saveAll(agendamentos);
		
		
	}
	
	private LocalDate convertToValidDate(LocalDate date, TipoTransacao tipoTransacao, int parcelas) {
		if (tipoTransacao == TipoTransacao.DEBITO) 
			date = date.plusDays(1);
		
		if (tipoTransacao == TipoTransacao.CREDITO) 
			date = date.plusDays(30 * parcelas);
		
		Boolean isSabado = date.getDayOfWeek() == DayOfWeek.SATURDAY;
		Boolean isDomingo = date.getDayOfWeek() == DayOfWeek.SUNDAY;
		
		if (isSabado) 
			date = date.plusDays(2);
		
		if (isDomingo) 
			date = date.plusDays(1);
		
		
		
		return date;
	};
	
	private double setValueByInstallment(int parcela, Pagamento pagamento, Venda venda) {
		double valor = pagamento.getValor();
		int parcelasTotais = pagamento.getParcelas();
		double taxaTransacao = venda.getTaxaTransacao();
		
		if(parcela == 0) {
			return valor + taxaTransacao;
		}
		
		double valorTotal = valor + (parcelasTotais * taxaTransacao);
		double valorParcela = valorTotal/parcelasTotais;
		
		if(parcela == 1) {
			double dizimaPeriodica = valorTotal - (valorParcela * parcelasTotais);
			
			return ((long) ((valorParcela + dizimaPeriodica) * 100)) / 100.0;
		}
		
		return ((long) ((valorParcela) * 100)) / 100.0;
	};

}
