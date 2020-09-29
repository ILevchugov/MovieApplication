package ru.levchugov.movieapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.levchugov.movieapp.model.Vote;
import ru.levchugov.movieapp.model.dto.VoteDto;
import ru.levchugov.movieapp.repository.VoteRepository;
import ru.levchugov.movieapp.service.VoteService;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class VoteServiceImpl implements VoteService {

    private VoteRepository voteRepository;

    @Override
    public List<VoteDto> readAll() {
        List<Vote> votes = voteRepository.findAll();
        List<VoteDto> voteDtos = new ArrayList<VoteDto>();
        for (Vote vote: votes) {
            voteDtos.add(vote.toDto());
        }
        return voteDtos;
    }
}
