CREATE TABLE if not exists shedlock (
name VARCHAR(64) NOT NULL,
lock_until TIMESTAMP NOT NULL,
locked_at TIMESTAMP NOT NULL,
locked_by VARCHAR(255) NOT NULL,
PRIMARY KEY (name)
);

CREATE TABLE if not exists events (
id SERIAL,
host VARCHAR(255) NOT NULL,
event_type VARCHAR(255) NOT NULL,
thread VARCHAR(255) NOT NULL,
created_at TIMESTAMP NOT NULL,
PRIMARY KEY (id)
);