package ru.levchugov.movieapp.service;

import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.model.User;

import java.util.List;

public interface UserService {

    void create(User user);

    List<User> readAll();

    User findById(long id);

    void addMovieToWatch(User user, Movie movie);

    void removeMovie(User user, Movie movie);

}
