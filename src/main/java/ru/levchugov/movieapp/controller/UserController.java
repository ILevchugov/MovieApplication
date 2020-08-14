package ru.levchugov.movieapp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.levchugov.movieapp.model.dto.UserDto;
import ru.levchugov.movieapp.service.UserService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody UserDto userDto) {
        userService.create(userDto);

        log.info("Получен запрос на добавление нового пользователя {}.", userDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDto>> read() {
        final List<UserDto> users = userService.readAll();

        log.info("Получен запрос на просмотр информации о пользователях.");

        return !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserDto> read(@PathVariable(value = "id") int id) {
        final UserDto userDto = userService.findById(id);

        log.info("Получен запрос на просмотр информации о пользователе {}.", userDto);

        return userDto != null
                ? new ResponseEntity<>(userDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
