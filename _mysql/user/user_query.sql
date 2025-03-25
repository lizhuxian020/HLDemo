CREATE TABLE user_account (
                              `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY  COMMENT '用户ID',
                              `account` varchar(15) NOT NULL COMMENT '手机号码（登录时作为username使用）',
                              `password` varchar(64) NOT NULL COMMENT '用户密码（sha256加密）'
);

ALTER TABLE user_account ADD COLUMN real_name VARCHAR(50) NULL DEFAULT "";

UPDATE user_account SET real_name = "test";