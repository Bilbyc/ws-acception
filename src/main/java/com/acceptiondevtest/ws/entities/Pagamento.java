package com.acceptiondevtest.ws.entities;

import java.io.Serializable;


import com.acceptiondevtest.ws.entities.enums.Bandeira;
import com.acceptiondevtest.ws.entities.enums.TipoTransacao;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String tipo;
	@Enumerated(EnumType.STRING)
	private TipoTransacao tipoTransacao;
	private int parcelas;
	private String cartao;
	@Id
	private String codigoAutorizacao;
	private int nsu;
	@Enumerated(EnumType.STRING)
	private Bandeira bandeira;
	private double valor;
	@ManyToOne
	@JoinColumn(name = "pedido_codigo")
	private Pedido pedido;
	
	public Pagamento() {
		
	}

	public Pagamento(String tipo, TipoTransacao tipoTransacao, int parcelas, String cartao, String codigoAutorizacao, int nsu,
			Bandeira bandeira, double valor) {
		this.tipo = tipo;
		this.tipoTransacao = tipoTransacao;
		this.parcelas = parcelas;
		this.cartao = cartao;
		this.codigoAutorizacao = codigoAutorizacao;
		this.nsu = nsu;
		this.bandeira = bandeira;
		this.valor = valor;
	}
	
	@PrePersist
    @PreUpdate
    public void formatDouble() {
		this.valor = Math.round(this.valor / 100.0 * 100.0) / 100.0;
    }
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getCodigoAutorizacao() {
		return codigoAutorizacao;
	}

	public void setCodigoAutorizacao(String codigoAutorizacao) {
		this.codigoAutorizacao = codigoAutorizacao;
	}

	public int getNsu() {
		return nsu;
	}

	public void setNsu(int nsu) {
		this.nsu = nsu;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pedido getPedido() {
		return pedido;
	}

	
	
	
	
	
	
	
	
	
	
	
}
