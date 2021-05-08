package ru.levchugov.notification.service.mail;

import ru.levchugov.notification.model.Email;
import ru.levchugov.notification.model.EmailType;

public interface SendingStrategy {

    void send(Email email);

    EmailType getType();

}
