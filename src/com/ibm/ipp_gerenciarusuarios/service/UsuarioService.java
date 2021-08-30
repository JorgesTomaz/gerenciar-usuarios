package com.ibm.ipp_gerenciarusuarios.service;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.ipp_gerenciarusuarios.to.PerfilTO;
import com.ibm.ipp_gerenciarusuarios.to.UsuarioVinculadoTO;

import br.com.ipiranga.UsuarioPortalWSService.ListarClientesAssociadosAoUsuarioResponse;
import br.com.ipiranga.UsuarioPortalWSService.ListarPerfisDoUsuarioResponse;
import br.com.ipiranga.UsuarioPortalWSService.ServiceResponse;
import br.com.ipiranga.aci.portalri.compartilhadas.to.UsuarioTO;
import br.com.ipiranga.notificacaoPortal.service.UsuarioClientService;
import cbpi.fit.saa.ws.usuarioportal.DadosClienteRIVO;
import cbpi.fit.saa.ws.usuarioportal.PerfilAcessoVO;


public class UsuarioService implements Serializable{

	private static final long serialVersionUID = -7277171533242969144L;

	private UsuarioClientService usuarioService = new UsuarioClientService();
	
		
	/**
	 * Método responsavel por listar os cliente de um usuário
	 * @param usuario para filtro
	 * @return List<DadosClienteRIVO>
	 */
	public List<DadosClienteRIVO> obterClientes(UsuarioTO usuario) {
		 ListarClientesAssociadosAoUsuarioResponse clientesAssociadosAoUsuario;
		List<DadosClienteRIVO> clientes = null;
		try {
			clientesAssociadosAoUsuario = usuarioService.listarClientesAssociadosAoUsuario(usuario.getLogin());
			clientes = clientesAssociadosAoUsuario.get_return().getListaDeClientes();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	/**
	 * Método responsavel por obter a lista de cliente
	 * @param login para filtrar os clientes
	 * @return List<DadosClienteRIVO>
	 */
	public List<DadosClienteRIVO> obterClientes(String login) {
		UsuarioTO usuario = new UsuarioTO();
		usuario.setLogin(login);
		return this.obterClientes(usuario);
	}

	/**
	 * Método responsável por obter os dados do cliente
	 * @param usuario dados do usuário
	 * @param cdPessDv código do cliente
	 * @return DadosClienteRIVO
	 */
	public DadosClienteRIVO obterCliente(UsuarioTO usuario, String cdPessDv) {
		List<DadosClienteRIVO> clientes = obterClientes(usuario);
		for(DadosClienteRIVO cliente: clientes) {
			if(cliente.getCdPessDv().equals(cdPessDv))
				return cliente;
		}
		return null;
	}

	/**
	 * Método responsavel por inativar o usuário
	 * @param usuario
	 */
	public void inativarUsuario(UsuarioVinculadoTO usuario) {
		ServiceResponse inativar;
		try {
			inativar = usuarioService.inativar(usuario.getCodigo(), usuario.getMaster().getLogin());
			System.out.println(inativar.get_return().getMensagem());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		usuario.setStatus(!usuario.getStatus());
	}

	/**
	 * Método responsavel por ativar o usuário
	 * @param usuario usuario a ser ativado
	 * @return ServiceResponse
	 */
	public ServiceResponse ativarUsuario(UsuarioVinculadoTO usuario) {
		ServiceResponse reativar = null;
		try {
			reativar = usuarioService.reativar(usuario.getCodigo(), usuario.getMaster().getLogin());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return reativar;
	}

	/**
	 * 
	 * Método responsavel por ativar o usuário
	 * @param usuario usuario a ser ativado
	 * @return ServiceResponse
	 */
	public ServiceResponse ativarUsuario(String codigoUsuario, String login) {
		ServiceResponse reativar = null;
		try {
			reativar = usuarioService.reativar(codigoUsuario, login);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return reativar;
	}

	/**
	 * 
	 * Método responsavel por inativar o usuário
	 * @param usuario usuario a ser inativado
	 * @return ServiceResponse
	 */
	public ServiceResponse inativarUsuario(String codigoUsuario, String login) {
		ServiceResponse inativar = null;
		try {
			inativar = usuarioService.inativar(codigoUsuario, login);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return inativar;
	}

	/**
	 * Método responsavel por alterar a senha do usuário
	 * @param usuario usuario a ter a senha alterada
	 * @param senhaAtual
	 * @param novaSenha
	 */
	public void alterarSenha(UsuarioTO usuario, String senhaAtual, String novaSenha) {
		// TODO alterar senha
		
		/*try {
			usuarioService.trocarSenha(usuario.getLogin(), novaSenha, senhaAtual);
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
		}*/
	}

	/**
	 * Método responsável pelo reset de senha
	 * @param loginUsuario login do usuário
	 * @return mensagem de sucesso
	 */
	public String resetSenha(String loginUsuario) {
		String senha = null;
		// TODO reset de senha
		/*try {
			senha = usuarioService.recuperarSenha(loginUsuario);
		} catch (RemoteException | NegocioException e) {
			e.printStackTrace();
		}*/
		return senha;
	}

	/**
	 * Método responsável por obter a lista de perfis
	 * @param login do usuario
	 * @return List<PerfilTO>
	 */
	public List<PerfilTO> obterPerfis(String login) {
		ListarPerfisDoUsuarioResponse responseListarPerfisDoUsuario = null;
		try {
			responseListarPerfisDoUsuario = usuarioService.listarPerfisDoUsuario(login);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		List<PerfilTO> perfis = null;
		List<PerfilAcessoVO> listaDePerfis = responseListarPerfisDoUsuario.get_return().getListaDePerfis();
		if(listaDePerfis.size() > 0) {
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

	/**
	 * Método responsável por verificar tipo de usuário master
	 * @param usuario para verificação
	 * @return boolean
	 */
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
