/*
 Navicat Premium Data Transfer

 Source Server         : 本机MySQL
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : huiapi_db

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 25/02/2024 13:44:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for interface_info
-- ----------------------------
DROP TABLE IF EXISTS `interface_info`;
CREATE TABLE `interface_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `url` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接口地址',
  `requestParams` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求参数',
  `responseHeader` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '响应头',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '接口状态（0-关闭，1-开启）',
  `method` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求类型',
  `userId` bigint(20) NOT NULL COMMENT '创建人',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `requestHeader` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求头',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '接口信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of interface_info
-- ----------------------------
INSERT INTO `interface_info` VALUES (1, '大声发', '实打实', 'http:ssss', NULL, 'sdd', 1, 'post', 1, '2023-12-26 09:52:30', '2024-01-22 15:30:33', 0, '111');
INSERT INTO `interface_info` VALUES (2, 'sdasd', 'aaaa', 'http:ssaaaasds', NULL, '2222', 0, 'get', 2, '2023-12-26 09:53:16', '2023-12-26 09:53:16', 0, 'sddd');
INSERT INTO `interface_info` VALUES (3, '小鹿接口', '测试测试', 'https://aaa', NULL, 'qqqqq', 0, 'GET', 1737739878882578433, '2024-01-11 17:20:05', '2024-01-11 21:35:20', 1, 'eqwe');
INSERT INTO `interface_info` VALUES (4, '啥啥啥', '三四十', 'localhost', NULL, '弟弟', 0, 'get', 1737739878882578433, '2024-01-11 21:35:51', '2024-01-11 21:35:51', 0, '啥啥啥');
INSERT INTO `interface_info` VALUES (5, 'abcd', 'aaa', 'localhost', NULL, 'aaaddd', 0, 'post', 1737739878882578433, '2024-01-12 10:45:10', '2024-01-12 15:33:45', 1, 'sdsa');
INSERT INTO `interface_info` VALUES (6, 'dasda', 'sdasd', 'asd', NULL, 'asda', 0, 'sadas', 1737739878882578433, '2024-01-12 15:43:06', '2024-01-12 15:43:06', 0, 'asd');
INSERT INTO `interface_info` VALUES (7, '测试接口', '阿巴巴', 'LOCALHOST', NULL, 'SSSS', 0, 'POST', 1737739878882578433, '2024-01-13 17:39:23', '2024-01-13 17:40:26', 0, 'SSS');
INSERT INTO `interface_info` VALUES (8, '猫娘接口', '小鹿专属', 'localhost', NULL, 'SSR', 0, 'POST', 1737739878882578433, '2024-01-13 17:40:01', '2024-01-13 17:40:01', 0, 'SSR');
INSERT INTO `interface_info` VALUES (9, 'getUsernameByPost', '获取用户名', 'http://localhost:7165/api/name/user', '[{\"name\": \"username\", \"type\": \"string\"}]', '{\"Content-Type\": \"application/json\"}', 1, 'POST', 1746428569809293314, '2024-01-14 15:14:02', '2024-01-21 00:14:47', 0, '{\"Content-Type\": \"application/json\"}');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '内容',
  `tags` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标签列表（json 数组）',
  `thumbNum` int(11) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `favourNum` int(11) NOT NULL DEFAULT 0 COMMENT '收藏数',
  `userId` bigint(20) NOT NULL COMMENT '创建用户 id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_userId`(`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '帖子' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------

-- ----------------------------
-- Table structure for post_favour
-- ----------------------------
DROP TABLE IF EXISTS `post_favour`;
CREATE TABLE `post_favour`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `postId` bigint(20) NOT NULL COMMENT '帖子 id',
  `userId` bigint(20) NOT NULL COMMENT '创建用户 id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_postId`(`postId`) USING BTREE,
  INDEX `idx_userId`(`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '帖子收藏' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post_favour
-- ----------------------------

-- ----------------------------
-- Table structure for post_thumb
-- ----------------------------
DROP TABLE IF EXISTS `post_thumb`;
CREATE TABLE `post_thumb`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `postId` bigint(20) NOT NULL COMMENT '帖子 id',
  `userId` bigint(20) NOT NULL COMMENT '创建用户 id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_postId`(`postId`) USING BTREE,
  INDEX `idx_userId`(`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '帖子点赞' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post_thumb
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userAccount` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账号',
  `userPassword` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `unionId` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '微信开放平台id',
  `mpOpenId` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '公众号openId',
  `userName` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `userAvatar` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像',
  `userProfile` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户简介',
  `userRole` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'user' COMMENT '用户角色：user/admin/ban',
  `accessKey` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'accessKey',
  `secretKey` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'secretKey',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_unionId`(`unionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1746428569809293315 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1746400100928946177, 'xiaolu', 'b0dd3697a192885d7c055db46155b26a', NULL, NULL, '小鹿', 'https://c-ssl.duitang.com/uploads/blog/202108/30/20210830211816_b5f35.jpg', NULL, 'user', '0e5dcf66fed6707491279dd8ddac4834', 'ac2c3b1971bd5c64cd97f45efbe457ee', '2024-01-22 14:37:52', '2024-01-14 13:13:25', 0);
INSERT INTO `user` VALUES (1746428569809293314, 'test', '7dc67d94096a417e32b45f4f0053a703', NULL, NULL, '测试', 'https://c-ssl.duitang.com/uploads/blog/202108/30/20210830211816_b5f35.jpg', NULL, 'admin', '9651f521a50af05dfdfc2f51e917b01d', '0f414809d3a26db6c8eea5bb54f56a9b', '2024-01-21 00:33:33', '2024-01-14 15:06:32', 0);

-- ----------------------------
-- Table structure for user_interface_info
-- ----------------------------
DROP TABLE IF EXISTS `user_interface_info`;
CREATE TABLE `user_interface_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userId` bigint(20) NOT NULL COMMENT '创建人 id',
  `interfaceInfoId` bigint(20) NOT NULL COMMENT '接口 id',
  `totalNum` int(11) NOT NULL DEFAULT 0 COMMENT '总调用次数',
  `leftNum` int(11) NOT NULL DEFAULT 0 COMMENT '剩余调用次数',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '接口状态（0-正常，1-禁用）',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户调用接口关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_interface_info
-- ----------------------------
INSERT INTO `user_interface_info` VALUES (1, 1746428569809293314, 9, 7, 993, 0, '2024-01-15 12:10:34', '2024-01-21 01:01:50', 0);
INSERT INTO `user_interface_info` VALUES (2, 1746400100928946177, 8, 3, 997, 0, '2024-01-22 13:02:22', '2024-01-22 13:04:13', 0);

SET FOREIGN_KEY_CHECKS = 1;
