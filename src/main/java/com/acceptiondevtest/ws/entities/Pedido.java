package com.acceptiondevtest.ws.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private double valor;
	private LocalDate data;
	private boolean faturado;
	private Loja loja;
	private Pagamento[] pagamentos;
	
	public Pedido() {
		
	}

	public Pedido(String codigo, double valor, LocalDate data, boolean faturado, Loja loja, Pagamento[] pagamentos) {
		this.codigo = codigo;
		this.valor = valor;
		this.data = data;
		this.faturado = faturado;
		this.loja = loja;
		this.pagamentos = pagamentos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public boolean isFaturado() {
		return faturado;
	}

	public void setFaturado(boolean faturado) {
		this.faturado = faturado;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Pagamento[] getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(Pagamento[] pagamentos) {
		this.pagamentos = pagamentos;
	};
	
	
	
	
}
