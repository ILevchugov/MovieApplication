package ru.levchugov.movieapp.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.model.dto.MovieDto;
import ru.levchugov.movieapp.model.User;
import ru.levchugov.movieapp.model.dto.UserDto;
import ru.levchugov.movieapp.repository.UserRepository;
import ru.levchugov.movieapp.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
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
        return modelMapper.map(userRepository.findById(id).get(), UserDto.class);
    }

    @Override
    public void addMovieToWatch(UserDto userDto, MovieDto movieDto) {
        userDto.getMoviesToWatch().add(movieDto.getId());

        User user = modelMapper.map(userDto, User.class);

        userRepository.save(user);
    }

    @Override
    public void removeMovie(UserDto userDto, MovieDto movieDto) {
        userDto.getMoviesToWatch().remove(movieDto);
        userDto.getMoviesWatched().add(movieDto.getId());

        User user = modelMapper.map(userDto, User.class);

        userRepository.save(user);
    }

}
