package ru.levchugov.movieapp.service.rabbit;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface VoteIn {

    String INPUT = "vote";

    @Input(INPUT)
    SubscribableChannel input();

}
