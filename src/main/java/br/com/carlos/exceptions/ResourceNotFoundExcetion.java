package br.com.carlos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceNotFoundExcetion extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExcetion(String ex) {
		super(ex);
	}
}
