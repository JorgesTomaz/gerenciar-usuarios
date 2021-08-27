package com.ibm.ipp_gerenciarusuarios.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator.CpfValidator")
public class CpfValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object valor) throws ValidatorException {
		String cpf = String.valueOf(valor);
		if(valor == null || "".equals(cpf)) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Campo CPF é obrigatório");
			message.setDetail("Campo CPF é obrigatório");
			throw new ValidatorException(message);
		}
		if(!validaCPF(cpf)) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("CPF inválido.");
			message.setDetail("CPF inválido.");
			throw new ValidatorException(message);
		}
	}

	private static boolean validaCPF(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");
		if(cpf == null || cpf.length() != 11 || isCPFPadrao(cpf)) {
			return false;
		}
		try {
			Long.parseLong(cpf);
		} catch (NumberFormatException e) {
			return false;
		}
		return calcDigVerif(cpf.substring(0, 9)).equals(cpf.substring(9, 11));
	}

	private static String calcDigVerif(String num) {
		Integer primDig, segDig;
		int soma = 0, peso = 10;
		for(int i = 0; i < num.length(); i++ )
			soma += Integer.parseInt(num.substring(i, i + 1))* peso --;
		
		if(soma % 11 == 0 | soma % 11 == 1) {
			primDig = new Integer(0);
		}else {
			primDig = new Integer(11 - (soma % 11));
		}
		soma = 0;
		peso = 11;
		for(int i = 0; i < num.length(); i++ )
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		soma += primDig.intValue() * 2;
		if(soma % 11 == 0 | soma % 11 == 1)
			segDig = new Integer(0);
		else
			segDig = new Integer(11 - (soma % 11));
		
		return primDig.toString() + segDig.toString();
	}

	private static boolean isCPFPadrao(String cpf) {
		System.out.println(cpf);
		if(cpf.equals("11111111111")||
				cpf.equals("22222222222")||
				cpf.equals("33333333333")||
				cpf.equals("44444444444")||
				cpf.equals("55555555555")||
				cpf.equals("66666666666")||
				cpf.equals("77777777777")||
				cpf.equals("88888888888")||
				cpf.equals("99999999999")) {
			System.out.println("padrão");
			return true;
		}
		System.out.println("Não padrão");
		return false;
	}

}
