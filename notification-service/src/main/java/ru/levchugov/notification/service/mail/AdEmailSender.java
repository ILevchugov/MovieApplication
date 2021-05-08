package ru.levchugov.notification.service.mail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import ru.levchugov.notification.model.Email;
import ru.levchugov.notification.model.EmailType;

@Slf4j
@Component
@AllArgsConstructor
public class AdEmailSender implements SendingStrategy {

    private final MailSender mailSender;

    @Override
    public void send(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("Discount 15%");
        message.setText("First month with discount!");
        message.setTo(email.getTo());

        mailSender.send(message);

        log.info("Ad email message sent to {}", email.getTo());
    }

    @Override
    public EmailType getType() {
        return EmailType.ADVERTISING;
    }
}
