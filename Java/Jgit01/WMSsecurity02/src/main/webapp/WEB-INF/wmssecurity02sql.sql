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

------------------------------------------------------------------
-- ENCRYPTED
------------------------------------------------------------------
SELECT username, password, enabled
  FROM users;

UPDATE users
   SET password='$2a$13$zoQiQmcNdkw.PlVS/WsU2O4CM0V/G396YKiU6EXUErqi6TceNgb.q' --123456
 WHERE username='mkyong';
UPDATE users
   SET password='$2a$13$0nQ7hp65hH6iIWUlUEWEvuY12RUewjHZD4ZoNJ2dOLHuirOCTf0Ee' --fata
 WHERE username='mujo';

------------------------------------------------------------------
-- q w
------------------------------------------------------------------
INSERT INTO users(
            username, password)
    -- VALUES ('q', '$2a$16$U6khDN/VeWElfQ5XCss2A.xaqxGbmrIRMl4GhB8G.l9vdiI8BXrti'); -- 16
    VALUES ('q', '$2a$14$XFS5wl8MyrCZuSbvfePigeEgo1GoljRts6ZAs9aNRxnSeWcLWHgwy');
-- UPDATE users SET password = '$2a$14$XFS5wl8MyrCZuSbvfePigeEgo1GoljRts6ZAs9aNRxnSeWcLWHgwy' WHERE username = 'q'

------------------------------------------------------------------
-- It won't work without ROLE_USER because of spring-security authorities-by-username-query
------------------------------------------------------------------
SELECT user_role_id, username, role
  FROM user_roles;

INSERT INTO user_roles(username, role)
	VALUES('q', 'ROLE_USER')

------------------------------------------------------------------
-- The following stored procedures cannot be used with vanilla 
-- jdbc-user-service, because it uses prepared statements
-- the prepared statements, when used correctly, prevent from
-- SQL injection
------------------------------------------------------------------
select username,password,enabled from users where username='q'

CREATE FUNCTION users_select_by_username(_username text) RETURNS TABLE(username text, password text, enabled smallint) AS $$
  SELECT username, password, enabled FROM users WHERE username = _username
$$ LANGUAGE SQL;

SELECT * FROM users_select_by_username('q')

select username,role from user_roles where username='q'

CREATE FUNCTION user_roles_select_by_username(_username text) RETURNS TABLE(username text, role text) AS $$
  SELECT username, role FROM user_roles WHERE username = _username
$$ LANGUAGE SQL;

SELECT * FROM user_roles_select_by_username('q')
SELECT * FROM user_roles_select_by_username('mkyong')
------------------------------------------------------------------