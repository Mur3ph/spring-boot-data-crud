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
  person_id 						SERIAL NOT NULL,
  first_name 						CHARACTER VARYING(150) NOT NULL,
  last_name 						CHARACTER VARYING(150) NOT NULL,
  username 							CHARACTER VARYING(150) NOT NULL,
  password 							CHARACTER VARYING(150) NOT NULL,
  CONSTRAINT pk_person 				PRIMARY KEY (person_id),
  CONSTRAINT uk_person_username 	UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE person
  OWNER TO postgres;


-- Table: person_info

-- DROP TABLE person_info;

CREATE TABLE person_info
(
  person_info_id 				SERIAL NOT NULL,
  person_id 					SERIAL NOT NULL,
  dob 							DATE NOT NULL,
  age 							INTEGER NOT NULL,
  address_line_1 				CHARACTER VARYING(150) NOT NULL,
  address_line_2 				CHARACTER VARYING(150) NOT NULL,
  city 							CHARACTER VARYING(150) NOT NULL,
  country 						CHARACTER VARYING(150) NOT NULL,
  insurance_type 				CHARACTER VARYING(150) NOT NULL,
  email 						CHARACTER VARYING(150) NOT NULL,
  tel 							CHARACTER VARYING(150) NOT NULL,
  mobile 						CHARACTER VARYING(150) NOT NULL,
  CONSTRAINT pk_person_info 	PRIMARY KEY (person_info_id),
  CONSTRAINT fk_person_id 		FOREIGN KEY (person_id) REFERENCES person (person_id),
  CONSTRAINT uk_person_email 	UNIQUE (email)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE person_info
  OWNER TO postgres;
  
  
-- Table: post

-- DROP TABLE post;

CREATE TABLE post
(
  id serial 				NOT NULL,
  message 					CHARACTER(150) NOT NULL,
  CONSTRAINT post_pkey 		PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE post
  OWNER TO postgres;
  
  
-- Table: medical_history

-- DROP TABLE medical_history;

CREATE TABLE medical_history
(
  medical_history_id 			SERIAL NOT NULL,
  person_id 					SERIAL NOT NULL,
  xray 							CHARACTER VARYING(150) NOT NULL,
  alergy 						CHARACTER VARYING(150) NOT NULL,
  disease 						CHARACTER VARYING(150) NOT NULL,
  pregnant 						CHARACTER VARYING(150) NOT NULL,
  prescription 					CHARACTER VARYING(150) NOT NULL,
  prescription_prior 			CHARACTER VARYING(150) NOT NULL,
  current_health 				CHARACTER VARYING(150) NOT NULL,
  physician 					CHARACTER VARYING(150) NOT NULL,
  CONSTRAINT pk_medical_history PRIMARY KEY (medical_history_id),
  CONSTRAINT fk_person_id 		FOREIGN KEY (person_id) REFERENCES person (person_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE medical_history
  OWNER TO postgres;
