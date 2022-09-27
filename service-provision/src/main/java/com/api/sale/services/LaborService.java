package com.api.sale.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        LocalDate date = LocalDate.parse(laborDto.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var labor = new Labor();
        BeanUtils.copyProperties(laborDto, labor);
        Client client = clientService.findById(laborDto.getIdClient());
        labor.setClient(client);
        labor.setDate(date);
        return repository.save(labor);
    } 

    public List<Labor> findByClientNameAndDate(String name, Integer month) {
        return repository.findByClientNameAndDate(name, month);
    }
}
