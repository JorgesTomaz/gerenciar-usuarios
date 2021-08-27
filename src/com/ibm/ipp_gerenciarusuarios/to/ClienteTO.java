package com.ibm.ipp_gerenciarusuarios.to;

public class ClienteTO extends GenericTO{

	private static final long serialVersionUID = 6362200131557883585L;
	
	private String cnpj;
	private Boolean principal;

	public ClienteTO() {
		super();
	}

	public ClienteTO(Integer id, String nome, String cnpj, boolean principal) {
		super(id, nome);
		this.setCnpj(cnpj);
		this.setPrincipal(principal);
	}

	public ClienteTO(String nome, String cnpj, boolean principal) {
		super(nome);
		this.setCnpj(cnpj);
		this.setPrincipal(principal);
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}
	
}
