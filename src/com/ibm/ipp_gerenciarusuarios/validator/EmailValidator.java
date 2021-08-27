package com.ibm.ipp_gerenciarusuarios.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator.email")
public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object valor) throws ValidatorException {
		String email = String.valueOf(valor);
		//Properties
		if(null == valor || "".equals(email)) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Campo E-mail é obrigatório");
			message.setDetail("Campo E-mail é obrigatório");
			throw new ValidatorException(message);
		}
		if(!validaEmail(email)) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("E-mail inválido");
			message.setDetail("E-mail inválido");
			throw new ValidatorException(message);
		}
	}

	private static boolean validaEmail(String email) {
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches())
			return true;
		return false;
	}

}
