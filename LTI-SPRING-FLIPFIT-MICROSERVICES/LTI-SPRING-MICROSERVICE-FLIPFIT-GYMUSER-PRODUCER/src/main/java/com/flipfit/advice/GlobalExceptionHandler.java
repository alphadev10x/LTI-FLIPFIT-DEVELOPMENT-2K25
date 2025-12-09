package com.flipfit.advice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.flipfit.dao.ErrorResponse;
import com.flipfit.exception.RegistrationNotDoneException;
import com.flipfit.exception.UserNotFoundException;



public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
	    ErrorResponse errorResponse = new ErrorResponse(
	            LocalDateTime.now(),
	            ex.getMessage(),
	            request.getDescription(false)
	    );
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(RegistrationNotDoneException.class)
	public ResponseEntity<ErrorResponse> handleRegistrationNotDoneException(RegistrationNotDoneException ex, WebRequest request) {
	    ErrorResponse errorResponse = new ErrorResponse(
	            LocalDateTime.now(),
	            ex.getMessage(),
	            request.getDescription(false)
	    );
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<Map<String, String>> handleValidationExceptions(
             MethodArgumentNotValidException ex) {
         Map<String, String> errors = new HashMap<>();
         ex.getBindingResult().getFieldErrors().forEach(error ->
                 errors.put(error.getField(), error.getDefaultMessage()));
         return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
     }
	
	
	
	
	
}
