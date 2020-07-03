package ru.levchugov.movieapp.service;

import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.model.MovieDto;
import ru.levchugov.movieapp.model.UserDto;

import java.util.List;

public interface UserService {

    void create(UserDto user);

    List<UserDto> readAll();

    UserDto findById(long id);

    void addMovieToWatch(UserDto user, MovieDto movie);

    void removeMovie(UserDto user, MovieDto movie);

}
