package com.acceptiondevtest.ws.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String codigo;
	private double valor;
	private String data;
	private boolean faturado;
	@ManyToOne
	@JoinColumn(name = "loja_cnpj")
	private Loja loja;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pedido_codigo")
	private List<Pagamento> pagamentos = new ArrayList<>();
	
	public Pedido() {
		
	}

	public Pedido(String codigo, double valor, String data, boolean faturado, Loja loja, List<Pagamento> pagamentos) {
		this.codigo = codigo;
		this.valor = valor/100;
		this.data = data;
		this.faturado = faturado;
		this.loja = loja;
		this.pagamentos = pagamentos;
	}
	
	
	@PrePersist
    @PreUpdate
    public void formatDouble() {
		this.valor = Math.round(this.valor / 100.0 * 100.0) / 100.0;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
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

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}
	
	public static String CSV_HEADER = "REGISTRO;DATA_ENVIO;DATA_REF\n";

	
}
