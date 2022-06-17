package com.example.lesson3.service.impl;

import com.example.lesson3.dto.HorseDto;
import com.example.lesson3.entity.HorseEntity;
import com.example.lesson3.entity.ResponseObject;
import com.example.lesson3.repository.HorseAccountRepository;
import com.example.lesson3.repository.HorseReponsitory;
import com.example.lesson3.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class HorseImpl implements HorseService {
    @Autowired
    private HorseReponsitory horseReponsitory;

    @Autowired
    private HorseAccountRepository horseAccountRepository;

    @Override
    public <S extends HorseEntity> S save(S entity) {
        return horseReponsitory.save(entity);
    }
    @Override
    public List<HorseDto> findAll() {
        List<HorseDto> listHorseDto = new ArrayList<>();
        List<HorseEntity> listHorses = horseReponsitory.findAll();
        listHorses.forEach(horseEntity -> listHorseDto.add(new HorseDto(horseEntity.getName(),horseEntity.getFoaled())));
        return listHorseDto;
    }
    @Override
    public ResponseEntity<ResponseObject> deleteById(Long id) {
        if(findHorseById(id) != null){
            horseReponsitory.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Oke","Deleted successfully","")
            );
        }else
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failed","Not found horse by id = " + id,"")
            );
    }
    // tìm kiếm horse theo id
    @Override
    public HorseEntity findHorseById(Long id) {
        return horseReponsitory.findFirstById(id);
    }

    public List<HorseDto> getListHorseByTrainerIdAndYear(Long id,int year){
        List<HorseDto> listHorseDto = new ArrayList<>();
        List<HorseEntity> listHorses = horseAccountRepository.findAllByTrainerAndYear(id,year);
        listHorses.forEach(horseEntity -> listHorseDto.add(new HorseDto(horseEntity.getName(),horseEntity.getFoaled())));
        return listHorseDto;
    }
}
