package com.sistrans.exception;

public class AppLogicException extends RuntimeException {
    
    public AppLogicException(String message) {
        super(message);
    }
    
    public AppLogicException(String message, Throwable cause) {
        super(message, cause);
    }
}
