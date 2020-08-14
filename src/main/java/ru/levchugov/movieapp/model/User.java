package ru.levchugov.movieapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.levchugov.movieapp.model.dto.UserDto;
import ru.levchugov.movieapp.model.dto.VoteDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "usersIdSeq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersIdSeq")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(name = "users_movies_to_watch",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id")
    )
    private Set<Movie> moviesToWatch;

    @ManyToMany
    @JoinTable(name = "watched_users_movie",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id")
    )
    private Set<Movie> moviesWatched;

    @OneToMany(mappedBy = "user")
    private Set<Vote> votes;


    public UserDto toDto() {
        UserDto userDto = new UserDto();

        userDto.setName(name);
        userDto.setFullName(fullName);
        userDto.setId(id);
        userDto.setEmail(email);
        userDto.setMoviesToWatch(getMoviesIds(moviesToWatch));
        userDto.setMoviesWatched(getMoviesIds(moviesWatched));
        userDto.setVotes(getVotesDto(votes));

        return userDto;
    }

    public static User fromDto(UserDto userDto) {
        User user = new User();

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());

        return user;
    }

    private List<Long> getMoviesIds(Set<Movie> movies) {

        List<Long> ids = new ArrayList<>();
        for (Movie movie: movies ) {
            ids.add(movie.getId());
        }
        return ids;
    }

    private List<VoteDto> getVotesDto(Set<Vote> votes) {

        List<VoteDto> voteDtos = new ArrayList<>();
        for (Vote vote: votes ) {
            voteDtos.add(vote.toDto());
        }
        return voteDtos;
    }

}
