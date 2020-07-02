package ru.levchugov.movieapp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.levchugov.movieapp.model.User;
import ru.levchugov.movieapp.service.UserService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody User user) {
        userService.create(user);

        log.info("Получен запрос на добавление нового пользователя {}.", user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> read() {
        final List<User> users = userService.readAll();

        log.info("Получен запрос на просмотр информации о пользователях.");

        return !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> read(@PathVariable(value = "id") int id) {
        final User user = userService.findById(id);

        log.info("Получен запрос на просмотр информации о пользователе {}.", user);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
