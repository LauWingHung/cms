/*
Navicat MySQL Data Transfer

Source Server         : lau1yach
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : lau1yach

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2018-06-26 19:49:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `name` varchar(20) NOT NULL,
  `sex` char(2) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(40) DEFAULT NULL,
  `wechatid` varchar(40) DEFAULT NULL,
  `qqid` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`name`,`phone`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('可添加新联系人了', '', '0', '', '', '', '');
INSERT INTO `contact` VALUES ('奥术大师', '', '0', '13333333333', '', '', '');
INSERT INTO `contact` VALUES ('可添加新联系人了', '', '0', '13222222222', '', '', '');
INSERT INTO `contact` VALUES ('爱仕达多', '', '0', '12222222222', '', '', '');
INSERT INTO `contact` VALUES ('刘永鸿', '男', '23', '15622734832', '872395037@qq.com', 'LauGaDaiXiu', '872395037');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('刘永鸿', 'root');
