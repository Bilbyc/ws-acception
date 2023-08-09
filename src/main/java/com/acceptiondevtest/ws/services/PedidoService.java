package com.acceptiondevtest.ws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acceptiondevtest.ws.entities.Pedido;
import com.acceptiondevtest.ws.repositories.LojaRepository;
import com.acceptiondevtest.ws.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	@Autowired
	private LojaRepository lojaRepository;
	
	public Pedido insert(Pedido obj) {
		lojaRepository.save(obj.getLoja());
		
		return repository.save(obj);
	};

}
