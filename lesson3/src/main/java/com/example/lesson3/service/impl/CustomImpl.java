package com.example.lesson3.service.impl;

import com.example.lesson3.dto.HorseResponse;
import com.example.lesson3.entity.HorseEntity;
import com.example.lesson3.service.CustomService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomImpl implements CustomService {

    @PersistenceContext
    public EntityManager em;
    @Override
    public List<HorseResponse> findHorseByIdTrainerAndFoaled(Long trainerID, Integer year){
        if(year != null){
            TypedQuery<HorseEntity> query =em.createQuery("select h from HorseEntity h join HorseAccount ha on h.id = ha.horse.id join  TrainerEntity t on ha.account1.id = t.account.id where t.id =:id and year(h.foaled) = :year",HorseEntity.class);
            query.setParameter("id",trainerID);
            query.setParameter("year",year);
            List<HorseResponse> horseResponses = query.getResultList().stream().map(horseEntity -> new HorseResponse(horseEntity.getName(),horseEntity.getFoaled())).collect(Collectors.toList());
            return horseResponses;
        }else
        {
            TypedQuery<HorseEntity> query =em.createQuery("select h from HorseEntity h join HorseAccount ha on h.id = ha.horse.id join  TrainerEntity t on ha.account1.id = t.account.id where t.id =:id",HorseEntity.class);
            query.setParameter("id",trainerID);
            List<HorseResponse> horseResponses = query.getResultList().stream().map(horseEntity -> new HorseResponse(horseEntity.getName(),horseEntity.getFoaled())).collect(Collectors.toList());
            return horseResponses;
        }
    }
}
