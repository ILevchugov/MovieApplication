package ru.levchugov.subscription.rabbit.listener;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import ru.levchugov.subscription.domain.dto.UserDto;
import ru.levchugov.subscription.domain.service.UserService;
import ru.levchugov.subscription.rabbit.UserIn;

@Slf4j
@Component
@AllArgsConstructor
@EnableBinding(UserIn.class)
public class UserListener {

    private final UserService userService;

    @StreamListener(target = UserIn.USER)
    public void receive(UserDto userDto) {
        userService.addUser(userDto);
        log.info("received {}", userDto);
    }
}
