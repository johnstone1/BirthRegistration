package com.Birth_Registration.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateChildNameDto {

    private String mothersName;
    private String streetNo;
    private String childOlderName;
    private String childNewName;
}




