DROP DATABASE finalproject;
CREATE DATABASE finalproject;
USE finalproject;

CREATE TABLE statuses (
  id INTEGER NOT NULL PRIMARY KEY,
  name VARCHAR (20) NOT NULL UNIQUE
);

INSERT INTO Statuses VALUES (0,'enable');
INSERT INTO Statuses VALUES (1,'disable');
INSERT INTO statuses VALUES (2,'rent');
INSERT INTO statuses VALUES (3,'repair');
INSERT INTO statuses VALUES (4,'not paid');
INSERT INTO statuses VALUES (5,'paid');
INSERT INTO statuses VALUES (6,'canceled');
INSERT INTO statuses VALUES (7,'accepted');
INSERT INTO statuses VALUES (8,'success');
INSERT INTO statuses VALUES (9,'returned');
INSERT INTO statuses VALUES (10,'waiting');

CREATE TABLE roles(
  id INTEGER NOT NULL PRIMARY KEY,
  name VARCHAR (10) NOT NULL UNIQUE
);

INSERT INTO roles VALUES (0,'admin');
INSERT INTO roles VALUES (1,'manager');
INSERT INTO roles VALUES (2,'customer');
INSERT INTO roles VALUES (3,'blocked');

CREATE TABLE classes (
  id INTEGER NOT NULL PRIMARY KEY,
  name VARCHAR (10) NOT NULL UNIQUE
);

INSERT INTO classes VALUES (0,'A');
INSERT INTO classes VALUES (1,'B');
INSERT INTO classes VALUES (2,'C');
INSERT INTO classes VALUES (3,'D');
INSERT INTO classes VALUES (4, 'E');
INSERT INTO classes VALUES (5,'F');
INSERT INTO classes VALUES (6,'M');
INSERT INTO classes VALUES (7,'S');
INSERT INTO classes VALUES (8,'J');
INSERT INTO classes VALUES (9,'P');

CREATE TABLE cars (
  id INTEGER NOT NULL auto_increment PRIMARY KEY,
  mark VARCHAR (20) NOT NULL,
  model VARCHAR (20) NOT NULL,
  price INTEGER NOT NULL,
  carClass INTEGER NOT NULL REFERENCES classes(id),
  status INTEGER NOT NULL DEFAULT "0" REFERENCES statuses
);

INSERT INTO cars (mark,model,price,carClass) VALUES ('Audi', 'A3', 1000, 3);
INSERT INTO cars (mark,model,price,carClass) VALUES('Audi', 'A4', 1200, 3);
INSERT INTO cars (mark,model,price,carClass) VALUES('Audi', 'TT', 2000, 2);
INSERT INTO cars (mark,model,price,carClass) VALUES('Audi', 'A5', 2100, 5);
INSERT INTO cars (mark,model,price,carClass) VALUES('Audi', 'R8', 4000, 7);
INSERT INTO cars (mark,model,price,carClass) VALUES('BMW', 'F30/31', 900, 3);
INSERT INTO cars (mark,model,price,carClass) VALUES('BMW', 'F22', 1200, 3);
INSERT INTO cars (mark,model,price,carClass) VALUES('BMW', 'X6', 3000, 8);
INSERT INTO cars (mark,model,price,carClass) VALUES('BMW', 'Grand Tourer', 2100, 1);
INSERT INTO cars (mark,model,price,carClass) VALUES('BMW', 'X5', 2800, 8);
INSERT INTO cars (mark,model,price,carClass) VALUES('Toyota', 'Corolla', 900, 3);
INSERT INTO cars (mark,model,price,carClass) VALUES('Toyota', 'Prius', 750, 6);
INSERT INTO cars (mark,model,price,carClass) VALUES('Toyota', 'Land Cruiser', 2800, 8);
INSERT INTO cars (mark,model,price,carClass) VALUES('Toyota', 'Hilux', 1500, 9);
INSERT INTO cars (mark,model,price,carClass) VALUES('Toyota', 'Auris', 800, 0);
INSERT INTO cars (mark,model,price,carClass) VALUES('Nissan', 'Micra', 800, 0);
INSERT INTO cars (mark,model,price,carClass) VALUES('Nissan', 'GT-R', 3000, 2);

CREATE TABLE users(
  id INTEGER NOT NULL auto_increment PRIMARY KEY,
  email VARCHAR (20) NOT NULL UNIQUE ,
  password VARCHAR (50) NOT NULL,
  firstName VARCHAR (30) NOT NULL,
  lastName VARCHAR (30) NOT NULL,
  role INTEGER NOT NULL REFERENCES roles(id)
);

INSERT INTO users(email, password, firstName, lastName, role) VALUES ('admin@a', '1', 'Admin', 'admin', "0");
INSERT INTO users(email, password, firstName, lastName, role) VALUES ('manager@m', '1', 'Manager', 'manager', '1');
INSERT INTO users(email, password, firstName, lastName, role) VALUES ('customer@c', '1', 'Customer', 'customer', '2');

CREATE TABLE orders(
  id INTEGER NOT NULL auto_increment PRIMARY KEY,
  passport VARCHAR (10) NOT NULL,
  user_id INTEGER NOT NULL REFERENCES users(id),
  check_id INTEGER REFERENCES checks(id),
  car INTEGER(10) NOT NULL REFERENCES cars(id),
  startDate DATE NOT NULL,
  endDate DATE NOT NULL,
  driver BOOLEAN NOT NULL,
  status INTEGER NOT NULL REFERENCES statuses(id)
);


CREATE TABLE checks(
  id INTEGER NOT NULL auto_increment PRIMARY KEY,
  date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  description VARCHAR (300),
  price INTEGER,
  status INTEGER NOT NULL REFERENCES statuses(id)
);
