package com.api.sale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sale.entities.Labor;

@Repository
public interface LaborRepository extends JpaRepository<Labor, Integer> {

    
}
