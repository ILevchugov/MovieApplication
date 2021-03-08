package ru.levchugov.movieapp.service.rabbit;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface VoteOut {

    String OUTPUT = "vote";

    @Output(OUTPUT)
    MessageChannel output();

}
