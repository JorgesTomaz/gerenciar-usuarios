package com.ibm.ipp_gerenciarusuarios.converter;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ibm.ipp_gerenciarusuarios.helpers.ViewHelper;
import com.ibm.ipp_gerenciarusuarios.to.PerfilTO;

@FacesConverter("perfilConverter")
public class PerfilConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String codigo) throws ConverterException {
		ValueExpression vex = 
				ctx.getApplication().getExpressionFactory()
				.createValueExpression(ctx.getELContext(), "#{viewhelper}", ViewHelper.class);
		ViewHelper viewHelper = (ViewHelper)vex.getValue(ctx.getELContext());
		
		return viewHelper.obterPerfil(codigo);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object perfil) throws ConverterException {
		return ((PerfilTO)perfil).getCodigo();
	}

}
