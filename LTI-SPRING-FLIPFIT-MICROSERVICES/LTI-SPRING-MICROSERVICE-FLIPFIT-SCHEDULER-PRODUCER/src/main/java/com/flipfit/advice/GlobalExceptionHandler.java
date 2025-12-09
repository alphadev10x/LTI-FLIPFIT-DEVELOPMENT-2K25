package com.flipfit.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.flipfit.dao.ErrorResponse;
import com.flipfit.exception.ScheduleNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ScheduleNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleScheduleNotFoundException(ScheduleNotFoundException ex, WebRequest request) {
	    ErrorResponse errorResponse = new ErrorResponse(
	            LocalDateTime.now(),
	            ex.getMessage(),
	            request.getDescription(false)
	    );
	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
	    ErrorResponse errorResponse = new ErrorResponse(
	            LocalDateTime.now(),
	            "An unexpected error occurred",
	            request.getDescription(false)
	    );
	    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
