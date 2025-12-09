package com.flipfit.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.flipfit.dao.ErrorResponse;
import com.flipfit.exception.DetailsNotAvailableException;
import com.flipfit.exception.NoPendingCenterException;
import com.flipfit.exception.NoPendingOwnerException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DetailsNotAvailableException.class)
	public ResponseEntity<ErrorResponse> handleApprovalNotDoneException(DetailsNotAvailableException ex,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoPendingCenterException.class)
	public ResponseEntity<ErrorResponse> handleNoPendingCenterException(NoPendingCenterException ex,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoPendingOwnerException.class)
	public ResponseEntity<ErrorResponse> handleNoPendingOwnerException(NoPendingOwnerException ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
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
