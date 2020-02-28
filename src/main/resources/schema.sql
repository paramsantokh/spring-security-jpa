DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id int(11) NOT NULL,
  active bit(1) NOT NULL,
  password varchar(255),
  roles varchar(255),
  user_name varchar(255)
);