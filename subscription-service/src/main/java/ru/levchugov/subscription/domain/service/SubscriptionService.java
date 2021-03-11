package ru.levchugov.subscription.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levchugov.subscription.dao.SubscriptionDao;
import ru.levchugov.subscription.dao.UserRepository;
import ru.levchugov.subscription.domain.Subscription;
import ru.levchugov.subscription.domain.User;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubscriptionService {

    private final SubscriptionDao subscriptionDao;
    private final UserRepository userRepository;

    public List<Subscription> getAll() {
        return subscriptionDao.findAll();
    }

    public void subscribe(long userId, long subscriptionId) {
        Optional<Subscription> subscription = subscriptionDao.findById(subscriptionId);
        if (subscription.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException();
        }

        User user = userOptional.get();
        user.subscribe(subscription.get());

        userRepository.save(user);
    }

}
