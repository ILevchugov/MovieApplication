package ru.levchugov.movieapp.model;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    private long id;

    private String name;

    private String fullName;

    private String email;

    private Set<MovieDto> moviesToWatch;

    private Set<MovieDto> moviesWatched;
}
