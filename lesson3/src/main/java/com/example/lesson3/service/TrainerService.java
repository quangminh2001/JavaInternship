package com.example.lesson3.service;

import com.example.lesson3.dto.TrainerResponse;
import com.example.lesson3.entity.ResponseObject;
import com.example.lesson3.entity.TrainerEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainerService {

    public ResponseEntity<ResponseObject> findTrainerByID(Long id);
    public List<TrainerResponse> findAll();
    public ResponseEntity<ResponseObject> deleteByID(Long id);
    public ResponseEntity<ResponseObject> updateTrainer1(Long id,TrainerEntity newTrainer);
}
