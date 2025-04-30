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

 Date: 30/04/2025 18:07:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for building_info
-- ----------------------------
DROP TABLE IF EXISTS `building_info`;
CREATE TABLE `building_info` (
  `building_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '楼栋id',
  `name` varchar(10) NOT NULL COMMENT '楼栋名称',
  `address` varchar(100) DEFAULT NULL COMMENT '楼栋地址',
  `owner_id` int NOT NULL COMMENT '房东id, 即userId',
  `water_bill` float DEFAULT '0' COMMENT '水费',
  `electric_bill` float DEFAULT '0' COMMENT '电费',
  `property_fee` float DEFAULT '0' COMMENT '管理费',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `village_name` varchar(10) DEFAULT NULL COMMENT '村名字',
  `region_name` varchar(10) DEFAULT NULL COMMENT '区名字',
  `total_floor` tinyint DEFAULT NULL COMMENT '总楼层',
  `elevator` tinyint DEFAULT NULL COMMENT '是否带电梯, 0不带, 1带',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `created_by` int unsigned DEFAULT NULL COMMENT '记录创建人id',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `updated_by` int DEFAULT NULL COMMENT '记录更新人id',
  PRIMARY KEY (`building_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of building_info
-- ----------------------------
BEGIN;
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (1, '1', '1栋', 1, 7, 1.5, 5, NULL, '横岭村', '一区', 8, 1, 0, '2025-04-23 15:32:17', NULL, NULL, NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (2, '22', '2栋', 0, 0, 0, 0, NULL, '横岭村', '一区', 0, 0, 1, '2025-04-24 18:11:24', NULL, '2025-04-28 18:14:40', NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (3, '床家', '3栋', 1, 7, 1.5, 5, NULL, '横岭村', '一区', 8, 1, 0, '2025-04-24 18:15:19', NULL, NULL, NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (4, '豪', '4栋', 1, 7, 1.5, 5, NULL, '横岭村', '一区', 8, 1, 0, '2025-04-24 18:15:31', NULL, NULL, NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (5, '游家', '6栋', 1, 7, 1.5, 5, NULL, '横岭村', '一区', 8, 1, 0, '2025-04-24 18:15:49', NULL, NULL, NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (6, '白家', '9栋', 1, 7, 1.5, 5, NULL, '横岭村', '一区', 8, 1, 0, '2025-04-24 18:16:03', NULL, NULL, NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (7, '鸟家', '11栋', 1, 7, 1.5, 5, NULL, '横岭村', '一区', 8, 1, 0, '2025-04-24 18:16:14', NULL, NULL, NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (8, '床家2', '12栋', 0, 0, 0, 0, NULL, '横岭村', '一区', 0, 0, 1, '2025-04-24 18:16:29', NULL, '2025-04-28 18:32:17', NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (9, '豪家2', '13栋', 1, 7, 1.5, 5, NULL, '横岭村', '一区', 8, 1, 0, '2025-04-24 18:16:41', NULL, NULL, NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (10, '菜家', '10栋', 1, 7, 1.5, 5, NULL, '横岭村', '一区', 8, 1, 0, '2025-04-24 18:16:53', NULL, NULL, NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (11, '贤家', '15栋', 1, 7, 1.5, 5, NULL, '横岭村', '一区', 8, 1, 0, '2025-04-24 18:17:07', NULL, NULL, NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (12, '无人', '19栋', 0, 0, 0, 0, NULL, '横岭村', '一区', 0, 0, 1, '2025-04-27 14:35:52', NULL, '2025-04-29 11:38:27', NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (13, '11栋', '11栋', 1, 7, 1.5, 5, NULL, '横岭村', '一区', 18, 0, 0, '2025-04-29 14:27:52', NULL, NULL, NULL);
INSERT INTO `building_info` (`building_id`, `name`, `address`, `owner_id`, `water_bill`, `electric_bill`, `property_fee`, `description`, `village_name`, `region_name`, `total_floor`, `elevator`, `is_deleted`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (14, '12栋', '12栋', 1, 7, 1.5, 5, '哈哈哈啊哈哈哈啊哈哈哈啊哈哈哈啊哈哈哈啊哈哈哈啊哈哈哈啊哈哈哈啊哈哈哈啊哈哈哈啊哈哈哈啊哈哈哈啊哈哈哈啊哈哈哈啊哈哈哈啊123', '横岭村', '一区', 8, 1, 0, '2025-04-29 14:28:13', NULL, '2025-04-29 14:28:29', NULL);
COMMIT;

-- ----------------------------
-- Table structure for building_room_ref
-- ----------------------------
DROP TABLE IF EXISTS `building_room_ref`;
CREATE TABLE `building_room_ref` (
  `ref_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '房间id',
  `building_id` int unsigned NOT NULL,
  `room_id` int unsigned NOT NULL,
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `created_by` int unsigned DEFAULT NULL COMMENT '记录创建人id',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `updated_by` int DEFAULT NULL COMMENT '记录更新人id',
  PRIMARY KEY (`ref_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of building_room_ref
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info` (
  `room_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '房间id',
  `name` varchar(10) NOT NULL COMMENT '楼栋名称',
  `rent` float NOT NULL DEFAULT '0' COMMENT '租金',
  `area` float DEFAULT NULL COMMENT '面积',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `created_by` int unsigned DEFAULT NULL COMMENT '记录创建人id',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `updated_by` int DEFAULT NULL COMMENT '记录更新人id',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of room_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `user_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `account` varchar(15) NOT NULL COMMENT '手机号码（登录时作为username使用）',
  `password` varchar(64) NOT NULL COMMENT '用户密码（sha256加密）',
  `real_name` varchar(50) DEFAULT '',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
  `created_by` int unsigned DEFAULT NULL COMMENT '记录创建人id',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `updated_by` int DEFAULT NULL COMMENT '记录更新人id',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=813707269 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user_account
-- ----------------------------
BEGIN;
INSERT INTO `user_account` (`user_id`, `account`, `password`, `real_name`, `created_at`, `is_deleted`, `created_by`, `updated_at`, `updated_by`) VALUES (1, '123', 'asdasd', 'test', '2025-03-26 15:13:43', 0, NULL, NULL, NULL);
INSERT INTO `user_account` (`user_id`, `account`, `password`, `real_name`, `created_at`, `is_deleted`, `created_by`, `updated_at`, `updated_by`) VALUES (251699201, '111', 'asdasd', 'hahah', '2025-04-29 18:21:52', 0, NULL, NULL, NULL);
INSERT INTO `user_account` (`user_id`, `account`, `password`, `real_name`, `created_at`, `is_deleted`, `created_by`, `updated_at`, `updated_by`) VALUES (813707266, '222', 'asdasd', '嘿嘿嘿', '2025-04-29 18:24:54', 0, NULL, NULL, NULL);
INSERT INTO `user_account` (`user_id`, `account`, `password`, `real_name`, `created_at`, `is_deleted`, `created_by`, `updated_at`, `updated_by`) VALUES (813707267, '333', 'asdasd', '哈哈哈', '2025-04-29 18:25:20', 0, NULL, NULL, NULL);
INSERT INTO `user_account` (`user_id`, `account`, `password`, `real_name`, `created_at`, `is_deleted`, `created_by`, `updated_at`, `updated_by`) VALUES (813707268, '5556', 'asdasd', '阿萨德', '2025-04-29 18:25:52', 0, NULL, '2025-04-29 18:28:46', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
