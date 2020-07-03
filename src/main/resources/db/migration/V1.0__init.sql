
CREATE TABLE IF NOT EXISTS users
(
    id INTEGER PRIMARY KEY,
    name varchar(200),
    full_name varchar(200),
    email varchar(200)
);


CREATE SEQUENCE IF NOT EXISTS users_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS movies_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS movies
(
    id    INTEGER PRIMARY KEY,
    title  VARCHAR(200) NOT NULL,
    year VARCHAR(254) NOT NULL,
    director varchar(260) NOT NULL
);

CREATE TABLE IF NOT EXISTS users_movies_to_watch
(
    user_id INTEGER NOT NULL,
    movie_id INTEGER NOT NULL,
    CONSTRAINT user_foreign_key FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT movie_foreign_key FOREIGN KEY (movie_id) REFERENCES movies (id)
);

