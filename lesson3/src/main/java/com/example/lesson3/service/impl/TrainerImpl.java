package com.example.lesson3.service.impl;

import com.example.lesson3.dto.TrainerResponse;
import com.example.lesson3.entity.ResponseObject;
import com.example.lesson3.entity.TrainerEntity;
import com.example.lesson3.repository.TrainerRepository;
import com.example.lesson3.service.TrainerService;
import com.example.lesson3.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainerImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;
    // find all trainer
    public List<TrainerResponse> findAll() {
        List<TrainerEntity> listTrainer = trainerRepository.findAll();
        List<TrainerResponse> listTrainerResponse = listTrainer.stream().map(trainerEntity -> new TrainerResponse(trainerEntity.getName())).collect(Collectors.toList());
        return listTrainerResponse;
    }

    // delete by id
    public ResponseEntity<ResponseObject> deleteByID(Long id){
//        System.out.println(findTrainerByID(id));

        if(trainerRepository.findFirstById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failed","Not find trainer id = " + id,"")
            );
        }else {
            trainerRepository.deleteTrainerID(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Oke","Deleted trainer id = " + id,"")
            );
        }
    }
    // update trainer by id
    @Override
    public ResponseEntity<ResponseObject> updateTrainer1(Long id,TrainerEntity newTrainer) {
        TrainerEntity trainerEntity = trainerRepository.findFirstById(id);
        if(findTrainerByID(trainerEntity.getId()) == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failed","Not find trainer id = " + trainerEntity.getId(),"")
            );
        }else
        {
            if(!newTrainer.getName().isEmpty())
                trainerEntity.setName(newTrainer.getName());
            if(newTrainer.getAccount() != null)
                trainerEntity.setAccount(newTrainer.getAccount());
                trainerRepository.save(trainerEntity);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Oke","Update successfully trainer id = " + trainerEntity.getId(),Convert.entityToDto(new TrainerResponse(),trainerRepository.getReferenceById(id))));
        }
    }
    @Override
    public ResponseEntity<ResponseObject> findTrainerByID(Long id) {

        if (trainerRepository.findFirstById(id) != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Oke","Find trainer id = " + id, Convert.entityToDto(new TrainerResponse(),trainerRepository.findFirstById(id)) )
            );
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Fail","Not find trainer by id = " +id,"")
            );
    }
}
