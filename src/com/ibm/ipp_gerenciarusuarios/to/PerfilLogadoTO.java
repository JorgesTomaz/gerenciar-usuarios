package com.ibm.ipp_gerenciarusuarios.to;

import java.util.List;

public class PerfilLogadoTO extends GenericTO{

	private static final long serialVersionUID = -243566194778060073L;
	private String email;
	private String cpf;
	private String telefone;
	private List<PerfilTO> perfis;
	private String senhaAntiga;
	private String novaSenha;

	public PerfilLogadoTO() {
	}

	public PerfilLogadoTO(String nome, String email, String cpf, String telefone) {
		super(nome);
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public PerfilLogadoTO(int id, String nome, String email, String cpf, String telefone) {
		super(id, nome);
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<PerfilTO> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<PerfilTO> perfis) {
		this.perfis = perfis;
	}

	public String getSenhaAntiga() {
		return senhaAntiga;
	}

	public void setSenhaAntiga(String senhaAntiga) {
		this.senhaAntiga = senhaAntiga;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
}
