package com.example.lesson3.utils;

import com.example.lesson3.dto.AccountDto;
import com.example.lesson3.dto.HorseDto;
import com.example.lesson3.dto.TrainerDTO;
import com.example.lesson3.entity.AccountEntity;
import com.example.lesson3.entity.HorseEntity;
import com.example.lesson3.entity.TrainerEntity;

public class Convert {
    public static TrainerDTO entityToDto(TrainerDTO trainerDTO, TrainerEntity trainerEntity){
        if(!trainerEntity.getName().isEmpty())
            trainerDTO.setName(trainerEntity.getName());
        if(trainerEntity.getAccount() != null)
            trainerDTO.setAccountDto(entityToAccountDto(new AccountDto(),trainerEntity.getAccount()));
        return trainerDTO;
    }
    public  static HorseDto entityToHorseDto(HorseDto horseDto, HorseEntity horseEntity){
        if(!horseEntity.getName().isEmpty())
            horseDto.setName(horseEntity.getName());
        if(!horseEntity.getFoaled().toString().isEmpty())
            horseDto.setFoaled(horseEntity.getFoaled());
        return horseDto;
    }
    public static AccountDto entityToAccountDto(AccountDto accountDto, AccountEntity accountEntity){
        if(!accountEntity.getUsername().isEmpty())
            accountDto.setUsername(accountEntity.getUsername());
        if(!accountEntity.getPassword().isEmpty())
            accountDto.setPassword(accountEntity.getPassword());

        accountDto.setStatus(accountEntity.getStatus());
        return accountDto;
    }
}
