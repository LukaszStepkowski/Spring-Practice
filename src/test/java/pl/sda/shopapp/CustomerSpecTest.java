package pl.sda.shopapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shopapp.dto.CustomerQuery;
import pl.sda.shopapp.entity.Person;
import pl.sda.shopapp.repository.CustomerRepository;
import pl.sda.shopapp.repository.CustomerSpec;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerSpecTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    void testSpec(){
        //given
        var query = new CustomerQuery();
        query.setName("Jan");
        query.setTaxId("123456789");

        var person1 = new Person("Jan", "Kowalski", "123456789");
        var person2 = new Person("Jan", "Nowak", "789456123");
        repository.saveAll(asList(person1, person2));

        //when
        var customers = repository.findAll(CustomerSpec.withQuery(query));

        //then
        assertEquals(1, customers.size());

    }
}
