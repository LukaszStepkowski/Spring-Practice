package pl.sda.shopapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.shopapp.entity.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    // select * from Customer c where c.name = ?
    List<Customer> findByName(String name);

    // select * from Customer c where c.name like
    List<Customer> findByNameStartingWith(String name);
}
