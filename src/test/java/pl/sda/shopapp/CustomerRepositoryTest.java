package pl.sda.shopapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import pl.sda.shopapp.entity.*;
import pl.sda.shopapp.repository.CustomerRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    void testCreateAndFind(){
        //given
        var person = new Person("Jan", "Kowalski", "123456789");
        var address = new Address("test", "test", "01-500", "PL");
        person.addAddress(address);

        var company = new Company(new VatNumber("1234567890"), "Test S.A.");
        var companyAddress = new Address("test", "test", "01-500", "PL");
        company.addAddress(companyAddress);

        //when
        repository.saveAll(Arrays.asList(person, company));
        /*
        same as
        repository.save(person);
        repository.save(company);
        */

        repository.flush();

        //then
        var customers = repository.findAll();
        assertTrue(customers.contains(person));
        assertTrue(customers.contains(company));

        var sortedCustomers = repository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        assertEquals(company, sortedCustomers.get(0));
        assertEquals(person, sortedCustomers.get(1));
    }

    @Test
    void testFindByName(){
        //given
        var company = new Company(new VatNumber("1234567890"), "Test S.A.");
        var companyAddress = new Address("test", "test", "01-500", "PL");
        company.addAddress(companyAddress);

        //when
        repository.save(company);
        var customers = repository.findByName("Test S.A.");

        //then
        assertFalse(customers.isEmpty());
        assertEquals("Test S.A.", customers.get(0).getName());
    }
}
