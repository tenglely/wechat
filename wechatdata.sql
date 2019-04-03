/*
 Navicat MySQL Data Transfer

 Source Server         : teng
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : wechatdata

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 01/04/2019 11:14:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attention
-- ----------------------------
DROP TABLE IF EXISTS `attention`;
CREATE TABLE `attention`  (
  `aid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `nid` int(10) NOT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ctype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `typeid` int(10) NOT NULL,
  `cdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for greens
-- ----------------------------
DROP TABLE IF EXISTS `greens`;
CREATE TABLE `greens`  (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gstyle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `glabel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gcover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ghits` int(10) NOT NULL,
  `gwriter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gneed` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of greens
-- ----------------------------
INSERT INTO `greens` VALUES (12, '炸排骨', '粤菜', '家常菜', '', 3, 'system', '2019-03-24 14:00:22', '<p>打</p>');
INSERT INTO `greens` VALUES (13, '蒜蓉蒸虾', '苏菜', '家常菜', '1231.jpg', 2, 'system', '2019-03-24 15:56:23', '<p><img src=\"http://localhost:8080/wechat_real/test/upload/image/20190327/1553687253449096273.jpg\" title=\"1553687253449096273.jpg\" alt=\"s113291_155365238539360.jpg\"/></p>');
INSERT INTO `greens` VALUES (14, '保存', '粤菜', '烧烤', '', 3, 'system', '2019-03-24 16:07:21', '<p>zc</p>');
INSERT INTO `greens` VALUES (16, '唐', '苏菜', '家常菜', '', 5, 'system', '2019-03-25 10:24:16', '<p>宣传</p>');
INSERT INTO `greens` VALUES (17, '走', '川菜', '烧烤', '', 6, 'system', '2019-03-25 10:24:25', '<p>辅导费</p>');
INSERT INTO `greens` VALUES (18, '防守打法', '浙菜', '西餐 烧烤', '', 0, 'system', '2019-03-25 21:32:50', '<p>大峡谷梵蒂冈</p>');
INSERT INTO `greens` VALUES (19, 'step', '鲁菜', '家常菜', '', 0, 'system', '2019-03-26 22:17:38', '<p>shfgjhasgjkaskjdbcxmznbmn部门在巴拿马最新版才能买自行车把毛主席不能出门在下半年出卖你&nbsp;</p><p>丝黛芬妮开始对你们查询，vmcxnvm,</p>');
INSERT INTO `greens` VALUES (20, '防守打法发送到', '川菜', '家常菜', '', 0, 'system', '2019-03-26 22:20:25', '<p>第三方</p>');
INSERT INTO `greens` VALUES (21, '让他一人头', '鲁菜', '甜点 ', '131.jpg', 0, 'system', '2019-03-28 09:28:45', '<p><img title=\"1553736523040040611.jpg\" alt=\"87.jpg\" src=\"http://localhost:8080/wechat_real/test/upload/image/20190328/1553736523040040611.jpg\"/>如同一条</p>');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `pid` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` int(10) NOT NULL,
  `pcontent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hits` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodnum` int(10) NOT NULL,
  `badnum` int(10) NOT NULL,
  `pdate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for step
-- ----------------------------
DROP TABLE IF EXISTS `step`;
CREATE TABLE `step`  (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `step` int(10) NOT NULL,
  `gid` int(11) NOT NULL,
  `voice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sdescribe` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `timing` int(10) NOT NULL,
  `sphoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of step
-- ----------------------------
INSERT INTO `step` VALUES (5, 1, 15, '空', 'vzvxzv', 0, '1120165-20170816195217834-1322829917.png');
INSERT INTO `step` VALUES (8, 1, 13, '空', '蒜末50克、葱花10克，虾300克开背去虾线', 4, 'n113291_154466745372251.jpg');
INSERT INTO `step` VALUES (9, 2, 13, '空', '锅中放入食用油5ML，倒入蒜末，大火爆香', 1, 'n113291_154466746698846.jpg');
INSERT INTO `step` VALUES (10, 1, 21, '空', 'cvnvnbvn', 0, '初音_01.jpg');

-- ----------------------------
-- Table structure for we_user
-- ----------------------------
DROP TABLE IF EXISTS `we_user`;
CREATE TABLE `we_user`  (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `purl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` int(5) NOT NULL,
  `uclass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of we_user
-- ----------------------------
INSERT INTO `we_user` VALUES (3, 'admin', '123', '84c6087.jpg', 1, '超级管理员', 'yes');
INSERT INTO `we_user` VALUES (5, 'cxz', '123', 'manager.jpg', 1, '管理员', 'yes');
INSERT INTO `we_user` VALUES (6, 'sdf', '123', 'manager.jpg', 1, '管理员', 'yes');
INSERT INTO `we_user` VALUES (7, '我是说', '123', 'manager.jpg', 1, '管理员', 'yes');
INSERT INTO `we_user` VALUES (8, 'a', '123', 'manager.jpg', 1, '用户', 'yes');
INSERT INTO `we_user` VALUES (9, 'testadmin', '123', 'manager.jpg', 1, '管理员', 'yes');

SET FOREIGN_KEY_CHECKS = 1;
