package ru.levchugov.movieapp.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.levchugov.movieapp.model.Movie;

import java.util.List;

@Component
@AllArgsConstructor
public class MovieJdbcRepository {

    private JdbcTemplate jdbcTemplate;

    public void save(Movie movie) {
        String saveQuery = "insert into movies (id, title, year, director) values (nextval('movies_id_seq'), ?, ?, ?)";

        jdbcTemplate.update(
                saveQuery,
                movie.getTitle(),
                movie.getYear(),
                movie.getDirector()
        );

    }

    public List<Movie> findAll() {
        String findAllQuery = "select * from movies";

        return jdbcTemplate.query(
                findAllQuery,
                (rs, rowNum) ->
                        Movie.builder()
                                .id(rs.getLong("id"))
                                .title(rs.getString("title"))
                                .director(rs.getString("director"))
                                .year(rs.getString("year"))
                                .build()
        );
    }
}
