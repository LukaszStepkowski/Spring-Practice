package pl.sda.shopapp.entity;

import pl.sda.shopapp.util.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public final class VatNumber {

    @Column(name = "vat_number")
    private String value;

    public VatNumber(String value){
        Preconditions.requireNonNulls(value);
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (!value.matches("\\d{10}")){
            throw new IllegalArgumentException("Vat number is invalid: " + value);
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VatNumber vatNumber = (VatNumber) o;
        return value.equals(vatNumber.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
