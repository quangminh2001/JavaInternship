package com.example.lesson3.service;


import com.example.lesson3.dto.HorseRequest;
import com.example.lesson3.dto.HorseResponse;
import com.example.lesson3.dto.TrainerRequest;
import com.example.lesson3.dto.TrainerResponse;
import com.example.lesson3.entity.HorseEntity;
import com.example.lesson3.entity.ResponseObject;
import com.example.lesson3.entity.TrainerEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HorseService {
    public <S extends HorseEntity> S save(S entity);

//    public List<HorseResponse> findAll();
    public ResponseEntity<ResponseObject> deleteById(Long id);
    public HorseEntity findHorseById(Long id);
    public List<HorseResponse> getListHorseByTrainerIdAndYear(Long id, int year);
    public ResponseEntity<ResponseObject> update(Long id, HorseRequest horseRequest);
    public ResponseEntity<ResponseObject> createHorse(HorseRequest horseRequest);
}
