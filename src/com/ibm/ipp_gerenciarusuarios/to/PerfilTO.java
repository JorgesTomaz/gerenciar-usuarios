package com.ibm.ipp_gerenciarusuarios.to;

public class PerfilTO extends GenericTO {

	private static final long serialVersionUID = -5698305741465850066L;
	
	private String descricao;
	private String document;

	public PerfilTO() {
		super();
	}

	public PerfilTO(Integer id, String nome, String descricao) {
		super(id, nome);
		this.descricao = descricao;
	}
	
	public PerfilTO(String codigo, String descricao) {
		setCodigo(codigo);
		setDescricao(descricao);
	}
	
	@Override
	public String toString() {
		StringBuilder perfil = new StringBuilder();
		perfil.append(this.getCodigo())
		.append(",")
		.append(getDescricao());
		return perfil.toString();
	}

	public PerfilTO(String perfil) {
		this(perfil.split(","));
	}
	
	private PerfilTO(String[]data) {
		this(data[0], data[1]);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	
}
