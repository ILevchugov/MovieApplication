package ru.levchugov.movieapp.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.levchugov.movieapp.model.dto.UserDto;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaUserSender {

    private final KafkaTemplate<String, UserDto> kafkaTemplate;

    public void send(String topic, UserDto user) {
        kafkaTemplate.send(topic, user);
        log.info("new user {} sended to kafka ", user);
    }

}
