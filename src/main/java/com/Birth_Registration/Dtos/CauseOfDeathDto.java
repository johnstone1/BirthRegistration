package com.Birth_Registration.Dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CauseOfDeathDto {

    private String code;
    private int count;
    private String description;
}
