/*
 Navicat Premium Data Transfer

 Source Server         : LZXTest
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 192.168.4.132:3306
 Source Schema         : hl_demo

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 19/03/2025 18:29:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `user_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `account` varchar(15) NOT NULL COMMENT '手机号码（登录时作为username使用）',
  `password` varchar(64) NOT NULL COMMENT '用户密码（sha256加密）',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user_account
-- ----------------------------
BEGIN;
INSERT INTO `user_account` (`user_id`, `account`, `password`) VALUES (1, '123', 'asdasd');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
