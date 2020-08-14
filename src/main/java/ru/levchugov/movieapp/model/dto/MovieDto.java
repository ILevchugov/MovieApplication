package ru.levchugov.movieapp.model.dto;

import lombok.Data;

@Data
public class MovieDto {

    private long id;

    private String title;

    private String year;

    private String director;

}
