package com.example.lesson3.repository;

import com.example.lesson3.entity.HorseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorseReponsitory extends JpaRepository<HorseEntity,Long> {
    HorseEntity findFirstById(Long id);

}
