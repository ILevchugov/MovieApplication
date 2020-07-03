package ru.levchugov.movieapp.model;

import lombok.Data;

@Data
public class MovieDto {

    private long id;

    private String title;

    private String year;

    private String director;
}
