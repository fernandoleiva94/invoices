package com.sevenb.invoices.service;

import com.sevenb.invoices.model.InvoiceType;
import com.sevenb.invoices.repository.InvoiceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceTypeServiceImpl implements InvoiceTypeService{

    private final InvoiceTypeRepository invoiceTypeRepository;

    public InvoiceTypeServiceImpl(InvoiceTypeRepository invoiceTypeRepository){
        this.invoiceTypeRepository = invoiceTypeRepository;
    }

    @Override
    public List<InvoiceType> findAll(){
        return invoiceTypeRepository.findAll();
    }
}
