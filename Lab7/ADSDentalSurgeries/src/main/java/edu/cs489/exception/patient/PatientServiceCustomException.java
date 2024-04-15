package edu.cs489.exception.patient;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class PatientServiceCustomException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private HttpStatus status;
	
	public PatientServiceCustomException(String message, String errorCode, HttpStatus notFound) {
		super(message);
		this.errorCode = errorCode;
		this.status = notFound;
	}

}
