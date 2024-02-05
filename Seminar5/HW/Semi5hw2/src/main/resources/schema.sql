CREATE TABLE users (
                       id int AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255),
                       password VARCHAR(255),
                       email VARCHAR(255),
                       role VARCHAR(255)
);


CREATE TABLE project (
                          id int AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255),
                          description VARCHAR(255),
                          created_date DATE
);
