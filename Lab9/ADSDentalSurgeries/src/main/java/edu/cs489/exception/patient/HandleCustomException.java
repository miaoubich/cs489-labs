package edu.cs489.exception.patient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.cs489.model.ErrorMessage;

@RestControllerAdvice
public class HandleCustomException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(PatientServiceCustomException.class)
	public ResponseEntity<ErrorMessage> handlePatientException(PatientServiceCustomException exception){
		return new ResponseEntity<>(ErrorMessage.builder()
								.errorCode(exception.getErrorCode())
								.errorMassage(exception.getMessage())
								.build(), exception.getStatus());
	}
}
