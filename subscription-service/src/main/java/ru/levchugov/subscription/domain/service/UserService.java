package ru.levchugov.subscription.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levchugov.subscription.dao.UserDao;
import ru.levchugov.subscription.domain.User;
import ru.levchugov.subscription.domain.dto.UserDto;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDao userDao;

    public void addUser(UserDto userDto) {
        userDao.create(
                User.builder()
                        .id(userDto.getId())
                        .name(userDto.getName())
                        .fullName(userDto.getFullName())
                        .email(userDto.getEmail())
                        .build()
        );
    }
}
