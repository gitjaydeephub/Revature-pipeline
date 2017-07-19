DROP TABLE users;

CREATE TABLE users(
  u_id INT,
  u_role_id INT NOT NULL,
  u_email VARCHAR2(1000) UNIQUE NOT NULL,
  u_password VARCHAR2(1000) NOT NULL,
  u_fname VARCHAR2(1000) NOT NULL,
  u_lname VARCHAR2(1000) NOT NULL,
  PRIMARY KEY(u_id),
  FOREIGN KEY(u_role_id) REFERENCES u_role(u_role_id)
);

CREATE TABLE u_role(
  u_role_id INT,
  u_role VARCHAR2(1000) UNIQUE NOT NULL,
  PRIMARY KEY(u_role_id)
);

