package com.Birth_Registration.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeathRegistrationDTO {

    // Deceased details
    private String opd;
    private String patientNo;
    private String patientName;
    private String name;
    private Date date;
    private String streetNo;
    private String placeOfBirth;
    private String residence;
    private Date birthDate;
    private int age;
    private String gender;
    private String nextOfKin;
    private String occupation;
    private String morbidCondition;

    // Cause of death details
    private String causeOfDeathCode;
    private int causeOfDeathCount;
    private String causeOfDeathDescription;

    // Certification details
    private boolean attendedBeforeDeath;
    private boolean postMortem;
    private boolean examinedBodyBeforeDeath;
    private String examinerName;
    private String examinerTitle;
    private Date certificationDate;
}
