package com.sevenb.invoices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "provider")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Provider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    @Column(nullable = false)
    private String cuit;
    private String address;
    private String phone;
    private String fiscalCondition;
    private Boolean isAgreement = Boolean.FALSE;
    private Boolean isIibbExcept = Boolean.FALSE;
    private Boolean isMunicipalityExcept = Boolean.FALSE;
    @ManyToOne
    private Company company;



}

