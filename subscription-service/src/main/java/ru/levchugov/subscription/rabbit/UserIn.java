package ru.levchugov.subscription.rabbit;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UserIn {

    String USER = "user";

    @Input(USER)
    SubscribableChannel input();

}
