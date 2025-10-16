package com.sevenb.invoices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "point_sale", nullable = false)
    private Integer pointSale;
    @Column(nullable = false)
    private Long number;
    @ManyToOne
    private Provider provider;
    @Column(nullable = false)
    private LocalDate date;

    private Double engraved;
    private Double exempt;
    private Double iva105;
    private Double iva21;
    private Double iva27;
    private Double iibb;
    private Double taxedOthers;
    private Double municipality;
    private Boolean impacted;
    @ManyToOne
    private Company company;


}
