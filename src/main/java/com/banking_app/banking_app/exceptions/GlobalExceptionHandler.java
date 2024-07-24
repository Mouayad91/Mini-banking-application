package com.banking_app.banking_app.exceptions;

import java.time.LocalDateTime;

import javax.security.auth.login.AccountException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    
//hander AccountExceptions
@ExceptionHandler(AccountException.class)
public ResponseEntity<ErrorsDetails> handleAccountException(
    AccountExceptions exceptions, WebRequest webRequest){
      
      ErrorsDetails errorsDetails = new ErrorsDetails(
        LocalDateTime.now(), 
        exceptions.getMessage(), 
        webRequest.getDescription(false), 
        "ACCOUNT NOT FOUND");
      
      
        return new ResponseEntity<>(errorsDetails, HttpStatus.NOT_FOUND);



}

// handle generic exception

@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorsDetails> handleGenericException(Exception exception,WebRequest webRequest){

    ErrorsDetails errorsDetails = new ErrorsDetails(
        LocalDateTime.now(),
         exception.getMessage(),
          webRequest.getDescription(false), 
          "INTERNAL SERVER ERROR");
  
  
  
          return new ResponseEntity<>(errorsDetails, HttpStatus.INTERNAL_SERVER_ERROR);

}

}
