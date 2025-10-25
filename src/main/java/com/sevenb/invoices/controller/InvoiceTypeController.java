package com.sevenb.invoices.controller;

import com.sevenb.invoices.model.InvoiceType;
import com.sevenb.invoices.service.InvoiceTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/invoice-type", produces = "application/json")
public class InvoiceTypeController {

    private final InvoiceTypeService invoiceTypeService;

    public InvoiceTypeController(InvoiceTypeService invoiceTypeService){
        this.invoiceTypeService = invoiceTypeService;
    }

    @GetMapping
    public ResponseEntity<List<InvoiceType>> findAll(){
        return ResponseEntity.ok(invoiceTypeService.findAll());
    }

}
