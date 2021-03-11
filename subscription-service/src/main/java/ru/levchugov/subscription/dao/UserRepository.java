package ru.levchugov.subscription.dao;

import org.springframework.data.repository.CrudRepository;
import ru.levchugov.subscription.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    Optional<User> findById(Long id);

    @Override
    User save(User user);

    @Override
    List<User> findAll();
}
