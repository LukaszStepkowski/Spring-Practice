package pl.sda.shopapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.shopapp.dto.CreateCompanyDto;
import pl.sda.shopapp.entity.Company;
import pl.sda.shopapp.entity.VatNumber;
import pl.sda.shopapp.repository.CustomerRepository;

import java.util.UUID;

import static pl.sda.shopapp.util.Preconditions.requireNonNulls;

@Service
public class CustomerService {


    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        requireNonNulls(repository);
        this.repository = repository;
    }

    @Transactional
    public UUID createCompany(CreateCompanyDto dto){
        var company = new Company(new VatNumber(dto.getVatNumber()), dto.getName());
        repository.save(company);
        return company.getId();
    }

}
