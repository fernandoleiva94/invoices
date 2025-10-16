package com.sevenb.invoices.controller;

import com.sevenb.invoices.dto.InvoiceDto;
import com.sevenb.invoices.dto.SearchInvoiceInputDto;
import com.sevenb.invoices.model.Invoice;
import com.sevenb.invoices.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "/invoice", produces = "application/json")
class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController (InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> findByFilters(@RequestParam String startDate, @RequestParam String endDate,
                                       @RequestParam(required = false) Boolean impacted,
                                       @RequestParam(required = false) Long idProvider,
                                       @RequestHeader("Authorization") String bearerToken) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return invoiceService.findByFilters(new SearchInvoiceInputDto(LocalDate.parse(startDate, formatter),
            LocalDate.parse(endDate, formatter), impacted, idProvider), bearerToken);
    }

    @GetMapping("/{id}")
    public Invoice findInvoiceId(@PathVariable Long id) {
        return invoiceService.findById(id);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> save(@RequestBody InvoiceDto invoiceDto, @RequestHeader("Authorization") String bearerToken) {
        return invoiceService.save(invoiceDto, bearerToken);
    }

    @PutMapping("/{id}")
    public Invoice update(@RequestBody InvoiceDto invoiceDto, @PathVariable Long id) {
        return invoiceService.update(invoiceDto, id);
    }
}
