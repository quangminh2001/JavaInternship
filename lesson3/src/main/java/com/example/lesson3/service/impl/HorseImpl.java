package com.example.lesson3.service.impl;

import com.example.lesson3.entity.HorseEntity;
import com.example.lesson3.repository.HorseReponsitory;
import com.example.lesson3.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HorseImpl implements HorseService {
    @Autowired
    private HorseReponsitory horseReponsitory;

    @Override
    public <S extends HorseEntity> S save(S entity) {
        return horseReponsitory.save(entity);
    }
    @Override
    public List<HorseEntity> findAll() {
        return horseReponsitory.findAll();
    }
    @Override
    public void deleteById(Long id) {
        horseReponsitory.deleteById(id);
    }

    public HorseEntity findHorseById(Long id) {
        return horseReponsitory.findFirstById(id);
    }
}
