/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50172
Source Host           : localhost:3306
Source Database       : sign

Target Server Type    : MYSQL
Target Server Version : 50172
File Encoding         : 65001

Date: 2018-09-29 16:56:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `date` timestamp NULL DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `message` int(11) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '2018-09-29 00:00:00', '1', null);
INSERT INTO `record` VALUES ('2', '2018-09-29 14:49:09', '1', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `username` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'aaa', 'aaa', '');
INSERT INTO `user` VALUES ('3', 'bbb', 'bbb', '李四');
INSERT INTO `user` VALUES ('4', 'ccc', 'c', 'c');
INSERT INTO `user` VALUES ('5', 'ddd', 'ddd', 'ddd');
INSERT INTO `user` VALUES ('6', 'eee', 'eee', '王五');
