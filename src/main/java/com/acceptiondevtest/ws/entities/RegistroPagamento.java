package com.acceptiondevtest.ws.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class RegistroPagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data;
	private String cnpj;
	private double valorPagamento;
	private String agrupamento;
	
	public RegistroPagamento() {
		
	}

	public RegistroPagamento(Long id, LocalDate data, String cnpj, double valorPagamento, String agrupamento) {
		this.id = id;
		this.data = data;
		this.cnpj = cnpj;
		this.valorPagamento = valorPagamento;
		this.agrupamento = agrupamento;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public String getAgrupamento() {
		return agrupamento;
	}

	public void setAgrupamento(String agrupamento) {
		this.agrupamento = agrupamento;
	}
	
	public String[] toStringArray() {
		
	    return new String[]{
	        data.format(DateTimeFormatter.ofPattern("ddMMyyyy")),
	        cnpj,
	        NumberFormat.getInstance().format(valorPagamento),
	        agrupamento
	    };
	}
	

}
