package ru.levchugov.movieapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
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

}
