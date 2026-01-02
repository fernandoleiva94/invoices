package com.sevenb.invoices.service;


import com.sevenb.invoices.dto.BearerTokenPayloadDto;
import com.sevenb.invoices.dto.InvoiceDto;
import com.sevenb.invoices.dto.SearchInvoiceInputDto;
import com.sevenb.invoices.exception.NotFoundException;
import com.sevenb.invoices.mapper.InvoiceMapper;
import com.sevenb.invoices.model.Invoice;
import com.sevenb.invoices.model.InvoiceType;
import com.sevenb.invoices.model.Provider;
import com.sevenb.invoices.repository.InvoiceRepository;
import com.sevenb.invoices.repository.InvoiceTypeRepository;
import com.sevenb.invoices.repository.ProviderRepository;
import com.sevenb.invoices.util.JWTExtractionUtil;
import jakarta.persistence.EntityExistsException;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ProviderRepository providerRepository;
    private final JWTExtractionUtil jwtExtractionUtil;
    private final InvoiceTypeRepository invoiceTypeRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
                              ProviderRepository providerRepository,
                              JWTExtractionUtil jwtExtractionUtil, InvoiceTypeRepository invoiceTypeRepository) {
        this.invoiceRepository = invoiceRepository;
        this.providerRepository = providerRepository;
        this.jwtExtractionUtil = jwtExtractionUtil;
        this.invoiceTypeRepository = invoiceTypeRepository;
    }

    private final  InvoiceMapper invoiceMapper = Mappers.getMapper(InvoiceMapper.class);

    @Override
    public ResponseEntity<?> save(InvoiceDto invoiceDto, String bearerToken) {
        BearerTokenPayloadDto  bearerTokenPayloadDto = jwtExtractionUtil.getPayloadFromToken(bearerToken);
        Invoice invoice = invoiceMapper.sourceToDestination(invoiceDto);

        Provider providerOpt = providerRepository.findById(invoiceDto.getProvider()).orElseThrow();
        invoice.setProvider(providerOpt);

        InvoiceType invoiceType = invoiceTypeRepository.findById(invoiceDto.getInvoiceTypeId()).orElseThrow();
        invoice.setInvoiceType(invoiceType);

        invoice.setCompany(bearerTokenPayloadDto.getCompany());

        List<Invoice> repeatedInvoices = invoiceRepository.findByPointSaleAndNumberAndProviderAndCompany(invoice.getPointSale(),
            invoice.getNumber(), invoice.getProvider(), invoice.getCompany());
        if (repeatedInvoices.isEmpty())
            return new ResponseEntity<>(invoiceRepository.save(invoice), HttpStatus.CREATED);
        throw new EntityExistsException("invoice-service.invoice.already-exist");
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public Invoice update(InvoiceDto invoiceDto, Long id) {
        Invoice updateInvoice = findById(id);
        if (Objects.isNull(updateInvoice))
            throw new NotFoundException("invoice-service.invoice.not-found") ;
        updateInvoice.setDate(invoiceDto.getDate());
        updateInvoice.setNumber(invoiceDto.getNumber());
        updateInvoice.setPointSale(invoiceDto.getPointSale());

         Provider providerOpt = providerRepository.findById(invoiceDto.getProvider()).orElseThrow();
        updateInvoice.setProvider(providerOpt);

        InvoiceType invoiceType = invoiceTypeRepository.findById(invoiceDto.getInvoiceTypeId()).orElseThrow();
        updateInvoice.setInvoiceType(invoiceType);

        updateInvoice.setEngraved(invoiceDto.getEngraved());
        updateInvoice.setEngraved105(invoiceDto.getEngraved105());
        updateInvoice.setEngraved27(invoiceDto.getEngraved27());
        updateInvoice.setExempt(invoiceDto.getExempt());
        updateInvoice.setIva105(invoiceDto.getIva105());
        updateInvoice.setIva21(invoiceDto.getIva21());
        updateInvoice.setIva27(invoiceDto.getIva27());
        updateInvoice.setIibb(invoiceDto.getIibb());
        updateInvoice.setTaxedOthers(invoiceDto.getTaxedOthers());
        updateInvoice.setMunicipality(invoiceDto.getMunicipality());
        updateInvoice.setImpacted(invoiceDto.getImpacted());
        updateInvoice.setNonTaxableAmount(invoiceDto.getNonTaxableAmount());


        return invoiceRepository.save(updateInvoice);
    }

    @Override
    public List<Invoice> findByFilters(SearchInvoiceInputDto invoiceDto, String bearerToken) {
        BearerTokenPayloadDto bearerTokenPayloadDto = jwtExtractionUtil.getPayloadFromToken(bearerToken);

        if (invoiceDto.getIdProvider() != null && invoiceDto.getImpacted() != null) {
            Provider provider = providerRepository.findById(invoiceDto.getIdProvider()).orElseThrow();

            return invoiceRepository.findByDateBetweenAndProviderAndImpactedAndCompany(invoiceDto.getStarDate(),
                invoiceDto.getEndDate(), provider, invoiceDto.getImpacted(), bearerTokenPayloadDto.getCompany());
        }

        if (invoiceDto.getIdProvider() == null && invoiceDto.getImpacted() != null) {
            return invoiceRepository.findByDateBetweenAndImpactedAndCompany(invoiceDto.getStarDate(),
                invoiceDto.getEndDate(), invoiceDto.getImpacted(), bearerTokenPayloadDto.getCompany());
        }

        if (invoiceDto.getIdProvider() != null) {
           Provider provider = providerRepository.findById(invoiceDto.getIdProvider()).orElseThrow();
            return invoiceRepository.findByDateBetweenAndProviderAndCompany(invoiceDto.getStarDate(),
                invoiceDto.getEndDate(), provider, bearerTokenPayloadDto.getCompany());
        }

        return invoiceRepository.findByDateBetweenAndCompany(invoiceDto.getStarDate(),
            invoiceDto.getEndDate(), bearerTokenPayloadDto.getCompany());
    }
}
