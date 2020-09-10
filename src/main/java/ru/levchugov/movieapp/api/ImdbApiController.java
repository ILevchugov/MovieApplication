package ru.levchugov.movieapp.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.levchugov.movieapp.configuration.AppProperties;
import ru.levchugov.movieapp.api.model.SearchMovieResult;

import java.util.List;

@RestController
@AllArgsConstructor
public class ImdbApiController {

    private final AppProperties appProperties;
    private final FeignApiClient feignApiClient;

    @GetMapping(value = "/movies/search")
    public List<SearchMovieResult> search(@RequestParam(name = "movie") String movie) {
        return feignApiClient.searchMovie(appProperties.getImdbApiKey(), movie).getResults();
    }

}
