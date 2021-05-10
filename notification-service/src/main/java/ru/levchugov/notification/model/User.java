package ru.levchugov.notification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@AllArgsConstructor
@Document(collection = "users")
public class User {

    private final String name;

    private final String fullName;

    private final String email;

}