package ru.levchugov.subscription.dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import ru.levchugov.subscription.domain.User;

import java.util.Set;


@Repository
@AllArgsConstructor
public class UserDao {

    private final JdbcOperations jdbc;

    public void create(User user) {
        String createQuery = "insert into users (id, name, full_name, email) values (?, ?, ?, ?)";

        jdbc.update(
                createQuery,
                user.getId(),
                user.getName(),
                user.getFullName(),
                user.getEmail()
        );
    }
}

