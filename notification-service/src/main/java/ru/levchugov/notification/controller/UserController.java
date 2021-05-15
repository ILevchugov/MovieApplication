package ru.levchugov.notification.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.levchugov.notification.model.User;
import ru.levchugov.notification.repository.UserRepository;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserRepository userMongoRepository;

    @PostMapping("user")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userMongoRepository.save(user);
        return ResponseEntity.ok().build();
    }


    @GetMapping("users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userMongoRepository.findAll());
    }

}
