package com.api.sale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sale.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
    
}
