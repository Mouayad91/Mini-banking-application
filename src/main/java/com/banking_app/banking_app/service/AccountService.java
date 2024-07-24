package com.banking_app.banking_app.service;

import java.util.List;

import com.banking_app.banking_app.dto.AccountDto;
import com.banking_app.banking_app.dto.TransfareFundDto;
/**
 * Service interface for account-related operations.
 */
public interface  AccountService {
    

AccountDto createAccount(AccountDto accountDto);

AccountDto getAccountByID(Long id);

AccountDto deposite(Long id, double amount);

AccountDto withDraw(Long id, double amount);

List<AccountDto> getAllAccounts();

void deleteAccount(Long id);

void transfareFund(TransfareFundDto transfareFundDto);

}