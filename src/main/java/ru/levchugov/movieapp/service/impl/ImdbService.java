package ru.levchugov.movieapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.api.ImdbApiClient;
import ru.levchugov.movieapp.api.model.Rating;
import ru.levchugov.movieapp.api.model.SearchData;
import ru.levchugov.movieapp.api.model.SearchMovieResult;
import ru.levchugov.movieapp.configuration.AppProperties;
import ru.levchugov.movieapp.model.dto.MovieDto;

import java.util.List;

@Service
@AllArgsConstructor
public class ImdbService {

    private final AppProperties appProperties;
    private final ImdbApiClient imdbApiClient;

    public Rating getMovieRating(MovieDto movieDto) {
        SearchData searchData = imdbApiClient.searchMovie(appProperties.getImdbApiKey(), movieDto.getTitle());
        List<SearchMovieResult> results = searchData.getResults();
        return imdbApiClient.getRating(appProperties.getImdbApiKey(), results.get(0).getId());
    }
}
