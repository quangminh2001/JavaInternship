package com.example.lesson3.service.impl;

import com.example.lesson3.entity.TrainerEntity;
import com.example.lesson3.repository.TrainerRepository;
import com.example.lesson3.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainerImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public List<TrainerEntity> findAll() {
        return trainerRepository.findAll();
    }

    public void deleteByID(Long id){
        trainerRepository.deleteById(id);
    }

    @Override
    public void updateTrainer(TrainerEntity trainerEntity) {
        trainerRepository.save(trainerEntity);
    }

    @Override
    public TrainerEntity findTrainerByID(Long id) {
        return trainerRepository.findFirstById(id);
    }


}
