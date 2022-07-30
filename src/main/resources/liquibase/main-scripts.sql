-- liquibase formatted sql

-- changeSet ilukashin:1

CREATE TABLE candidates
(
    id_candidate bigint PRIMARY KEY,
    name_candidate TEXT NOT NULL,
    username_candidate TEXT,
    phone_number TEXT UNIQUE
);

CREATE TABLE dogs
(
    id_dog bigserial unique not null,
    name_dog text not null,
    age real
)