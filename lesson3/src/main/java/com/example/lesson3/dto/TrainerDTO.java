package com.example.lesson3.dto;

import com.example.lesson3.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDTO {
    private String name;
    private AccountDto accountDto;
}
