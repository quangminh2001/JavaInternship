package com.example.lesson3.service;

import com.example.lesson3.entity.TrainerEntity;
import com.example.lesson3.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainerService {

    public TrainerEntity findTrainerByID(Long id);
    public List<TrainerEntity> findAll();
    public void deleteByID(Long id);
    public void updateTrainer(TrainerEntity trainerEntity);
}
