package ru.levchugov.movieapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.api.FeignApiClient;
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
    private final FeignApiClient feignApiClient;

    public Rating getMovieRating(MovieDto movieDto) {
        SearchData searchData = feignApiClient.searchMovie(appProperties.getImdbApiKey(), movieDto.getTitle());
        List<SearchMovieResult> results = searchData.getResults();
        return feignApiClient.getRating(appProperties.getImdbApiKey(), results.get(0).getId());
    }
}
