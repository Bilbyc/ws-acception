package com.acceptiondevtest.ws.entities;

import java.time.LocalDate;

import com.acceptiondevtest.ws.entities.enums.TipoTransacao;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private TipoTransacao tipoTransacao;
	private LocalDate data;
	private int numParcela;
	private double valor;
	@ManyToOne
	@JoinColumn(name = "pagamento_authcode")
	private Pagamento pagamento;
	private boolean enviado; 
	
	public Agendamento() {
		
	}

	public Agendamento(Long id, TipoTransacao tipoTransacao, LocalDate data, int numParcela, double valor, Pagamento pagamento) {
		this.id = id;
		this.tipoTransacao = tipoTransacao;
		this.data = data;
		this.numParcela = numParcela;
		this.valor = valor;
		this.pagamento = pagamento;
		this.enviado = false;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipo(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getNumParcela() {
		return numParcela;
	}

	public void setNumParcela(int numParcela) {
		this.numParcela = numParcela;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	};
	
	public void setAuthCode(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public boolean isEnviado() {
		return enviado;
	}

	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}
	
	
	
	
	
	
	
	
	
}


