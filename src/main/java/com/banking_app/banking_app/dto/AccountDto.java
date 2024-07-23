package com.banking_app.banking_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data //automatically generate getter,setter methods
@AllArgsConstructor
@NoArgsConstructor

// Dto class to transfare data between server and client
public class AccountDto {
    
    private Long id;
    private String accountOwnerName;
    private double balance;



}