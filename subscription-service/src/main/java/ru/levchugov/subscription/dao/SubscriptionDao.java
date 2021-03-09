package ru.levchugov.subscription.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.levchugov.subscription.domain.Subscription;

import java.util.List;

@Repository
public interface SubscriptionDao extends CrudRepository<Subscription, Long> {

    @Override
    List<Subscription> findAll();

}
