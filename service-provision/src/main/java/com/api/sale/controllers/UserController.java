package com.api.sale.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.sale.entities.User;
import com.api.sale.exceptions.UsernameRegisteredException;
import com.api.sale.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid User user) {
        try {
            userService.save(user);
            return new ResponseEntity<>( HttpStatus.CREATED);
            
        } catch (UsernameRegisteredException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
