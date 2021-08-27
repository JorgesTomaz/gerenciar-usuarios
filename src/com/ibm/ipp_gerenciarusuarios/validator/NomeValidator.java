package com.ibm.ipp_gerenciarusuarios.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator.nome")
public class NomeValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object valor) throws ValidatorException {
		String nome = String.valueOf(valor);
		if(null == valor || "".equals(nome)) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Campo Nome é obrigatório");
			message.setDetail("Campo Nome é obrigatório");
			throw new ValidatorException(message);
		}
	}

}
