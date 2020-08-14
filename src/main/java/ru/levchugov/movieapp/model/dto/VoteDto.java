package ru.levchugov.movieapp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VoteDto {

    @JsonProperty("user")
    private long userId;
    @JsonProperty("movie")
    private long movieId;
    @JsonProperty("value")
    private int value;

}
