package ru.levchugov.movieapp.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.levchugov.movieapp.api.model.SearchMovieResult;
import ru.levchugov.movieapp.service.impl.ImdbService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ImdbApiController {

    private final ImdbService imdbService;

    @GetMapping(value = "/movies/search")
    public List<SearchMovieResult> search(@RequestParam(name = "movie") String movie) {
        return imdbService.search(movie);
    }

}
