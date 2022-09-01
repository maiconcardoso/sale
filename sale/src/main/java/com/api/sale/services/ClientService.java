package com.api.sale.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.sale.entities.Client;
import com.api.sale.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client save(Client client) {
        return repository.save(client);
    }
    
}
