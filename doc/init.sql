-- 创建数据库
CREATE DATABASE gambling;

-- `gambling`.auth_role definition

CREATE TABLE `auth_role` (
     `role_id` varchar(100) NOT NULL COMMENT '角色id',
     `role_name` varchar(100) NOT NULL COMMENT '角色名称',
     `create_time` datetime NOT NULL COMMENT '创建时间',
     `update_time` datetime DEFAULT NULL COMMENT '更新时间',
     `remark` varchar(300) DEFAULT NULL COMMENT '备注信息',
     PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `gambling`.auth_role_permission definition

CREATE TABLE `auth_role_permission` (
    `role_id` varchar(100) NOT NULL COMMENT '角色id',
    `permission_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限值',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `remark` varchar(300) DEFAULT NULL COMMENT '备注信息',
    KEY `auth_role_permission_role_id_IDX` (`role_id`) USING BTREE,
    CONSTRAINT `auth_role_permission_role_FK` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `gambling`.auth_user definition

CREATE TABLE `auth_user` (
 `user_id` varchar(100) NOT NULL COMMENT '用户Id',
 `user_name` varchar(100) NOT NULL COMMENT '用户名称',
 `password` varchar(100) NOT NULL COMMENT '登录密码',
 `status` tinyint(1) NOT NULL COMMENT '账户状态',
 `create_time` datetime NOT NULL COMMENT '创建时间',
 `update_time` datetime DEFAULT NULL,
 `remark` varchar(300) DEFAULT NULL COMMENT '备注信息',
 PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `gambling`.auth_user_login definition

CREATE TABLE `auth_user_login` (
    `user_id` varchar(100) NOT NULL COMMENT '帐号id',
    `token` varchar(100) NOT NULL COMMENT '登录token',
    `login_time` datetime NOT NULL COMMENT '登录时间',
    `expiry_time` int NOT NULL COMMENT '登录有效时间',
    PRIMARY KEY (`user_id`),
    CONSTRAINT `auth_user_login_FK` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- `gambling`.auth_user_role definition

CREATE TABLE `auth_user_role` (
  `user_id` varchar(100) NOT NULL COMMENT '账户id',
  `role_id` varchar(100) NOT NULL COMMENT '角色id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注信息',
  KEY `auth_user_role_role_FK` (`role_id`),
  KEY `auth_user_role_user_id_IDX` (`user_id`) USING BTREE,
  CONSTRAINT `auth_user_role_role_FK` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`role_id`),
  CONSTRAINT `auth_user_role_user_FK` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;