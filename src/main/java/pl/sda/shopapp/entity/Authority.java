package pl.sda.shopapp.entity;

import pl.sda.shopapp.util.JpaOnly;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    private UUID id;

    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @JpaOnly
    public Authority() {
    }

    public UUID getId() {
        return id;
    }

    public String getAuthority() {
        return authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority1 = (Authority) o;
        return id.equals(authority1.id) &&
                authority.equals(authority1.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authority);
    }
}
