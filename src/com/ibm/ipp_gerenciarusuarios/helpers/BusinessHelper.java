package com.ibm.ipp_gerenciarusuarios.helpers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ibm.ipp_gerenciarusuarios.to.UsuarioVinculadoTO;

import cbpi.fit.saa.ws.usuarioportal.DadosClienteRIVO;

@ManagedBean(name="businesshelper")
@RequestScoped
public class BusinessHelper implements Serializable{

	private static final long serialVersionUID = -8159828982117782314L;
	// recupera o context faces.
	//FacesContext context = FacesContext.getCurrentInstance();
	// recupera o viewhelper da sessão
	//ViewHelper viewhelper = (ViewHelper) context.getExternalContext().getSessionMap().get("viewhelper");
	

}
