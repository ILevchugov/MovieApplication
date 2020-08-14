package ru.levchugov.movieapp.service.rabbit.sender;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.levchugov.movieapp.model.dto.VoteDto;
import ru.levchugov.movieapp.service.rabbit.VoteOut;

@Slf4j
@Service
@AllArgsConstructor
@EnableBinding(VoteOut.class)
public class VoteSender {

    private VoteOut voteOut;

    public void send(long userId, long movieId, int value) {
        VoteDto vote = new VoteDto();
        vote.setUserId(userId);
        vote.setMovieId(movieId);
        vote.setValue(value);

        voteOut.output().send(MessageBuilder.withPayload(vote).build());
        log.info("Сообщение ушло {}", vote);

    }
}
