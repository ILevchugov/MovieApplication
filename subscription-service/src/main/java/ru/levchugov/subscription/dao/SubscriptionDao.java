package ru.levchugov.subscription.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.levchugov.subscription.domain.Subscription;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionDao extends CrudRepository<Subscription, Long> {

    @Override
    List<Subscription> findAll();

    @Override
    Optional<Subscription> findById(Long id);

}
