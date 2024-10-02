package com.liza.rest.my_controller;

public class CreamNotFoundException extends RuntimeException {

    public CreamNotFoundException(String message) {
        super(message);
    }

    public CreamNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreamNotFoundException(Throwable cause) {
        super(cause);
    }
}
