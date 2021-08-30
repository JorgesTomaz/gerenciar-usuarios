package com.ibm.ipp_gerenciarusuarios.helpers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="businesshelper")
@RequestScoped
public class BusinessHelper implements Serializable{

	private static final long serialVersionUID = -8159828982117782314L;
	// recupera o context faces.
	//FacesContext context = FacesContext.getCurrentInstance();
	// recupera o viewhelper da sessão
	//ViewHelper viewhelper = (ViewHelper) context.getExternalContext().getSessionMap().get("viewhelper");
	

}
