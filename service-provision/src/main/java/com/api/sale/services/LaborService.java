package com.api.sale.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.sale.dtos.LaborDto;
import com.api.sale.entities.Client;
import com.api.sale.entities.Labor;
import com.api.sale.repositories.LaborRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LaborService {
    
    private final LaborRepository repository;
    private final ClientService clientService;

    public Labor save(LaborDto laborDto) {
        var labor = new Labor();
        BeanUtils.copyProperties(laborDto, labor);
        Client client = clientService.findById(laborDto.getIdClient());
        labor.setClient(client);
        return repository.save(labor);
    } 
}
