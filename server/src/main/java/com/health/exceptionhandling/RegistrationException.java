package com.health.exceptionhandling;

public class RegistrationException extends RuntimeException{

    public RegistrationException(String message){
        super(message);
    }

}
