package ru.levchugov.notification.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.levchugov.notification.model.Email;
import ru.levchugov.notification.model.EmailType;
import ru.levchugov.notification.model.MailTemplate;
import ru.levchugov.notification.model.User;
import ru.levchugov.notification.repository.UserRepository;
import ru.levchugov.notification.service.NotificationService;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaConsumer {

    private final UserRepository userRepository;
    private final NotificationService notificationService;

    @KafkaListener(topics = "mailTemplates")
    public void receive(MailTemplate payload) {
        log.info("new template {}", payload);
    }

    @KafkaListener(containerFactory = "kafkaUserListenerContainerFactory", topics = "users")
    public void receive(User user) {
        log.info("received information about new user {}", user);
        userRepository.save(user);
        notificationService.sendEmail(
                Email.builder()
                        .userName(user.getName() + user.getFullName())
                        .to(user.getEmail())
                        .build(),
                EmailType.GREETING_NEW_USER
        );

    }
}
