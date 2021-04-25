package ru.levchugov.movieapp.service.rabbit.listener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import ru.levchugov.movieapp.model.Movie;
import ru.levchugov.movieapp.model.User;
import ru.levchugov.movieapp.model.Vote;
import ru.levchugov.movieapp.model.dto.VoteDto;
import ru.levchugov.movieapp.repository.MovieRepository;
import ru.levchugov.movieapp.repository.UserRepository;
import ru.levchugov.movieapp.repository.VoteRepository;
import ru.levchugov.movieapp.service.rabbit.VoteIn;


@Slf4j
@Component
@AllArgsConstructor
@EnableBinding(VoteIn.class)
public class VoteListener {

    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @StreamListener(target = VoteIn.INPUT)
    public void receiveMessage(VoteDto voteDto) {
        log.info("Received <" + voteDto.toString() + ">");

        Vote vote = new Vote();
        User user = userRepository.findById(voteDto.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("Invalid user id")
        );
        Movie movie = movieRepository.findById(voteDto.getMovieId()).orElseThrow(
                () -> new IllegalArgumentException("Invalid movie id")
        );
        vote.setUser(user);
        vote.setMovie(movie);

        voteRepository.save(vote);
    }
}
