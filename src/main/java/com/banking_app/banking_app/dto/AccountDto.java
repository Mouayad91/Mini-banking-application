package com.banking_app.banking_app.dto;



/**
 * Data Transfer Object for Account.
 */
public record AccountDto(Long id, 
String accountOwnerName,
 double balance){

}