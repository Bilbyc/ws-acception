package com.acceptiondevtest.ws.entities;

import com.acceptiondevtest.ws.entities.enums.Bandeira;
import com.acceptiondevtest.ws.entities.enums.TipoTransacao;

public class Pagamento {
	private String tipo;
	private TipoTransacao tipoTransacao;
	private int parcelas;
	private String cartao;
	private String codigoAutorizacao;
	private int nsu;
	private Bandeira bandeira;
	private double valor;
	
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
	};
	
	
	
	
	
	
	
	
}
