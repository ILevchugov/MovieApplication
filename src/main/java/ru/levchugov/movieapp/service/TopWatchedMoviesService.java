package ru.levchugov.movieapp.service;

import ru.levchugov.movieapp.model.Movie;

import java.util.List;

public interface TopWatchedMoviesService {

    List<Movie> getTopWatchedMovies();

}
