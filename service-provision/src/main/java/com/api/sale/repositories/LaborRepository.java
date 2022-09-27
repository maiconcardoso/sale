package com.api.sale.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.sale.entities.Labor;

@Repository
public interface LaborRepository extends JpaRepository<Labor, Integer> {

    @Query("SELECT l FROM Labor l JOIN l.client c WHERE c.name LIKE :name and MONTH(l.date) = :month")
    List<Labor> findByClientNameAndDate(@Param("name") String name, @Param("month") Integer month);
    

}
