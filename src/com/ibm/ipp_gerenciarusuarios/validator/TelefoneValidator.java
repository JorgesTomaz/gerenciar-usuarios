package com.ibm.ipp_gerenciarusuarios.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator.telefone")
public class TelefoneValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object valor) throws ValidatorException {
		String telefone = String.valueOf(valor);
		if(null == valor || "".equals(telefone)) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Campo telefone � obrigat�rio");
			message.setDetail("Campo telefone � obrigat�rio");
			throw new ValidatorException(message);
		}
		if(!validaTelefone(telefone)) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Telefone inv�lido");
			message.setDetail("Telefone inv�lido");
			throw new ValidatorException(message);
		}
	}

	private boolean validaTelefone(String telefone) {
		telefone = telefone.replaceAll("[^0-9]", "");
		if(telefone.length() >= 10 || telefone.length() <= 11) {
			return true;
		}
		return false;
	}

}
