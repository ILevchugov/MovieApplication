package ru.levchugov.movieapp.service;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.model.dto.MovieDto;
import ru.levchugov.movieapp.repository.MovieJdbcRepository;
import ru.levchugov.movieapp.service.impl.MovieServiceImpl;

import java.util.List;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {MovieServiceImpl.class})
class MovieServiceTest {

    @Autowired
    MovieService movieService;

    @MockBean
    private MovieJdbcRepository movieJdbcRepository;

    @Test
    void test_add() {
        ModelMapper modelMapper = new ModelMapper();
        MovieDto movieDto = new MovieDto();
        movieDto.setId(1L);
        movieDto.setTitle("movie");
        movieDto.setDirector("director");
        movieDto.setYear("2020");

        movieService.add(movieDto);

        doNothing().when(movieJdbcRepository).save(any());

        verify(movieJdbcRepository).save(modelMapper.map(movieDto, Movie.class));
    }

    @Test
    void test_find_all() {
        when(movieJdbcRepository.findAll()).thenReturn(List.of(Movie.builder()
                .director("director")
                .id(1L)
                .title("title")
                .year("2020")
                .build()));

        List<MovieDto> movies = movieService.findAll();

        //some shit
        assertEquals(movies.get(0).getDirector(), "director");
        assertEquals(movies.get(0).getId(), 1L);
        assertEquals(movies.get(0).getTitle(), "title");
        assertEquals(movies.get(0).getYear(), "2020");
    }
}