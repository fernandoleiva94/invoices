package com.sevenb.invoices.mapper;

import com.sevenb.invoices.dto.InvoiceDto;
import com.sevenb.invoices.model.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface InvoiceMapper {
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "provider", ignore = true)
    Invoice sourceToDestination(InvoiceDto invoiceDto);

}
