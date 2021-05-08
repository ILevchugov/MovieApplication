package ru.levchugov.notification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Builder
@Getter
@Table(value = "users")
public class User {

    @Id
    private final Long id;
    private final String name;
    private final String fullName;
    private final String email;
    private final String subscriptionState;

}