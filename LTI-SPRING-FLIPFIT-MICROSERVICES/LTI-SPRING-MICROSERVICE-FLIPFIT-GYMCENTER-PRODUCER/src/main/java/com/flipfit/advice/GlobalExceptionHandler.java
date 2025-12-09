package com.flipfit.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.flipfit.dao.ErrorResponse;
import com.flipfit.exception.DetailsNotAvailableException;

public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(DetailsNotAvailableException.class)
	public ResponseEntity<ErrorResponse> handleApprovalNotDoneException(DetailsNotAvailableException ex, WebRequest request) {
	    ErrorResponse errorResponse = new ErrorResponse(
	            LocalDateTime.now(),
	            ex.getMessage(),
	            request.getDescription(false)
	    );
	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
}
