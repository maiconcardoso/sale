package com.api.sale.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.sale.entities.Labor;

@Repository
public interface LaborRepository extends JpaRepository<Labor, Integer> {

    @Query(" SELECT obj FROM Labor obj join obj.client c WHERE c.name LIKE :name OR MONTH(obj.date) = :month ")
    List<Labor> findByClientNameAndDate(String name, Integer month);

    
}
