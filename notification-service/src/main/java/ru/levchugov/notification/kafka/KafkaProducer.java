package ru.levchugov.notification.kafka;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.levchugov.notification.model.MailTemplate;

@Component
@AllArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, MailTemplate> kafkaTemplate;

    public void send(String topic, MailTemplate payload) {
        kafkaTemplate.send(topic, payload);
    }

}
