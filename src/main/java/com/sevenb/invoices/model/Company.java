package com.sevenb.invoices.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String cuit;
    private String address;
    private String phone;
    private String email;
    private String fiscalCondition;
    private String habilitationMun;
    private String habilitationDgr;
    private Boolean iibb = Boolean.FALSE;
    private Boolean municipalityRet = Boolean.FALSE;
    private String fantasyName;
}
