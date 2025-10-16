package com.sevenb.invoices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private Long id;
    private Integer pointSale;
    private Long number;
    private Long provider;
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
}
