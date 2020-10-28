package ru.levchugov.movieapp.service.impl;

import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.model.dto.MovieDto;
import ru.levchugov.movieapp.model.User;
import ru.levchugov.movieapp.model.dto.UserDto;
import ru.levchugov.movieapp.repository.UserRepository;
import ru.levchugov.movieapp.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserDto userDto) {
        userRepository.save(User.fromDto(userDto));
    }

    @Override
    public List<UserDto> readAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();

        for (User user: users) {
            usersDto.add(user.toDto());
        }

        return usersDto;

    }
    @Override
    public UserDto findById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get().toDto();
        } else {
            throw new IllegalArgumentException("Wrong id");
        }
    }

    @Override
    public void addMovieToWatch(UserDto userDto, MovieDto movieDto) {
        userDto.getMoviesToWatch().add(movieDto.getId());

        userRepository.save(User.fromDto(userDto));
    }

    @Override
    public void removeMovie(UserDto userDto, MovieDto movieDto) {
        userDto.getMoviesToWatch().remove(movieDto);
        userDto.getMoviesWatched().add(movieDto.getId());

        userRepository.save(User.fromDto(userDto));
    }

}
