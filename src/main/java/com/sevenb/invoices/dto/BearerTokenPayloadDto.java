package com.sevenb.invoices.dto;

import com.sevenb.invoices.model.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dto used in order to obtain Bearer Token payload from Authorization headers.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BearerTokenPayloadDto {

    private String userId;
    private Company company;
    private String role;

}
