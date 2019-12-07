package com.cs.product.exception;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound() {
        super();
    }
    public ProductNotFound(final String message) {
        super(message);
    }
}
