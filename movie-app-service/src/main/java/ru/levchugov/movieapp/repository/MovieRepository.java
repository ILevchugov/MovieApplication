package ru.levchugov.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levchugov.movieapp.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
