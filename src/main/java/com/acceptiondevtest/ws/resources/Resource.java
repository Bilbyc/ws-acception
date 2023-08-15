package com.acceptiondevtest.ws.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acceptiondevtest.ws.entities.Pedido;
import com.acceptiondevtest.ws.services.PedidoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(value = "ws")
public class Resource {
	
	@Autowired
	private PedidoService service;
	
	@Autowired
	private SftpResource sftp;
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/pedido")
	public ResponseEntity<String> insertMany(@RequestBody String obj) {
		try {
			Pedido readValues = new ObjectMapper().readValue(
					obj, new TypeReference<Pedido>() {});
			
			service.insert(readValues);
						
			return ResponseEntity.ok().body("Submissões processadas com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body("Erro no recebimento das submissões");
		}
	};
	
	@PostMapping(value = "/vendas")
	public ResponseEntity<String> insertVendas() {
		try {
			
			sftp.getData("/data/out/ACC01.csv");
		
			return ResponseEntity.ok().body("Arquivo CSV processado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body("Arquivo CSV com erros.");
		}
	
	}
}
