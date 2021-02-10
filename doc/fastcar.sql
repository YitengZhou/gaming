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
     `total_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '投注金额',
     `profit` decimal(10, 2) NULL DEFAULT NULL COMMENT '投注盈利',
     `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态类型',
     `sum3` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和3',
     `sum4` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和4',
     `sum5` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和5',
     `sum6` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和6',
     `sum7` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和7',
     `sum8` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和8',
     `sum9` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和9',
     `sum10` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和10',
     `sum11` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和11',
     `sum12` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和12',
     `sum13` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和13',
     `sum14` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和14',
     `sum15` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和15',
     `sum16` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和16',
     `sum17` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和17',
     `sum18` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和18',
     `sum19` decimal(10, 2) NULL DEFAULT NULL COMMENT '冠亚和19',
     `first_first` decimal(10, 2) NULL DEFAULT NULL,
     `first_second` decimal(10, 2) NULL DEFAULT NULL,
     `first_third` decimal(10, 2) NULL DEFAULT NULL,
     `first_fourth` decimal(10, 2) NULL DEFAULT NULL,
     `first_fifth` decimal(10, 2) NULL DEFAULT NULL,
     `first_sixth` decimal(10, 2) NULL DEFAULT NULL,
     `first_seventh` decimal(10, 2) NULL DEFAULT NULL,
     `first_eighth` decimal(10, 2) NULL DEFAULT NULL,
     `first_ninth` decimal(10, 2) NULL DEFAULT NULL,
     `first_tenth` decimal(10, 2) NULL DEFAULT NULL,
     `second_first` decimal(10, 2) NULL DEFAULT NULL,
     `second_second` decimal(10, 2) NULL DEFAULT NULL,
     `second_third` decimal(10, 2) NULL DEFAULT NULL,
     `second_fourth` decimal(10, 2) NULL DEFAULT NULL,
     `second_fifth` decimal(10, 2) NULL DEFAULT NULL,
     `second_sixth` decimal(10, 2) NULL DEFAULT NULL,
     `second_seventh` decimal(10, 2) NULL DEFAULT NULL,
     `second_eighth` decimal(10, 2) NULL DEFAULT NULL,
     `second_ninth` decimal(10, 2) NULL DEFAULT NULL,
     `second_tenth` decimal(10, 2) NULL DEFAULT NULL,
     `third_first` decimal(10, 2) NULL DEFAULT NULL,
     `third_second` decimal(10, 2) NULL DEFAULT NULL,
     `third_third` decimal(10, 2) NULL DEFAULT NULL,
     `third_fourth` decimal(10, 2) NULL DEFAULT NULL,
     `third_fifth` decimal(10, 2) NULL DEFAULT NULL,
     `third_sixth` decimal(10, 2) NULL DEFAULT NULL,
     `third_seventh` decimal(10, 2) NULL DEFAULT NULL,
     `third_eighth` decimal(10, 2) NULL DEFAULT NULL,
     `third_ninth` decimal(10, 2) NULL DEFAULT NULL,
     `third_tenth` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_first` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_second` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_third` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_fourth` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_fifth` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_sixth` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_seventh` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_eighth` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_ninth` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_tenth` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_first` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_second` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_third` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_fourth` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_fifth` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_sixth` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_seventh` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_eighth` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_ninth` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_tenth` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_first` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_second` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_third` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_fourth` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_fifth` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_sixth` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_seventh` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_eighth` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_ninth` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_tenth` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_first` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_second` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_third` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_fourth` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_fifth` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_sixth` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_seventh` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_eighth` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_ninth` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_tenth` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_first` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_second` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_third` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_fourth` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_fifth` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_sixth` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_seventh` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_eighth` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_ninth` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_tenth` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_first` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_second` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_third` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_fourth` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_fifth` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_sixth` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_seventh` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_eighth` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_ninth` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_tenth` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_first` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_second` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_third` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_fourth` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_fifth` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_sixth` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_seventh` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_eighth` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_ninth` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_tenth` decimal(10, 2) NULL DEFAULT NULL,
     `first_big` decimal(10, 2) NULL DEFAULT NULL,
     `first_small` decimal(10, 2) NULL DEFAULT NULL,
     `first_odd` decimal(10, 2) NULL DEFAULT NULL,
     `first_even` decimal(10, 2) NULL DEFAULT NULL,
     `first_dragon` decimal(10, 2) NULL DEFAULT NULL,
     `first_tiger` decimal(10, 2) NULL DEFAULT NULL,
     `second_big` decimal(10, 2) NULL DEFAULT NULL,
     `second_small` decimal(10, 2) NULL DEFAULT NULL,
     `second_odd` decimal(10, 2) NULL DEFAULT NULL,
     `second_even` decimal(10, 2) NULL DEFAULT NULL,
     `second_dragon` decimal(10, 2) NULL DEFAULT NULL,
     `second_tiger` decimal(10, 2) NULL DEFAULT NULL,
     `third_big` decimal(10, 2) NULL DEFAULT NULL,
     `third_small` decimal(10, 2) NULL DEFAULT NULL,
     `third_odd` decimal(10, 2) NULL DEFAULT NULL,
     `third_even` decimal(10, 2) NULL DEFAULT NULL,
     `third_dragon` decimal(10, 2) NULL DEFAULT NULL,
     `third_tiger` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_big` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_small` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_odd` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_even` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_dragon` decimal(10, 2) NULL DEFAULT NULL,
     `fourth_tiger` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_big` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_small` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_odd` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_even` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_dragon` decimal(10, 2) NULL DEFAULT NULL,
     `fifth_tiger` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_big` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_small` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_odd` decimal(10, 2) NULL DEFAULT NULL,
     `sixth_even` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_big` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_small` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_odd` decimal(10, 2) NULL DEFAULT NULL,
     `seventh_even` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_big` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_small` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_odd` decimal(10, 2) NULL DEFAULT NULL,
     `eighth_even` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_big` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_small` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_odd` decimal(10, 2) NULL DEFAULT NULL,
     `ninth_even` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_big` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_small` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_odd` decimal(10, 2) NULL DEFAULT NULL,
     `tenth_even` decimal(10, 2) NULL DEFAULT NULL,
     `top_big` decimal(10, 2) NULL DEFAULT NULL,
     `top_small` decimal(10, 2) NULL DEFAULT NULL,
     `top_odd` decimal(10, 2) NULL DEFAULT NULL,
     `top_even` decimal(10, 2) NULL DEFAULT NULL,
     PRIMARY KEY (`eid`) USING BTREE,
     INDEX `bet_race_id_FK`(`race_id`) USING BTREE,
     INDEX `bet_race_user_id_FK`(`user_id`) USING BTREE,
     CONSTRAINT `bet_race_id_FK` FOREIGN KEY (`race_id`) REFERENCES `fast_car` (`eid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
     CONSTRAINT `bet_race_user_id_FK` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `long_dragon`  (
    `eid` int NOT NULL AUTO_INCREMENT COMMENT '自增键',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
    `race_id` int NOT NULL COMMENT '比赛id',
    `sum3` int NULL DEFAULT NULL COMMENT '冠亚和3',
    `sum4` int NULL DEFAULT NULL COMMENT '冠亚和4',
    `sum5` int NULL DEFAULT NULL COMMENT '冠亚和5',
    `sum6` int NULL DEFAULT NULL COMMENT '冠亚和6',
    `sum7` int NULL DEFAULT NULL COMMENT '冠亚和7',
    `sum8` int NULL DEFAULT NULL COMMENT '冠亚和8',
    `sum9` int NULL DEFAULT NULL COMMENT '冠亚和9',
    `sum10` int NULL DEFAULT NULL COMMENT '冠亚和10',
    `sum11` int NULL DEFAULT NULL COMMENT '冠亚和11',
    `sum12` int NULL DEFAULT NULL COMMENT '冠亚和12',
    `sum13` int NULL DEFAULT NULL COMMENT '冠亚和13',
    `sum14` int NULL DEFAULT NULL COMMENT '冠亚和14',
    `sum15` int NULL DEFAULT NULL COMMENT '冠亚和15',
    `sum16` int NULL DEFAULT NULL COMMENT '冠亚和16',
    `sum17` int NULL DEFAULT NULL COMMENT '冠亚和17',
    `sum18` int NULL DEFAULT NULL COMMENT '冠亚和18',
    `sum19` int NULL DEFAULT NULL COMMENT '冠亚和19',
    `first_first` int NULL DEFAULT NULL,
    `first_second` int NULL DEFAULT NULL,
    `first_third` int NULL DEFAULT NULL,
    `first_fourth` int NULL DEFAULT NULL,
    `first_fifth` int NULL DEFAULT NULL,
    `first_sixth` int NULL DEFAULT NULL,
    `first_seventh` int NULL DEFAULT NULL,
    `first_eighth` int NULL DEFAULT NULL,
    `first_ninth` int NULL DEFAULT NULL,
    `first_tenth` int NULL DEFAULT NULL,
    `second_first` int NULL DEFAULT NULL,
    `second_second` int NULL DEFAULT NULL,
    `second_third` int NULL DEFAULT NULL,
    `second_fourth` int NULL DEFAULT NULL,
    `second_fifth` int NULL DEFAULT NULL,
    `second_sixth` int NULL DEFAULT NULL,
    `second_seventh` int NULL DEFAULT NULL,
    `second_eighth` int NULL DEFAULT NULL,
    `second_ninth` int NULL DEFAULT NULL,
    `second_tenth` int NULL DEFAULT NULL,
    `third_first` int NULL DEFAULT NULL,
    `third_second` int NULL DEFAULT NULL,
    `third_third` int NULL DEFAULT NULL,
    `third_fourth` int NULL DEFAULT NULL,
    `third_fifth` int NULL DEFAULT NULL,
    `third_sixth` int NULL DEFAULT NULL,
    `third_seventh` int NULL DEFAULT NULL,
    `third_eighth` int NULL DEFAULT NULL,
    `third_ninth` int NULL DEFAULT NULL,
    `third_tenth` int NULL DEFAULT NULL,
    `fourth_first` int NULL DEFAULT NULL,
    `fourth_second` int NULL DEFAULT NULL,
    `fourth_third` int NULL DEFAULT NULL,
    `fourth_fourth` int NULL DEFAULT NULL,
    `fourth_fifth` int NULL DEFAULT NULL,
    `fourth_sixth` int NULL DEFAULT NULL,
    `fourth_seventh` int NULL DEFAULT NULL,
    `fourth_eighth` int NULL DEFAULT NULL,
    `fourth_ninth` int NULL DEFAULT NULL,
    `fourth_tenth` int NULL DEFAULT NULL,
    `fifth_first` int NULL DEFAULT NULL,
    `fifth_second` int NULL DEFAULT NULL,
    `fifth_third` int NULL DEFAULT NULL,
    `fifth_fourth` int NULL DEFAULT NULL,
    `fifth_fifth` int NULL DEFAULT NULL,
    `fifth_sixth` int NULL DEFAULT NULL,
    `fifth_seventh` int NULL DEFAULT NULL,
    `fifth_eighth` int NULL DEFAULT NULL,
    `fifth_ninth` int NULL DEFAULT NULL,
    `fifth_tenth` int NULL DEFAULT NULL,
    `sixth_first` int NULL DEFAULT NULL,
    `sixth_second` int NULL DEFAULT NULL,
    `sixth_third` int NULL DEFAULT NULL,
    `sixth_fourth` int NULL DEFAULT NULL,
    `sixth_fifth` int NULL DEFAULT NULL,
    `sixth_sixth` int NULL DEFAULT NULL,
    `sixth_seventh` int NULL DEFAULT NULL,
    `sixth_eighth` int NULL DEFAULT NULL,
    `sixth_ninth` int NULL DEFAULT NULL,
    `sixth_tenth` int NULL DEFAULT NULL,
    `seventh_first` int NULL DEFAULT NULL,
    `seventh_second` int NULL DEFAULT NULL,
    `seventh_third` int NULL DEFAULT NULL,
    `seventh_fourth` int NULL DEFAULT NULL,
    `seventh_fifth` int NULL DEFAULT NULL,
    `seventh_sixth` int NULL DEFAULT NULL,
    `seventh_seventh` int NULL DEFAULT NULL,
    `seventh_eighth` int NULL DEFAULT NULL,
    `seventh_ninth` int NULL DEFAULT NULL,
    `seventh_tenth` int NULL DEFAULT NULL,
    `eighth_first` int NULL DEFAULT NULL,
    `eighth_second` int NULL DEFAULT NULL,
    `eighth_third` int NULL DEFAULT NULL,
    `eighth_fourth` int NULL DEFAULT NULL,
    `eighth_fifth` int NULL DEFAULT NULL,
    `eighth_sixth` int NULL DEFAULT NULL,
    `eighth_seventh` int NULL DEFAULT NULL,
    `eighth_eighth` int NULL DEFAULT NULL,
    `eighth_ninth` int NULL DEFAULT NULL,
    `eighth_tenth` int NULL DEFAULT NULL,
    `ninth_first` int NULL DEFAULT NULL,
    `ninth_second` int NULL DEFAULT NULL,
    `ninth_third` int NULL DEFAULT NULL,
    `ninth_fourth` int NULL DEFAULT NULL,
    `ninth_fifth` int NULL DEFAULT NULL,
    `ninth_sixth` int NULL DEFAULT NULL,
    `ninth_seventh` int NULL DEFAULT NULL,
    `ninth_eighth` int NULL DEFAULT NULL,
    `ninth_ninth` int NULL DEFAULT NULL,
    `ninth_tenth` int NULL DEFAULT NULL,
    `tenth_first` int NULL DEFAULT NULL,
    `tenth_second` int NULL DEFAULT NULL,
    `tenth_third` int NULL DEFAULT NULL,
    `tenth_fourth` int NULL DEFAULT NULL,
    `tenth_fifth` int NULL DEFAULT NULL,
    `tenth_sixth` int NULL DEFAULT NULL,
    `tenth_seventh` int NULL DEFAULT NULL,
    `tenth_eighth` int NULL DEFAULT NULL,
    `tenth_ninth` int NULL DEFAULT NULL,
    `tenth_tenth` int NULL DEFAULT NULL,
    `first_big` int NULL DEFAULT NULL,
    `first_small` int NULL DEFAULT NULL,
    `first_odd` int NULL DEFAULT NULL,
    `first_even` int NULL DEFAULT NULL,
    `first_dragon` int NULL DEFAULT NULL,
    `first_tiger` int NULL DEFAULT NULL,
    `second_big` int NULL DEFAULT NULL,
    `second_small` int NULL DEFAULT NULL,
    `second_odd` int NULL DEFAULT NULL,
    `second_even` int NULL DEFAULT NULL,
    `second_dragon` int NULL DEFAULT NULL,
    `second_tiger` int NULL DEFAULT NULL,
    `third_big` int NULL DEFAULT NULL,
    `third_small` int NULL DEFAULT NULL,
    `third_odd` int NULL DEFAULT NULL,
    `third_even` int NULL DEFAULT NULL,
    `third_dragon` int NULL DEFAULT NULL,
    `third_tiger` int NULL DEFAULT NULL,
    `fourth_big` int NULL DEFAULT NULL,
    `fourth_small` int NULL DEFAULT NULL,
    `fourth_odd` int NULL DEFAULT NULL,
    `fourth_even` int NULL DEFAULT NULL,
    `fourth_dragon` int NULL DEFAULT NULL,
    `fourth_tiger` int NULL DEFAULT NULL,
    `fifth_big` int NULL DEFAULT NULL,
    `fifth_small` int NULL DEFAULT NULL,
    `fifth_odd` int NULL DEFAULT NULL,
    `fifth_even` int NULL DEFAULT NULL,
    `fifth_dragon` int NULL DEFAULT NULL,
    `fifth_tiger` int NULL DEFAULT NULL,
    `sixth_big` int NULL DEFAULT NULL,
    `sixth_small` int NULL DEFAULT NULL,
    `sixth_odd` int NULL DEFAULT NULL,
    `sixth_even` int NULL DEFAULT NULL,
    `seventh_big` int NULL DEFAULT NULL,
    `seventh_small` int NULL DEFAULT NULL,
    `seventh_odd` int NULL DEFAULT NULL,
    `seventh_even` int NULL DEFAULT NULL,
    `eighth_big` int NULL DEFAULT NULL,
    `eighth_small` int NULL DEFAULT NULL,
    `eighth_odd` int NULL DEFAULT NULL,
    `eighth_even` int NULL DEFAULT NULL,
    `ninth_big` int NULL DEFAULT NULL,
    `ninth_small` int NULL DEFAULT NULL,
    `ninth_odd` int NULL DEFAULT NULL,
    `ninth_even` int NULL DEFAULT NULL,
    `tenth_big` int NULL DEFAULT NULL,
    `tenth_small` int NULL DEFAULT NULL,
    `tenth_odd` int NULL DEFAULT NULL,
    `tenth_even` int NULL DEFAULT NULL,
    `top_big` int NULL DEFAULT NULL,
    `top_small` int NULL DEFAULT NULL,
    `top_odd` int NULL DEFAULT NULL,
    `top_even` int NULL DEFAULT NULL,
    PRIMARY KEY (`eid`) USING BTREE,
    INDEX `long_dragon_race_id_FK`(`race_id`) USING BTREE,
    CONSTRAINT `long_dragon_race_id_FK` FOREIGN KEY (`race_id`) REFERENCES `fast_car` (`eid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `fast_car_result`  (
    `eid` int NOT NULL AUTO_INCREMENT COMMENT '自增键',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
    `race_id` int NOT NULL COMMENT '比赛id',
    `sum3` int NULL DEFAULT NULL COMMENT '冠亚和3',
    `sum4` int NULL DEFAULT NULL COMMENT '冠亚和4',
    `sum5` int NULL DEFAULT NULL COMMENT '冠亚和5',
    `sum6` int NULL DEFAULT NULL COMMENT '冠亚和6',
    `sum7` int NULL DEFAULT NULL COMMENT '冠亚和7',
    `sum8` int NULL DEFAULT NULL COMMENT '冠亚和8',
    `sum9` int NULL DEFAULT NULL COMMENT '冠亚和9',
    `sum10` int NULL DEFAULT NULL COMMENT '冠亚和10',
    `sum11` int NULL DEFAULT NULL COMMENT '冠亚和11',
    `sum12` int NULL DEFAULT NULL COMMENT '冠亚和12',
    `sum13` int NULL DEFAULT NULL COMMENT '冠亚和13',
    `sum14` int NULL DEFAULT NULL COMMENT '冠亚和14',
    `sum15` int NULL DEFAULT NULL COMMENT '冠亚和15',
    `sum16` int NULL DEFAULT NULL COMMENT '冠亚和16',
    `sum17` int NULL DEFAULT NULL COMMENT '冠亚和17',
    `sum18` int NULL DEFAULT NULL COMMENT '冠亚和18',
    `sum19` int NULL DEFAULT NULL COMMENT '冠亚和19',
    `first_first` int NULL DEFAULT NULL,
    `first_second` int NULL DEFAULT NULL,
    `first_third` int NULL DEFAULT NULL,
    `first_fourth` int NULL DEFAULT NULL,
    `first_fifth` int NULL DEFAULT NULL,
    `first_sixth` int NULL DEFAULT NULL,
    `first_seventh` int NULL DEFAULT NULL,
    `first_eighth` int NULL DEFAULT NULL,
    `first_ninth` int NULL DEFAULT NULL,
    `first_tenth` int NULL DEFAULT NULL,
    `second_first` int NULL DEFAULT NULL,
    `second_second` int NULL DEFAULT NULL,
    `second_third` int NULL DEFAULT NULL,
    `second_fourth` int NULL DEFAULT NULL,
    `second_fifth` int NULL DEFAULT NULL,
    `second_sixth` int NULL DEFAULT NULL,
    `second_seventh` int NULL DEFAULT NULL,
    `second_eighth` int NULL DEFAULT NULL,
    `second_ninth` int NULL DEFAULT NULL,
    `second_tenth` int NULL DEFAULT NULL,
    `third_first` int NULL DEFAULT NULL,
    `third_second` int NULL DEFAULT NULL,
    `third_third` int NULL DEFAULT NULL,
    `third_fourth` int NULL DEFAULT NULL,
    `third_fifth` int NULL DEFAULT NULL,
    `third_sixth` int NULL DEFAULT NULL,
    `third_seventh` int NULL DEFAULT NULL,
    `third_eighth` int NULL DEFAULT NULL,
    `third_ninth` int NULL DEFAULT NULL,
    `third_tenth` int NULL DEFAULT NULL,
    `fourth_first` int NULL DEFAULT NULL,
    `fourth_second` int NULL DEFAULT NULL,
    `fourth_third` int NULL DEFAULT NULL,
    `fourth_fourth` int NULL DEFAULT NULL,
    `fourth_fifth` int NULL DEFAULT NULL,
    `fourth_sixth` int NULL DEFAULT NULL,
    `fourth_seventh` int NULL DEFAULT NULL,
    `fourth_eighth` int NULL DEFAULT NULL,
    `fourth_ninth` int NULL DEFAULT NULL,
    `fourth_tenth` int NULL DEFAULT NULL,
    `fifth_first` int NULL DEFAULT NULL,
    `fifth_second` int NULL DEFAULT NULL,
    `fifth_third` int NULL DEFAULT NULL,
    `fifth_fourth` int NULL DEFAULT NULL,
    `fifth_fifth` int NULL DEFAULT NULL,
    `fifth_sixth` int NULL DEFAULT NULL,
    `fifth_seventh` int NULL DEFAULT NULL,
    `fifth_eighth` int NULL DEFAULT NULL,
    `fifth_ninth` int NULL DEFAULT NULL,
    `fifth_tenth` int NULL DEFAULT NULL,
    `sixth_first` int NULL DEFAULT NULL,
    `sixth_second` int NULL DEFAULT NULL,
    `sixth_third` int NULL DEFAULT NULL,
    `sixth_fourth` int NULL DEFAULT NULL,
    `sixth_fifth` int NULL DEFAULT NULL,
    `sixth_sixth` int NULL DEFAULT NULL,
    `sixth_seventh` int NULL DEFAULT NULL,
    `sixth_eighth` int NULL DEFAULT NULL,
    `sixth_ninth` int NULL DEFAULT NULL,
    `sixth_tenth` int NULL DEFAULT NULL,
    `seventh_first` int NULL DEFAULT NULL,
    `seventh_second` int NULL DEFAULT NULL,
    `seventh_third` int NULL DEFAULT NULL,
    `seventh_fourth` int NULL DEFAULT NULL,
    `seventh_fifth` int NULL DEFAULT NULL,
    `seventh_sixth` int NULL DEFAULT NULL,
    `seventh_seventh` int NULL DEFAULT NULL,
    `seventh_eighth` int NULL DEFAULT NULL,
    `seventh_ninth` int NULL DEFAULT NULL,
    `seventh_tenth` int NULL DEFAULT NULL,
    `eighth_first` int NULL DEFAULT NULL,
    `eighth_second` int NULL DEFAULT NULL,
    `eighth_third` int NULL DEFAULT NULL,
    `eighth_fourth` int NULL DEFAULT NULL,
    `eighth_fifth` int NULL DEFAULT NULL,
    `eighth_sixth` int NULL DEFAULT NULL,
    `eighth_seventh` int NULL DEFAULT NULL,
    `eighth_eighth` int NULL DEFAULT NULL,
    `eighth_ninth` int NULL DEFAULT NULL,
    `eighth_tenth` int NULL DEFAULT NULL,
    `ninth_first` int NULL DEFAULT NULL,
    `ninth_second` int NULL DEFAULT NULL,
    `ninth_third` int NULL DEFAULT NULL,
    `ninth_fourth` int NULL DEFAULT NULL,
    `ninth_fifth` int NULL DEFAULT NULL,
    `ninth_sixth` int NULL DEFAULT NULL,
    `ninth_seventh` int NULL DEFAULT NULL,
    `ninth_eighth` int NULL DEFAULT NULL,
    `ninth_ninth` int NULL DEFAULT NULL,
    `ninth_tenth` int NULL DEFAULT NULL,
    `tenth_first` int NULL DEFAULT NULL,
    `tenth_second` int NULL DEFAULT NULL,
    `tenth_third` int NULL DEFAULT NULL,
    `tenth_fourth` int NULL DEFAULT NULL,
    `tenth_fifth` int NULL DEFAULT NULL,
    `tenth_sixth` int NULL DEFAULT NULL,
    `tenth_seventh` int NULL DEFAULT NULL,
    `tenth_eighth` int NULL DEFAULT NULL,
    `tenth_ninth` int NULL DEFAULT NULL,
    `tenth_tenth` int NULL DEFAULT NULL,
    `first_big` int NULL DEFAULT NULL,
    `first_small` int NULL DEFAULT NULL,
    `first_odd` int NULL DEFAULT NULL,
    `first_even` int NULL DEFAULT NULL,
    `first_dragon` int NULL DEFAULT NULL,
    `first_tiger` int NULL DEFAULT NULL,
    `second_big` int NULL DEFAULT NULL,
    `second_small` int NULL DEFAULT NULL,
    `second_odd` int NULL DEFAULT NULL,
    `second_even` int NULL DEFAULT NULL,
    `second_dragon` int NULL DEFAULT NULL,
    `second_tiger` int NULL DEFAULT NULL,
    `third_big` int NULL DEFAULT NULL,
    `third_small` int NULL DEFAULT NULL,
    `third_odd` int NULL DEFAULT NULL,
    `third_even` int NULL DEFAULT NULL,
    `third_dragon` int NULL DEFAULT NULL,
    `third_tiger` int NULL DEFAULT NULL,
    `fourth_big` int NULL DEFAULT NULL,
    `fourth_small` int NULL DEFAULT NULL,
    `fourth_odd` int NULL DEFAULT NULL,
    `fourth_even` int NULL DEFAULT NULL,
    `fourth_dragon` int NULL DEFAULT NULL,
    `fourth_tiger` int NULL DEFAULT NULL,
    `fifth_big` int NULL DEFAULT NULL,
    `fifth_small` int NULL DEFAULT NULL,
    `fifth_odd` int NULL DEFAULT NULL,
    `fifth_even` int NULL DEFAULT NULL,
    `fifth_dragon` int NULL DEFAULT NULL,
    `fifth_tiger` int NULL DEFAULT NULL,
    `sixth_big` int NULL DEFAULT NULL,
    `sixth_small` int NULL DEFAULT NULL,
    `sixth_odd` int NULL DEFAULT NULL,
    `sixth_even` int NULL DEFAULT NULL,
    `seventh_big` int NULL DEFAULT NULL,
    `seventh_small` int NULL DEFAULT NULL,
    `seventh_odd` int NULL DEFAULT NULL,
    `seventh_even` int NULL DEFAULT NULL,
    `eighth_big` int NULL DEFAULT NULL,
    `eighth_small` int NULL DEFAULT NULL,
    `eighth_odd` int NULL DEFAULT NULL,
    `eighth_even` int NULL DEFAULT NULL,
    `ninth_big` int NULL DEFAULT NULL,
    `ninth_small` int NULL DEFAULT NULL,
    `ninth_odd` int NULL DEFAULT NULL,
    `ninth_even` int NULL DEFAULT NULL,
    `tenth_big` int NULL DEFAULT NULL,
    `tenth_small` int NULL DEFAULT NULL,
    `tenth_odd` int NULL DEFAULT NULL,
    `tenth_even` int NULL DEFAULT NULL,
    `top_big` int NULL DEFAULT NULL,
    `top_small` int NULL DEFAULT NULL,
    `top_odd` int NULL DEFAULT NULL,
    `top_even` int NULL DEFAULT NULL,
    PRIMARY KEY (`eid`) USING BTREE,
    INDEX `fast_car_result_race_id_FK`(`race_id`) USING BTREE,
    CONSTRAINT `fast_car_result_race_id_FK` FOREIGN KEY (`race_id`) REFERENCES `fast_car` (`eid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;