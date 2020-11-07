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

import java.util.Optional;


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
        Optional<User> user = userRepository.findById(voteDto.getUserId());
        Optional<Movie> movie = movieRepository.findById(voteDto.getMovieId());
        if (user.isPresent() && movie.isPresent()) {
            vote.setUser(user.get());
            vote.setMovie(movie.get());
        } else {
            //todo: приудмать свои ексепшены
            throw new IllegalArgumentException("Received vote with wrong movie or user");
        }
        voteRepository.save(vote);
    }
}
