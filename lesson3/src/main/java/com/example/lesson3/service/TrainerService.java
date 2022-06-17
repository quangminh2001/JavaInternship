package com.example.lesson3.service;

import com.example.lesson3.dto.TrainerDTO;
import com.example.lesson3.entity.ResponseObject;
import com.example.lesson3.entity.TrainerEntity;
import com.example.lesson3.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainerService {

    public TrainerDTO findTrainerByID(Long id);
    public List<TrainerDTO> findAll();
    public ResponseEntity<ResponseObject> deleteByID(Long id);
    public ResponseEntity<ResponseObject> updateTrainer1(Long id,TrainerEntity newTrainer);
}
