CREATE TABLE user_account (
                              `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY  COMMENT '用户ID',
                              `account` varchar(15) NOT NULL COMMENT '手机号码（登录时作为username使用）',
                              `password` varchar(64) NOT NULL COMMENT '用户密码（sha256加密）'
);

ALTER TABLE user_account ADD COLUMN real_name VARCHAR(50) NULL DEFAULT "";
UPDATE user_account SET real_name = "test";

CREATE TABLE building_info (
                               `building_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '楼栋id',
                               `name` VARCHAR(10) NOT NULL COMMENT '楼栋名称',
                               `address` VARCHAR(100) COMMENT '楼栋地址',
                               `owner_id` int(10) NOT NULL COMMENT '房东id, 即userId',
                               `water_bill` FLOAT DEFAULT 0.0 COMMENT '水费',
                               `electric_bill` FLOAT DEFAULT 0.0 COMMENT '电费',
                               `property_fee` FLOAT DEFAULT 0.0 COMMENT '管理费',
                               `description` VARCHAR(100) COMMENT '描述'
);

CREATE TABLE room_info (
                           `room_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '房间id',
                           `name` VARCHAR(10) NOT NULL COMMENT '楼栋名称',
                           `rent` FLOAT DEFAULT 0 NOT NULL COMMENT '租金',
                           `area` FLOAT COMMENT '面积',
                           `description` VARCHAR(100) COMMENT '描述'
)

CREATE TABLE building_room_ref (
                                   `ref_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '房间id',
                                   `building_id` int(10) UNSIGNED NOT NULL ,
                                   `room_id` int(10) UNSIGNED NOT NULL
);

ALTER TABLE building_info
    ADD COLUMN village_name VARCHAR(10) COMMENT "村名字",
ADD COLUMN region_name VARCHAR(10) COMMENT "区名字",
ADD COLUMN total_floow TINYINT COMMENT "总楼层",
ADD COLUMN elevator TINYINT COMMENT "是否带电梯, 0不带, 1带"

ALTER TABLE user_account
    ADD COLUMN `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
ADD COLUMN `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
ADD COLUMN `created_by` int(10) unsigned DEFAULT NULL COMMENT '记录创建人id',
ADD COLUMN `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
                                                                                              ADD COLUMN `updated_by` int(10) DEFAULT NULL COMMENT '记录更新人id'

ALTER TABLE building_info
    ADD COLUMN `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
ADD COLUMN `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
ADD COLUMN `created_by` int(10) unsigned DEFAULT NULL COMMENT '记录创建人id',
ADD COLUMN `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
                                                                                              ADD COLUMN `updated_by` int(10) DEFAULT NULL COMMENT '记录更新人id'

ALTER TABLE room_info
    ADD COLUMN `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
ADD COLUMN `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
ADD COLUMN `created_by` int(10) unsigned DEFAULT NULL COMMENT '记录创建人id',
ADD COLUMN `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
                                                                                              ADD COLUMN `updated_by` int(10) DEFAULT NULL COMMENT '记录更新人id'

ALTER TABLE building_room_ref
    ADD COLUMN `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
ADD COLUMN `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
ADD COLUMN `created_by` int(10) unsigned DEFAULT NULL COMMENT '记录创建人id',
ADD COLUMN `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
                                                                                              ADD COLUMN `updated_by` int(10) DEFAULT NULL COMMENT '记录更新人id'

-- `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（1：是，0：否）',
--   `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
--   `created_by` int(10) unsigned DEFAULT NULL COMMENT '记录创建人id',
--   `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
--   `updated_by` int(10) DEFAULT NULL COMMENT '记录更新人id',
















