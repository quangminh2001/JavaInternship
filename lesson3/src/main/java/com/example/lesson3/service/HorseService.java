package com.example.lesson3.service;


import com.example.lesson3.dto.HorseDto;
import com.example.lesson3.entity.HorseEntity;
import com.example.lesson3.entity.ResponseObject;
import com.example.lesson3.entity.TrainerEntity;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HorseService {
    public <S extends HorseEntity> S save(S entity);

    public List<HorseDto> findAll();
    public ResponseEntity<ResponseObject> deleteById(Long id);
    public HorseEntity findHorseById(Long id);
    public List<HorseDto> getListHorseByTrainerIdAndYear(Long id,int year);
}
