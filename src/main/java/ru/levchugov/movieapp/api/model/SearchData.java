package ru.levchugov.movieapp.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchData {

    private String searchType;

    private String expression;

    private List<SearchMovieResult> results;

}
