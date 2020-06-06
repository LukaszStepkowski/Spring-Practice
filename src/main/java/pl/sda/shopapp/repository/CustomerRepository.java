package pl.sda.shopapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.shopapp.entity.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    List<Customer> findByName(String name);
}
