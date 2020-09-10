package ru.levchugov.movieapp.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rating {

    private String imDbId;

    private String title;

    private String fullTitle;

    private String type;

    private String year;

    private String imDb;

    private String metacritic;

    private String theMovieDb;

    private String rottenTomatoes;

    private String tV_com;

    private String filmAffinity;
}
