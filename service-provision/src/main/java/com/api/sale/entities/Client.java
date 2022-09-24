package com.api.sale.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 170)
    @NotEmpty(message = "The client name cannot be empty")
    private String name;

    @Column(nullable = false, length = 20, unique = true)
    @NotNull(message = "The client CPF cannot be empty.")
    @CPF(message = "CPF Invalid!")
    private String cpf;

    @Column(name = "registary_date")
    private LocalDate registaryDate;

    @PrePersist
    private void prePersist() {
        setRegistaryDate(LocalDate.now()); 
    }

    
}
