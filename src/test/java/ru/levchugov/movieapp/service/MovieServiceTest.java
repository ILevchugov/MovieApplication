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
    private MovieService movieService;

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
        when(movieJdbcRepository.findAll()).thenReturn(
                List.of(Movie.builder()
                        .director("director")
                        .id(1L)
                        .title("title")
                        .year("2020")
                        .build())
        );

        List<MovieDto> movies = movieService.findAll();

        assertEquals(1L, movies.get(0).getId());
        assertEquals( "director", movies.get(0).getDirector());
        assertEquals("title", movies.get(0).getTitle());
        assertEquals("2020", movies.get(0).getYear());
    }

    @Test
    void test_find_by_id() {
        when(movieJdbcRepository.findById(any())).thenReturn(
                Movie.builder()
                        .director("director")
                        .id(1L)
                        .title("title")
                        .year("2020")
                        .build()
        );

        MovieDto movie = movieService.findById(1L);

        assertEquals(1L, movie.getId());
        assertEquals("title", movie.getTitle());
        assertEquals("director", movie.getDirector());
        assertEquals("2020", movie.getDirector());
    }
}