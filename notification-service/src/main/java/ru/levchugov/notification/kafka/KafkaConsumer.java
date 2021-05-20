package ru.levchugov.notification.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.levchugov.notification.model.MailTemplate;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "mailTemplates")
    public void receive(MailTemplate payload){
        log.info("new template {}", payload);
    }
}
