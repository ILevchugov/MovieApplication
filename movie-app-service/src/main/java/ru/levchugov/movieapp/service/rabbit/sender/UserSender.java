package ru.levchugov.movieapp.service.rabbit.sender;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.model.dto.UserDto;
import ru.levchugov.movieapp.service.rabbit.UserOut;

@Slf4j
@Service
@AllArgsConstructor
@EnableBinding(UserOut.class)
public class UserSender {

    private final UserOut userOut;

    public void send(UserDto user) {
        userOut.output().send(MessageBuilder.withPayload(user).build());
        log.info("out {}", user);
    }
}
