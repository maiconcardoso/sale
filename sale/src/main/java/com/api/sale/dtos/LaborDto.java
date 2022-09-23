package com.api.sale.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
    private BigDecimal amount;
    private LocalDate date;

    public LaborDto(Labor labor) {
        this.description = labor.getDescription();
        this.idClient = labor.getClient().getId();
        this.amount = labor.getAmount();
        this.date = labor.getDate();
    }

    
    
}
