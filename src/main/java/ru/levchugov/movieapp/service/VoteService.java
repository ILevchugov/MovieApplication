package ru.levchugov.movieapp.service;

import ru.levchugov.movieapp.model.dto.VoteDto;

import java.util.List;

public interface VoteService {
    List<VoteDto> readAll();
}
