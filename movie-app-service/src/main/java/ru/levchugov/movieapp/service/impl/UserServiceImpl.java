package ru.levchugov.movieapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.api.NotificationClient;
import ru.levchugov.movieapp.api.model.Email;
import ru.levchugov.movieapp.model.dto.MovieDto;
import ru.levchugov.movieapp.model.User;
import ru.levchugov.movieapp.model.dto.UserDto;
import ru.levchugov.movieapp.repository.UserRepository;
import ru.levchugov.movieapp.service.UserService;
import ru.levchugov.movieapp.service.rabbit.sender.UserSender;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserSender userSender;
    private final NotificationClient notificationClient;

    @Override
    public void create(UserDto userDto) {
        userSender.send(userDto);
        userRepository.save(User.fromDto(userDto));
        notificationClient.sendEmail(
                Email.builder()
                        .to(userDto.getEmail())
                        .text("Welcome, " + userDto.getFullName() + " " + userDto.getName() + "!")
                        .build()
        );
    }

    @Override
    public List<UserDto> readAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();

        for (User user : users) {
            usersDto.add(user.toDto());
        }

        return usersDto;

    }

    @Override
    public UserDto findById(long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Wrong id")
        ).toDto();
    }

    @Override
    public void addMovieToWatch(UserDto userDto, MovieDto movieDto) {
        userDto.getMoviesToWatch().add(movieDto.getId());
        userRepository.save(User.fromDto(userDto));
    }

    @Override
    public void removeMovie(UserDto userDto, MovieDto movieDto) {
        userDto.getMoviesToWatch().remove(movieDto.getId());
        userDto.getMoviesWatched().add(movieDto.getId());

        userRepository.save(User.fromDto(userDto));
    }

}
