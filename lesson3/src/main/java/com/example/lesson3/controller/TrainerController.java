package com.example.lesson3.controller;


import com.example.lesson3.entity.BaseEntity;
import com.example.lesson3.entity.TrainerEntity;
import com.example.lesson3.repository.TrainerRepository;
import com.example.lesson3.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;


    @GetMapping()
    public ResponseEntity<?> getTrainers(){
        return  ResponseEntity.ok(trainerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTrainer(@PathVariable("id") Long id){
//        System.out.println(trainerService.findTrainerByID(id).getAccount());
        return ResponseEntity.ok(trainerService.findTrainerByID(id));
    }
    // error
    @PutMapping()
    public  ResponseEntity<?> updateTrainer(@RequestBody TrainerEntity trainerEntity){
        trainerService.updateTrainer(trainerEntity);
//        System.out.println(trainerEntity.toString());
        return ResponseEntity.ok(trainerEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrainer(@PathVariable("id") Long id){
        trainerService.deleteByID(id);
        return ResponseEntity.ok(trainerService.findAll());
    }
}
