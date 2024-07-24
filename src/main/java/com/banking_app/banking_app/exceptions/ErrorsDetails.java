package com.banking_app.banking_app.exceptions;

import java.time.LocalDateTime;

public record ErrorsDetails(LocalDateTime
 timestamp,
String message, 
String details,
String errorCode) {
    




}
