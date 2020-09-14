package ru.levchugov.movieapp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.levchugov.movieapp.model.dto.VoteDto;
import ru.levchugov.movieapp.service.VoteService;


import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @GetMapping(value = "votes")
    public ResponseEntity<List<VoteDto>> getVotes() {
        List<VoteDto> votes = voteService.readAll();

        return !votes.isEmpty()
                ? new ResponseEntity<>(votes, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
