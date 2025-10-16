package com.sevenb.invoices.exception;

/**
 * Class for Not Found Exceptions
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
