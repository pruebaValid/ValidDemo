package com.valid.demo.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final String NO_FOUND_USUARIO = "USUARIO NO FOUND";
	 
    @ExceptionHandler(UsuarioNoFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException
                        (UsuarioNoFoundException ex, WebRequest request) 
    {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse(NO_FOUND_USUARIO, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	
	
}
