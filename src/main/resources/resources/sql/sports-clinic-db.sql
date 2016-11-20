-- Database: sportsclinicdb


-- DROP DATABASE sportsclinicdb;

CREATE DATABASE sportsclinicdb
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_Ireland.1252'
       LC_CTYPE = 'English_Ireland.1252'
       CONNECTION LIMIT = -1;
       
-- Table: person

-- DROP TABLE person;

CREATE TABLE person
(
  person_id serial NOT NULL,
  first_name character varying(150) NOT NULL,
  last_name character varying(150) NOT NULL,
  age integer NOT NULL,
  username character varying(150) NOT NULL,
  email character varying(150) NOT NULL,
  password character varying(150) NOT NULL,
  CONSTRAINT person_pkey PRIMARY KEY (person_id),
  CONSTRAINT person_email_key UNIQUE (email),
  CONSTRAINT person_username_key UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE person
  OWNER TO postgres;

  
-- Table: post

-- DROP TABLE post;

CREATE TABLE post
(
  id serial NOT NULL,
  message character(150) NOT NULL,
  CONSTRAINT post_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE post
  OWNER TO postgres;
