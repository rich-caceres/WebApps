DROP TABLE IF EXISTS users;
 
CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  name VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO users (username, password, name) VALUES
  ('Rich', 'richierich', 'Richard Caceres'),
  ('Bill', 'Gates', 'Bill Gates'),
  ('Flight', 'passw', 'Eric Terry');