package com.ibm.ipp_gerenciarusuarios.exception;

import java.util.Map;

public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 6332572080221837919L;
	private Integer statusCode = null;
	private String forwardPath = null;
	private String forwardName = null;
	private Map<String, String> mapFieldsErros = null;
	/**
	 * @param statusCode
	 * @param message
	 */
	public BusinessException(Integer statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getForwardPath() {
		return forwardPath;
	}
	public void setForwardPath(String forwardPath) {
		this.forwardPath = forwardPath;
	}
	public String getForwardName() {
		return forwardName;
	}
	public void setForwardName(String forwardName) {
		this.forwardName = forwardName;
	}
	public Map<String, String> getMapFieldsErros() {
		return mapFieldsErros;
	}
	public void setMapFieldsErros(Map<String, String> mapFieldsErros) {
		this.mapFieldsErros = mapFieldsErros;
	}
}
