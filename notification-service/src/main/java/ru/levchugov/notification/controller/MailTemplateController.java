package ru.levchugov.notification.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.levchugov.notification.model.MailTemplate;
import ru.levchugov.notification.repository.MailTemplateRepository;

@Slf4j
@RestController
@AllArgsConstructor
public class MailTemplateController {

    private final MailTemplateRepository mailTemplateRepository;

    @PostMapping("mail/templates")
    public ResponseEntity<?> addTemplate(@RequestBody MailTemplate mailTemplate) {
        log.info("template for saving: {}", mailTemplate);
        mailTemplateRepository.save(mailTemplate);

        return ResponseEntity.ok().build();
    }

    @GetMapping("mail/templates")
    public ResponseEntity<?> getTemplates() {
        return ResponseEntity.ok(mailTemplateRepository.findAll());
    }

}
