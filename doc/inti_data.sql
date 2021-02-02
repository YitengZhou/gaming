-- init auth_role data

INSERT INTO `gambling`.auth_role (role_id,role_name,create_time,update_time,remark) VALUES
('admin','系统管理员','2020-09-09 16:12:01','2020-09-09 16:12:01',NULL);


-- init auth_role_permission data

INSERT INTO `gambling`.auth_role_permission (role_id,permission_value,create_time,update_time,remark) VALUES
('admin','system','2020-09-16 20:33:12','2020-09-16 20:33:12',''),
('admin','system:user','2020-09-16 20:33:12','2020-09-16 20:33:12',''),
('admin','system:role','2020-09-16 20:33:12','2020-09-16 20:33:12','');

-- init auth_user data

INSERT INTO `gambling`.auth_user (user_id,user_name,password,status,create_time,update_time,remark) VALUES
('admin','系统管理员','3f4bffa77257d243875d0a5a80635934',1,'2021-01-08 14:52:54','2021-01-08 14:52:54',NULL);


-- init auth_user_role data

INSERT INTO `gambling`.auth_user_role (user_id,role_id,create_time,update_time,remark) VALUES
('admin','admin','2021-01-08 14:53:07','2021-01-08 14:53:07','');