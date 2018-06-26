DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS position;
DROP TABLE IF EXISTS users;

-- Table: company
CREATE TABLE company (
  id   INT         NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL
);

-- Table: department
CREATE TABLE department (
  id   INT         NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL
);

-- Table: position
CREATE TABLE position (
  id   INT         NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL
);

-- Table: users
CREATE TABLE users (
  id            INT         NOT NULL AUTO_INCREMENT,
  name          VARCHAR(45) NOT NULL,
  lastname      VARCHAR(45) NOT NULL,
  date_of_birth DATE        NOT NULL,
);