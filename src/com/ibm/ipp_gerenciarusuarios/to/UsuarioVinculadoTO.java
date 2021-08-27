package com.ibm.ipp_gerenciarusuarios.to;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import br.com.ipiranga.aci.portalri.compartilhadas.to.UsuarioTO;
import cbpi.fit.saa.ws.usuarioportal.DadosClienteRIVO;

public class UsuarioVinculadoTO extends PerfilLogadoTO implements Comparable<UsuarioVinculadoTO>{

	private static final long serialVersionUID = -8178228181927971313L;
	
	private String login;
	private Boolean status;
	private List<PerfilTO> perfis;
	private List<DadosClienteRIVO> clientes;
	private UsuarioTO master;
	private XMLGregorianCalendar dtIncl;

	public UsuarioVinculadoTO() {}
	
	public UsuarioVinculadoTO(int id, String nome, String email, String cpf, String telefone, String login, List<PerfilTO> perfis,List<DadosClienteRIVO> clientes, Boolean status) {
		super(id, nome, email, cpf, telefone);
		this.setLogin(login);
		this.perfis = perfis;
		this.clientes = clientes;
		this.setStatus(status);
	}

	public String getAtivo(){
		if(status){
			return "checked";
		}
		return null;
	}

	public List<PerfilTO> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<PerfilTO> perfis) {
		this.perfis = perfis;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<DadosClienteRIVO> getClientes() {
		return clientes;
	}

	public void setClientes(List<DadosClienteRIVO> clientes) {
		this.clientes = clientes;
	}

	public UsuarioTO getMaster() {
		return master;
	}

	public void setMaster(UsuarioTO master) {
		this.master = master;
	}

	public XMLGregorianCalendar getDtIncl() {
		return dtIncl;
	}

	public void setDtIncl(XMLGregorianCalendar xmlGregorianCalendar) {
		this.dtIncl = xmlGregorianCalendar;
	}

	@Override
	public int compareTo(UsuarioVinculadoTO o) {
		if(getDtIncl() == null || o.getDtIncl() == null) {
			return 0;
		}
		return getDtIncl().compare(o.getDtIncl());
	}
}
