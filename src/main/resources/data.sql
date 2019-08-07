DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS message;

CREATE TABLE employee (
  employee_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE message (
  id INT AUTO_INCREMENT PRIMARY KEY,
  employee_id INT,
  title VARCHAR(250) NOT NULL,
  text VARCHAR(250) NOT NULL,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

CREATE INDEX idx_create_date ON message (create_date);

CREATE TABLE follower (
  id INT AUTO_INCREMENT PRIMARY KEY,
  follower_id INT,
  publisher_id INT,
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (follower_id) REFERENCES employee(employee_id),
  FOREIGN KEY (publisher_id) REFERENCES employee(employee_id)
);

INSERT INTO employee (first_name, last_name) VALUES('John', 'Doe');
INSERT INTO employee (first_name, last_name) VALUES('Jane', 'Doe');
INSERT INTO employee (first_name, last_name) VALUES('Bob', 'Wilson');
INSERT INTO employee (first_name, last_name) VALUES('Rob', 'Kelly');
INSERT INTO employee (first_name, last_name) VALUES('Pat', 'Fielder');

INSERT INTO message (employee_id, title, text) VALUES
  (1, 'Beautiful Day', 'What a beautiful day!!');
INSERT INTO message (employee_id, title, text) VALUES
  (2, 'Hello', 'My first tweet.');
INSERT INTO message (employee_id, title, text) VALUES
  (3, 'Happy Holidays', 'Wishing everyone happy holidays!!');
INSERT INTO message (employee_id, title, text) VALUES
  (4, 'Boo!', 'Happy Halloween!!');
INSERT INTO message (employee_id, title, text) VALUES
  (5, 'Merry Christmas', 'Merry christmas to all.');

INSERT INTO follower (follower_id, publisher_id) VALUES
  (1, 2);
  INSERT INTO follower (follower_id, publisher_id) VALUES
  (1, 3);
INSERT INTO follower (follower_id, publisher_id) VALUES
  (2, 3);


