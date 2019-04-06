/*
 Navicat MySQL Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : question

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 31/03/2019 19:00:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_information` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_start` datetime NOT NULL,
  `activity_end` datetime NOT NULL,
  `activity_people_number` int(8) NOT NULL,
  `studio_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`activity_id`) USING BTREE,
  INDEX `Ref_13`(`studio_id`) USING BTREE,
  CONSTRAINT `Ref_13` FOREIGN KEY (`studio_id`) REFERENCES `studio` (`studio_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (1, 'XXX', 'CCC', '2011-12-02 10:50:25', '2011-12-02 10:50:25', 22, 6);
INSERT INTO `activity` VALUES (3, '活动1', '活动1介绍', '2019-03-22 12:37:00', '2019-03-22 12:37:03', 22, 1);
INSERT INTO `activity` VALUES (4, '活动1', '活动1介绍', '2019-03-22 12:37:00', '2019-03-22 12:37:03', 22, 1);
INSERT INTO `activity` VALUES (5, '活动1', '活动1介绍', '2019-03-22 12:37:00', '2019-03-22 12:37:03', 22, 1);
INSERT INTO `activity` VALUES (6, '活动1', '活动1介绍', '2019-03-22 12:37:00', '2019-03-22 12:37:03', 22, 1);
INSERT INTO `activity` VALUES (7, '添加的新活动', '新活动没有介绍', '2011-12-02 10:50:25', '2011-12-02 10:50:25', 22, 1);
INSERT INTO `activity` VALUES (9, 'xxx', 'aaa', '2011-12-02 10:50:25', '2011-12-02 10:50:25', 22, 3);

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT,
  `answer_time` datetime NOT NULL,
  `option_id` int(11) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`answer_id`) USING BTREE,
  INDEX `Ref_09`(`option_id`) USING BTREE,
  INDEX `Ref_10`(`user_id`) USING BTREE,
  CONSTRAINT `Ref_09` FOREIGN KEY (`option_id`) REFERENCES `options` (`option_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Ref_10` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for aspect
-- ----------------------------
DROP TABLE IF EXISTS `aspect`;
CREATE TABLE `aspect`  (
  `aspect_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `aspect_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`aspect_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for aspect_detial
-- ----------------------------
DROP TABLE IF EXISTS `aspect_detial`;
CREATE TABLE `aspect_detial`  (
  `detial_id` int(11) NOT NULL AUTO_INCREMENT,
  `detiat_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `aspect_id` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`detial_id`) USING BTREE,
  INDEX `Ref_04`(`aspect_id`) USING BTREE,
  CONSTRAINT `Ref_04` FOREIGN KEY (`aspect_id`) REFERENCES `aspect` (`aspect_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_time` datetime NOT NULL,
  `comment_detial` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_like` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `comment_sender` int(11) NOT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `Ref_01`(`user_id`) USING BTREE,
  CONSTRAINT `Ref_01` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for options
-- ----------------------------
DROP TABLE IF EXISTS `options`;
CREATE TABLE `options`  (
  `option_id` int(11) NOT NULL,
  `option_detial` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `option_order` tinyint(2) NOT NULL,
  `question_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`option_id`) USING BTREE,
  INDEX `Ref_08`(`question_id`) USING BTREE,
  CONSTRAINT `Ref_08` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `questionnaire_id` int(11) NOT NULL DEFAULT 0,
  `question_id` int(11) NOT NULL,
  `question_detial` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`question_id`) USING BTREE,
  INDEX `Ref_07`(`questionnaire_id`) USING BTREE,
  INDEX `question_id`(`question_id`) USING BTREE,
  CONSTRAINT `Ref_07` FOREIGN KEY (`questionnaire_id`) REFERENCES `questionnaire` (`questionnaire_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE `questionnaire`  (
  `questionnaire_id` int(11) NOT NULL AUTO_INCREMENT,
  `questionnaire_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `questionnaire_instruction` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`questionnaire_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for studio
-- ----------------------------
DROP TABLE IF EXISTS `studio`;
CREATE TABLE `studio`  (
  `studio_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `studio_information` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `studio_people_number` int(8) NOT NULL,
  PRIMARY KEY (`studio_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of studio
-- ----------------------------
INSERT INTO `studio` VALUES (1, '工作室标题', '工作室介绍', 26);
INSERT INTO `studio` VALUES (3, '工作室标题2', '工作室介绍2', 100);
INSERT INTO `studio` VALUES (4, '工作室标题2', '工作室介绍2', 100);
INSERT INTO `studio` VALUES (5, '工作室标题2', '工作室介绍2', 100);
INSERT INTO `studio` VALUES (6, '工作室标题', '工作室介绍', 26);
INSERT INTO `studio` VALUES (7, '工作室标题', '工作室介绍', 0);
INSERT INTO `studio` VALUES (8, '工作室标题', '工作室介绍', 26);
INSERT INTO `studio` VALUES (9, '工作室标题', '工作室介绍', 26);
INSERT INTO `studio` VALUES (10, '工作室标题', '工作室介绍', 26);

-- ----------------------------
-- Table structure for studio_activity_list
-- ----------------------------
DROP TABLE IF EXISTS `studio_activity_list`;
CREATE TABLE `studio_activity_list`  (
  `studio_studio_id` int(11) NOT NULL,
  `activity_list_activity_id` int(11) NOT NULL,
  UNIQUE INDEX `UK_2uueoqoa4nkjkd546p97uv5vc`(`activity_list_activity_id`) USING BTREE,
  INDEX `FKbqbmc7a4y2ussegf4cu8apsc7`(`studio_studio_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(10) NOT NULL,
  `open_id` binary(28) NOT NULL,
  `tell_number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_gender` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  CONSTRAINT `FK7k9gq173s19lgyq78e4bk53vu` FOREIGN KEY (`user_id`) REFERENCES `user_and_activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 2147483647, 0x6F707862753533475A64426667644B66516351354459316744715F34, '15681910683', '物联1704', 1);

-- ----------------------------
-- Table structure for user_and_activity
-- ----------------------------
DROP TABLE IF EXISTS `user_and_activity`;
CREATE TABLE `user_and_activity`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `join_time` datetime NULL DEFAULT NULL,
  `activity_id` int(11) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Ref_14`(`activity_id`) USING BTREE,
  INDEX `Ref_15`(`user_id`) USING BTREE,
  CONSTRAINT `Ref_14` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Ref_15` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_and_activity
-- ----------------------------
INSERT INTO `user_and_activity` VALUES (1, '2019-03-23 16:33:15', 1, 1);
INSERT INTO `user_and_activity` VALUES (2, '2019-03-23 16:33:15', 3, 1);
INSERT INTO `user_and_activity` VALUES (3, '2019-03-23 16:33:15', 6, 1);
INSERT INTO `user_and_activity` VALUES (4, '2019-03-23 16:33:15', 1, 1);

-- ----------------------------
-- Table structure for user_and_aspect
-- ----------------------------
DROP TABLE IF EXISTS `user_and_aspect`;
CREATE TABLE `user_and_aspect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aspect_id` tinyint(4) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Ref_05`(`aspect_id`) USING BTREE,
  INDEX `Ref_06`(`user_id`) USING BTREE,
  CONSTRAINT `Ref_05` FOREIGN KEY (`aspect_id`) REFERENCES `aspect` (`aspect_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Ref_06` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_and_studio
-- ----------------------------
DROP TABLE IF EXISTS `user_and_studio`;
CREATE TABLE `user_and_studio`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `join_time` datetime NULL DEFAULT NULL,
  `studio_id` int(11) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Ref_11`(`studio_id`) USING BTREE,
  INDEX `Ref_12`(`user_id`) USING BTREE,
  CONSTRAINT `Ref_11` FOREIGN KEY (`studio_id`) REFERENCES `studio` (`studio_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Ref_12` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_and_studio
-- ----------------------------
INSERT INTO `user_and_studio` VALUES (1, '2019-03-23 17:54:36', 1, 1);
INSERT INTO `user_and_studio` VALUES (2, '2019-03-23 17:54:36', 3, 1);
INSERT INTO `user_and_studio` VALUES (3, '2019-03-23 17:54:36', 4, 1);
INSERT INTO `user_and_studio` VALUES (4, '2019-03-23 17:54:36', 5, 1);
INSERT INTO `user_and_studio` VALUES (5, '2019-03-23 17:54:36', 8, 1);
INSERT INTO `user_and_studio` VALUES (6, '2019-03-23 17:54:36', 7, 1);
INSERT INTO `user_and_studio` VALUES (7, '2019-03-23 17:54:36', 9, 1);
INSERT INTO `user_and_studio` VALUES (8, '2019-03-23 17:54:36', 10, 1);

-- ----------------------------
-- Table structure for user_and_tag
-- ----------------------------
DROP TABLE IF EXISTS `user_and_tag`;
CREATE TABLE `user_and_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `tag_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Ref_02`(`user_id`) USING BTREE,
  INDEX `Ref_03`(`tag_id`) USING BTREE,
  CONSTRAINT `Ref_02` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Ref_03` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
