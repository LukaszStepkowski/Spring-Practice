package pl.sda.shopapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import pl.sda.shopapp.entity.Customer;
import pl.sda.shopapp.entity.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID>, JpaSpecificationExecutor<Customer> {

    // select * from Customer c where c.name = ?1
    List<Customer> findByName(String name);

    // select * from Customer c where c.name like = ?1%
    List<Customer> findByNameStartingWith(String name);

    @Query("from Customer c where c.taxId = ?1")
    Optional<Customer> findByTaxId(String taxId);

    @Query("from Person p where p.firstName like ?1 and p.lastName like ?2")
    List<Person> findPerson(String firstName, String lastName);

    @Query("select c from Customer c join c.addresses a where a.city = ?1")
    Page<Customer> findByCity(String city, Pageable pageable);
}
