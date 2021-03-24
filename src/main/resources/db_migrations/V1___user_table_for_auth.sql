
CREATE TABLE USER (
	id varchar(128) primary key,
    username VARCHAR(28) not null unique,
    password TEXT NOT NULL,
    firstname VARCHAR(28) NOT NULL,
    lastname VARCHAR(28) NOT NULL,
    email VARCHAR(28) NOT NULL
);