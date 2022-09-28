package com.api.sale.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaborDto implements Serializable{

    @NotEmpty(message = "The Description cannot be empty")
    private String description;

    @NotNull(message = "The Name Client cannot be empty")
    private Integer idClient;
    private Double amount;
    private String date;
    
}
