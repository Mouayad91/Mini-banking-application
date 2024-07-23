package com.banking_app.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking_app.banking_app.entity.Account;

public interface  AccountRepository extends JpaRepository<Account, Long> {
    
}