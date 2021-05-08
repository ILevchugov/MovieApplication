package ru.levchugov.notification.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.levchugov.notification.model.Email;
import ru.levchugov.notification.model.EmailType;
import ru.levchugov.notification.service.mail.SendingStrategy;

import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class NotificationService {

    Map<EmailType, SendingStrategy> sendingStrategies;

    public void sendEmail(Email email, EmailType emailType) {
        sendingStrategies.get(emailType).send(email);

        log.info("Email message sent to {}", email.getTo());
    }
}
