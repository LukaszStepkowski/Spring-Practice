package pl.sda.shopapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shopapp.entity.Address;
import pl.sda.shopapp.entity.Company;
import pl.sda.shopapp.entity.Person;
import pl.sda.shopapp.entity.VatNumber;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void testCreatePerson(){
        //given
        var person = new Person("Jan", "Kowalski", "123456789");
        var address = new Address("test", "test", "01-500", "PL");
        person.addAddress(address);

        //when
        em.persist(person);
        em.flush();
        em.clear();
        var readPerson = em.find(Person.class, person.getId());

        //then
        assertEquals(readPerson, person);
        assertEquals(1, readPerson.getAddresses().size());
    }

    @Test
    @Transactional
    void testCreateCompany(){
        //given
        var company = new Company(new VatNumber("1234567890"), "Test S.A.");
        var address = new Address("test", "test", "01-500", "PL");
        company.addAddress(address);

        //when
        em.persist(company);
        em.flush();
        em.clear();
        var readCompany = em.find(Company.class, company.getId());

        //then
        assertEquals(readCompany, company);
        assertEquals(1, readCompany.getAddresses().size());
        assertEquals(readCompany.getAddresses().get(0), address);

    }
}
