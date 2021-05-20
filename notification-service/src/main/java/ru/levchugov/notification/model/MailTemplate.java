package ru.levchugov.notification.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "mail_templates")
public class MailTemplate {

    private final String text;

    private final String subject;

    private final EmailType emailType;

    //TODO: make class immutable, add @JsonCreator
    public MailTemplate() {
        this.text = null;
        this.subject = null;
        this.emailType = null;
    }

}
