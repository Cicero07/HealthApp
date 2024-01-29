package com.health.exceptionhandling;

public class IntegrationException extends RuntimeException {

    private String errorCode;

    public IntegrationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public IntegrationException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

