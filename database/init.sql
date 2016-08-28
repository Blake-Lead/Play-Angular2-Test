----------
-- WIKI --
----------

-- create wiki database
CREATE DATABASE wiki OWNER afpauser;

-- use wiki database
\c wiki

-- create table category
CREATE TABLE category (
    id              serial      PRIMARY KEY,
    tag             varchar(40) NOT NULL,
    description     varchar(99) NULL
);

-- create table article
CREATE TABLE article (
    id              serial      PRIMARY KEY,
    title           varchar(40) NOT NULL,
    author          varchar(40) NOT NULL,
    body            text        NOT NULL,
    category_id     integer     REFERENCES category
);

-- grant privileges
GRANT ALL PRIVILEGES ON TABLE category TO afpauser;
GRANT ALL PRIVILEGES ON TABLE article TO afpauser;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public to afpauser;
GRANT ALL PRIVILEGES ON SCHEMA public TO afpauser;

------------
-- IPBASE --
------------

-- create wiki database
CREATE DATABASE ipbase OWNER afpauser;

-- use ipbase database
\c ipbase

-- create table group
CREATE TABLE agroup(
    id              serial      PRIMARY KEY,
    name            varchar(40) NOT NULL,
    description     varchar(99) NULL
);

-- create table address
CREATE TABLE address (
    id              serial      PRIMARY KEY,
    ip              varchar(15) NOT NULL,
    port            integer     NOT NULL,
    description     varchar(99) NOT NULL,
    group_id        integer     REFERENCES agroup
);

-- grant privileges
GRANT ALL PRIVILEGES ON TABLE agroup TO afpauser;
GRANT ALL PRIVILEGES ON TABLE address TO afpauser;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public to afpauser;
GRANT ALL PRIVILEGES ON SCHEMA public TO afpauser;
