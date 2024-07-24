package com.banking_app.banking_app.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.banking_app.banking_app.dto.AccountDto;
import com.banking_app.banking_app.entity.Account;
import com.banking_app.banking_app.exceptions.AccountExceptions;
import com.banking_app.banking_app.mapper.AccountMapper;
import com.banking_app.banking_app.repository.AccountRepository;
import com.banking_app.banking_app.service.AccountService;


@Service // create a spring bean for this class
public class AccountServiceImpl implements AccountService {

    //Dependancy injection
    private AccountRepository accountRepository;


    // @Autowired automaticalyy inject the dependancy
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    

/**
 * convert account DTO into account JPA entity
 * then save account JPA entity int database
 * (Meantime conversion logic)
 * @param accountDto
 * @return
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


@Override
public AccountDto getAccountByID(Long id) {

Account account = accountRepository.
findById(id).
orElseThrow(()->new AccountExceptions("Account is not registered"));

return AccountMapper.mapToAccountDto(account);

}


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


@Override
public List<AccountDto> getAllAccounts() {
   
List<Account> accounts = accountRepository.findAll();

return accounts.stream().
map((account)-> AccountMapper.
mapToAccountDto(account)).
collect(Collectors.toList());


}


@Override
public void deleteAccount(Long id) {


    Account account = accountRepository.
    findById(id).
    orElseThrow(()->new AccountExceptions("Account is not registered"));

    accountRepository.deleteById(id);


}
  
    


    
}