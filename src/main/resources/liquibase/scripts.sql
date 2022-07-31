-- liquibase formatted sql

-- changeSet ivan:1

CREATE TABLE candidates
(
    id_candidate       bigint PRIMARY KEY,
    name_candidate     TEXT,
    username_candidate TEXT,
    phone_number       TEXT UNIQUE,
    bot_state          TEXT
);

CREATE TABLE dogs
(
    id_dog   bigserial PRIMARY KEY,
    name_dog text not null,
    age      real
);