--liquibase formatted sql

--changeset i.shcherbachenya:2024-10-09--initial-schema-00
--comment Create inventory table
--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:0 SELECT count(*) FROM information_schema.tables WHERE table_catalog = 'ecommerce_inventory' AND table_schema = 'public' AND table_name='inventory';
CREATE TABLE inventory
(
    id            VARCHAR(36) NOT NULL UNIQUE,
    item_id       VARCHAR(36) NOT NULL,
    count         INTEGER     NOT NULL,
    creation_date TIMESTAMP   NOT NULL,
    update_date   TIMESTAMP,
    PRIMARY KEY (id)
);
