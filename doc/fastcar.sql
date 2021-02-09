DROP TABLE IF EXISTS `fast_car`;
-- `gambling`.fastcar definition

CREATE TABLE `fast_car`  (
  `eid` int NOT NULL AUTO_INCREMENT COMMENT '自增键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `first` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第一名',
  `second` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第二名',
  `third` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第三名',
  `fourth` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第四名',
  `fifth` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第五名',
  `sixth` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第六名',
  `seventh` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第七名',
  `eighth` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第八名',
  `ninth` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第九名',
  `tenth` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第十名',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`eid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

CREATE TABLE `bet_race`  (
   `eid` int NOT NULL AUTO_INCREMENT COMMENT '自增键',
   `create_time` datetime NOT NULL COMMENT '创建时间',
   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
   `race_id` int NOT NULL COMMENT '比赛id',
   `user_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账户id',
   PRIMARY KEY (`eid`) USING BTREE,
   INDEX `bet_race_id_FK`(`race_id`) USING BTREE,
   INDEX `bet_race_user_id_FK`(`user_id`) USING BTREE,
   CONSTRAINT `bet_race_id_FK` FOREIGN KEY (`race_id`) REFERENCES `fast_car` (`eid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
   CONSTRAINT `bet_race_user_id_FK` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;