package ru.levchugov.movieapp.service;

import ru.levchugov.movieapp.model.dto.MovieDto;

import java.util.List;


public interface TopWatchedMoviesService {

    List<MovieDto> getTopWatchedMovies();

}
