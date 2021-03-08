package ru.levchugov.movieapp.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    @NotNull
    private String imdbApiKey;

}
