package ru.levchugov.movieapp.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchMovieResult {

    private String id;

    private String resultType;

    private String image;

    private String title;

    private String description;

}
