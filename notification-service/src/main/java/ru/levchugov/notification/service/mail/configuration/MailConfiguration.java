package ru.levchugov.notification.service.mail.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.levchugov.notification.model.EmailType;
import ru.levchugov.notification.service.mail.sender.SendingStrategy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Configuration
public class MailConfiguration {

    @Bean
    Map<EmailType, SendingStrategy> sendingStrategies(List<SendingStrategy> sendingStrategies) {
        return sendingStrategies.stream().collect(Collectors.toMap(SendingStrategy::getType, Function.identity()));
    }

}
