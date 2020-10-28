CREATE TABLE IF NOT EXISTS votes
(
    id    INTEGER PRIMARY KEY,
    vote_value  INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    movie_id INTEGER NOT NULL,
    CONSTRAINT user_foreign_key FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT movie_foreign_key FOREIGN KEY (movie_id) REFERENCES movies (id)
);

INSERT INTO votes (id, vote_value, user_id, movie_id)
VALUES(1, 1, 1, 1);

CREATE SEQUENCE IF NOT EXISTS votes_id_seq START WITH 2 INCREMENT BY 1;

