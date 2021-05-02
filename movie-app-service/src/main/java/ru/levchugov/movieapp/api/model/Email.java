package ru.levchugov.movieapp.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Email {

    private String to;
    private String text;

}
