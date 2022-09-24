package com.api.sale.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.api.sale.dtos.LaborDto;
import com.api.sale.entities.Labor;
import com.api.sale.repositories.LaborRepository;
import com.api.sale.utils.BigDecimalConverter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LaborService {
    
    private final LaborRepository repository;
    private final BigDecimalConverter bigDecimalConverter;


    public Labor save(LaborDto laborDto) {
        var labor = new Labor();
        bigDecimalConverter.converter(laborDto.getAmount().toString());
        BeanUtils.copyProperties(laborDto, labor);
        return repository.save(labor);
    } 
}
