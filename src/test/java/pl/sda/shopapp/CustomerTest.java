package pl.sda.shopapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shopapp.entity.Address;
import pl.sda.shopapp.entity.Person;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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
        Assertions.assertEquals(readPerson, person);
        Assertions.assertEquals(1, readPerson.getAddresses().size());
    }
}
