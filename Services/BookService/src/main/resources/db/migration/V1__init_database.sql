CREATE SEQUENCE IF NOT EXISTS book_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS revinfo_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE book
(
    id             INTEGER          NOT NULL,
    title          VARCHAR(255),
    author         VARCHAR(255),
    publisher      VARCHAR(255),
    isbn           VARCHAR(255),
    description    VARCHAR(255),
    price          DOUBLE PRECISION,
    stock          INTEGER          NOT NULL,
    category       VARCHAR(255),
    published_date TIMESTAMP(6) WITHOUT TIME ZONE,
    rating         DOUBLE PRECISION NOT NULL,
    rating_count   BIGINT           NOT NULL,
    CONSTRAINT pk_book PRIMARY KEY (id)
);

CREATE TABLE revchanges
(
    rev        BIGINT NOT NULL,
    entityname VARCHAR(255)
);

CREATE TABLE revinfo
(
    rev      BIGINT NOT NULL,
    revtstmp BIGINT,
    CONSTRAINT pk_revinfo PRIMARY KEY (rev)
);

ALTER TABLE revchanges
    ADD CONSTRAINT fk_revchanges_on_default_tracking_modified_entities_changelog FOREIGN KEY (rev) REFERENCES revinfo (rev);