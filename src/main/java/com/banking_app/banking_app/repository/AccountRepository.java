package com.banking_app.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking_app.banking_app.entity.Account;
/**
 * Repository interface for Account entity.
 */
public interface  AccountRepository extends JpaRepository<Account, Long> {
    
}