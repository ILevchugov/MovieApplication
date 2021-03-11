package ru.levchugov.subscription.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

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
    private Long subscriptionId;
    private Date subscriptionDate;

    public void subscribe(Subscription subscription) {
        this.subscriptionId = subscription.getId();
        this.subscriptionDate = new Date();
    }

}
