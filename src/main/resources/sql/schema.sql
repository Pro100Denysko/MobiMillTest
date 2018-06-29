DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS position;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS company_departments;
DROP TABLE IF EXISTS user_departments;

-- Table: company
CREATE TABLE company (
  id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,

  UNIQUE (name)
);

-- Table: department
CREATE TABLE department (
  id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL,

  UNIQUE (name)
);

-- Table: position
CREATE TABLE position (
  id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL
);

-- Table: users
CREATE TABLE users (
  id            INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(45) NOT NULL,
  lastname      VARCHAR(45) NOT NULL,
  date_of_birth DATE        NOT NULL,
  position_id   INT         NOT NULL,
  company_id    INT         NOT NULL
);

-- Table for mapping company and departments: company_departments
CREATE TABLE company_departments (
  company_id    INT NOT NULL,
  department_id INT NOT NULL,

  UNIQUE (company_id, department_id),

  FOREIGN KEY (company_id) REFERENCES company (id),
  FOREIGN KEY (department_id) REFERENCES department (id)
);

-- Table for mapping user and departments: user_departments
CREATE TABLE user_departments (
  user_id       INT NOT NULL,
  department_id INT NOT NULL,

  UNIQUE (user_id, department_id),

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (department_id) REFERENCES department (id)
);