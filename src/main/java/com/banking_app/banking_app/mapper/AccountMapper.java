package com.banking_app.banking_app.mapper;

import com.banking_app.banking_app.dto.AccountDto;
import com.banking_app.banking_app.entity.Account;

public class AccountMapper {
    
//converts account dto into JAP entity
public static Account mapToAccount(AccountDto accountDto){
   
   Account account = new Account( accountDto.getId(),
   accountDto.getAccountOwnerName(),
   accountDto.getBalance());
  
    return account;

    
}

// convert account JPA entity into account dto
public static AccountDto mapToAccountDto(Account account){

    AccountDto accountDto = new AccountDto(
    account.getId(),
    account.getAccountOwnerName(),
    account.getBalance()

    );


    return accountDto;
}


}