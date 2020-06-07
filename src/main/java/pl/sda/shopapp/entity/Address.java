package pl.sda.shopapp.entity;

import pl.sda.shopapp.util.JpaOnly;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

import static pl.sda.shopapp.util.Preconditions.requireNonNulls;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    private UUID id;

    private String street;
    private String city;
    private String zipCode;
    private String country;

    @JpaOnly
    private Address() {
    }

    public Address(String street, String city, String zipCode, String country) {
        requireNonNulls(street, city, zipCode, country);
        this.id = UUID.randomUUID();
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) &&
                city.equals(address.city) &&
                zipCode.equals(address.zipCode) &&
                country.equals(address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, zipCode, country);
    }
}
