package ru.levchugov.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
