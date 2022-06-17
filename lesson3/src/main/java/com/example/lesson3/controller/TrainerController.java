package com.example.lesson3.controller;


import com.example.lesson3.entity.BaseEntity;
import com.example.lesson3.entity.ResponseObject;
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

    // get all trainer localhost:8080/trainer
    @GetMapping()
    public ResponseEntity<?> getTrainers(){
        return  ResponseEntity.ok(trainerService.findAll());
    }

    //get trainer by id localhost:8080/trainer/11
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getTrainer(@PathVariable("id") Long id){
        // nếu tìm ra thì sẽ trả về dữ liệu còn nếu không sẽ không trả về rỗng
        if (trainerService.findTrainerByID(id) != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Oke","Find trainer id = " + id, trainerService.findTrainerByID(id) )
            );
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Fail","Not find trainer by id = " +id,"")
            );
    }
    // update trainer
    @PutMapping("/{id}")
    public  ResponseEntity<?> updateTrainer(@PathVariable("id") Long id,@RequestBody TrainerEntity trainerEntity){
        trainerService.updateTrainer1(id,trainerEntity);
        return ResponseEntity.ok(trainerService.findAll());
    }

    //delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrainer(@PathVariable("id") Long id){
        return trainerService.deleteByID(id);
    }
}
