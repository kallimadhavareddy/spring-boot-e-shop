package com.cs.customer.exception;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound() {
        super();
    }
    public CustomerNotFound(final String message) {
        super(message);
    }
}
