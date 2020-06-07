package pl.sda.shopapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.shopapp.entity.Company;
import pl.sda.shopapp.entity.Customer;
import pl.sda.shopapp.entity.Person;
import pl.sda.shopapp.entity.VatNumber;
import pl.sda.shopapp.repository.CustomerRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

@SpringBootTest
@Transactional
public class CustomerNameModifyTest {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private EntityManager em;

    @Test
    void testModifyCompanyName() {
        //given
        var company = new Company(new VatNumber("1234567899"), "Change Me");
        repository.saveAndFlush(company);
        em.clear();

        //when
        int updated = repository.updateCompanyName(company.getId(), "TEST S.A.");


        //then
        Assertions.assertEquals(1, updated);
        var customers = repository.findById(company.getId()).get();
        Assertions.assertEquals("TEST S.A.", customers.getName());
    }
}
