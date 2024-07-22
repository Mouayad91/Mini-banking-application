package com.banking_app.banking_app.service.impl;


import org.springframework.stereotype.Service;

import com.banking_app.banking_app.dto.AccountDto;
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
       
        return null;

    }
    
}
