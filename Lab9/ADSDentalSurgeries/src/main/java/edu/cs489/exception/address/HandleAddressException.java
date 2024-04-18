package edu.cs489.exception.address;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.cs489.model.ErrorMessage;

@ControllerAdvice
public class HandleAddressException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AddressServiceCustomException.class)
	public ResponseEntity<ErrorMessage> handlePatientException(AddressServiceCustomException exception){
		return new ResponseEntity<>(ErrorMessage.builder()
								.errorCode(exception.getErrorCode())
								.errorMassage(exception.getMessage())
								.build(), exception.getStatus());
	}
}
