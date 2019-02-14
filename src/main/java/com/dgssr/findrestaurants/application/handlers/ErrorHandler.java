package com.dgssr.findrestaurants.application.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dgssr.findrestaurants.infrastructure.exceptions.AddressNotFoundException;
import com.dgssr.findrestaurants.infrastructure.exceptions.ContactNotFoundException;
import com.dgssr.findrestaurants.infrastructure.exceptions.RestaurantNotFoundException;

/**
 * This handler is intended to be generic. It has a simple mechanism to identify
 * exceptions and internationalized messages for each exception.
 * 
 * The error massages and each status can be managed trough the
 * messages.properties file.
 * 
 * @author
 *
 */
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ AddressNotFoundException.class, ContactNotFoundException.class, RestaurantNotFoundException.class})
	protected ResponseEntity<Object> handleEmptyExceptions(Exception exception, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpStatus status = HttpStatus.OK;
		return handleExceptionInternal(exception, new Error(status.value(), exception.getMessage()), headers, status,
				request);
	}
	
	@ExceptionHandler({ Exception.class})
	protected ResponseEntity<Object> handlExceptions(Exception exception, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
		return handleExceptionInternal(exception, new Error(status.value(), exception.getMessage()), headers, status,
				request);
	}

}
