package com.example.lesson3.utils;

import com.example.lesson3.dto.AccountResponse;
import com.example.lesson3.dto.HorseResponse;
import com.example.lesson3.dto.TrainerResponse;
import com.example.lesson3.entity.AccountEntity;
import com.example.lesson3.entity.HorseEntity;
import com.example.lesson3.entity.TrainerEntity;

public class Convert {
    public static TrainerResponse entityToDto(TrainerResponse trainerResponse, TrainerEntity trainerEntity){
        if(!trainerEntity.getName().isEmpty())
            trainerResponse.setName(trainerEntity.getName());
        return trainerResponse;
    }
    public  static HorseResponse entityToHorseDto(HorseResponse horseResponse, HorseEntity horseEntity){
        if(!horseEntity.getName().isEmpty())
            horseResponse.setName(horseEntity.getName());
        if(!horseEntity.getFoaled().toString().isEmpty())
            horseResponse.setFoaled(horseEntity.getFoaled());
        return horseResponse;
    }
    public static AccountResponse entityToAccountDto(AccountResponse accountResponse, AccountEntity accountEntity){
        if(!accountEntity.getUsername().isEmpty())
            accountResponse.setUsername(accountEntity.getUsername());
            accountResponse.setStatus(accountEntity.getStatus());
        return accountResponse;
    }
}
