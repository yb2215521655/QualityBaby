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

 Date: 15/03/2019 19:48:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activity_information` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activity_start` datetime NULL DEFAULT NULL,
  `activity_end` datetime NULL DEFAULT NULL,
  `activity_people_number` tinyint(4) NULL DEFAULT NULL,
  `studio_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`activity_id`) USING BTREE,
  INDEX `Ref_10`(`studio_id`) USING BTREE,
  CONSTRAINT `Ref_10` FOREIGN KEY (`studio_id`) REFERENCES `studio` (`studio_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT,
  `open_Id` int(28) NOT NULL DEFAULT 0,
  `option_id` int(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`answer_id`) USING BTREE,
  INDEX `Ref_05`(`open_Id`) USING BTREE,
  INDEX `Ref_06`(`option_id`) USING BTREE,
  CONSTRAINT `Ref_05` FOREIGN KEY (`open_Id`) REFERENCES `user` (`open_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Ref_06` FOREIGN KEY (`option_id`) REFERENCES `option` (`option_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for aspect
-- ----------------------------
DROP TABLE IF EXISTS `aspect`;
CREATE TABLE `aspect`  (
  `aspect_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `aspect_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`aspect_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for aspect_detial
-- ----------------------------
DROP TABLE IF EXISTS `aspect_detial`;
CREATE TABLE `aspect_detial`  (
  `detial_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Сά',
  `detial_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Сά',
  `aspect_id` tinyint(4) NOT NULL DEFAULT 0 COMMENT 'Сά',
  PRIMARY KEY (`detial_id`) USING BTREE,
  INDEX `Ref_07`(`aspect_id`) USING BTREE,
  CONSTRAINT `Ref_07` FOREIGN KEY (`aspect_id`) REFERENCES `aspect` (`aspect_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_time` datetime NULL DEFAULT NULL,
  `comment_detial` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `comment_like` tinyint(4) NULL DEFAULT NULL,
  `comment_sender` int(28) NOT NULL DEFAULT 0,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `Ref_15`(`comment_sender`) USING BTREE,
  CONSTRAINT `Ref_15` FOREIGN KEY (`comment_sender`) REFERENCES `user` (`open_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for option
-- ----------------------------
DROP TABLE IF EXISTS `option`;
CREATE TABLE `option`  (
  `option_id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'ѡ',
  `option_detial` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ѡ',
  `option_order` tinyint(4) NULL DEFAULT NULL COMMENT 'ѡ',
  `question_id` int(20) NOT NULL DEFAULT 0 COMMENT 'ѡ',
  PRIMARY KEY (`option_id`) USING BTREE,
  INDEX `Ref_04`(`question_id`) USING BTREE,
  CONSTRAINT `Ref_04` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'ѡ' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `question_id` int(20) NOT NULL AUTO_INCREMENT,
  `question_detial` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `questionnaire_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`question_id`) USING BTREE,
  INDEX `Ref_03`(`questionnaire_id`) USING BTREE,
  CONSTRAINT `Ref_03` FOREIGN KEY (`questionnaire_id`) REFERENCES `questionnaire` (`questionnaire_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE `questionnaire`  (
  `questionnaire_id` int(11) NOT NULL AUTO_INCREMENT,
  `questionnaire_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `questionnaire_introduction` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`questionnaire_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for studio
-- ----------------------------
DROP TABLE IF EXISTS `studio`;
CREATE TABLE `studio`  (
  `studio_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studio_information` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`studio_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `open_Id` int(28) NOT NULL COMMENT '΢',
  `tell_number` int(11) NULL DEFAULT NULL,
  `class_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_gender` tinyint(1) NULL DEFAULT NULL COMMENT 'ѧ',
  `stu_id` int(10) NULL DEFAULT NULL COMMENT 'ѧ',
  PRIMARY KEY (`open_Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_and_activity
-- ----------------------------
DROP TABLE IF EXISTS `user_and_activity`;
CREATE TABLE `user_and_activity`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `activity_id` int(11) NOT NULL DEFAULT 0,
  `open_Id` int(28) NOT NULL DEFAULT 0,
  `join_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Ref_13`(`activity_id`) USING BTREE,
  INDEX `Ref_14`(`open_Id`) USING BTREE,
  CONSTRAINT `Ref_13` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Ref_14` FOREIGN KEY (`open_Id`) REFERENCES `user` (`open_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_and_aspect
-- ----------------------------
DROP TABLE IF EXISTS `user_and_aspect`;
CREATE TABLE `user_and_aspect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `detial_id` int(11) NOT NULL DEFAULT 0 COMMENT 'ά',
  `open_Id` int(28) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Ref_08`(`detial_id`) USING BTREE,
  INDEX `Ref_09`(`open_Id`) USING BTREE,
  CONSTRAINT `Ref_08` FOREIGN KEY (`detial_id`) REFERENCES `aspect_detial` (`detial_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Ref_09` FOREIGN KEY (`open_Id`) REFERENCES `user` (`open_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_and_studio
-- ----------------------------
DROP TABLE IF EXISTS `user_and_studio`;
CREATE TABLE `user_and_studio`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `studio_id` int(11) NOT NULL DEFAULT 0,
  `open_Id` int(28) NOT NULL DEFAULT 0,
  `join_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Ref_11`(`studio_id`) USING BTREE,
  INDEX `Ref_12`(`open_Id`) USING BTREE,
  CONSTRAINT `Ref_11` FOREIGN KEY (`studio_id`) REFERENCES `studio` (`studio_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Ref_12` FOREIGN KEY (`open_Id`) REFERENCES `user` (`open_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_and_tag
-- ----------------------------
DROP TABLE IF EXISTS `user_and_tag`;
CREATE TABLE `user_and_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open_Id` int(28) NOT NULL DEFAULT 0,
  `tag_id` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ref_1`(`open_Id`) USING BTREE,
  INDEX `ref_02`(`tag_id`) USING BTREE,
  CONSTRAINT `ref_1` FOREIGN KEY (`open_Id`) REFERENCES `user` (`open_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ref_02` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
