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

alter table `bet_race` add `first_first` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `first_second` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `first_third` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `first_fourth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `first_fifth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `first_sixth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `first_seventh` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `first_eighth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `first_ninth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `first_tenth` decimal(10, 2) NULL DEFAULT NULL;

alter table `bet_race` add `second_first` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `second_second` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `second_third` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `second_fourth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `second_fifth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `second_sixth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `second_seventh` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `second_eighth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `second_ninth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `second_tenth` decimal(10, 2) NULL DEFAULT NULL;

alter table `bet_race` add `third_first` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `third_second` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `third_third` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `third_fourth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `third_fifth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `third_sixth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `third_seventh` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `third_eighth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `third_ninth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `third_tenth` decimal(10, 2) NULL DEFAULT NULL;

alter table `bet_race` add `fourth_first` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fourth_second` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fourth_third` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fourth_fourth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fourth_fifth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fourth_sixth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fourth_seventh` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fourth_eighth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fourth_ninth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fourth_tenth` decimal(10, 2) NULL DEFAULT NULL;

alter table `bet_race` add `fifth_first` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fifth_second` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fifth_third` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fifth_fourth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fifth_fifth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fifth_sixth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fifth_seventh` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fifth_eighth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fifth_ninth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `fifth_tenth` decimal(10, 2) NULL DEFAULT NULL;

alter table `bet_race` add `sixth_first` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `sixth_second` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `sixth_third` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `sixth_fourth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `sixth_fifth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `sixth_sixth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `sixth_seventh` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `sixth_eighth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `sixth_ninth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `sixth_tenth` decimal(10, 2) NULL DEFAULT NULL;

alter table `bet_race` add `seventh_first` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `seventh_second` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `seventh_third` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `seventh_fourth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `seventh_fifth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `seventh_sixth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `seventh_seventh` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `seventh_eighth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `seventh_ninth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `seventh_tenth` decimal(10, 2) NULL DEFAULT NULL;

alter table `bet_race` add `eighth_first` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `eighth_second` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `eighth_third` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `eighth_fourth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `eighth_fifth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `eighth_sixth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `eighth_seventh` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `eighth_eighth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `eighth_ninth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `eighth_tenth` decimal(10, 2) NULL DEFAULT NULL;

alter table `bet_race` add `ninth_first` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `ninth_second` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `ninth_third` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `ninth_fourth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `ninth_fifth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `ninth_sixth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `ninth_seventh` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `ninth_eighth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `ninth_ninth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `ninth_tenth` decimal(10, 2) NULL DEFAULT NULL;

alter table `bet_race` add `tenth_first` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `tenth_second` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `tenth_third` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `tenth_fourth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `tenth_fifth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `tenth_sixth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `tenth_seventh` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `tenth_eighth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `tenth_ninth` decimal(10, 2) NULL DEFAULT NULL;
alter table `bet_race` add `tenth_tenth` decimal(10, 2) NULL DEFAULT NULL;
