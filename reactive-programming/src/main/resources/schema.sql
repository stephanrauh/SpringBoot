-- CREATE DATABASE reactive;

CREATE TABLE IF NOT EXISTS employee
(
    id SERIAL PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL
);