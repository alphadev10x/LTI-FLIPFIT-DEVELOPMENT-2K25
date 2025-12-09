package com.flipfit.exception;

public class NoPendingOwnerException extends RuntimeException {
    public NoPendingOwnerException(String message) {
        super(message);
    } 
}
