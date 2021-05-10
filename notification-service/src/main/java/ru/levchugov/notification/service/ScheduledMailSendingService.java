package ru.levchugov.notification.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Service;
import ru.levchugov.notification.model.Email;
import ru.levchugov.notification.model.EmailType;
import ru.levchugov.notification.repository.UserMongoRepository;
import ru.levchugov.notification.service.mail.SendingStrategy;

import java.util.Map;

@Service
@AllArgsConstructor
public class ScheduledMailSendingService {

    private final Map<EmailType, SendingStrategy> sendingStrategies;
    private final UserMongoRepository userRepository;

    @Scheduled(fixedRate = 60000)
    public void send() {
       userRepository.findAll().forEach(
               user -> sendingStrategies.get(EmailType.ADVERTISING).send(
                       Email.builder()
                               .userName(user.getName())
                               .to(user.getEmail())
                               .build()
               )
       );

    }

}
