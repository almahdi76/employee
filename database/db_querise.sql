DROP DATABASE IF EXISTS jdbc_courses_db;
CREATE DATABASE jdbc_courses_db;
use jdbc_courses_db;

CREATE TABLE employee (
id INT(15) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(25),
gendre BOOLEAN,
birth_date DATE,
salary REAL
);

