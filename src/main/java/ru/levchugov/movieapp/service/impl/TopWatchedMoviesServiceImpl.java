package ru.levchugov.movieapp.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.model.User;
import ru.levchugov.movieapp.repository.MovieRepository;
import ru.levchugov.movieapp.repository.UserRepository;
import ru.levchugov.movieapp.service.TopWatchedMoviesService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TopWatchedMoviesServiceImpl implements TopWatchedMoviesService {
    private static final int TOP_SIZE = 3;

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getTopWatchedMovies() {
        List<Movie> movies = movieRepository.findAll();

        log.info("Список фильмов {}", movies);

        movies.sort((movie1, movie2) -> {
            int movie1Count = 0;
            int movie2Count = 0;
            List<User> users = userRepository.findAll();

            for (User user1 : users) {
                if (user1.getMoviesWatched().contains(movie1)) {
                    movie1Count++;
                }
                if (user1.getMoviesWatched().contains(movie2)) {
                    movie2Count++;
                }
            }
            return movie2Count - movie1Count;
        });


        log.info("Отсортированный список {}", movies);

        ArrayList<Movie> topWatchedMovies = new ArrayList<>(TOP_SIZE);
        for (int i = 0; i < TOP_SIZE; i++) {
            topWatchedMovies.add(movies.get(i));
        }

        return topWatchedMovies;
    }
}
