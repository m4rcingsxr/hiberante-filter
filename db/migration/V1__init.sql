CREATE SEQUENCE public.users_seq INCREMENT 1 START WITH 1 MINVALUE 1;

CREATE TABLE users
(
    id         BIGINT  NOT NULL,
    name   VARCHAR NOT NULL,
    lastname   VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

CREATE SEQUENCE public.address_seq INCREMENT 1 START WITH 1 MINVALUE 1;

CREATE TABLE address
(
    id         BIGINT  NOT NULL,
    street    VARCHAR NOT NULL,
    PRIMARY KEY (id)
);

