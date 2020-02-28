delete from user;
INSERT INTO user(id,active,password,roles,user_name) VALUES(1,_binary '','pass','ROLE_USER,ROLE_ADMIN','user');
commit;