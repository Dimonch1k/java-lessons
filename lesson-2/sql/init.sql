DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE roles
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(100) NOT NULL
);

CREATE TABLE users
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role_id INTEGER REFERENCES roles(id)
);

INSERT INTO roles (name)
VALUES  ('ADMIN'),
        ('USER');

INSERT INTO users (name, email, role_id)
VALUES ('Dmytro', 'dmytro@gmail.com', 1),
       ('Maks', 'maks@gmail.com', 2),
       ('Bohdan', 'bohdan@gmail.com', 2),
       ('Ostap', 'ostap@gmail.com', 1),
       ('Arsen', 'arsen@gmail.com', 2),
       ('Artur', 'artur@gmail.com', 1);
