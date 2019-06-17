/*
Navicat MySQL Data Transfer

Source Server         : 123.207.10.237
Source Server Version : 50642
Source Host           : 123.207.10.237:3306
Source Database       : api_demo

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2019-06-16 23:55:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_course`
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '课程名称',
  `teacher` varchar(50) NOT NULL COMMENT '老师',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('47', 'java', '郭东山');
INSERT INTO `t_course` VALUES ('49', 'javaweb', '梁国业');
