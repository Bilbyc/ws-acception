package com.acceptiondevtest.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acceptiondevtest.ws.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String>{

}
