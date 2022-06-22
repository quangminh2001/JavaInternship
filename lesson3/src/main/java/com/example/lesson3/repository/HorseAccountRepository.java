package com.example.lesson3.repository;

import com.example.lesson3.entity.HorseAccount;
import com.example.lesson3.entity.HorseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorseAccountRepository extends JpaRepository<HorseAccount,Long> {
    @Override
    List<HorseAccount> findAll();

    @Query("select h from HorseEntity h join HorseAccount ha on h.id = ha.horse.id join  TrainerEntity t on ha.account1.id = t.account.id where t.id = ?1 and year(h.foaled) = ?2")
    public List<HorseEntity> findAllByTrainerAndYear(Long trainerid,int year);


}
