package com.api.sale.services;

import org.springframework.stereotype.Service;

import com.api.sale.entities.Client;
import com.api.sale.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepository repository;

    public Client save(Client client) {
        return repository.save(client);
    }
    
}
