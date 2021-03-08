package ru.levchugov.subscription.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {

    private final Long id;
    private final String name;
    private final String fullName;
    private final String email;

}
