package ru.levchugov.subscription.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.levchugov.subscription.domain.dto.UserDto;
import ru.levchugov.subscription.domain.service.UserService;

@RestController
@AllArgsConstructor
public class SubscriptionController {

    private final UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<?> addUser(@RequestBody UserDto user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
