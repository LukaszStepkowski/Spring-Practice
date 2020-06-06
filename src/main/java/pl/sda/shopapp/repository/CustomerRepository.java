package pl.sda.shopapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.shopapp.entity.Customer;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
