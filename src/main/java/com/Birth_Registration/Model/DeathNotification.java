package com.Birth_Registration.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "death_notification")
public class DeathNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gender;
    private String name;
    private int age;
    private String estate;
    private String street;
    private String date;
    private String sheetNo;
    private String ipOp;
    private String houseNo;
    private String box;
    private String tel;


    private String nextOfKin;
    private String kinEstate;
    private String kinHouseNo;
    private String kinStreet;
    private String broughtFrom;


    private String providerName;
    private String providerIdNo;
    private String providerBox;
    private String providerTel;
    private String providerRelation;

    // Brought in by details
    private String bringerName;
    private String bringerBox;
    private String bringerVehicleNo;
    private String bringerTelNo;
    private String bringerRelation;
    private String bringerLicence;

    // Medical practitioner details
    private String pupils;
    private String responseToStimuli;
    private String breathSounds;
    private String cardiacActivity;
    private String rigorMotis;
    private String otherFindings;
    private String arrivalStatus;
    private String policeStationReferredTo;
    private String practitionerDate;
    private String practitionerName;
    private String practitionerTime;
    private String practitionerDesignation;

    // Original copy collected by details
    private String collectorFullNames;
    private String collectorRelationship;
    private String collectorBox;
    private String collectorId;
}
