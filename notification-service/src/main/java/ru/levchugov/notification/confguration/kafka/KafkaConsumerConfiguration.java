package ru.levchugov.notification.confguration.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.levchugov.notification.model.MailTemplate;
import ru.levchugov.notification.model.User;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfiguration {

    @Value("${kafka.server}")
    private String bootstrapServersConfig;

    @Bean
    public ConsumerFactory<String, MailTemplate> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServersConfig
        );
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                "mails"
        );
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class
        );
        props.put(
                JsonDeserializer.TRUSTED_PACKAGES,
                "ru.levchugov.notification.model"
        );
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class
        );
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConsumerFactory<String, User> consumerUserFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServersConfig
        );
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                "users"
        );
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class
        );
        props.put(
                JsonDeserializer.USE_TYPE_INFO_HEADERS,
                false
        );
        props.put(
                JsonDeserializer.TYPE_MAPPINGS,
                "user:ru.levchugov.notification.model.User"
        );
        props.put(
                JsonDeserializer.TRUSTED_PACKAGES,
                "ru.levchugov.movieapp.model.dto"
        );
        props.put(
                JsonDeserializer.VALUE_DEFAULT_TYPE,
                User.class
        );
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class
        );
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, User> kafkaUserListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, User> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerUserFactory());
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MailTemplate> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MailTemplate> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
