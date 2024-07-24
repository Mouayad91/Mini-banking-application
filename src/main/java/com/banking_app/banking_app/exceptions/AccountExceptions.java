package com.banking_app.banking_app.exceptions;

/**
 * Custom exception class for account-related errors.
 */

public class AccountExceptions extends RuntimeException {

    public AccountExceptions(String message) {
        super(message);
    }
}
