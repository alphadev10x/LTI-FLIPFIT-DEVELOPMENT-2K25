package com.flipfit.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.flipfit.dao.ErrorResponse;
import com.flipfit.exception.BookingFullException;
import com.flipfit.exception.BookingNotFoundException;
import com.flipfit.exception.DetailsNotAvailableException;
import com.flipfit.exception.SlotsNotAvailableException;
import com.flipfit.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleBookingNotFoundException(BookingNotFoundException ex, WebRequest request) {
	    ErrorResponse errorResponse = new ErrorResponse(
	            LocalDateTime.now(),
	            ex.getMessage(),
	            request.getDescription(false)
	    );
	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookingFullException.class)
	public ResponseEntity<ErrorResponse> handleBookingFullException(BookingFullException ex,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
	    ErrorResponse errorResponse = new ErrorResponse(
	            LocalDateTime.now(),
	            ex.getMessage(),
	            request.getDescription(false)
	    );
	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SlotsNotAvailableException.class)
	public ResponseEntity<ErrorResponse> handleSlotsNotAvailableException(SlotsNotAvailableException ex, WebRequest request) {
	    ErrorResponse errorResponse = new ErrorResponse(
	            LocalDateTime.now(),
	            ex.getMessage(),
	            request.getDescription(false)
	    );
	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DetailsNotAvailableException.class)
	public ResponseEntity<ErrorResponse> handleApprovalNotDoneException(DetailsNotAvailableException ex, WebRequest request) {
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
	            ex.getMessage(),
	            request.getDescription(false)
	    );
	    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
