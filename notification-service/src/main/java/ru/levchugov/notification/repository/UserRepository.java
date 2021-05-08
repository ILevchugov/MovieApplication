package ru.levchugov.notification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.levchugov.notification.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
