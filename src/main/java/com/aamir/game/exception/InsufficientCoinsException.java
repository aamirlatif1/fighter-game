package com.aamir.game.exception;

public class InsufficientCoinsException extends RuntimeException {
    public InsufficientCoinsException(String message) {
        super(message);
    }
}
