package com.acceptiondevtest.ws.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acceptiondevtest.ws.entities.Pedido;
import com.acceptiondevtest.ws.repositories.LojaRepository;
import com.acceptiondevtest.ws.repositories.PedidoRepository;

@Service
public class PedidoService {

	private final List<Pedido> bufferedPedidos = Collections.synchronizedList(new ArrayList<>());
	private static final int BATCH_SIZE = 20000; 

	@Autowired
	private PedidoRepository repository;
	@Autowired
	private LojaRepository lojaRepository;


	public void insert(Pedido obj) {
		bufferedPedidos.add(obj);
		
        if (bufferedPedidos.size() >= BATCH_SIZE) {
            insertBatch(obj);
        }
	};
	
	private synchronized void insertBatch(Pedido obj) {
        if (!bufferedPedidos.isEmpty()) {
        	lojaRepository.save(obj.getLoja());
            repository.saveAll(bufferedPedidos);

            bufferedPedidos.clear();
        }
    }
}
