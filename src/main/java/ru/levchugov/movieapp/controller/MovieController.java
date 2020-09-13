package ru.levchugov.movieapp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.levchugov.movieapp.api.model.Rating;
import ru.levchugov.movieapp.model.dto.MovieDto;
import ru.levchugov.movieapp.service.MovieService;
import ru.levchugov.movieapp.service.impl.ImdbService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ImdbService imdbService;

    @PostMapping(value = "/movies")
    public ResponseEntity<?> create(@RequestBody MovieDto movieDto) {
        movieService.add(movieDto);

        log.info("Получен запрос на добавление нового фильма {} в б/д.", movieDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/movies")
    public ResponseEntity<List<MovieDto>> read() {
        final List<MovieDto> moviesDto = movieService.findAll();

        log.info("Получен запрос на просмотр информации о фильмах.");

        return !moviesDto.isEmpty()
                ? new ResponseEntity<>(moviesDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/movies/{id}")
    public ResponseEntity<MovieDto> read(@PathVariable(name = "id") int id) {
        try {
            MovieDto movieDto = movieService.findById(id);
            log.info("Получен запрос на получение информации о фильме {}.", movieDto);
            return new ResponseEntity<>(movieDto, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            log.error("Exception", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/movies/{id}/scores")
    public ResponseEntity<Rating> scores(@PathVariable(name = "id") int id) {
        try {
            Rating rating = imdbService.getMovieRating(movieService.findById(id));
            return new ResponseEntity<>(rating, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
