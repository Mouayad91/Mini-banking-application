package com.banking_app.banking_app.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.banking_app.banking_app.dto.AccountDto;
import com.banking_app.banking_app.dto.TransfareFundDto;
import com.banking_app.banking_app.entity.Account;
import com.banking_app.banking_app.exceptions.AccountExceptions;
import com.banking_app.banking_app.mapper.AccountMapper;
import com.banking_app.banking_app.repository.AccountRepository;
import com.banking_app.banking_app.service.AccountService;

/**
 * Implementation of AccountService interface.
 */

@Service // Marks this class as a Spring service component
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;


    // Constructor-based dependency injection
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    

    /** 
     * Creates a new account.
     * @param accountDto - the account details
     * @return the created account details
     */
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
       
        Account account = AccountMapper.mapToAccount(accountDto);

      /**
       * save account JPA entity and pass account to object
       * return the saved entity
       */
     Account savedAccount =  accountRepository.save(account);
       
     return AccountMapper.mapToAccountDto(savedAccount) ;

    }

    /**
     * Retrieves account details by ID.
     * @param id - the account ID
     * @return the account details
     */

        @Override
        public AccountDto getAccountByID(Long id) {

        Account account = accountRepository.
        findById(id).
        orElseThrow(()->new AccountExceptions("Account is not registered"));

        return AccountMapper.mapToAccountDto(account);

}


    /**
     * Deposits a specified amount into an account.
     * @param id - the account ID
     * @param amount - the amount to deposit
     * @return the updated account details
     */

    @Override
    public AccountDto deposite(Long id, double amount) {

    Account account = accountRepository.
    findById(id).
    orElseThrow(()->new AccountExceptions("Account is not registered"));
    


    double total = account.getBalance() + amount;

    account.setBalance(total);

   Account savedAccount = accountRepository.save(account);

   return AccountMapper.mapToAccountDto(savedAccount);
}

    /**
     * Withdraws a specified amount from an account.
     * @param id - the account ID
     * @param amount - the amount to withdraw
     * @return the updated account details
     */
    @Override
    public AccountDto withDraw(Long id, double amount) {
    

    Account account = accountRepository.
    findById(id).
    orElseThrow(()->new AccountExceptions("Account is not registered"));

    if(account.getBalance() < amount){

        throw new RuntimeException("Something went wrong");
    }

    double total = account.getBalance() - amount;

    account.setBalance(total);
    Account savedAccount = accountRepository.save(account);

    return AccountMapper.mapToAccountDto(savedAccount);

}
    /**
     * Retrieves all accounts.
     * @return a list of all accounts
     */

    @Override
    public List<AccountDto> getAllAccounts() {
   
    List<Account> accounts = accountRepository.findAll();

    return accounts.stream().
    map((account)-> AccountMapper.
    mapToAccountDto(account)).
    collect(Collectors.toList());


}

    /**
     * Deletes an account by ID.
     * @param id - the account ID
     */
    @Override
    public void deleteAccount(Long id) {


    Account account = accountRepository.
    findById(id).
    orElseThrow(()->new AccountExceptions("Account is not registered"));

    accountRepository.deleteById(id);


}

    /**
     * Transfers funds from one account to another.
     * @param transfareFundDto - the fund transfer details
     */
    @Override
    public void transfareFund(TransfareFundDto transfareFundDto) {
   
    
    // Retrieve the account from which funds are to be transferred
    Account fromAccount = accountRepository.
    findById(transfareFundDto.fromAcccountId()).
    orElseThrow(()->new AccountExceptions("Account is not registered"));
    
    // Retrieve the account to which funds are to be transferred
    Account toAccount = accountRepository.
    findById(transfareFundDto.toAccountId())
    .orElseThrow(()->new AccountExceptions("Account is not registered"));

    // Deduct the specified amount from the source account
    fromAccount.setBalance(fromAccount.getBalance() - transfareFundDto.amount());
     // Add the specified amount to the destination account
    toAccount.setBalance(toAccount.getBalance() + transfareFundDto.amount());
    

    // Save the updated source account to the repository
    accountRepository.save(fromAccount);
    // Save the updated destination account to the repository
    accountRepository.save(toAccount);


}
  
    


    
}