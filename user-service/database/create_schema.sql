CREATE TABLE users
(
    id               BIGSERIAL    NOT NULL UNIQUE,
    email            VARCHAR(255) NOT NULL UNIQUE,
    password         VARCHAR(255) NOT NULL,
    full_name        VARCHAR(255) NOT NULL,
    avatar_file_name VARCHAR(255),
    email_confirmed  boolean      NOT NULL,
    creation_date    TIMESTAMP    NOT NULL,
    update_date      TIMESTAMP,
    PRIMARY KEY (id)
);
