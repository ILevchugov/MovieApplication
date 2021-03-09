package ru.levchugov.subscription.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levchugov.subscription.dao.SubscriptionDao;
import ru.levchugov.subscription.domain.Subscription;

import java.util.List;

@Service
@AllArgsConstructor
public class SubscriptionService {

    private final SubscriptionDao subscriptionDao;

    public List<Subscription> getAll() {
        return subscriptionDao.findAll();
    }

}
