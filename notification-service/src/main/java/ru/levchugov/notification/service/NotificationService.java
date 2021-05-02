package ru.levchugov.notification.service;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class NotificationService {

   private final MailSender mailSender;

    public void sendEmail(String emailTo, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject("Greeting");
        message.setText(text);
        message.setTo(emailTo);

        mailSender.send(message);

        log.info("Email message sent to {}", emailTo);
    }
}
