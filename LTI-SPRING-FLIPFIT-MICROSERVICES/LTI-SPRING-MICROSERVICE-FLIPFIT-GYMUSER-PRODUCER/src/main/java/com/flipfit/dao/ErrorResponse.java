package com.flipfit.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String details;

	public ErrorResponse(LocalDateTime timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	// Getters
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}