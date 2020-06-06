package pl.sda.shopapp.entity;

import pl.sda.shopapp.util.JpaOnly;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "customer_type")
public abstract class Customer {

    @Id
    private UUID id;

    private String name;
    private String taxId;

    @JpaOnly
    private Customer() {
    }

    public Customer(String name, String taxId) {
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
}
