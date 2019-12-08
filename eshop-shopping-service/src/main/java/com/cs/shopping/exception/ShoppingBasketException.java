package com.cs.shopping.exception;

public class ShoppingBasketException extends RuntimeException {
    public ShoppingBasketException() {
        super();
    }
    public ShoppingBasketException(final String message) {
        super(message);
    }
}
