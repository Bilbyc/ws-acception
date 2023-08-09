package com.acceptiondevtest.ws.entities;

public class Pagamento {
	private String tipo;
	private String tipoTransacao;
	private int parcelas;
	private String cartao;
	private String codigoAutorizacao;
	private int nsu;
	private String bandeira;
	private double valor;
	
	public Pagamento() {
		
	}

	public Pagamento(String tipo, String tipoTransacao, int parcelas, String cartao, String codigoAutorizacao, int nsu,
			String bandeira, double valor) {
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

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
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

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	};
	
	
	
	
	
	
	
	
}
