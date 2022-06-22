package com.example.lesson3.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainerRequest {
    @NotEmpty(message = "Trainer name shouldn't be empty")
    private String name;
}
