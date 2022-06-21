package com.example.lesson3.controller;

import com.example.lesson3.dto.HorseRequest;
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
    // get horse by id trainer and year
    @GetMapping("/all")
    public ResponseEntity<?> getListHorseByYearAndTrainerID(@RequestParam("trainerID") Long trainerID, @RequestParam("year") int year ){
        return  ResponseEntity.ok(horseService.getListHorseByTrainerIdAndYear(trainerID,year));
    }
    @PostMapping()
    public ResponseEntity<?> createHorse(@RequestBody HorseRequest horseRequest){
        return horseService.createHorse(horseRequest);
    }
    // isPresent đê kiểm tra xem object có dữ liệu không
    @PutMapping("/{id}")
    // tạo ra horseRequest để nhận dữ liệu từ trên trên client xuống
    public ResponseEntity<?> updateByID(@PathVariable("id") Long id,@RequestBody HorseRequest horseRequest){
        return  horseService.update(id,horseRequest);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteHorse(@PathVariable("id") Long id){
        return horseService.deleteById(id);// viết câu query
    }
}
