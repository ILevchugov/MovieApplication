package ru.levchugov.movieapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.levchugov.movieapp.model.dto.VoteDto;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "votes")
public class Vote implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "votesIdSeq", sequenceName = "votes_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "votesIdSeq")
    private long id;

    @Column(name = "vote_value")
    private int value;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public VoteDto toDto() {
        VoteDto voteDto = new VoteDto();

        voteDto.setUserId(user.getId());
        voteDto.setMovieId(movie.getId());
        voteDto.setValue(value);

        return voteDto;
    }
}
