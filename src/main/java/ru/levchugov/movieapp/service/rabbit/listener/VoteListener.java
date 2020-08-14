package ru.levchugov.movieapp.service.rabbit.listener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
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

    private VoteRepository voteRepository;
    private UserRepository userRepository;
    private MovieRepository movieRepository;

    @StreamListener(target = VoteIn.INPUT)
    public void receiveMessage(VoteDto voteDto) {
        log.info("Received <" + voteDto.toString() + ">");

        Vote vote = new Vote();
        vote.setUser(userRepository.findById(voteDto.getUserId()).get());
        vote.setMovie(movieRepository.findById(voteDto.getMovieId()).get());
        vote.setValue(voteDto.getValue());


        voteRepository.save(vote);
    }
}
