package com.sevenb.invoices.mapper;

import com.sevenb.invoices.dto.InvoiceDto;
import com.sevenb.invoices.model.Invoice;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-24T12:45:12-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.15 (Ubuntu)"
)
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public Invoice sourceToDestination(InvoiceDto invoiceDto) {
        if ( invoiceDto == null ) {
            return null;
        }

        Invoice invoice = new Invoice();

        invoice.setId( invoiceDto.getId() );
        invoice.setPointSale( invoiceDto.getPointSale() );
        invoice.setNumber( invoiceDto.getNumber() );
        invoice.setDate( invoiceDto.getDate() );
        invoice.setEngraved( invoiceDto.getEngraved() );
        invoice.setEngraved105( invoiceDto.getEngraved105() );
        invoice.setEngraved27( invoiceDto.getEngraved27() );
        invoice.setExempt( invoiceDto.getExempt() );
        invoice.setIva105( invoiceDto.getIva105() );
        invoice.setIva21( invoiceDto.getIva21() );
        invoice.setIva27( invoiceDto.getIva27() );
        invoice.setIibb( invoiceDto.getIibb() );
        invoice.setTaxedOthers( invoiceDto.getTaxedOthers() );
        invoice.setMunicipality( invoiceDto.getMunicipality() );
        invoice.setImpacted( invoiceDto.getImpacted() );

        return invoice;
    }
}
