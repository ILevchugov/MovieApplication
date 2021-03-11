CREATE TABLE IF NOT EXISTS users
(
    id                INTEGER PRIMARY KEY,
    name              varchar(200) NOT NULL,
    full_name         varchar(200) NOT NULL,
    email             varchar(200) NOT NULL,
    subscription_id   INTEGER,
    subscription_date DATE
);

CREATE TABLE IF NOT EXISTS subscriptions
(
    id     INTEGER PRIMARY KEY,
    name   VARCHAR NOT NULL,
    price  INTEGER NOT NULL,
    period INTEGER NOT NULL
);


INSERT INTO users (id, name, full_name, email)
VALUES (1, 'Ivan', 'Ivanov', 'ivanov@mail.ru')