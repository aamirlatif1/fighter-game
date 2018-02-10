package com.aamir.game.exception;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message, Exception e) {
        super(message, e);
    }

    public ResourceNotFoundException(String mesage) {
        super(mesage);
    }
}
