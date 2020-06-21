package pl.sda.shopapp.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreateUserDto {

    private String username;
    private String password;
    private List<String> roles;

    public CreateUserDto(String username, String password, List<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return new ArrayList<>(roles);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateUserDto that = (CreateUserDto) o;
        return username.equals(that.username) &&
                password.equals(that.password) &&
                roles.equals(that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, roles);
    }
}
