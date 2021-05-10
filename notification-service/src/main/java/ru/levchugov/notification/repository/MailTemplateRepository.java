package ru.levchugov.notification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.levchugov.notification.model.EmailType;
import ru.levchugov.notification.model.MailTemplate;

public interface MailTemplateRepository extends MongoRepository<MailTemplate, String> {

    @Query("{ 'emailType' : {$regex: ?0, $options: 'i' }}")
    MailTemplate findMailTemplateByEmailType(EmailType emailType);
}
