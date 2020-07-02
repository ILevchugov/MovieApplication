package ru.levchugov.movieapp.service;

import ru.levchugov.movieapp.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    Movie findById(long id);

    void add(Movie movie);

}
