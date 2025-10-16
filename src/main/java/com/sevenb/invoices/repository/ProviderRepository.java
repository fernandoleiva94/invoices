package com.sevenb.invoices.repository;

import com.sevenb.invoices.model.Company;
import com.sevenb.invoices.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Provider repository.
 */
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    Optional<List<Provider>> findByCompany(Company company);
    Optional<Provider> findByCompanyNameAndCuitAndCompany(String companyName, String cuit, Company company);
}
