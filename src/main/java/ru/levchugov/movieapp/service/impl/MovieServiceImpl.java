package ru.levchugov.movieapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.repository.MovieRepository;
import ru.levchugov.movieapp.service.MovieService;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public void add(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
       return movieRepository.findAll();
    }

    @Override
    public Movie findById(long id) {
        return movieRepository.findById(id).get();
    }

}
