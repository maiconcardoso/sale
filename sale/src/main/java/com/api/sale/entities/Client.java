package com.api.sale.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

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
    private String name;

    @Column(nullable = false, length = 20, unique = true)
    private String cpf;

    @Column(name = "registary_date")
    private LocalDate registaryDate;

    @PrePersist
    private void prePersist() {
        setRegistaryDate(LocalDate.now()); 
    }

    
}
