CREATE TABLE items
(
    id            BIGSERIAL NOT NULL UNIQUE,
    name          VARCHAR(255)     NOT NULL,
    description   TEXT             NOT NULL,
    price         DOUBLE PRECISION NOT NULL,
    type          VARCHAR(255)     NOT NULL,
    creation_date TIMESTAMP        NOT NULL,
    update_date   TIMESTAMP,
    PRIMARY KEY (id)
);
