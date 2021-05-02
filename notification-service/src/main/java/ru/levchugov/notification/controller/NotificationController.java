package ru.levchugov.notification.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.levchugov.notification.service.NotificationService;

@RestController
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("email")
    public ResponseEntity<?> sendEmail(@RequestBody Email email) {
        notificationService.sendEmail(email.getTo(), email.getText());

        return ResponseEntity.ok().build();
    }
}
