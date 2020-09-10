package ru.levchugov.movieapp.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.model.dto.MovieDto;
import ru.levchugov.movieapp.repository.MovieRepository;
import ru.levchugov.movieapp.service.MovieService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public void add(MovieDto movieDto) {
        Movie movie = modelMapper.map(movieDto, Movie.class);
        movieRepository.save(movie);
    }

    @Override
    public List<MovieDto> findAll() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieDto> moviesDtos = new ArrayList<>();

        for (Movie movie : movies) {
            moviesDtos.add(modelMapper.map(movie, MovieDto.class));
        }

        return moviesDtos;
    }

    @Override
    public MovieDto findById(long id) {

        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            return modelMapper.map(movieOptional.get(), MovieDto.class);
        } else {
            throw new IllegalArgumentException("No movie with this id");
        }
    }

}
