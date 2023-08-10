package com.acceptiondevtest.ws.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.acceptiondevtest.ws.entities.enums.Bandeira;
import com.acceptiondevtest.ws.entities.enums.TipoTransacao;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venda implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CsvBindByPosition(position = 0)
	private int tipoRegistro;
	
	@CsvDate(value="ddMMyyyy")
	@CsvBindByPosition(position = 1)
	private LocalDate dataVenda;
	
	@CsvBindByPosition(position = 2)
	private String cartao;
	
	//@Id
	@CsvBindByPosition(position = 3)
	private String codigoAutorizacao;
	
	@CsvBindByPosition(position = 4)
	private int nsu;
	
	@CsvBindByPosition(position = 5)
	private Bandeira bandeira;
	
	@CsvBindByPosition(position = 6)
	private int parcelas;
	
	@CsvBindByPosition(position = 7)
	private TipoTransacao tipoTransacao;
	
	@CsvBindByPosition(position = 8)
	private double valorTransacao;
	
	@CsvBindByPosition(position = 9)
	private double taxaTransacao;
		
	public Venda() {
		
	}

	public Venda(Long id, int tipoRegistro, LocalDate dataVenda, String cartao, String codigoAutorizacao, int nsu,
			Bandeira bandeira, int parcelas, TipoTransacao tipoTransacao, double valorTransacao, double taxaTransacao) {
		this.id = id;
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
