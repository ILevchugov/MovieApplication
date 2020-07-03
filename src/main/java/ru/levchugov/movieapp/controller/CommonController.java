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
import ru.levchugov.movieapp.model.MovieDto;
import ru.levchugov.movieapp.model.UserDto;
import ru.levchugov.movieapp.service.MovieService;
import ru.levchugov.movieapp.service.TopWatchedMoviesService;
import ru.levchugov.movieapp.service.UserService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class CommonController {

    private final UserService userService;
    private final MovieService movieService;
    private final TopWatchedMoviesService topWatchedMoviesService;

    @GetMapping(value = "users/{id}/movies_to_watch")
    public ResponseEntity<?> addMovie(@PathVariable(value = "id") int userId,
                                      @RequestParam(value = "movie_id") int movieId) {
        final UserDto userDto = userService.findById(userId);
        final MovieDto movie = movieService.findById(movieId);

        userService.addMovieToWatch(userDto, movie);

        log.info("Получен запрос от пользователя {} на добавление фильма {} для просмотра. ",
                userDto,
                movie);

        return (movie!=null && userDto !=null)
                ? new ResponseEntity<>(userDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "users/{id}/watched_movies")
    public ResponseEntity<?> removeMovie(@PathVariable(value = "id") int userId,
                                         @RequestParam(value = "movie_id") int movieId) {
        final UserDto userDto = userService.findById(userId);
        final MovieDto movieDto = movieService.findById(movieId);

        userService.removeMovie(userDto, movieDto);

        log.info("Получен запрос от пользователя {} на удаление фильма {} из списка для просмотра. ",
                userDto,
                movieDto);

        return (movieDto!=null && userDto !=null)
                ? new ResponseEntity<>(userDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "movies/top_watched_movies")
    public ResponseEntity<List<MovieDto>> getTopWatchedMovies() {
        final List<MovieDto> topWatchedMovies = topWatchedMoviesService.getTopWatchedMovies();

        return !topWatchedMovies.isEmpty()
                ? new ResponseEntity<>(topWatchedMovies, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
