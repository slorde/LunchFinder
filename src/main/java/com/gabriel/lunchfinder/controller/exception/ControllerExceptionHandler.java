package com.gabriel.lunchfinder.controller.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> badRequest(BadRequestException e, HttpServletRequest req) {
		StandardError error = new StandardError(BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(BAD_REQUEST).body(error);
	}

}
