package edu.cs489.exception.address;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class AddressServiceCustomException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private HttpStatus status;
	
	public AddressServiceCustomException(String message, String errorCode, HttpStatus notFound) {
		super(message);
		this.errorCode = errorCode;
		this.status = notFound;
	}

}
