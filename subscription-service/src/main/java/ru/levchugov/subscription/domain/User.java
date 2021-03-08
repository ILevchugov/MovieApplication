package ru.levchugov.subscription.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Builder
@Getter
public class User {

    private final Long id;
    private final String name;
    private final String fullName;
    private final String email;
    private Long subscriptionId;
    private final Date subscriptionDate;

}
