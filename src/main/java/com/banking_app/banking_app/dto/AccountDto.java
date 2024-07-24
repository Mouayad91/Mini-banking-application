package com.banking_app.banking_app.dto;
// @AllArgsConstructor
// @NoArgsConstructor

// // Dto class to transfare data between server and client
// public class AccountDto {
    
//     private Long id;
//     private String accountOwnerName;
//     private double balance;



// }


public record AccountDto(Long id, 
String accountOwnerName,
 double balance){



}