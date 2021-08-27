package com.ibm.ipp_gerenciarusuarios.service;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.ibm.ipp_gerenciarusuarios.to.PerfilTO;
import com.ibm.ipp_gerenciarusuarios.to.UsuarioVinculadoTO;

import br.com.ipiranga.aci.portalri.compartilhadas.to.UsuarioTO;
import br.com.ipiranga.aci.portalri.service.ClientService;
import br.com.ipiranga.logging.logger.IPPLogger;
import cbpi.fit.framework.negocio.NegocioException;
import cbpi.fit.saa.ws.usuarioportal.DadosClienteRIVO;
import cbpi.fit.saa.ws.usuarioportal.PerfilAcessoVO;
import cbpi.fit.saa.ws.usuarioportal.ResponseListarClientesAssociadosAoUsuario;
import cbpi.fit.saa.ws.usuarioportal.ResponseListarPerfisDoUsuario;
import cbpi.fit.saa.ws.usuarioportal.ResponseServices;
import cbpi.fit.saa.ws.usuarioportal.UsuarioPortalWSPortProxy;

public class UsuarioService implements Serializable{

	private static final long serialVersionUID = -7277171533242969144L;

	UsuarioPortalWSPortProxy usuarioService = new UsuarioPortalWSPortProxy();
	ClientService service = new ClientService();
	
	public List<DadosClienteRIVO> obterClientes(UsuarioTO usuario) {
		ResponseListarClientesAssociadosAoUsuario clientesAssociadosAoUsuario;
		List<DadosClienteRIVO> clientes = null;
		clientesAssociadosAoUsuario = usuarioService.listarClientesAssociadosAoUsuario(usuario.getLogin());
		clientes = clientesAssociadosAoUsuario.getListaDeClientes();
		
		return clientes;
	}
	
	public List<DadosClienteRIVO> obterClientes(String login) {
		UsuarioTO usuario = new UsuarioTO();
		usuario.setLogin(login);
		return this.obterClientes(usuario);
	}

	public DadosClienteRIVO obterCliente(UsuarioTO usuario, String cdPessDv) {
		List<DadosClienteRIVO> clientes = obterClientes(usuario);
		for(DadosClienteRIVO cliente: clientes) {
			if(cliente.getCdPessDv().equals(cdPessDv))
				return cliente;
		}
		return null;
	}

	public void inativarUsuario(UsuarioVinculadoTO usuario) {
		ResponseServices inativar;
		inativar = usuarioService.inativar(usuario.getCodigo(), usuario.getMaster().getLogin());
		System.out.println(inativar.getMensagem());
		usuario.setStatus(!usuario.getStatus());
	}

	public ResponseServices ativarUsuario(UsuarioVinculadoTO usuario) {
		ResponseServices reativar;
		reativar = usuarioService.reativar(usuario.getCodigo(), usuario.getMaster().getLogin());
		return reativar;
	}

	public ResponseServices ativarUsuario(String codigoUsuario, String login) {
		ResponseServices reativar;
		reativar = usuarioService.reativar(codigoUsuario, login);
		return reativar;
	}

	public ResponseServices inativarUsuario(String codigoUsuario, String login) {
		ResponseServices inativar;
		inativar = usuarioService.inativar(codigoUsuario, login);
		return inativar;
	}

	public void alterarSenha(UsuarioTO usuario, String senhaAtual, String novaSenha) {
		try {
			service.trocarSenha(usuario.getLogin(), novaSenha, senhaAtual);
		} catch (RemoteException e) {
			IPPLogger.singleton().severe(e.getMessage(), e);
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(e.getMessage());
			message.setDetail(e.getMessage());
			throw new ValidatorException(message);
		} catch (NegocioException e) {
			IPPLogger.singleton().severe(e.getMessage(), e);
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(e.getMessage());
			message.setDetail(e.getMessage());
			throw new ValidatorException(message);
		}
	}

	public String resetSenha(String loginUsuario) {
		String senha = null;
		try {
			senha = service.recuperarSenha(loginUsuario);
		} catch (RemoteException | NegocioException e) {
			e.printStackTrace();
		}
		return senha;
	}

	public List<PerfilTO> obterPerfis(String login) {
		ResponseListarPerfisDoUsuario responseListarPerfisDoUsuario = usuarioService.listarPerfisDoUsuario(login);
		List<PerfilTO> perfis = null;
		List<PerfilAcessoVO> listaDePerfis = responseListarPerfisDoUsuario.getListaDePerfis();
		if(!listaDePerfis.isEmpty()) {
			perfis = new ArrayList<PerfilTO>();
			for(PerfilAcessoVO perfilAcesso: listaDePerfis) {
				PerfilTO perfil = new PerfilTO();
				perfil.setCodigo(perfilAcesso.getCodigo());
				perfil.setNome(perfilAcesso.getDescricao());
				perfil.setDescricao(perfilAcesso.getDescricao());
				perfis.add(perfil);
			}
		}
		return perfis;
	}

	public boolean verificaMaster(UsuarioTO usuario) {
		List<PerfilTO> perfis = obterPerfis(usuario.getLogin());
		if(perfis != null && !perfis.isEmpty()) {
			for(PerfilTO perfil: perfis) {
				if(perfil.getCodigo().equals("94"))
					return true;
			}
		}
		return false;
	}

}
