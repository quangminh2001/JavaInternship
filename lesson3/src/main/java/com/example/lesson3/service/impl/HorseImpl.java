package com.example.lesson3.service.impl;

import com.example.lesson3.dto.HorseRequest;
import com.example.lesson3.dto.HorseResponse;
import com.example.lesson3.dto.TrainerRequest;
import com.example.lesson3.dto.TrainerResponse;
import com.example.lesson3.entity.HorseEntity;
import com.example.lesson3.entity.ResponseObject;
import com.example.lesson3.entity.TrainerEntity;
import com.example.lesson3.repository.HorseAccountRepository;
import com.example.lesson3.repository.HorseReponsitory;
import com.example.lesson3.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<ResponseObject> createHorse(HorseRequest horseRequest){
        //check name
        int size = Integer.parseInt(""+horseReponsitory.findAll().stream().filter(horseEntity -> horseEntity.getName().equals(horseRequest.getName())).count());
        if(size > 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("Failed","Name is exists in horse table","")
            );
        }else {
            HorseEntity horseEntity = new HorseEntity();
            horseEntity.setName(horseRequest.getName());
            horseEntity.setFoaled(horseRequest.getFoaled());
            save(horseEntity);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Successfull","Create horse successfull","")
            );
        }
    }

    @Override
    public ResponseEntity<ResponseObject> deleteById(Long id) {
        // check horse id exists in horseaccount
        int size = Integer.parseInt(""+horseAccountRepository.findAll().stream().filter(horseAccount -> horseAccount.getHorse().getId() == id).count());
        System.out.println(size);
        if(size > 0){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseObject("Failed","Don't delete horse because it is exists in horseaccount","")
            );
        }
        // check null or not null
        if(horseReponsitory.findFirstById(id) != null){
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


    // find by trainer id and year
    public List<HorseResponse> getListHorseByTrainerIdAndYear(Long id, int year){
        List<HorseEntity> listHorses = horseAccountRepository.findAllByTrainerAndYear(id,year);
        List<HorseResponse> listHorseResponse = listHorses.stream().map(horseEntity -> new HorseResponse(horseEntity.getName(),horseEntity.getFoaled())).collect(Collectors.toList());
        return listHorseResponse;
    }


    @Override
    public ResponseEntity<ResponseObject> update(Long id, HorseRequest horseRequest) {
        int size =Integer.parseInt(""+horseReponsitory.findAll().stream().filter(horseEntity -> horseEntity.getName().equals(horseRequest.getName())).count());
        if(size > 0){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ResponseObject("Failed","Don't update trainer have name exists","")
            );
        }
        if(horseReponsitory.findFirstById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failed","Dont  find trainer id = "+id,"")
            );
        }else {
            HorseEntity horseEntity = new HorseEntity();
            horseEntity.setName(horseRequest.getName());
            horseEntity.setFoaled(horseRequest.getFoaled());
            horseEntity.setId(id);
            save(horseEntity);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Oke","Update successfull",new HorseResponse(horseEntity.getName(),horseEntity.getFoaled()))
            );
        }
    }
}
