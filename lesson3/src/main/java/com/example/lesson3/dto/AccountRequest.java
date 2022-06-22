package com.example.lesson3.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    @NotEmpty(message = "Name should't be empty")
    @Size(min = 5,message = "Username should be least 5 characters")
    private String username;
    @NotEmpty(message = "Password shouldn't be null")
    private String password;
    @Min(value = 0, message = "Status should be stay [0,1]")
    @Max(value = 1, message = "Status should be stay [0,1]")
    private int status;
}
