package ru.levchugov.movieapp.service.rabbit;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserOut {

    String USER = "user";

    @Output(USER)
    MessageChannel output();

}
