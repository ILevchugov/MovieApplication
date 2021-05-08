CREATE TABLE IF NOT EXISTS users
(
    id                     INTEGER PRIMARY KEY,
    name                   varchar(200) NOT NULL,
    full_name              varchar(200) NOT NULL,
    email                  varchar(200) NOT NULL,
    subscription_state     varchar(200) NOT NULL
);



INSERT INTO users (id, name, full_name, email, subscription_state)
VALUES (1, 'Ivan', 'Ivanov', 'lev4ugov@ya.ru', 'notsub')