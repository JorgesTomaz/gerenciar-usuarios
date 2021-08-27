package com.ibm.ipp_gerenciarusuarios.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator.senha")
public class SenhaValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object valor) throws ValidatorException {
		String senha = String.valueOf(valor);
		if(null == valor || "".equals(senha)) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Campo obrigatório");
			message.setDetail("Campo obrigatório");
			throw new ValidatorException(message);
		}
	}

}
