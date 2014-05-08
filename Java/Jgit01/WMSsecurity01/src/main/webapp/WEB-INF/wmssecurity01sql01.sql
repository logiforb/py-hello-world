--postgres
--PostgreSQL
--postgresql

--wmssecurity01admin
--wmssecurity01password

--wmssecurity01db01

--wmssecurity01sql01

--http://www.mkyong.com/spring-security/spring-security-form-login-using-database/


------------------------------------------------------------------
-- SQL
------------------------------------------------------------------
CREATE TABLE public.users
(
   username text NOT NULL,
   password text NOT NULL,
   enabled smallint NOT NULL DEFAULT 1,
   CONSTRAINT pk_username PRIMARY KEY (username)
)
WITH (
  OIDS = FALSE
)
;

CREATE TABLE public.user_roles
(
   user_role_id serial NOT NULL,
   username text NOT NULL,
   role text NOT NULL,
   CONSTRAINT pk_user_role_id PRIMARY KEY (user_role_id),
   CONSTRAINT uni_username_role UNIQUE (role, username),
   CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username) ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS = FALSE
)
;

INSERT INTO users(
            username, password)
    VALUES ('mujo', 'fata');
INSERT INTO users(
            username, password)
    VALUES ('mkyong', '123456');

SELECT username, password, enabled
  FROM users;

INSERT INTO user_roles(username, role)
    VALUES ('mkyong', 'ROLE_USER');
INSERT INTO user_roles(username, role)
    VALUES ('mujo', 'ROLE_USER');
INSERT INTO user_roles(username, role)
    VALUES ('mkyong', 'ROLE_ADMIN');

SELECT user_role_id, username, role
  FROM user_roles;

------------------------------------------------------------------
-- TEST
------------------------------------------------------------------
UPDATE users
   SET password='f44ta'
WHERE username = 'mujo';
