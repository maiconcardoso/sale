package com.api.sale.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Labor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    @NotEmpty(message = "The Descrition cannot be empty")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_client")
    @NotEmpty(message = "The Name Client cannot be empty")
    private Client client;


    @Column(name = "amount")
    private Double amount;

    @Column(name = "labor_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    
}
