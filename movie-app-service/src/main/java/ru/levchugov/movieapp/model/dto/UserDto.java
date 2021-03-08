package ru.levchugov.movieapp.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private long id;

    private String name;

    private String fullName;

    private String email;

    private List<Long> moviesToWatch;

    private List<Long> moviesWatched;

    private List<VoteDto> votes;

}
