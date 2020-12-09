CREATE TABLE IF NOT EXISTS users (
                                        id serial NOT NULL PRIMARY KEY,
                                        username varchar(32) NOT NULL UNIQUE,
                                        password varchar(32) NOT NULL,
                                        biography varchar(32)
);

CREATE TABLE IF NOT EXISTS user_aut (
                                        username varchar(32) NOT NULL PRIMARY KEY,
                                        role varchar(32) NOT NULL
);