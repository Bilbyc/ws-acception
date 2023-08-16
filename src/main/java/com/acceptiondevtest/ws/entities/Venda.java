package com.acceptiondevtest.ws.entities;

import java.io.Serializable;
import java.time.LocalDate;


import com.acceptiondevtest.ws.entities.enums.Bandeira;
import com.acceptiondevtest.ws.entities.enums.TipoTransacao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Venda implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private int tipoRegistro;
	private LocalDate dataVenda;
	private String cartao;
	private String codigoAutorizacao;
	
	@Id
	private int nsu;
	private Bandeira bandeira;
	private int parcelas;
	private TipoTransacao tipoTransacao;
	private double valorTransacao;
	private double taxaTransacao;
		
	public Venda() {
		
	}

	public Venda(int tipoRegistro, LocalDate dataVenda, String cartao, String codigoAutorizacao, int nsu,
			Bandeira bandeira, int parcelas, TipoTransacao tipoTransacao, double valorTransacao, double taxaTransacao) {
		this.tipoRegistro = tipoRegistro;
		this.dataVenda = dataVenda;
		this.cartao = cartao;
		this.codigoAutorizacao = codigoAutorizacao;
		this.nsu = nsu;
		this.bandeira = bandeira;
		this.parcelas = parcelas;
		this.tipoTransacao = tipoTransacao;
		this.valorTransacao = valorTransacao;
		this.taxaTransacao = taxaTransacao;
	}
	
	public int getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(int tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
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

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
		
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public double getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public double getTaxaTransacao() {
		return taxaTransacao;
	}

	public void setTaxaTransacao(double taxaTransacao) {
		this.taxaTransacao = taxaTransacao;
	}

	@Override
	public String toString() {
		return "Venda [tipoRegistro=" + tipoRegistro + ", dataVenda=" + dataVenda + ", cartao=" + cartao
				+ ", codigoAutorizacao=" + codigoAutorizacao + ", nsu=" + nsu + ", bandeira=" + bandeira + ", parcelas="
				+ parcelas + ", tipoTransacao=" + tipoTransacao + ", valorTransacao=" + valorTransacao
				+ ", taxaTransacao=" + taxaTransacao + "]";
	};
	
}
