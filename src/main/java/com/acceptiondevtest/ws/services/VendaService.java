package com.acceptiondevtest.ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acceptiondevtest.ws.entities.Venda;
import com.acceptiondevtest.ws.repositories.VendaRepository;

@Service
public class VendaService {
	@Autowired
	private VendaRepository repository;
	
	public List<Venda> insertAll(List<Venda> obj) {
		
		return repository.saveAll(obj);
		
	};
	
public Venda insert(Venda obj) {
		
		return repository.save(obj);
		
	};
}
