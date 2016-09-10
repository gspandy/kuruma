SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `T_BILL`
-- ----------------------------
DROP TABLE IF EXISTS `T_BILL`;
CREATE TABLE `T_BILL` (
  `ID` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SUM` double DEFAULT NULL,
  `COMMENT` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CAR_ID` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `USER_ID` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `T_CAR`
-- ----------------------------
DROP TABLE IF EXISTS `T_CAR`;
CREATE TABLE `T_CAR` (
  `ID` varchar(32) NOT NULL COMMENT 'I',
  `NAME` varchar(40) DEFAULT NULL,
  `LICENCE` varchar(12) DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `USER_ID` varchar(32) NOT NULL,
  `CREATED_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `T_CAR`
-- ----------------------------
BEGIN;
INSERT INTO `T_CAR` VALUES ('3e21b083aff2ea3acdd9cf9df5a91142', '奥迪', '沪B6LC47', '奥迪A4L个性运动版2015款', '9e21b083aff2ea3acdd9cf9df5a91141', '2016-09-10 15:07:32');
COMMIT;

-- ----------------------------
--  Table structure for `T_USER`
-- ----------------------------
DROP TABLE IF EXISTS `T_USER`;
CREATE TABLE `T_USER` (
  `ID` varchar(32) NOT NULL COMMENT '数据ID',
  `NAME` varchar(100) NOT NULL COMMENT '名字',
  `GENDER` varchar(10) NOT NULL COMMENT '性别',
  `PASSWORD` varchar(32) NOT NULL COMMENT '密码',
  `REGISTER_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `T_USER`
-- ----------------------------
BEGIN;
INSERT INTO `T_USER` VALUES ('9e21b083aff2ea3acdd9cf9df5a91141', '应卓', 'MALE', '9e21b083aff2ea3acdd9cf9df5a91141', '2016-08-24 12:20:29');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
