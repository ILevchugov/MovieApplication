CREATE TABLE IF NOT EXISTS watched_users_movie
(
    user_id INTEGER NOT NULL,
    movie_id INTEGER NOT NULL,
    CONSTRAINT user_foreign_key FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT movie_foreign_key FOREIGN KEY (movie_id) REFERENCES movies (id)
);