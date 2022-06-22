package com.example.lesson3.service;

import com.example.lesson3.dto.HorseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomService {
    List<HorseResponse> findHorseByIdTrainerAndFoaled(Long trainerID, Integer year);
}
