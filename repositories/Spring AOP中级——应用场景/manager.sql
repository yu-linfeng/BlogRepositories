/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : manager

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 10/31/2017 22:40:39 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'yu', '19'), ('2', 'yulinfeng', '23'), ('4', 'yulinfeng', '23'), ('5', 'yulinfeng', '23'), ('6', 'yulinfeng', '23'), ('7', 'yulinfeng', '23'), ('8', 'kevin', '23'), ('9', 'tony', '99'), ('10', 'kevin', '23');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
