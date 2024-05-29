CREATE DATABASE OnlineSystem;
USE OnlineSystem;

CREATE TABLE Shop (
	ShopId int PRIMARY KEY,
	Name varchar(100) NOT NULL,
    Address varchar(100) NOT NULL,
    email varchar(100) NOT NUll UNIQUE,
    phone VARCHAR(100) NOT NULL UNIQUE,
    modifiedDate datetime NOT NULL
);

CREATE TABLE Category(
	CategoryId int PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    Description VARCHAR(200) NOT NULL
);users