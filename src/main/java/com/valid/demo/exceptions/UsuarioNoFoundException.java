package com.valid.demo.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioNoFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9138339105277592237L;
	private HttpStatus httpStatus;
	private String message;
	
	
	public UsuarioNoFoundException(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}
	

}
