package pl.sda.shopapp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.shopapp.dto.CreateCompanyDto;
import pl.sda.shopapp.repository.CustomerRepository;

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
}
