package com.example.lesson3.service;


import com.example.lesson3.entity.HorseEntity;
import com.example.lesson3.entity.TrainerEntity;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HorseService {
    public <S extends HorseEntity> S save(S entity);

    public List<HorseEntity> findAll();
    public void deleteById(Long id);
    public HorseEntity findHorseById(Long id);
}
