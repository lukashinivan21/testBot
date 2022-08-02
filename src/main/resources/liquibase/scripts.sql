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

-- changeSet ivan:2

CREATE TABLE dog_owner
(
    id_candidate       bigint PRIMARY KEY,
    name_candidate     TEXT,
    username_candidate TEXT,
    phone_number       TEXT UNIQUE,
    bot_state          TEXT
);

CREATE TABLE cat_owner
(
    id_candidate       bigint PRIMARY KEY,
    name_candidate     TEXT,
    username_candidate TEXT,
    phone_number       TEXT UNIQUE,
    bot_state          TEXT
);

DROP TABLE candidates;