package com.sevenb.invoices.service;

import com.sevenb.invoices.dto.InvoiceDto;
import com.sevenb.invoices.dto.SearchInvoiceInputDto;
import com.sevenb.invoices.model.Invoice;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InvoiceService {
    ResponseEntity<?> save(InvoiceDto invoiceDto, String bearerToken);
    List<Invoice> findAll();
    Invoice findById(Long id);
    Invoice update(InvoiceDto invoiceDto, Long id);
    List<Invoice> findByFilters(SearchInvoiceInputDto inputDto, String bearerToken);

}
