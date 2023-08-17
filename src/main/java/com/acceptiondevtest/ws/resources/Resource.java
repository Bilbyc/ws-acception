package com.acceptiondevtest.ws.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acceptiondevtest.ws.entities.Pedido;
import com.acceptiondevtest.ws.entities.RegistroPagamento;
import com.acceptiondevtest.ws.services.PagamentoService;
import com.acceptiondevtest.ws.services.PedidoService;
import com.acceptiondevtest.ws.services.RegistroPagamentoService;
import com.acceptiondevtest.ws.services.SftpService;


@RestController
@RequestMapping(value = "ws")
public class Resource {
	
	@Autowired
	private PedidoService service;
	
	@Autowired
	private SftpService sftp;
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@Autowired
	private RegistroPagamentoService registroPagamentoService;
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/pedidos")
	public ResponseEntity<String> insertMany(@RequestBody Pedido obj) {
		try {
			
			service.insert(obj);
			
			return ResponseEntity.ok().body("Submissões processadas com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body("Erro no recebimento das submissões");
		}
	};
	
	
	@PostMapping(value = "/getcsv")
	public ResponseEntity<String> insertVendas() {
		try {
			
			sftp.getData("/data/out/ACC01.csv");
		
			return ResponseEntity.ok().body("Arquivo CSV processado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body("Arquivo CSV com erros.");
		}
	};
	
	@PostMapping(value = "/gerar-agendamentos")
	public ResponseEntity<String> gerarTransacoes() {
		try {
			
			pagamentoService.setAgendamentos();
		
			return ResponseEntity.ok().body("Arquivo CSV processado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body("Arquivo CSV com erros.");
		}
	};
	
	@PostMapping(value = "/sendcsv")
	public ResponseEntity<String> gerarArquivo() {
		try {
			
			List<RegistroPagamento> data = registroPagamentoService.buildRegistros();
			sftp.sendData(data);
		
			return ResponseEntity.ok().body("Arquivo CSV gerado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body("Arquivo CSV com erros.");
		}
	};
	
	
}
