package com.example.lesson3.repository;

import com.example.lesson3.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Long> {
    TrainerEntity findFirstById(Long id);
    @Override
    void deleteById(Long id);

//    write query
    @Transactional //commit bảng
    @Modifying // thay đổi trog bảng
    @Query( value = " DELETE from TrainerEntity t where t.id = ?1")
    void deleteTrainerID(Long id);
}
