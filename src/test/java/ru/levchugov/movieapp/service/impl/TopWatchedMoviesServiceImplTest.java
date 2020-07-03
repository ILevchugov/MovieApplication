package ru.levchugov.movieapp.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.model.User;
import ru.levchugov.movieapp.repository.MovieRepository;
import ru.levchugov.movieapp.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class TopWatchedMoviesServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    MovieRepository movieRepository;

    List<User> users = new ArrayList<>();
    List<Movie> unsortedMovies = new ArrayList<>();
    List<Movie> sortedMovies = new ArrayList<>();

    @InjectMocks
    private TopWatchedMoviesServiceImpl topWatchedMoviesService;

    @BeforeEach
    void init_test_data() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        Movie movie3 = new Movie();

        movie1.setTitle("Test_movie1");
        movie2.setTitle("Test_movie2");
        movie3.setTitle("Test_movie3");

        unsortedMovies.add(movie1);
        unsortedMovies.add(movie2);
        unsortedMovies.add(movie3);

        sortedMovies.add(movie2);
        sortedMovies.add(movie3);
        sortedMovies.add(movie1);

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        user1.setName("user1");
        user2.setName("user2");
        user3.setName("user3");

        user1.setMoviesWatched(new HashSet<>());
        user2.setMoviesWatched(new HashSet<>());
        user3.setMoviesWatched(new HashSet<>());

        user1.getMoviesWatched().add(movie2);

        user2.getMoviesWatched().add(movie2);
        user2.getMoviesWatched().add(movie3);

        user3.getMoviesWatched().add(movie2);
        user3.getMoviesWatched().add(movie3);
        user3.getMoviesWatched().add(movie1);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        when(userRepository.findAll()).thenReturn(users);
        when(movieRepository.findAll()).thenReturn(unsortedMovies);
    }

    @Test
    public void test_mocks() {
        assertEquals(users, userRepository.findAll());
        assertEquals(unsortedMovies, movieRepository.findAll());
    }

    @Test
    public void test_getTopWatchedMovies() {

        List<Movie> topWatchedMovies = topWatchedMoviesService.getTopWatchedMovies();

        assertEquals(sortedMovies, topWatchedMovies);
    }
}