-- 创建数据库
CREATE DATABASE gambling;
DROP TABLE IF EXISTS `auth_role_perm`;
DROP TABLE IF EXISTS `auth_user_role`;
DROP TABLE IF EXISTS `auth_user_login`;
DROP TABLE IF EXISTS `auth_role`;
DROP TABLE IF EXISTS `auth_user`;

-- `gambling`.auth_role definition

CREATE TABLE `auth_role`  (
  `eid` int NOT NULL AUTO_INCREMENT COMMENT '自增键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `role_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色id',
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `service` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属服务',
  `description` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注信息',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`eid`) USING BTREE,
  UNIQUE INDEX `auth_role_role_id_unique`(`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


-- `gambling`.auth_role_perm definition

CREATE TABLE `auth_role_perm`  (
   `eid` int NOT NULL AUTO_INCREMENT COMMENT '自增键',
   `create_time` datetime NOT NULL COMMENT '创建时间',
   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
   `role_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色id',
   `permission_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限值',
   `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注信息',
   PRIMARY KEY (`eid`) USING BTREE,
   INDEX `auth_role_perm_role_id_IDX`(`role_id`) USING BTREE,
   CONSTRAINT `auth_role_perm_role_FK` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


-- `gambling`.auth_user definition

CREATE TABLE `auth_user`  (
  `eid` int NOT NULL AUTO_INCREMENT COMMENT '自增键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `user_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户Id',
  `user_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名称',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录密码',
  `status` tinyint(1) NOT NULL COMMENT '账户状态',
  `login_fail` int NOT NULL DEFAULT 0 COMMENT '连续登录失败次数',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`eid`) USING BTREE,
  UNIQUE INDEX `auth_user_user_id_unique`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


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


CREATE TABLE `auth_user_role`  (
   `eid` int NOT NULL AUTO_INCREMENT COMMENT '自增键',
   `create_time` datetime NOT NULL COMMENT '创建时间',
   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
   `user_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账户id',
   `role_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色id',
   `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注信息',
   PRIMARY KEY (`eid`) USING BTREE,
   INDEX `auth_user_role_role_FK`(`role_id`) USING BTREE,
   INDEX `auth_user_role_user_id_IDX`(`user_id`) USING BTREE,
   CONSTRAINT `auth_user_role_role_FK` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
   CONSTRAINT `auth_user_role_user_FK` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;