package com.whyr.timezoneconverter.controller.exception;

import com.whyr.timezoneconverter.service.exceptions.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {ServiceException.class})
	private ResponseEntity<String> returnException(ServiceException ex) {

		return new ResponseEntity<>(ex.getErrorMessage(), ex.getHttpStatus());
	}


}
