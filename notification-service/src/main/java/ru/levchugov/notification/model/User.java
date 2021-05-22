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

    private String name;

    private String fullName;

    private String email;

    //TODO: make class immutable, add @JsonCreator
    public User() {
        this.name = null;
        this.fullName = null;
        this.email = null;
    }

}