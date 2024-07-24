package com.banking_app.banking_app.exceptions;

import java.time.LocalDateTime;
/**
 * Data Transfer Object for error details.
 */

public record ErrorsDetails(LocalDateTime
 timestamp,
String message, 
String details,
String errorCode) {
    
}
