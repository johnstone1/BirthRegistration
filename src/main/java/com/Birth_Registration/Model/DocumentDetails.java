package com.Birth_Registration.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "document_details")
public class DocumentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "document_source_id", nullable = false)
    private DocumentSource documentSource;

    private String docNo;
    private String name;

    private String externalRef;

    private Integer startNo;

    private Integer endNo;

    private Double amount;

    @Temporal(TemporalType.DATE)
    private Date uploadDate;

    private boolean bankAccount;

}
