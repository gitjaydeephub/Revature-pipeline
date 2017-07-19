INSERT INTO u_role VALUES(1, 'student');
INSERT INTO u_role VALUES(2, 'teacher');

INSERT into users(u_role_id, u_email, u_password, u_fname, u_lname) VALUES(1,'student1@gmail.com', 'pass', 'lisa', 'bush');


INSERT into users(u_role_id, u_email, u_password, u_fname, u_lname) VALUES(2,'teacher1@gmail.com', 'pass', 'bob', 'marley');

CREATE SEQUENCE user_id_seq
  START WITH 1
  INCREMENT BY 1;
  
  
  
  CREATE OR REPLACE TRIGGER user_id_seq_trigg
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
  IF :new.u_id IS NULL THEN
    SELECT user_id_seq.nextval INTO :new.u_id FROM DUAL;
  END IF;
END;
/


commit;