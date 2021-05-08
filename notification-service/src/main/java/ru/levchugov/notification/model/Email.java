package ru.levchugov.notification.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Email {

    String to;
    String text;
    String subject;
    String userName;

}
