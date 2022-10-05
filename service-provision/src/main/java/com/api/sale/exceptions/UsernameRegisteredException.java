package com.api.sale.exceptions;

public class UsernameRegisteredException extends RuntimeException{
    
    public UsernameRegisteredException(String login) {
        super("User already registered to login" + login);
    }
}
