package ru.levchugov.movieapp.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.levchugov.movieapp.api.model.Rating;
import ru.levchugov.movieapp.api.model.SearchData;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "imdb", url = "https://imdb-api.com", path = "/en/API")
public interface FeignApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "SearchMovie/{key}/{movie}", consumes = APPLICATION_JSON_VALUE)
    SearchData searchMovie(
            @PathVariable(name = "key") final String key,
            @PathVariable(name = "movie") final String movie
    );

    @RequestMapping(method = RequestMethod.GET, value = "Ratings/{key}/{id}", consumes = APPLICATION_JSON_VALUE)
    Rating getRating(
            @PathVariable(name = "key") final String key,
            @PathVariable(name = "id") final String id
    );
}
