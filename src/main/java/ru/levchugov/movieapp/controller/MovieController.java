package ru.levchugov.movieapp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.service.MovieService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping(value = "/movies")
    public ResponseEntity<?> create(@RequestBody Movie movie) {
        movieService.add(movie);

        log.info("Получен запрос на добавление нового фильма {} в б/д.", movie);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/movies")
    public ResponseEntity<List<Movie>> read() {
        final List<Movie> movies = movieService.findAll();

        log.info("Получен запрос на просмотр информации о фильмах.");

        return !movies.isEmpty()
                ? new ResponseEntity<>(movies, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/movies/{id}")
    public ResponseEntity<Movie> read(@PathVariable(name = "id") int id) {
        final Movie movie = movieService.findById(id);

        log.info("Получен запрос на получение информации о фильме {}.", movie);

        return movie != null
                ? new ResponseEntity<>(movie, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
