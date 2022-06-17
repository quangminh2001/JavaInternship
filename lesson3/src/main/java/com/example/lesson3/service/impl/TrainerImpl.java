package com.example.lesson3.service.impl;

import com.example.lesson3.dto.AccountDto;
import com.example.lesson3.dto.TrainerDTO;
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

@Component
public class TrainerImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;
    // find all trainer
    public List<TrainerDTO> findAll() {
        List<TrainerDTO> listTrainerDTO = new ArrayList<>();
        List<TrainerEntity> listTrainer = trainerRepository.findAll();
        listTrainer.forEach(trainerEntity -> listTrainerDTO.add(new TrainerDTO(trainerEntity.getName(),Convert.entityToAccountDto(new AccountDto(),trainerEntity.getAccount()))));
        return listTrainerDTO;
    }

    // delete by id
    public ResponseEntity<ResponseObject> deleteByID(Long id){
        if(findTrainerByID(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failt","Not find trainer id = " + id,"")
            );
        }else {
            trainerRepository.deleteById(id);
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
                    new ResponseObject("Oke","Update successfully trainer id = " + trainerEntity.getId(),trainerEntity));
        }

    }
    @Override
    public TrainerDTO findTrainerByID(Long id) {
        return Convert.entityToDto(new TrainerDTO(),trainerRepository.findFirstById(id));
    }


}
