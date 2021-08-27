package com.ibm.ipp_gerenciarusuarios.to;

import java.io.Serializable;

public class GenericTO implements Serializable{

	private static final long serialVersionUID = 6056368867194735223L;
	private Integer id;
	private String codigo;
	private String nome;
	
	public GenericTO() {
	}

	public GenericTO(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public GenericTO(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
