/**
 * 
 */
package com.flipfit.exception;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipfit.dao.ErrorResponse;
import com.google.gson.Gson;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;

/**
 * 
 */
public class CustomFeignErrorDecoder implements ErrorDecoder {
	private static final Logger logger = LoggerFactory.getLogger(CustomFeignErrorDecoder.class);

	@Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus status = HttpStatus.valueOf(response.status());
        String responseBody = extractResponseBody(response);
        Gson gson = new Gson();
        // Log error details
        logger.error("Feign client error. Method: {}, Status: {}, Body: {}", 
                     methodKey, status, responseBody);
        ErrorResponse errorResponse = gson.fromJson(responseBody, ErrorResponse.class);
        System.out.println("\nJSON string converted to Java object:");
        System.out.println(errorResponse);

        // Map status codes to exceptions
        switch (status) {
            case BAD_REQUEST:
                return new IllegalArgumentException("Invalid request: " + responseBody);
            case UNAUTHORIZED:
                return new SecurityException("Unauthorized access");
            case FORBIDDEN:
                return new AccessDeniedException("Access forbidden");
            case NOT_FOUND:
                return new Exception("Resource not found");
            case INTERNAL_SERVER_ERROR:
            	System.out.println("Coming here ");
                return new UserNotFoundException(errorResponse.getMessage());
            case SERVICE_UNAVAILABLE:
                return new RetryableException(response.status(), "Service unavailable", null, null, null);
            default:
                return new Exception("Unexpected error: " + responseBody);
        }
    }

    private String extractResponseBody(Response response) {
        if (response.body() == null) {
            return "No response body";
        }

        try {
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            logger.error("Failed to read response body", ex);
            return "Error reading response body";
        }
    }
}
