package pl.sda.shopapp.service.customer;

import org.springframework.stereotype.Component;
import pl.sda.shopapp.dto.AddressDto;
import pl.sda.shopapp.dto.CustomerQueryResultDto;
import pl.sda.shopapp.entity.Address;
import pl.sda.shopapp.entity.Company;
import pl.sda.shopapp.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class CustomerMapper {

    public List<CustomerQueryResultDto> map(List<Customer> customers){
        return customers.stream()
                .map(this::map)
                .collect(toList());
    }

    List<AddressDto> mapAddresses(List<Address> addresses) {
        return addresses.stream()
                .map(address -> new AddressDto(address.getId(), address.getStreet(), address.getZipCode(), address.getCity(), address.getCountry()))
                .collect(toList());
    }

    private CustomerQueryResultDto map(Customer customer) {
        return new CustomerQueryResultDto(
                customer.getId(),
                customer.getName(),
                customer.getTaxId(),
                customer instanceof Company
                        ? CustomerQueryResultDto.CustomerType.COMPANY
                        : CustomerQueryResultDto.CustomerType.PERSON
        );
    }
}
