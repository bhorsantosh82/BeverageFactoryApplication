package com.demo.app.exception;

public class InvalidOrderException extends RuntimeException {

    public InvalidOrderException(String errorMessage) {
        super(errorMessage);
    }
}
