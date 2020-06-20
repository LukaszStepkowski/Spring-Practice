package pl.sda.shopapp.rest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.sda.shopapp.dto.CreateCompanyDto;
import pl.sda.shopapp.dto.CustomerQuery;
import pl.sda.shopapp.dto.CustomerQueryResultDto;
import pl.sda.shopapp.service.CustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static pl.sda.shopapp.util.Preconditions.requireNonNulls;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    private final CustomerService service;

    CustomerRestController (CustomerService service) {
        requireNonNulls(service);
        this.service = service;
    }

    @GetMapping
    List<CustomerQueryResultDto> list() {
        return service.findCustomer(new CustomerQuery());
    }

    @PostMapping
    UUID createCustomer(@RequestBody @Valid CreateCompanyDto dto) {
        return service.createCompany(dto);
    }
}
