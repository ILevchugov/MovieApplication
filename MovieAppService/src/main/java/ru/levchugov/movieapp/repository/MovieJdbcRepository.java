package ru.levchugov.movieapp.repository;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.levchugov.movieapp.model.Movie;

import java.util.List;

@Repository
@AllArgsConstructor
public class MovieJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

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

    public Movie findById(long id) {
        String findByIdQuery = "select * from movies where id = ?";

        return jdbcTemplate.queryForObject(findByIdQuery,
                new Object[]{id},
                (rs, rowNum) ->
                        Movie.builder()
                                .id(rs.getLong("id"))
                                .title(rs.getString("title"))
                                .director(rs.getString("director"))
                                .year(rs.getString("year"))
                                .build()
        );
    }

    public Movie findByTitle(String title) {
        String findByTitleQuery = "select * from movies where title = ?";
        try {
            return jdbcTemplate.queryForObject(findByTitleQuery, new Object[]{title},
                    (rs, rowNum) ->
                            Movie.builder()
                                    .id(rs.getLong("id"))
                                    .title(rs.getString("title"))
                                    .director(rs.getString("director"))
                                    .year(rs.getString("year"))
                                    .build()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
