package ru.levchugov.movieapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.model.User;
import ru.levchugov.movieapp.repository.UserRepository;
import ru.levchugov.movieapp.service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void addMovieToWatch(User user, Movie movie) {
        user.getMoviesToWatch().add(movie);

        userRepository.save(user);
    }

    @Override
    public void removeMovie(User user, Movie movie) {
        user.getMoviesToWatch().remove(movie);
        user.getMoviesWatched().add(movie);

        userRepository.save(user);
    }

}
