create user netflix;
alter user netflix WITH ENCRYPTED PASSWORD 'netflix';

CREATE DATABASE "netflixmgmt";

grant all PRIVILEGES on DATABASE "netflixmgmt" to netflix;