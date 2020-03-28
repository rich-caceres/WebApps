CREATE DATABASE UserFlights

GO

CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));


CREATE TABLE authorities (
  user_role_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
  username varchar(45) NOT NULL FOREIGN KEY REFERENCES users (username),
  roles varchar(45) NOT NULL,
  );
  
  
USE UserFlights

INSERT INTO users (username,password,enabled)
VALUES ('Rich', '{noop}123456', 1)