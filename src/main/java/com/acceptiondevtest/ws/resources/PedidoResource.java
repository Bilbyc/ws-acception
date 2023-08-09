package com.acceptiondevtest.ws.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.acceptiondevtest.ws.entities.Loja;
import com.acceptiondevtest.ws.entities.Pagamento;
import com.acceptiondevtest.ws.entities.Pedido;
import com.acceptiondevtest.ws.entities.enums.Bandeira;
import com.acceptiondevtest.ws.entities.enums.TipoTransacao;
import com.acceptiondevtest.ws.services.PedidoService;

@RestController
@RequestMapping(value = "ws/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<Pedido> findAll(){
		Loja loja = new Loja("L001", "03235289000116");
		List<Pagamento> pagamentos = new ArrayList<>();
		Pagamento pagamento = new Pagamento("CARTAO", TipoTransacao.CREDITO, 3, "123456*1234", "AAA001", 7965, Bandeira.VISA, 100.00);
		pagamentos.add(pagamento);
		
		Pedido p = new Pedido("P0000001", 100.0, LocalDate.now(), true, loja, pagamentos);
		
		return ResponseEntity.ok().body(p);
	};
	
	@PostMapping 
	public ResponseEntity<Pedido> insert(@RequestBody Pedido obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(obj.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	};
	

}
