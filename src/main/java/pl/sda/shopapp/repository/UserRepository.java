package pl.sda.shopapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.shopapp.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
