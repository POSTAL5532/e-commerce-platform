--liquibase formatted sql

--changeset i.shcherbachenya:2024-10-09--initial-schema-00
--comment Create orders table
--preconditions onFail:HALT onError:HALT
--precondition-sql-check expectedResult:0 SELECT count(*) FROM information_schema.tables WHERE table_catalog = 'ecommerce_users' AND table_schema = 'public' AND table_name='orders';
CREATE TABLE orders
(
    id            BIGSERIAL        NOT NULL UNIQUE,
    user_id       BIGINT           NOT NULL,
    item_id       BIGINT           NOT NULL,
    currency      VARCHAR(4)       NOT NULL,
    amount        DOUBLE PRECISION NOT NULL,
    creation_date TIMESTAMP        NOT NULL,
    update_date   TIMESTAMP,
    PRIMARY KEY (id)
);
