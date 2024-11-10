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
