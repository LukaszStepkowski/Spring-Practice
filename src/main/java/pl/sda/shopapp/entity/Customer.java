package pl.sda.shopapp.entity;

import pl.sda.shopapp.util.JpaOnly;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static pl.sda.shopapp.util.Preconditions.requireNonNulls;

@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "customer_type")
public abstract class Customer {

    @Id
    private UUID id;

    private String name;
    private String taxId;

    @OneToMany
    private List<Address> addresses;

    @JpaOnly
    private Customer() {
    }

    public Customer(String name, String taxId) {
        requireNonNulls(name, taxId);
        this.id = UUID.randomUUID();
        this.name = name;
        this.taxId = taxId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) &&
                name.equals(customer.name) &&
                taxId.equals(customer.taxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, taxId);
    }
}
