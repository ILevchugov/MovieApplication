package ru.levchugov.notification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.levchugov.notification.model.User;

public interface UserMongoRepository extends MongoRepository<User, String> {
}
