package com.librarian.exception;

public class CheckoutErrorRuntimeException extends RuntimeException {

    public CheckoutErrorRuntimeException(String message) {
        super(message);
    }
}
