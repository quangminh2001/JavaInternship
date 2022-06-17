package com.example.lesson3.controller;

import com.example.lesson3.entity.HorseEntity;
import com.example.lesson3.entity.ResponseObject;
import com.example.lesson3.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horse")
public class HorseController {

    @Autowired
    HorseService horseService;

    @GetMapping("/all")
    public ResponseEntity<?> getListHorseByYearAndTrainerID(@RequestParam("trainerID") Long trainerID, @RequestParam("year") int year ){
        return  ResponseEntity.ok(horseService.getListHorseByTrainerIdAndYear(trainerID,year));
    }

    @PostMapping()
    public ResponseEntity<?> createHorse(@RequestBody HorseEntity horseEntity){
        horseService.save(horseEntity);
        return ResponseEntity.ok(horseService.findAll());
    }

    // isPresent đê kiểm tra xem object có dữ liệu không
    @PutMapping("/{id}")
    public ResponseEntity<?> updateByID(@PathVariable("id") Long id,@RequestBody HorseEntity horseEntity){
        HorseEntity horseEntity1 = new HorseEntity();
        horseEntity1 = horseService.findHorseById(id);
        horseEntity1.setName(horseEntity.getName());
        horseEntity1.setFoaled(horseEntity.getFoaled());
        horseService.save(horseEntity1);
        return  ResponseEntity.ok(horseService.findAll());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteHorse(@PathVariable("id") Long id){
        return horseService.deleteById(id);
    }

}
