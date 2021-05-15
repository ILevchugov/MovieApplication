package ru.levchugov.notification.service.mail;


import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.levchugov.notification.model.EmailType;
import ru.levchugov.notification.model.MailTemplate;
import ru.levchugov.notification.repository.MailTemplateRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MailTemplateService {

    private final MailTemplateRepository mailTemplateRepository;

    @Cacheable("mailTemplates")
    public MailTemplate getMailTemplateByType(EmailType emailType) {
        return mailTemplateRepository.findMailTemplateByEmailType(emailType);
    }

    public void create(MailTemplate mailTemplate) {
        mailTemplateRepository.save(mailTemplate);
    }

    public List<MailTemplate> getAll() {

        return mailTemplateRepository.findAll();
    }
}
