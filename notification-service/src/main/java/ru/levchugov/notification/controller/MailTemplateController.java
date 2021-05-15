package ru.levchugov.notification.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.levchugov.notification.model.MailTemplate;
import ru.levchugov.notification.service.mail.MailTemplateService;

@Slf4j
@RestController
@AllArgsConstructor
public class MailTemplateController {

    private final MailTemplateService mailTemplateService;

    @PostMapping("mail/templates")
    public ResponseEntity<?> addTemplate(@RequestBody MailTemplate mailTemplate) {
        log.info("template for saving: {}", mailTemplate);
        mailTemplateService.create(mailTemplate);

        return ResponseEntity.ok().build();
    }

    @GetMapping("mail/templates")
    public ResponseEntity<?> getTemplates() {
        return ResponseEntity.ok(mailTemplateService.getAll());
    }

}
