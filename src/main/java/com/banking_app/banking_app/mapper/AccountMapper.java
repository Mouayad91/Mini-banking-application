package com.banking_app.banking_app.mapper;

import com.banking_app.banking_app.dto.AccountDto;
import com.banking_app.banking_app.entity.Account;

public class AccountMapper {
    
//converts objects from one type to another
public static Account mapToAccount(AccountDto accountDto){
   
   Account account = new Account( accountDto.getId(),
   accountDto.getAccountOwnerName(),
   accountDto.getBalance());
  
    return account;

    
}


}
