package com.Birth_Registration.Model;

import lombok.Data;
import jakarta.persistence.*;

import java.util.Date;

@Data
@Entity
@Table(name = "death_registration")
public class DeathRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cause_of_death_id", referencedColumnName = "id")
    private CauseOfDeath causeOfDeath;

    // Certification details
    private boolean attendedBeforeDeath;
    private boolean postMortem;
    private boolean examinedBodyBeforeDeath;
    private String examinerName;
    private String examinerTitle;
    private Date certificationDate;
}
