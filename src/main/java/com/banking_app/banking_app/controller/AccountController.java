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
import com.banking_app.banking_app.dto.TransfareFundDto;
import com.banking_app.banking_app.service.AccountService;


@RestController // Marks the class as a Spring MVC controller where every method returns a domain object instead of a view.
@RequestMapping("/api/accounts") // Base URL for all endpoints in this controller.
public class AccountController {

    private final AccountService accountService;
    
    // Constructor-based dependency injection
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Handles the creation of a new account.
     * @param accountDto - the account details
     * @return ResponseEntity containing the created account and HTTP status
     */

    @PostMapping // Maps HTTP POST requests to /api/accounts
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    /**
     * Retrieves account details by ID.
     * @param id - the account ID
     * @return ResponseEntity containing the account details and HTTP status
     */

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        
        AccountDto accountDto = accountService.getAccountByID(id);
        
        return new ResponseEntity<>(accountDto,HttpStatus.OK);
    }
    

    /**
     * Deposits a specified amount into an account.
     * @param id - the account ID
     * @param request - map containing the amount to deposit
     * @return ResponseEntity containing the updated account details
     */ 
    
     @PutMapping("/{id}/deposit") // Maps HTTP PUT requests to /api/accounts/{id}/deposit
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){


    double amount = request.get("amount");
     AccountDto accountDto= accountService.deposite(id, amount);
   
        return ResponseEntity.ok(accountDto);
  
    }

    /**
     * Withdraws a specified amount from an account.
     * @param id - the account ID
     * @param request - map containing the amount to withdraw
     * @return ResponseEntity containing the updated account details
     */

    @PutMapping("/{id}/withdraw")  // Maps HTTP PUT requests to /api/accounts/{id}/withdraw
    public ResponseEntity<AccountDto> withDraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withDraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }


    /**
     * Retrieves all accounts.
     * @return ResponseEntity containing a list of all accounts
     */

    @GetMapping // Maps HTTP GET requests to /api/accounts
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
    List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }


    /**
     * Deletes an account by ID.
     * @param id - the account ID
     * @return ResponseEntity containing a success message
     */

    @DeleteMapping("/{id}") // Maps HTTP DELETE requests to /api/accounts/{id}
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){

         accountService.deleteAccount(id);

      
        return ResponseEntity.ok("Account is deleted!");

    }


    /**
     * Transfers funds from one account to another.
     * @param transfareFundDto - details of the fund transfer
     * @return ResponseEntity containing a success message
     */   
     
     @PostMapping("/transfare") // Maps HTTP POST requests to /api/accounts/transfare
    public ResponseEntity<String> transfareFund(@RequestBody TransfareFundDto transfareFundDto){

        accountService.transfareFund(transfareFundDto);

        return ResponseEntity.ok("Amount transfared successfully");

    }


}