package ru.levchugov.movieapp.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.model.dto.MovieDto;
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

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<MovieDto> getTopWatchedMovies() {
        List<Movie> movies = movieRepository.findAll();

        log.info("Список фильмов {}", movies);

        //todo: придумать более оптимальный алгоритм
        movies.sort((firstMovie, secondMovie) -> {
            int movie1Count = 0;
            int movie2Count = 0;
            List<User> users = userRepository.findAll();

            for (User user : users) {
                if (user.getMoviesWatched().contains(firstMovie)) {
                    movie1Count++;
                }
                if (user.getMoviesWatched().contains(secondMovie)) {
                    movie2Count++;
                }
            }
            return movie2Count - movie1Count;
        });


        log.info("Отсортированный список {}", movies);

        ArrayList<MovieDto> topWatchedMovies = new ArrayList<>(TOP_SIZE);
        for (int i = 0; i < TOP_SIZE; i++) {
            topWatchedMovies.add(modelMapper.map(movies.get(i), MovieDto.class));
        }

        return topWatchedMovies;
    }
}
