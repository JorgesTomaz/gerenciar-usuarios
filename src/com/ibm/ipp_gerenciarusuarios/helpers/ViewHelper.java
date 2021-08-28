package com.ibm.ipp_gerenciarusuarios.helpers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ibm.ipp_gerenciarusuarios.service.FuncionarioService;
import com.ibm.ipp_gerenciarusuarios.service.UsuarioService;
import com.ibm.ipp_gerenciarusuarios.to.PerfilLogadoTO;
import com.ibm.ipp_gerenciarusuarios.to.PerfilTO;
import com.ibm.ipp_gerenciarusuarios.to.UsuarioVinculadoTO;
import com.ibm.wps.pe.pc.std.core.PortletUtils;

import br.com.ipiranga.aci.portalri.compartilhadas.bean.UsuarioAutenticado;
import br.com.ipiranga.aci.portalri.compartilhadas.to.UsuarioTO;
import br.com.ipiranga.aci.portalri.utils.PortalUtils;
import br.com.ipiranga.logging.logger.IPPLogger;
import cbpi.fit.saa.ws.usuarioportal.DadosClienteRIVO;
import cbpi.fit.saa.ws.usuarioportal.ResponseIncluirFuncionarioCliente;
import cbpi.fit.saa.ws.usuarioportal.ResponseServices;

@ManagedBean(name = "viewhelper")
@SessionScoped
public class ViewHelper implements Serializable {

	private static final long serialVersionUID = 1784317140470688726L;
	private static final String SUCCESS = "success";
	private final String home = "#";
	private PerfilLogadoTO perfilLogado;
	// dados para paginação e filtro
	private List<UsuarioVinculadoTO> usuarios;
	private List<UsuarioVinculadoTO> filtroUsuarios;
	private String filtroCdPess;
	private String filtroStatus;
	private List<UsuarioVinculadoTO> paginaUsuarios;
	private int paginaAtual = 0;
	private int totalPaginas;
	private int paginaSelecionada;
	private List<String> paginas;

	private List<DadosClienteRIVO> clientes;

	private String centralDeAjuda;

	private List<PerfilTO> perfis;
	private PerfilTO perfilSelecionado;

	private String codigoPerfil;
	private String cdPessDv;
	private UsuarioVinculadoTO novoUsuario;

	private UsuarioTO usuario;

	private FuncionarioService funcionarioService = new FuncionarioService();
	private UsuarioService usuarioService = new UsuarioService();

	private boolean aceito;

	private String mensagemSucesso;
	private String mensagemErro;

	private String senhaAtual;
	private String novaSenha;
	private String confirmaSenha;

	public ViewHelper() {
		try {
			PortletRequest portletRequest = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			HttpServletRequest httpservletrequest = PortletUtils.getInternalRequest(portletRequest)
					.getHttpServletRequest();
			IPPLogger.singleton().finest("Construtor", httpservletrequest.getSession().getId());
			setUsuario(UsuarioAutenticado.singleton().getUsuarioAutenticado(httpservletrequest.getSession().getId()));
		} catch (Exception e) {
			IPPLogger.singleton().finest("Erro ao obter usuário");
			IPPLogger.singleton().severe(e, e.getMessage());
		}
	}

	public String meuPerfil() {
		setMensagemSucesso(null);
		setMensagemErro(null);
		IPPLogger.singleton().finest("meu perfil: ", usuario.toString());
		IPPLogger.singleton().finest("master: ", usuario.isMaster());
		try {
			if (usuario == null) {
				PortletRequest portletRequest = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext()
						.getRequest();
				HttpServletRequest httpservletrequest = PortletUtils.getInternalRequest(portletRequest)
						.getHttpServletRequest();
				IPPLogger.singleton().finest("usuario nulo, obtendo novamente");
				IPPLogger.singleton().finest("Meu Perfil ", httpservletrequest.getSession().getId());
				setUsuario(
						UsuarioAutenticado.singleton().getUsuarioAutenticado(httpservletrequest.getSession().getId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		IPPLogger.singleton().finest("master: ", usuario.isMaster());
		perfilLogado = null;
		perfilLogado = funcionarioService.obterPerfilLogado(usuario);
		/*
		perfilLogado.setNome(usuario.getNome());
		perfilLogado.setCodigo(usuario.getLogin());
		perfilLogado.setCpf(usuario.getEstabelecimentoSimulado().getCdPess());
		perfilLogado.setEmail(usuario.getEstabelecimentoSimulado().getCdEmail().replace("+", ""));
		 */
		perfilLogado.setPerfis(usuarioService.obterPerfis(usuario.getLogin()));
		return SUCCESS;
	}

	public String alterarSenha() {
		IPPLogger.singleton().finest("Chamada a lógica alterar senha.");
		if (validaSenha()) {
			usuarioService.alterarSenha(usuario, senhaAtual, novaSenha);
			setMensagemSucesso("Senha alterada com sucesso");
		} else {
			setMensagemSucesso("Os campos devem ser iguais");
		}
		return SUCCESS;
	}

	private boolean validaSenha() {
		if (novaSenha.equals(confirmaSenha)) {
			return true;
		}
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		message.setSummary("Os campos devem ser iguais");
		message.setDetail("Os campos devem ser iguais");
		throw new ValidatorException(message);
	}

	public String gerenciarUsuarios() {
		IPPLogger.singleton().finest("Metodo gerenciar usuarios", usuario.toString());
		IPPLogger.singleton().finest("master: ", usuario.isMaster());
		if (null == usuario) {
			try {
				PortletRequest portletRequest = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext()
						.getRequest();
				HttpServletRequest httpservletrequest = PortletUtils.getInternalRequest(portletRequest)
						.getHttpServletRequest();
				IPPLogger.singleton().finest("Gerenciar usuario session id", httpservletrequest.getSession().getId());
				setUsuario(
						UsuarioAutenticado.singleton().getUsuarioAutenticado(httpservletrequest.getSession().getId()));
			} catch (Exception e) {
				IPPLogger.singleton().finest("Erro ao obter usuário");
				IPPLogger.singleton().severe(e, e.getMessage());
			}
		}
		setUsuarios(funcionarioService.obterUsuariosVinculados(usuario));
		if(null == getFiltroUsuarios())
		  setFiltroUsuarios(getUsuarios());
		setClientes(usuarioService.obterClientes(usuario));
		// setMaster(usuario.isMaster());
		IPPLogger.singleton().finest("Usuario da sessão ", usuario.isMaster());
		if (usuario.isMaster()) {
			return SUCCESS;
		} else {
			// return SUCCESS;
			return "/PerfilView.xhtml?faces.redirect=true";
		}
	}

	public void ativarInativarUsuario(String codigoUsuario, boolean status) {
		if (status) {
			ResponseServices ativarUsuario = usuarioService.ativarUsuario(codigoUsuario, usuario.getLogin());
			if (ativarUsuario.getCodigo() == 1) {
				setMensagemSucesso("Usuário Ativado com sucesso");
			} else {
				setMensagemErro("Erro ao ativar usuário");
			}

		} else {
			ResponseServices inativarUsuario = usuarioService.inativarUsuario(codigoUsuario, usuario.getLogin());
			if (inativarUsuario.getCodigo() == 1) {
				setMensagemSucesso("Usuário inativado com sucesso");
			} else {
				setMensagemErro("Erro ao inativar usuário");
			}
		}
	}

	public String adicionarUsuario() {
		setMensagemSucesso(null);
		setMensagemErro(null);
		IPPLogger.singleton().finest("Chamada a lógica adicionar usuários.");
		IPPLogger.singleton().finest("Obtendo página de ajuda.");
		PortletRequest portletRequest = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		PortletResponse portletResponse = (PortletResponse) FacesContext.getCurrentInstance().getExternalContext()
				.getResponse();
		centralDeAjuda = PortalUtils.singleton().getContentNodeUrl(portletRequest, portletResponse,
				"redeipiranga.ajudaesuporte.page");
		if (usuario == null) {
			try {
				HttpServletRequest httpservletrequest = PortletUtils.getInternalRequest(portletRequest)
						.getHttpServletRequest();
				setUsuario(
						UsuarioAutenticado.singleton().getUsuarioAutenticado(httpservletrequest.getSession().getId()));
			} catch (Exception e) {
				IPPLogger.singleton().finest("Erro ao obter usuário");
				IPPLogger.singleton().severe(e, e.getMessage());
			}
		}

		setNovoUsuario(new UsuarioVinculadoTO());
		getNovoUsuario().setMaster(usuario);
		setClientes(usuarioService.obterClientes(usuario));
		setPerfis(funcionarioService.obterPerfis(usuario.getLogin()));
		setAceito(false);
		return SUCCESS;
	}
	public void filtrarUsuarios() {
		setMensagemSucesso(null);
		System.out.println("Chamada do filtro.");
		setFiltroUsuarios(null);
		ArrayList<UsuarioVinculadoTO> usuariosTemp = null;
		boolean adiciona = false;
		boolean filtro1 = false;
		if (null != getFiltroStatus() && !"se".equals(getFiltroStatus())) {
			System.out.println("Filtro Status: " + getFiltroStatus());
			filtro1 = true;
			usuariosTemp = new ArrayList<UsuarioVinculadoTO>();
			for (UsuarioVinculadoTO usuario : getUsuarios()) {
				if (usuario.getStatus() && "1".equals(getFiltroStatus())) {
					adiciona = true;
				}
				if (!usuario.getStatus() && "2".equals(getFiltroStatus())) {
					adiciona = true;
				}
				if (adiciona) {
					usuariosTemp.add(usuario);
					adiciona = false;
				}
			}
		}
		if (null != usuariosTemp) {
			setFiltroUsuarios(usuariosTemp);
			usuariosTemp = null;
		} else if (!filtro1) {
			setFiltroUsuarios(getUsuarios());
		}
		if (null != getFiltroCdPess() && !"".equals(getFiltroCdPess())) {
			System.out.println("Filtro Cliente: " + getFiltroCdPess());
			usuariosTemp = new ArrayList<UsuarioVinculadoTO>();
			for (UsuarioVinculadoTO usuario : getFiltroUsuarios()) {
				System.out.println(usuario.getNome());
				List<DadosClienteRIVO> clientesUsuario = usuario.getClientes();
				for (DadosClienteRIVO dadosCliente : clientesUsuario) {
					System.out.println(dadosCliente.getNmPess());
					if (getFiltroCdPess().equals(dadosCliente.getCdPess())) {
						adiciona = true;
					}
				}
				if (adiciona) {
					usuariosTemp.add(usuario);
					adiciona = false;
				}
			}
		}
		if (null != usuariosTemp) {
			setFiltroUsuarios(usuariosTemp);
		} else {
			setFiltroUsuarios(getUsuarios());
		}
	}
	public String editarUsuario(String CodigoUsuario) {
		IPPLogger.singleton().finest("Chamada a lógica editar um usuário. com o código : " + CodigoUsuario);
		setMensagemSucesso(null);
		setMensagemErro(null);
		setNovoUsuario(obterUsuarioDaLista(CodigoUsuario));
		getNovoUsuario().setClientes(usuarioService.obterClientes(CodigoUsuario));

		IPPLogger.singleton().finest("Usuário obtido da lista: " + novoUsuario.getNome());
		setClientes(null);
		setClientes(usuarioService.obterClientes(usuario));
		setPerfis(null);
		setPerfis(funcionarioService.obterPerfis(usuario.getLogin()));
		setAceito(false);
		return "/EditarUsuarioView.xhtml?faces.redirect=true";
	}

	public String alterarUsuario() {
		IPPLogger.singleton().finest("Alterando dados do usuário" + novoUsuario.getNome());
		setMensagemSucesso(null);
		setMensagemErro(null);
		if(validaPerfis() && validaCliente()) {
			funcionarioService.alterar(novoUsuario);
			setMensagemSucesso("Usuário Alterado com sucesso");
			return voltarHome();
		}else {
			setMensagemErro("Pelomenos um perfil/cliente deve ser adicionado");
			return "falha";
		}
	}

	private boolean validaPerfis() {
		if(null != novoUsuario.getPerfis() && novoUsuario.getPerfis().size() > 0) {
			return true;
		}
		return false;
	}

	private UsuarioVinculadoTO obterUsuarioDaLista(String codigoUsuario) {
		for (UsuarioVinculadoTO usuario : getUsuarios()) {
			if (usuario.getCodigo().equals(codigoUsuario))
				return usuario;
		}
		return null;
	}

	public void validateEmail(FacesContext context, UIComponent component, Object value) {
		String email = (String) value;
		if (!email.contains("@")) {
			((UIInput) component).setValid(false);
			FacesMessage message = new FacesMessage("Email inválido");
			context.addMessage(email, message);
		}
	}

	public void removerCliente(String cdPessDv) {
		DadosClienteRIVO cliente = obterClienteDaLista(novoUsuario.getClientes(), cdPessDv);
		novoUsuario.getClientes().remove(cliente);
		if (novoUsuario.getClientes().size() > 0) {
			if (!verificaSeTemPrincipal(novoUsuario.getClientes())) {
				novoUsuario.getClientes().get(0).setCnpjPrincipal(Boolean.TRUE);
			}
		}
	}

	private boolean verificaSeTemPrincipal(List<DadosClienteRIVO> clientes2) {
		for (DadosClienteRIVO dadosCliente : clientes2) {
			if (dadosCliente.isCnpjPrincipal())
				return true;
		}
		return false;
	}

	private DadosClienteRIVO obterClienteDaLista(List<DadosClienteRIVO> clientesNovoUsuaio, String cdPessDvCliente) {
		for (DadosClienteRIVO clienteNovoUsuario : clientesNovoUsuaio) {
			if (clienteNovoUsuario.getCdPessDv().equals(cdPessDvCliente))
				return clienteNovoUsuario;
		}
		return null;
	}

	public void adicionarCliente() {
		System.out.println("Adicionar Cliente");

		DadosClienteRIVO cliente = usuarioService.obterCliente(usuario, cdPessDv);
		if (novoUsuario.getClientes() == null) {
			novoUsuario.setClientes(new ArrayList<DadosClienteRIVO>());
		}
		if (cliente != null) {
			if (novoUsuario.getClientes().size() == 0)
				cliente.setCnpjPrincipal(Boolean.TRUE);

			if (!novoUsuario.getClientes().contains(cliente)) {
				novoUsuario.getClientes().add(cliente);
			}
		}
	}

	public void removerPerfil(String codigo) {
		PerfilTO perfil = obterPerfil(novoUsuario.getPerfis(), codigo);
		novoUsuario.getPerfis().remove(perfil);
	}

	public void adicionarPerfil() {
		// PerfilTO perfil = funcionarioService.obterPerfil(usuario.getLogin(),
		// codigoPerfil);
		PerfilTO perfil = obterPerfil(codigoPerfil);
		if (novoUsuario.getPerfis() == null) {
			novoUsuario.setPerfis(new ArrayList<PerfilTO>());
		}
		if (perfil != null) {
			if (!novoUsuario.getPerfis().contains(perfil)) {
				novoUsuario.getPerfis().add(perfil);
			}
		}
	}

	private PerfilTO obterPerfil(List<PerfilTO> listaPerfis, String codigo) {
		for (PerfilTO perfilRetorno : listaPerfis) {
			if (perfilRetorno.getCodigo().equals(codigo))
				return perfilRetorno;
		}
		return null;
	}

	public PerfilTO obterPerfil(String codigo) {
		for (PerfilTO perfilRetorno : perfis) {
			if (perfilRetorno.getCodigo().equals(codigo))
				return perfilRetorno;
		}
		return null;
	}

	public String cadastrarUsuario() {
		System.out.println("Cadastrar usuário");
		setMensagemSucesso(null);
		setMensagemErro(null);
		ResponseIncluirFuncionarioCliente incluirFuncionarioCliente = null;
		if (!aceito || novoUsuario.getNome().isEmpty()) {
			System.out.println("Erro na validação");
			return "fail";
		}
		// Incluir funcionário
		if(validaPerfis() && validaCliente()) {
			incluirFuncionarioCliente = funcionarioService.incluir(novoUsuario);
		}else {
			setMensagemSucesso("Pelomenos um perfil/cliente deve ser adicionado");
			return "erro";
		}

		if (incluirFuncionarioCliente.getCodigo() == 1) {
			setMensagemSucesso("Usuário Cadastrado com sucesso");
			return "/HomeView.xhtml?faces.redirect=true";
		} else {
			setMensagemSucesso("Erro ao cadastrar: " + incluirFuncionarioCliente.getMensagem());
			return "erro";
		}
	}

	private boolean validaCliente() {
		if(null != novoUsuario.getClientes() && novoUsuario.getClientes().size() > 0) {
			return true;
		}
		return false;
	}

	public String resetDeSennha(String loginUsuario) {
		String resetSenha = funcionarioService.resetSenha(usuario, loginUsuario);
		System.out.println("Reset de senha do: " + loginUsuario + resetSenha);
		setMensagemSucesso("Pedido de reset de senha enviado. " + resetSenha);
		return SUCCESS;
	}

	public String voltarHome() {
		return "/HomeView.xhtml?faces.redirect=true";
	}

	public void apagarMensagem() {
		System.out.println("Apagando a mensagem");
		setMensagemSucesso(null);
		setMensagemErro(null);
	}

	public String getHome() {

		return home;
	}

	public String getMensagemSucesso() {
		return mensagemSucesso;
	}

	public void setMensagemSucesso(String mensagemSucesso) {
		this.mensagemSucesso = mensagemSucesso;
	}

	public boolean isAceito() {
		return aceito;
	}

	public void setAceito(boolean aceito) {
		this.aceito = aceito;
	}

	public UsuarioTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioTO usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioVinculadoTO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioVinculadoTO> usuarios) {
		this.usuarios = usuarios;
	}

	public List<DadosClienteRIVO> getClientes() {
		return clientes;
	}

	public void setClientes(List<DadosClienteRIVO> clientes) {
		this.clientes = clientes;
	}

	public PerfilLogadoTO getPerfilLogado() {
		return perfilLogado;
	}

	public void setPerfilLogado(PerfilLogadoTO perfilLogado) {
		this.perfilLogado = perfilLogado;
	}

	public String getCentralDeAjuda() {
		return centralDeAjuda;
	}

	public void setCentralDeAjuda(String centralDeAjuda) {
		this.centralDeAjuda = centralDeAjuda;
	}

	public UsuarioVinculadoTO getNovoUsuario() {
		return novoUsuario;
	}

	public void setNovoUsuario(UsuarioVinculadoTO novoUsuario) {
		this.novoUsuario = novoUsuario;
	}

	public List<PerfilTO> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<PerfilTO> perfis) {
		this.perfis = perfis;
	}

	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	public void setCodigoPerfil(String idPerfil) {
		this.codigoPerfil = idPerfil;
	}

	public String getCdPessDv() {
		return cdPessDv;
	}

	public void setCdPessDv(String cdPessDv) {
		this.cdPessDv = cdPessDv;
	}

	public PerfilTO getPerfilSelecionado() {
		return perfilSelecionado;
	}

	public void setPerfilSelecionado(PerfilTO perfilSelecionado) {
		this.perfilSelecionado = perfilSelecionado;
	}

	public List<UsuarioVinculadoTO> getPaginaUsuarios() {
		return paginaUsuarios;
	}

	public void setPaginaUsuarios(List<UsuarioVinculadoTO> paginaUsuarios) {
		this.paginaUsuarios = paginaUsuarios;
	}

	public List<UsuarioVinculadoTO> getFiltroUsuarios() {
		return filtroUsuarios;
	}

	public void setFiltroUsuarios(List<UsuarioVinculadoTO> filtroUsuarios) {
		this.filtroUsuarios = filtroUsuarios;
	}

	public String getFiltroCdPess() {
		return filtroCdPess;
	}

	public void setFiltroCdPess(String filtroCdPess) {
		this.filtroCdPess = filtroCdPess;
	}

	public String getFiltroStatus() {
		return filtroStatus;
	}

	public void setFiltroStatus(String filtroStatus) {
		this.filtroStatus = filtroStatus;
	}

	public int getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public int getPaginaSelecionada() {
		return paginaSelecionada;
	}

	public void setPaginaSelecionada(int paginaSelecionada) {
		this.paginaSelecionada = paginaSelecionada;
	}

	public List<String> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<String> paginas) {
		this.paginas = paginas;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
}
