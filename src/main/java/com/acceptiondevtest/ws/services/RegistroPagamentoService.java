package com.acceptiondevtest.ws.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acceptiondevtest.ws.entities.RegistroPagamento;
import com.acceptiondevtest.ws.entities.enums.Bandeira;
import com.acceptiondevtest.ws.entities.Agendamento;

import com.acceptiondevtest.ws.repositories.AgendamentoRepository;
import com.acceptiondevtest.ws.repositories.PagamentoRepository;
import com.acceptiondevtest.ws.repositories.RegistroPagamentoRepository;
import com.acceptiondevtest.ws.repositories.VendaRepository;

@Service
public class RegistroPagamentoService {

	@Autowired
	AgendamentoRepository agendamentoRepository;

	@Autowired
	VendaRepository vendaRepository;

	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	RegistroPagamentoRepository repository;

	public List<RegistroPagamento> buildRegistros() {

		List<RegistroPagamento> registros = new ArrayList<>();
		List<Agendamento> agendamentos = agendamentoRepository.findAll();

		for (Agendamento agendamento : agendamentos) {

			agendamento.setEnviado(true);
			String cnpj = agendamento.getPagamento().getPedido().getLoja().getCnpj();
			Bandeira bandeira = agendamento.getPagamento().getBandeira();
			String agrupamento = bandeira + "x" + agendamento.getTipoTransacao();

			registros.add(new RegistroPagamento(null, agendamento.getData(), cnpj, agendamento.getValor(), agrupamento));
		}

		List<RegistroPagamento> registrosBuildados= new ArrayList<>();
		
		registrosBuildados = processRegistros(registros);
		
		repository.saveAll(registrosBuildados);
		
		return registrosBuildados;
	}

	
	public List<RegistroPagamento> processRegistros(List<RegistroPagamento> registros) {

	    List<String> agrupamentos = Arrays.asList(
	            "VISAxDEBITO", "VISAxCREDITO", 
	            "MASTERCARDxDEBITO", "MASTERCARDxCREDITO", 
	            "ELOxDEBITO", "ELOxCREDITO"
	    );

	    Set<String> cnpjsUnicos = registros.stream()
	                                      .map(RegistroPagamento::getCnpj)
	                                      .collect(Collectors.toSet());

	    List<RegistroPagamento> registrosAgregados = new ArrayList<>();

	    for (String cnpj : cnpjsUnicos) {
	        for (String agrupamento : agrupamentos) {
	            
	         
	            Map<LocalDate, Double> valorPorData = registros.stream()
	                                                          .filter(registro -> registro.getCnpj().equals(cnpj) && registro.getAgrupamento().equals(agrupamento))
	                                                          .collect(Collectors.groupingBy(
	                                                                  RegistroPagamento::getData,
	                                                                  Collectors.summingDouble(RegistroPagamento::getValorPagamento)
	                                                          ));

	            for (Map.Entry<LocalDate, Double> entry : valorPorData.entrySet()) {
	                registrosAgregados.add(new RegistroPagamento(null, entry.getKey(), cnpj, entry.getValue(), agrupamento));
	            }
	        }
	    }

	    return registrosAgregados;
	}
	
};
