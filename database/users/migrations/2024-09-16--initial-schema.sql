--liquibase formatted sql

--changeset i.shcherbachenya:2024-10-09--initial-schema-00
--comment Create users table
--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:0 SELECT count(*) FROM information_schema.tables WHERE table_catalog = 'ecommerce_users' AND table_schema = 'public' AND table_name='users';
CREATE TABLE users
(
    id               VARCHAR(36)  NOT NULL UNIQUE,
    email            VARCHAR(255) NOT NULL UNIQUE,
    password         VARCHAR(255) NOT NULL,
    full_name        VARCHAR(255) NOT NULL,
    avatar_file_name VARCHAR(255),
    email_confirmed  boolean      NOT NULL,
    creation_date    TIMESTAMP    NOT NULL,
    update_date      TIMESTAMP,
    PRIMARY KEY (id)
);
