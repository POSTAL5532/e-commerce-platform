--liquibase formatted sql

--changeset i.shcherbachenya:2024-10-09--initial-schema-00
--comment Create items table
--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:0 SELECT count(*) FROM information_schema.tables WHERE table_catalog = 'ecommerce_catalog' AND table_schema = 'public' AND table_name='items';
CREATE TABLE items
(
    id            VARCHAR(36)      NOT NULL UNIQUE,
    name          VARCHAR(255)     NOT NULL,
    description   TEXT             NOT NULL,
    price         DOUBLE PRECISION NOT NULL,
    type          VARCHAR(255)     NOT NULL,
    creation_date TIMESTAMP        NOT NULL,
    update_date   TIMESTAMP,
    PRIMARY KEY (id)
);
