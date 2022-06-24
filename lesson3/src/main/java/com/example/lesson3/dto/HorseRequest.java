package com.example.lesson3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorseRequest {
    @NotEmpty(message = "Horse name shouldn't be empty")
    private String name;
    // fix
    @NotNull(message = "Foaled shouldn't be null")
    private Date foaled;
//    @Pattern(regexp = "/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/",message = "Foaled format failed")
//    private String date = foaled+"";
}
