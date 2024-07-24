package com.banking_app.banking_app.exceptions;

import java.time.LocalDateTime;

import javax.security.auth.login.AccountException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Global exception handler for handling exceptions across the whole application.
 */

 
@ControllerAdvice // Allows for global exception handling in the application
public class GlobalExceptionHandler {
    
    /**
     * Handles AccountExceptions.
     * @param exceptions - the account exception
     * @param webRequest - the web request during which the exception occurred
     * @return ResponseEntity containing error details and HTTP status
     */

@ExceptionHandler(AccountException.class) // Specifies the type of exception to handle
public ResponseEntity<ErrorsDetails> handleAccountException(
    AccountExceptions exceptions, WebRequest webRequest){
      
      ErrorsDetails errorsDetails = new ErrorsDetails(
        LocalDateTime.now(), 
        exceptions.getMessage(), 
        webRequest.getDescription(false), 
        "ACCOUNT NOT FOUND");
      
      
        return new ResponseEntity<>(errorsDetails, HttpStatus.NOT_FOUND);



}

    /**
     * Handles generic exceptions.
     * @param exception - the exception
     * @param webRequest - the web request during which the exception occurred
     * @return ResponseEntity containing error details and HTTP status
     */

@ExceptionHandler(Exception.class) // Specifies the type of exception to handle
public ResponseEntity<ErrorsDetails> handleGenericException(Exception exception,WebRequest webRequest){

    ErrorsDetails errorsDetails = new ErrorsDetails(
        LocalDateTime.now(),
         exception.getMessage(),
          webRequest.getDescription(false), 
          "INTERNAL SERVER ERROR");
  
  
  
          return new ResponseEntity<>(errorsDetails, HttpStatus.INTERNAL_SERVER_ERROR);

}

}
