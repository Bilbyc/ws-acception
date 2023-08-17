package com.acceptiondevtest.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acceptiondevtest.ws.entities.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, String>{
	
	Pagamento findOneBycodigoAutorizacao(String codigoAutorizacao);

}
