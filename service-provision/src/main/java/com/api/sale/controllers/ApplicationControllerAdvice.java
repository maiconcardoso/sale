package com.api.sale.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.api.sale.exceptions.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    
    @ExceptionHandler( MethodArgumentNotValidException.class )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErrors( MethodArgumentNotValidException validException ) {
        BindingResult bindingResult = validException.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                        .stream()
                        .map( ObjectError -> ObjectError.getDefaultMessage() )
                        .collect(Collectors.toList());
        
        return new ApiErrors(messages);
    }

    @ExceptionHandler (ResponseStatusException.class)
    public ResponseEntity<ApiErrors> handleResponseStatusException(ResponseStatusException ex) {
        String messageError = ex.getMessage();
        HttpStatus httpStatus = ex.getStatus();
        ApiErrors api = new ApiErrors(messageError);
        return new ResponseEntity<ApiErrors>(api, httpStatus);
    }
}
