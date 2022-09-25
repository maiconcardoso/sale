package com.api.sale.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.api.sale.entities.Client;
import com.api.sale.entities.Labor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaborDto implements Serializable{

    private String description;
    private Integer idClient;
    private Double amount;
    private LocalDate date;
    
}
