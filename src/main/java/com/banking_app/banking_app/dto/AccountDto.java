package com.banking_app.banking_app.dto;

import lombok.Data;



@Data //automatically generate constructor,getter,setter methods

// Dto class to transfare data between server and client
public class AccountDto {
    
    private Long id;
    private String accountOwnerName;
    private double balance;



}
