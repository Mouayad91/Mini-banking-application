package com.banking_app.banking_app.mapper;

import com.banking_app.banking_app.dto.AccountDto;
import com.banking_app.banking_app.entity.Account;

/**
 * Mapper class for converting between Account entity and Account DTO.
 */

public class AccountMapper {
    
    /**
     * Converts AccountDto to Account entity.
     * @param accountDto - the account DTO
     * @return the account entity
     */public static Account mapToAccount(AccountDto accountDto){
   
   Account account = new Account( 
    accountDto.id(),
   accountDto.accountOwnerName(),
   accountDto.balance());
  
    return account;

    
}

    /**
     * Converts Account entity to AccountDto.
     * @param account - the account entity
     * @return the account DTO
     */public static AccountDto mapToAccountDto(Account account){

    AccountDto accountDto = new AccountDto(
    account.getId(),
    account.getAccountOwnerName(),
    account.getBalance()

    );


    return accountDto;
}


}