package com.aamir.game.exception;


public class SystemException extends RuntimeException {
    public SystemException(String message, Exception ex) {
        super(message, ex);
    }

    public SystemException(String message) {
        super(message);
    }
}
