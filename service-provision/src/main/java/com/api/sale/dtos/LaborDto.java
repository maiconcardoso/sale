package com.api.sale.dtos;

import java.io.Serializable;

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
    private String date;
    
}
