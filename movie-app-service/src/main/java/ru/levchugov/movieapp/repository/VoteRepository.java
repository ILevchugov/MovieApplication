package ru.levchugov.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levchugov.movieapp.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
