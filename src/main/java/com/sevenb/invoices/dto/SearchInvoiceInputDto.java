package com.sevenb.invoices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchInvoiceInputDto {
    private LocalDate starDate ;
    private LocalDate endDate;
    private Boolean impacted;
    private Long idProvider;
}
