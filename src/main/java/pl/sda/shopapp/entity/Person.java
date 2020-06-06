package pl.sda.shopapp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("person")
public final class Person extends Customer {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName, String taxId) {
        super(firstName + " " + lastName, taxId);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
