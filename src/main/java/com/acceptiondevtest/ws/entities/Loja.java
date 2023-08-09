package com.acceptiondevtest.ws.entities;

public class Loja {
	private String codigo;
	private String cnpj;
	
	public Loja() {
		
	};
	
	public Loja(String codigo, String cnpj) {
		this.codigo = codigo;
		this.cnpj = cnpj;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	

}
