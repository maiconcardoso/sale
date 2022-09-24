package com.api.sale.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Client findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    public Client save(Client client) {
        return repository.save(client);
    }

    public Client update(Integer id, Client client) {
        findById(id);
        Client.builder().cpf(client.getCpf()).name(client.getName());
        return repository.save(client);
    }

    public void delete(Integer id) {
        Client clientForDeleted = findById(id);
        repository.delete(clientForDeleted);
    }

}
