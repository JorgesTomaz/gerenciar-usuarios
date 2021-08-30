package com.ibm.ipp_gerenciarusuarios.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import org.json.JSONArray;

import com.ibm.ipp_gerenciarusuarios.exception.BusinessException;
import com.ibm.ipp_gerenciarusuarios.to.PerfilLogadoTO;
import com.ibm.ipp_gerenciarusuarios.to.PerfilTO;
import com.ibm.ipp_gerenciarusuarios.to.UsuarioVinculadoTO;

import br.com.ipiranga.FuncionarioClienteWSService.IncluirFuncionarioClienteResponse;
import br.com.ipiranga.FuncionarioClienteWSService.ListarPerfisDisponiveisParaAssociacaoResponse;
import br.com.ipiranga.FuncionarioClienteWSService.RecuperarSenhaResponse;
import br.com.ipiranga.FuncionarioClienteWSService.ServiceResponse;
import br.com.ipiranga.FuncionarioClienteWSService.UsuarioPorLoginResponse;
import br.com.ipiranga.aci.portalri.compartilhadas.to.UsuarioTO;
import br.com.ipiranga.logging.logger.IPPLogger;
import br.com.ipiranga.notificacaoPortal.service.FuncionarioClientService;
import cbpi.fit.saa.ws.usuarioportal.DadosClienteRIVO;
import cbpi.fit.saa.ws.usuarioportal.PerfilAcessoVO;
import cbpi.fit.saa.ws.usuarioportal.ResponseListarUsuariosVinculadosAoUsuarioMaster;
import cbpi.fit.saa.ws.usuarioportal.UsuarioPortalVO;

public class FuncionarioService implements Serializable {

	private static final long serialVersionUID = 1353526118643131169L;

	private static final int CODIGO_RETORNO_SUCESSO = 1;
	
	private FuncionarioClientService client;
	
	public FuncionarioService() {
		this.client = new FuncionarioClientService();
	}
	
	/**
	 * Método responsavel por incluir o usuário Vinculado
	 * @param novoUsuario usuario a ser incluido
	 * @return retorno do servico
	 */
	public IncluirFuncionarioClienteResponse incluir(UsuarioVinculadoTO novoUsuario) {
		

		List<String> cdPerfis = listarPerfis(novoUsuario.getPerfis());
		String[] perfisArray = new String[cdPerfis.size()];
		perfisArray = cdPerfis.toArray(perfisArray);

		IncluirFuncionarioClienteResponse clienteResponse = null;

		System.out.println("Parse dos dados do novo usuário");
		UsuarioPortalVO usuarioPortal = parseDadosUsuario(novoUsuario);

		List<DadosClienteRIVO> pontosDeVenda = obterPontosDeVenda(novoUsuario.getClientes());
		
				
		DadosClienteRIVO[] pontosDeVendaArray = new DadosClienteRIVO[pontosDeVenda.size()];
		pontosDeVendaArray = pontosDeVenda.toArray(pontosDeVendaArray);
		
		String[] pontosDeVendaString = new String[pontosDeVendaArray.length];
		for (int i = 0; i < pontosDeVendaArray.length; i++) {
			pontosDeVendaString[i] = pontosDeVendaArray[i].getCdPtov(); 
		}				
		
		try {
			clienteResponse = this.client.incluir(novoUsuario.getMaster().getLogin(), usuarioPortal, perfisArray,
					pontosDeVendaString);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return clienteResponse;
	}

	/**
	 * Método responsavel por obter a lista de usuários vinculados
	 * @param usuarioMaster usuario master
	 * @return List<UsuarioVinculadoTO>
	 */
	public List<UsuarioVinculadoTO> obterUsuariosVinculados(UsuarioTO usuarioMaster) {		
		
		ResponseListarUsuariosVinculadosAoUsuarioMaster usuariosVinculadosAoUsuarioMaster;
		List<UsuarioVinculadoTO> vinculados = null;
		
		List<UsuarioPortalVO> listaDeUsuarios = null;
		try {
			
			usuariosVinculadosAoUsuarioMaster = this.client.listarUsuariosVinculadosAoUsuarioMaster(
							usuarioMaster.getLogin()
			);
			listaDeUsuarios = (usuariosVinculadosAoUsuarioMaster.getListaDeUsuarios());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		vinculados = usuariosVinculados(listaDeUsuarios, usuarioMaster);
		return vinculados;
	}

	/**
	 * Método conversor de Objetos
	 * @param listaDeUsuarios lista de usuarios recebidos do servico
	 * @param usuarioMaster usuario principal
	 * @return List<UsuarioVinculadoTO>
	 */
	private List<UsuarioVinculadoTO> usuariosVinculados(List<UsuarioPortalVO> listaDeUsuarios,
			UsuarioTO usuarioMaster) {
		System.out.println("Recuperando os usuários vinculados");
		List<UsuarioVinculadoTO> usuariosVinculados = new ArrayList<UsuarioVinculadoTO>();
		if (!listaDeUsuarios.isEmpty()) {
			for (UsuarioPortalVO usuarioPortal : listaDeUsuarios) {
				UsuarioVinculadoTO usuarioVinculado = new UsuarioVinculadoTO();
				usuarioVinculado.setCodigo(usuarioPortal.getCodigo());
				usuarioVinculado.setEmail(usuarioPortal.getEmail());
				usuarioVinculado.setCpf(usuarioPortal.getCpf());
				usuarioVinculado.setNome(usuarioPortal.getNome());
				usuarioVinculado.setLogin(usuarioPortal.getCodigo());
				StringBuilder telefone = new StringBuilder("(").append(usuarioPortal.getDddTelefone()).append(")")
						.append(usuarioPortal.getTelefone());
				usuarioVinculado.setTelefone(telefone.toString());
				usuarioVinculado.setPerfis(obterPerfisSemDetalhes(usuarioPortal.getCodigo()));
				usuarioVinculado.setClientes(usuarioPortal.getPontosDeVenda());
				if (null != usuarioPortal.getDtInat()) {
					usuarioVinculado.setStatus(Boolean.FALSE);
				} else {
					usuarioVinculado.setStatus(Boolean.TRUE);
				}
				usuarioVinculado.setMaster(usuarioMaster);
				usuarioVinculado.setDtIncl(usuarioPortal.getDtIncl());
				usuariosVinculados.add(usuarioVinculado);
			}
		}
		Collections.sort(usuariosVinculados, Collections.reverseOrder());
		return usuariosVinculados;
	}
	
	/**
	 * Método resposavel por obter a lista de perfis sem detalhes
	 * @param usuarioLogin usuario logado
	 * @return List<PerfilTO>
	 */
	private List<PerfilTO> obterPerfisSemDetalhes(String usuarioLogin) {
		IPPLogger.singleton().finest("Obtendo perfis sem detalhes de: ", usuarioLogin);
		ListarPerfisDisponiveisParaAssociacaoResponse disponiveisParaAssociacao;
		List<PerfilTO> perfis = null;		
		try {			
			disponiveisParaAssociacao = this.client.listarPerfisDisponiveisParaAssociacao(usuarioLogin);
			if (disponiveisParaAssociacao.get_return().getListaDePerfis().size() > 0) {
				List<PerfilAcessoVO> listaDePerfis = disponiveisParaAssociacao.get_return().getListaDePerfis();
				perfis = new ArrayList<PerfilTO>();
				for (PerfilAcessoVO perfilAcesso : listaDePerfis) {
					PerfilTO perfil = new PerfilTO();
					perfil.setCodigo(perfilAcesso.getCodigo());
					perfil.setNome(perfilAcesso.getDescricao());
					perfil.setDescricao(perfilAcesso.getDescricao());
					perfis.add(perfil);
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return perfis;
	}

	/**
	 * Método resposavel por obter a lista de perfis
	 * @param usuarioLogin usuario logado
	 * @return List<PerfilTO>
	 */
	public List<PerfilTO> obterPerfis(String usuarioLogin) {
		IPPLogger.singleton().finest("Obtendo perfis com detalhes de: ", usuarioLogin);

		ListarPerfisDisponiveisParaAssociacaoResponse disponiveisParaAssociacao;
		List<PerfilTO> perfis = null;
		try {
			disponiveisParaAssociacao = this.client.listarPerfisDisponiveisParaAssociacao(usuarioLogin);
			if (disponiveisParaAssociacao.get_return().getListaDePerfis().size() > 0) {
				List<PerfilAcessoVO> listaDePerfis = disponiveisParaAssociacao.get_return().getListaDePerfis();
				perfis = new ArrayList<PerfilTO>();
				for (PerfilAcessoVO perfilAcesso : listaDePerfis) {
					PerfilTO perfil = new PerfilTO();
					perfil.setCodigo(perfilAcesso.getCodigo());
					perfil.setNome(perfilAcesso.getDescricao());
					perfil.setDescricao(perfilAcesso.getDescricao());
					perfis.add(perfil);
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		JSONArray array = obterDetalhesPerfis();
		return incluirDetalhes(perfis, array);
	}

	/**
	 * Método responsavel por obter os detalhes dos perfis
	 * @return
	 */
	private JSONArray obterDetalhesPerfis() {
		JSONArray array = null;
		try {
			// TODO pegar a url do ambiente
			String requestURL = "https://ridev2.redeipiranga.com.br/wps/wcm/connect/ri-conteudos-v2/servicos/gerenciarusuarios/index?subtype=json";
			URL url = new URL(requestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			System.out.println("Conteúdo json retornado");
			System.out.println(content.toString());
			array = new JSONArray(content.toString());

			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	/**
	 * Método responsavel por incluir os detalhes dos perfis
	 * @param perfis lista de perfis
	 * @param array objeto json
	 * @return List<PerfilTO>
	 */
	private List<PerfilTO> incluirDetalhes(List<PerfilTO> perfis, JSONArray array) {
		if (null != array) {
			for (PerfilTO perfil : perfis) {
				for (int i = 0; i < array.length(); i++) {
					if (perfil.getCodigo().equals(array.getJSONObject(i).getString("role"))) {
						perfil.setDescricao(array.getJSONObject(i).getString("description"));
						perfil.setDescricao(array.getJSONObject(i).getString("document"));
						break;
					}
				}
			}
		}
		return perfis;
	}

	/**
	 * Método responsável por alterar o usuário vinculado
	 * @param usuarioVinculado objeto contendo os dados do usuário
	 * @throws BusinessException
	 */
	public void alterar(UsuarioVinculadoTO usuarioVinculado) throws BusinessException {
		// List<DadosClienteRIVO> pontosDeVenda =
		// obterPontosDeVenda(usuarioVinculado.getClientes());

		UsuarioPortalVO usuarioPortal = parseDadosUsuario(usuarioVinculado);
		// usuarioPortal.setCdPerfis(listarPerfis(usuarioVinculado.getPerfis()));
		// usuarioPortal.setPontosDeVenda(pontosDeVenda);	
		try {
			
			ServiceResponse services = this.client.alterar(usuarioVinculado.getMaster().getLogin(), usuarioPortal);
			if (services.get_return().getCodigo() != CODIGO_RETORNO_SUCESSO) {
				throw new BusinessException(services.get_return().getCodigo(), services.get_return().getMensagem());
			}
			// this.client.associarPerfisAoUsuario(usuarioVinculado.getMaster().getLogin(),
			// usuarioPortal.getCodigo(), usuarioVinculado.getMaster().getLogin(),
			// listarPerfis(usuarioVinculado.getPerfis()));
			// this.client.associarCnpjsAoUsuario(usuarioVinculado.getMaster().getLogin(),
			// usuarioPortal.getCodigo(), usuarioVinculado.getMaster().getLogin(),
			// usuarioVinculado.getClientes());

		} catch (Exception e) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Erro ao alterar dados do usuário");
			message.setDetail(e.getMessage());

			throw new ValidatorException(message);
		}

	}

	/**
	 * Método responsável por listar os pontos de vendas
	 * @param clientes lista de clientes
	 * @return List<DadosClienteRIVO>
	 */
	private List<DadosClienteRIVO> obterPontosDeVenda(List<DadosClienteRIVO> clientes) {
		List<DadosClienteRIVO> pontosDeVenda = new ArrayList<DadosClienteRIVO>();
		for (cbpi.fit.saa.ws.usuarioportal.DadosClienteRIVO cliente : clientes) {
			DadosClienteRIVO pontoDeVenda = new DadosClienteRIVO();
			pontoDeVenda.setCdPess(cliente.getCdPess());
			pontoDeVenda.setCdPessDv(cliente.getCdPessDv());
			pontoDeVenda.setCdPtov(cliente.getCdPtov());
			pontoDeVenda.setCdTipoPess(cliente.getCdTipoPess());
			pontoDeVenda.setNmPess(cliente.getNmPess());
			pontoDeVenda.setCdPtoeCli(cliente.getCdPtoeCli());
			pontoDeVenda.setCnpjPrincipal(cliente.isCnpjPrincipal());
			pontosDeVenda.add(pontoDeVenda);
		}
		return pontosDeVenda;
	}

	/**
	 * Método de conversão dos dados do usuário vinculado
	 * @param novoUsuario objeto para parse
	 * @return UsuarioPortalVO
	 */
	private UsuarioPortalVO parseDadosUsuario(UsuarioVinculadoTO novoUsuario) {
		UsuarioPortalVO usuarioPortal = new UsuarioPortalVO();

		usuarioPortal.setCpf(novoUsuario.getCpf().replaceAll("[^0-9]", ""));
		usuarioPortal.setNome(novoUsuario.getNome());
		usuarioPortal.setEmail(novoUsuario.getEmail());
		usuarioPortal.setCdUsuarioAutenticado(novoUsuario.getMaster().getLogin());
		usuarioPortal.setCodigo(novoUsuario.getCodigo());

		String telefone = novoUsuario.getTelefone().replaceAll("[^0-9]", "");
		usuarioPortal.setDddTelefone(telefone.substring(0, 2));
		usuarioPortal.setTelefone(telefone.substring(2));

		return usuarioPortal;
	}

	/**
	 * Método responsável por lista os perfis
	 * @param perfis lista de pérfis
	 * @return List<String>
	 */
	private List<String> listarPerfis(List<PerfilTO> perfis) {
		List<String> cdPerfis = new ArrayList<String>();
		for (PerfilTO perfil : perfis) {
			cdPerfis.add(perfil.getCodigo());
		}
		return cdPerfis;
	}

	/**
	 * Método resposável por obter o perfil logado
	 * @param usuario dados do usuário
	 * @return PerfilLogadoTO
	 */
	public PerfilLogadoTO obterPerfilLogado(UsuarioTO usuario) {
		PerfilLogadoTO perfilLogado = null;		
		try {			
			UsuarioPorLoginResponse usuarioPorLogin = this.client.getUsuarioPorLogin(usuario.getLogin());
			perfilLogado = parseDados(usuarioPorLogin.get_return().getUsuario());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return perfilLogado;
	}

	/**
	 * Método de conversão de dados
	 * @param usuario contendo os dados do usuario
	 * @return PerfilLogadoTO
	 */
	private PerfilLogadoTO parseDados(UsuarioPortalVO usuario) {
		PerfilLogadoTO perfilLogado = new PerfilLogadoTO();
		perfilLogado.setNome(usuario.getNome());
		perfilLogado.setCodigo(usuario.getCodigo());
		perfilLogado.setCpf(usuario.getCpf());
		perfilLogado.setEmail(usuario.getEmail());
		perfilLogado.setTelefone(usuario.getTelefone());
		return perfilLogado;
	}

	/**
	 * Método resposável pelo reset de senha
	 * @param usuario
	 * @param loginUsuario
	 * @return
	 */
	public String resetSenha(UsuarioTO usuario, String loginUsuario) {
		try {
			RecuperarSenhaResponse recuperarSenha = this.client.recuperarSenha(loginUsuario, usuario.getLogin());
			return recuperarSenha.get_return().getMensagem();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}
