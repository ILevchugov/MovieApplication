package ru.levchugov.subscription.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Getter
@Table(value = "subscriptions")
public class Subscription {

    @Id
    private Long id;
    private String name;
    private Integer price;
    private Integer period;

}
