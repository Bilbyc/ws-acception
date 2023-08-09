package com.acceptiondevtest.ws.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.acceptiondevtest.ws.entities.Loja;
import com.acceptiondevtest.ws.entities.Pagamento;
import com.acceptiondevtest.ws.entities.Pedido;
import com.acceptiondevtest.ws.entities.enums.Bandeira;
import com.acceptiondevtest.ws.entities.enums.TipoTransacao;
import com.acceptiondevtest.ws.repositories.LojaRepository;
import com.acceptiondevtest.ws.repositories.PagamentoRepository;
import com.acceptiondevtest.ws.repositories.PedidoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private LojaRepository lojaRepository;

	@Override
	public void run(String... args) throws Exception {
		Loja loja = new Loja("L001", "03235289000116");
		Loja loja2 = new Loja("L001", "03235289000116");
		
		lojaRepository.saveAll(Arrays.asList(loja, loja2));
		
		Pagamento pagamento = new Pagamento("CARTAO", TipoTransacao.CREDITO, 3, "123456*1234", "AAA001", 7965, Bandeira.VISA, 100.00);
		List<Pagamento> pagamentos = new ArrayList<>();
		pagamentos.add(pagamento);
		
		Pagamento pagamento2 = new Pagamento("CARTAO", TipoTransacao.DEBITO, 3, "123456*1234", "BBB002", 8522, Bandeira.ELO, 50.0);
		List<Pagamento> pagamentos2 = new ArrayList<>();
		pagamentos2.add(pagamento2);
		
		pagamentoRepository.saveAll(Arrays.asList(pagamento));
				
		Pedido p = new Pedido("P0000001", 100.0, LocalDate.now(), true, loja, pagamentos);
		Pedido ped = new Pedido("P0000002", 50.0, LocalDate.now(), true, loja2, pagamentos2);
		
		pedidoRepository.saveAll(Arrays.asList(p, ped));
	}

}
