package ru.levchugov.movieapp.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.api.ImdbApiClient;
import ru.levchugov.movieapp.api.model.Rating;
import ru.levchugov.movieapp.api.model.SearchData;
import ru.levchugov.movieapp.api.model.SearchMovieResult;
import ru.levchugov.movieapp.configuration.AppProperties;
import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.model.dto.MovieDto;
import ru.levchugov.movieapp.repository.MovieJdbcRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ImdbService {

    private final MovieJdbcRepository movieJdbcRepository;
    private final AppProperties appProperties;
    private final ImdbApiClient imdbApiClient;

    public Rating getMovieRating(MovieDto movieDto) {
        SearchData searchData = imdbApiClient.searchMovie(appProperties.getImdbApiKey(), movieDto.getTitle());
        List<SearchMovieResult> results = searchData.getResults();
        return imdbApiClient.getRating(appProperties.getImdbApiKey(), results.get(0).getId());
    }

    public List<SearchMovieResult> search(String title) {

        Movie movie = movieJdbcRepository.findByTitle(title);

        List<SearchMovieResult> movieResultList
                = imdbApiClient.searchMovie(appProperties.getImdbApiKey(), title).getResults();

        if (movie == null) {
            log.info("Здесь должны добавлять новый фильм в базу");
        }

        return movieResultList;
    }
}
