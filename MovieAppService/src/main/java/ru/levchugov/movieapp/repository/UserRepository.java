package ru.levchugov.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levchugov.movieapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
