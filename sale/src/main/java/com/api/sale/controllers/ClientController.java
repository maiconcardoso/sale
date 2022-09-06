package com.api.sale.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.sale.entities.Client;
import com.api.sale.services.ClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Integer id) {
        return new ResponseEntity<Client>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody @Valid Client client) {
        return new ResponseEntity<Client>(service.save(client), HttpStatus.CREATED);
    }
    
}
