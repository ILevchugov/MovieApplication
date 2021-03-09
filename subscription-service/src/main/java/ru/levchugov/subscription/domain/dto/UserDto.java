package ru.levchugov.subscription.domain.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class UserDto {

    private final Long id;
    private final String name;
    private final String fullName;
    private final String email;

}
