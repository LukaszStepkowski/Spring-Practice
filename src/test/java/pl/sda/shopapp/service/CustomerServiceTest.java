package pl.sda.shopapp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.shopapp.dto.CreateCompanyDto;
import pl.sda.shopapp.dto.CustomerQuery;
import pl.sda.shopapp.dto.CustomerQueryResultDto;
import pl.sda.shopapp.entity.Company;
import pl.sda.shopapp.entity.Person;
import pl.sda.shopapp.entity.VatNumber;
import pl.sda.shopapp.repository.CustomerRepository;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class CustomerServiceTest {

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerRepository repository;

    @Test
    void testCreateCompany() {
        //given
        var createDto = new CreateCompanyDto("Test S.A.", "0123456789");

        //when
        var id = service.createCompany(createDto);

        //then
        var companyOptional = repository.findById(id);
        assertTrue(companyOptional.isPresent());
    }

    @Test
    void testFindCustomer(){
        //given
        var company = new Company(new VatNumber("1234567899"), "Test SA");
        var person1 = new Person("Test", "Kowalski", "123456789");
        var person2 = new Person("Adam", "Nowak", "123456789");
        repository.saveAll(asList(company, person1, person2));
        repository.flush();

        var query = new CustomerQuery();
        query.setName("Test");

        //when
        var customers = service.findCustomer(query);

        //then
        assertEquals(2, customers.size());
        var dto1 = new CustomerQueryResultDto(
                company.getId(), company.getName(),
                company.getTaxId(), CustomerQueryResultDto.CustomerType.COMPANY);
        assertTrue(customers.contains(dto1));

        var dto2 = new CustomerQueryResultDto(
                person1.getId(), person1.getName(),
                person1.getTaxId(), CustomerQueryResultDto.CustomerType.PERSON);
        assertTrue(customers.contains(dto2));
    }
}
