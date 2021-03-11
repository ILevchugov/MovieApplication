package ru.levchugov.subscription.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.levchugov.subscription.dao.UserRepository;
import ru.levchugov.subscription.domain.Subscription;
import ru.levchugov.subscription.domain.User;
import ru.levchugov.subscription.domain.dto.UserDto;
import ru.levchugov.subscription.domain.service.SubscriptionService;
import ru.levchugov.subscription.domain.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class  SubscriptionController {

    private final UserService userService;
    private final SubscriptionService subscriptionService;
    private final UserRepository userRepository;

    @PostMapping(value = "/users")
    public ResponseEntity<?> addUser(@RequestBody UserDto user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> get() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/subscriptions")
    public ResponseEntity<List<Subscription>> getAll() {
        return new ResponseEntity<>(subscriptionService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/users/{userId}/subscription")
    public ResponseEntity<?> subscription(@PathVariable(value = "userId") Long userId,
                                          @RequestParam(value = "id") Long subscriptionId) {

        subscriptionService.subscribe(userId, subscriptionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
