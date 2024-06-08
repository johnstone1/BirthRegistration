package com.Birth_Registration.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BirthRegistrationDTO {
    private boolean newChild;
    private String nameOfChild;
    private String registrationNo;
    private String placeOfBirth;
    private String nextOfKin;
    private boolean male;
    private boolean female;
    private boolean single;
    private boolean twin;
    private boolean bornAlive;
    private boolean dead;
    private Date date;
    private Date birthDate;
    private double weight;
    private String mothersName;
    private int mothersAge;
    private String mothersNationality;
    private String mothersResidence;
    private String mothersOccupation;
    private String mothersIdNo;
    private String mothersEducationLevel;
    private String mothersMaritalStatus;
    private String previousBirthToMother;
    private String fathersName;
    private String fathersNationality;
    private String fathersIdNo;
    private String capacityOfInformatName;
    private String capacityOfInformatRelationship;
    private boolean disclaimerAccepted;
    private Date registrationDate;
}
