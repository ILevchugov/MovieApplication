package ru.levchugov.movieapp.model.dto;

import lombok.Data;
import ru.levchugov.movieapp.model.Vote;
import ru.levchugov.movieapp.model.dto.MovieDto;

import java.util.List;
import java.util.Set;

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
