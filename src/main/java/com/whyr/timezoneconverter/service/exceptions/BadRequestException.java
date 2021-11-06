package com.whyr.timezoneconverter.service.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ServiceException {

	public BadRequestException(String errorMessage) {

		super(errorMessage, HttpStatus.BAD_REQUEST);
	}

}
