package com.Birth_Registration.Dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentRegistrationDto {

    private boolean bankAccount;
    private String documentSourceName;
    private String version;
    private String description;
    private String organization;
    private String docNo;
    private String name;
    private String externalRef;
    private Integer startNo;
    private Integer endNo;
    private Double amount;
    private Date uploadDate;
}
