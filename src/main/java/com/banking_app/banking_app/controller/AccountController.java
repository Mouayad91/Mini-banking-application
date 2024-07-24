package com.banking_app.banking_app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking_app.banking_app.dto.AccountDto;
import com.banking_app.banking_app.service.AccountService;


@RestController // Make this class a Spring MVC REST controller
@RequestMapping("/api/accounts") // Base URL for all controller methods
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Add account REST API
     * Return type ResponseEntity
     */
    @PostMapping // This maps to "/api/accounts"
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        
        AccountDto accountDto = accountService.getAccountByID(id);
        
        return new ResponseEntity<>(accountDto,HttpStatus.OK);
    }
    

    //Deposite rest API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){


    double amount = request.get("amount");
     AccountDto accountDto= accountService.deposite(id, amount);
   
        return ResponseEntity.ok(accountDto);
  
    }

    // Withdraw amount REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withDraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withDraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }




    // Get all Accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
    List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }


    //Delete Account 

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){

         accountService.deleteAccount(id);

      
        return ResponseEntity.ok("Account is deleted!");

    }

}