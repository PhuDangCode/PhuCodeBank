create database bankSystem;
use bankSystem;

CREATE TABLE people (
    identity_number VARCHAR(20) PRIMARY KEY,
    name VARCHAR(255),
    gender VARCHAR(10),
    DoB VARCHAR(50),
    Address VARCHAR(255),
    Phone VARCHAR(15)
);

CREATE TABLE customer (
    card_no VARCHAR(60) PRIMARY KEY,
    pin VARCHAR(4),
    amount VARCHAR(255), 
    identity_number VARCHAR(20),
    FOREIGN KEY (identity_number) REFERENCES people(identity_number)
);



CREATE TABLE employee (
    account VARCHAR(20) PRIMARY KEY,
    password VARCHAR(255),
    emp_id VARCHAR(10),
    position VARCHAR(50),
    salary VARCHAR(50),
    identity_number VARCHAR(20),
    FOREIGN KEY (identity_number) REFERENCES people(identity_number)
);



CREATE TABLE transaction (
    card_no VARCHAR(16),
    date VARCHAR(50),
    type VARCHAR(20),
    amount VARCHAR(255), 
    PRIMARY KEY (card_no, date),
    FOREIGN KEY (card_no) REFERENCES customer(card_no)
);


CREATE TABLE transfer (
    trade_code VARCHAR(20) PRIMARY KEY,
    card_no VARCHAR(60),
    date VARCHAR(50),
    amount VARCHAR(255),
    receiver VARCHAR(60),
    FOREIGN KEY (card_no) REFERENCES customer(card_no),
    FOREIGN KEY (receiver) REFERENCES customer(card_no)
);




