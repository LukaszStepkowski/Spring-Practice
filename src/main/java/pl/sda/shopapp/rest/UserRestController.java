package pl.sda.shopapp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.shopapp.dto.CreateUserDto;
import pl.sda.shopapp.service.user.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin/users")
public class UserRestController {

    private final UserService service;

    public UserRestController(UserService service) {
        this.service = service;
    }

    ResponseEntity<Void> createUser(@RequestBody @Valid CreateUserDto dto) {
        service.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
