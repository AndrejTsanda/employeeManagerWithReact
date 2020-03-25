DROP TABLE IF EXISTS users;
CREATE TABLE users (
  user_id INT NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(45) NOT NULL UNIQUE,
  user_password VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS departments;
CREATE TABLE departments (
  department_id INT NOT NULL AUTO_INCREMENT,
  department_name VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (department_id)
);

DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
  employee_id INT NOT NULL AUTO_INCREMENT,
  tabelNum INT NOT NULL UNIQUE,
  firstName VARCHAR(45) NOT NULL,
  lastName VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL UNIQUE,
  gender VARCHAR(6) NOT NULL CHECK (gender IN ('male', 'female')),
  birthday DATE,
  department_id INT NOT NULL,
  PRIMARY KEY (employee_id),
  FOREIGN KEY (department_id) REFERENCES departments(department_id)
);