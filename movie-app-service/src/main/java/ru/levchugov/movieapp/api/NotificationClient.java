package ru.levchugov.movieapp.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import ru.levchugov.movieapp.api.model.Email;

@FeignClient(name = "notification", url = "http://localhost:8070")
public interface NotificationClient {

    @PostMapping(value = "/email")
    void sendEmail(Email email);

}
