package ru.levchugov.movieapp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.model.User;
import ru.levchugov.movieapp.service.MovieService;
import ru.levchugov.movieapp.service.UserService;

@Slf4j
@RestController
@AllArgsConstructor
public class CommonController {

    private final UserService userService;
    private final MovieService movieService;

    @GetMapping(value = "users/{id}/movies_to_watch")
    public ResponseEntity<?> addMovie(@PathVariable(value = "id") int userId,
                                      @RequestParam(value = "movie_id") int movieId) {
        final User user = userService.findById(userId);
        final Movie movie = movieService.findById(movieId);

        userService.addMovieToWatch(user, movie);

        log.info("Получен запрос от пользователя {} на добавление фильма {} для просмотра. ",
                user,
                movie);

        return (movie!=null && user !=null)
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "users/{id}/watched_movies")
    public ResponseEntity<?> removeMovie(@PathVariable(value = "id") int userId,
                                         @RequestParam(value = "movie_id") int movieId) {
        final User user = userService.findById(userId);
        final Movie movie = movieService.findById(movieId);

        userService.removeMovie(user, movie);

        log.info("Получен запрос от пользователя {} на удаление фильма {} из списка для просмотра. ",
                user,
                movie);

        return (movie!=null && user !=null)
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
