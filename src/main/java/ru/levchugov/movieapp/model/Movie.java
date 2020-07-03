package ru.levchugov.movieapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "moviesIdSeq", sequenceName = "movies_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moviesIdSeq")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private String year;

    @Column(name = "director")
    private String director;

}
