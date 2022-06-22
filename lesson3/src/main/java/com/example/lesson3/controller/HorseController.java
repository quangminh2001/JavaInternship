package com.example.lesson3.controller;

import com.example.lesson3.dto.HorseRequest;
import com.example.lesson3.entity.HorseEntity;
import com.example.lesson3.entity.ResponseObject;
import com.example.lesson3.service.CustomService;
import com.example.lesson3.service.HorseService;
import com.example.lesson3.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/horse")
public class HorseController {


    @Autowired
    HorseService horseService;

    @Autowired
    CustomService customService;
    // get horse by id trainer and year
    @GetMapping("/all")
    public ResponseEntity<?> getListHorseByYearAndTrainerID(HttpServletRequest request){
        Long trainerID = Long.parseLong(request.getParameter("trainerID"));
        String year = request.getParameter("year");
        if(year == null){
            return  ResponseEntity.ok(customService.findHorseByIdTrainerAndFoaled(trainerID,null));
        }else {
            return ResponseEntity.ok(customService.findHorseByIdTrainerAndFoaled(trainerID,Integer.parseInt(year)));
        }
    }
    @PostMapping()
    public ResponseEntity<?> createHorse(@RequestBody @Valid HorseRequest horseRequest){
        return horseService.createHorse(horseRequest);
    }
    // isPresent đê kiểm tra xem object có dữ liệu không
    @PutMapping("/{id}")
    // tạo ra horseRequest để nhận dữ liệu từ trên trên client xuống
    public ResponseEntity<?> updateByID(@PathVariable("id") Long id,@RequestBody @Valid HorseRequest horseRequest){
        return  horseService.update(id,horseRequest);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteHorse(@PathVariable("id") Long id){
        return horseService.deleteById(id);// viết câu query
    }
}
