package com.banking_app.banking_app.dto;


/**
 * Data Transfer Object for transferring funds between accounts.
 */

public record  TransfareFundDto(Long fromAcccountId, 
Long toAccountId,
double amount) {
    
}
