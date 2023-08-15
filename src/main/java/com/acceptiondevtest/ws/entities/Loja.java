package com.acceptiondevtest.ws.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Loja implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigo;
	@Id
	private String cnpj;
	
	public Loja() {
		
	};
	
	public Loja(String codigo, String cnpj) {
		this.codigo = codigo;
		this.cnpj = cnpj;
	}
	
	public String[] toStringArray() {
		return new String[]{codigo, cnpj};
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
