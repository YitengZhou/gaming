-- init auth_role data

INSERT INTO `gambling`.auth_role VALUES (1, '2020-09-09 16:12:01', '2020-09-09 16:12:01', 'admin', '系统管理员', 'system', NULL, NULL);

-- init auth_role_permission data

INSERT INTO `gambling`.auth_role_perm VALUES (1, '2020-09-16 20:33:12', '2020-09-16 20:33:12', 'admin', 'system:manage-user', '');
INSERT INTO `gambling`.auth_role_perm VALUES (2, '2020-09-16 20:33:12', '2020-09-16 20:33:12', 'admin', 'system:manage-role', '');
INSERT INTO `gambling`.auth_role_perm VALUES (3, '2020-09-16 20:33:12', '2020-09-16 20:33:12', 'admin', 'system:search-user', '');
INSERT INTO `gambling`.auth_role_perm VALUES (4, '2020-09-16 20:33:12', '2020-09-16 20:33:12', 'admin', 'system:search-role', '');

-- init auth_user data

INSERT INTO `gambling`.auth_user VALUES (1, '2021-01-08 14:52:54', '2021-01-08 14:52:54', 'admin', '测试账号', '613980346794feadaf37d1ebf512d5fb', 1, 0, NULL);


-- init auth_user_role data

INSERT INTO `gambling`.auth_user_role VALUES (1, '2021-01-08 14:53:07', '2021-01-08 14:53:07', 'admin', 'admin', '');