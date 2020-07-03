package ru.levchugov.movieapp.service;


import ru.levchugov.movieapp.model.MovieDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> findAll();

    MovieDto findById(long id);

    void add(MovieDto movie);

}
