package com.whyr.timezoneconverter.service.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ServiceException extends RuntimeException {

	private final String errorMessage;
	private final HttpStatus httpStatus;

	public ServiceException(String errorMessage) {

		this(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ServiceException(String errorMessage, HttpStatus httpStatus) {

		super(errorMessage);

		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

}
