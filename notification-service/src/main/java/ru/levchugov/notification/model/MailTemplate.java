package ru.levchugov.notification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@ToString
@AllArgsConstructor
@Document(collection = "mail_templates")
public class MailTemplate {

    private final String text;

    private final String subject;

    private final EmailType emailType;

}
