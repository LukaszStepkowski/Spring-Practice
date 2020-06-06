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

import static java.util.Arrays.asList;
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
        repository.saveAll(asList(person, company));
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

    @Test
    void testFindByNameStartingWith(){
        //given
        var company = new Company(new VatNumber("1234567890"), "Test S.A.");
        var company2 = new Company(new VatNumber("1234567890"), "Testuj S.A.");
        var person = new Person("Jan", "Kowalski", "123456789");
        repository.saveAll(asList(company, company2, person));

        //when
        var customers = repository.findByNameStartingWith("Test");

        //then
        assertEquals(2, customers.size());
    }

    @Test
    void testHqlFindByTaxId(){
        //given
        var company1 = new Company(new VatNumber("1234567890"), "Test S.A.");
        var company2 = new Company(new VatNumber("1234567891"), "Testuj S.A.");
        repository.saveAll(asList(company1, company2));

        //when
        var customerOptional = repository.findByTaxId("1234567891");

        //then
        assertTrue(customerOptional.isPresent());
        assertEquals(company2, customerOptional.get());
    }

    @Test
    void testHqlFindByFirstAndLastName(){
        //given
        var person1 = new Person("Jan", "Kowalski", "123456789");
        var person2 = new Person("Jan", "Nowak", "789456123");
        repository.saveAll(asList(person1, person2));

        //when
        var customers = repository.findPerson("Jan%", "Kow%");

        //then
        assertEquals(1, customers.size());
        assertEquals(person1, customers.get(0));
    }
}
