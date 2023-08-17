package com.acceptiondevtest.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acceptiondevtest.ws.entities.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, String>{

}
