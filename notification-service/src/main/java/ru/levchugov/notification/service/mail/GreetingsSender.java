package ru.levchugov.notification.service.mail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import ru.levchugov.notification.model.Email;
import ru.levchugov.notification.model.EmailType;
import ru.levchugov.notification.model.MailTemplate;

@Slf4j
@Component
@AllArgsConstructor
public class GreetingsSender implements SendingStrategy {

    private final MailSender mailSender;
    private final MailTemplateService mailTemplateService;

    @Override
    public void send(Email email) {
        MailTemplate mailTemplate  = mailTemplateService.getMailTemplateByType(getType());

        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject(mailTemplate.getSubject());
        message.setText(mailTemplate.getText());
        message.setTo(email.getTo());

        mailSender.send(message);

        log.info("Greeting email message sent to {}", email.getTo());
    }

    @Override
    public EmailType getType() {
        return EmailType.GREETING_NEW_USER;
    }
}
