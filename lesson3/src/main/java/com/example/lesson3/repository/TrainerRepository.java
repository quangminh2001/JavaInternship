package com.example.lesson3.repository;

import com.example.lesson3.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Long> {
    TrainerEntity findFirstById(Long id);
    @Override
    void deleteById(Long id);

}
