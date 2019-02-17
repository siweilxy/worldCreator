/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.9
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 192.168.1.9
 Source Database       : world

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : utf-8

 Date: 02/17/2019 13:43:51 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `galaxy`
-- ----------------------------
DROP TABLE IF EXISTS `galaxy`;
CREATE TABLE `galaxy` (
  `id` int(99) unsigned NOT NULL AUTO_INCREMENT,
  `x` float(99,0) DEFAULT NULL,
  `y` float(99,0) DEFAULT NULL,
  `up` varchar(255) DEFAULT NULL,
  `down` varchar(255) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `planet`
-- ----------------------------
DROP TABLE IF EXISTS `planet`;
CREATE TABLE `planet` (
  `id` int(99) unsigned NOT NULL AUTO_INCREMENT,
  `x` float DEFAULT NULL,
  `y` float DEFAULT NULL,
  `up` varchar(255) DEFAULT NULL,
  `down` varchar(255) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=801 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `sources`
-- ----------------------------
DROP TABLE IF EXISTS `sources`;
CREATE TABLE `sources` (
  `id` int(99) unsigned NOT NULL,
  `s1` int(255) unsigned DEFAULT NULL,
  `s2` int(255) unsigned DEFAULT NULL,
  `s3` int(255) unsigned DEFAULT NULL,
  `s4` int(255) unsigned DEFAULT NULL,
  `s5` int(255) unsigned DEFAULT NULL,
  `s6` int(255) unsigned DEFAULT NULL,
  `s7` int(255) unsigned DEFAULT NULL,
  `s8` int(255) unsigned DEFAULT NULL,
  `s9` int(255) unsigned DEFAULT NULL,
  `s10` int(255) unsigned DEFAULT NULL,
  `s11` int(255) unsigned DEFAULT NULL,
  `s12` int(255) unsigned DEFAULT NULL,
  `s13` int(255) unsigned DEFAULT NULL,
  `s14` int(255) unsigned DEFAULT NULL,
  `s15` int(255) unsigned DEFAULT NULL,
  `s16` int(255) unsigned DEFAULT NULL,
  `s17` int(255) unsigned DEFAULT NULL,
  `s18` int(255) unsigned DEFAULT NULL,
  `s19` int(255) unsigned DEFAULT NULL,
  `s20` int(255) unsigned DEFAULT NULL,
  `s21` int(255) unsigned DEFAULT NULL,
  `s22` int(255) unsigned DEFAULT NULL,
  `s23` int(255) unsigned DEFAULT NULL,
  `s24` int(255) unsigned DEFAULT NULL,
  `s25` int(255) DEFAULT NULL,
  `s26` int(255) unsigned DEFAULT NULL,
  `s27` int(255) unsigned DEFAULT NULL,
  `s28` int(255) unsigned DEFAULT NULL,
  `s29` int(255) unsigned DEFAULT NULL,
  `s30` int(255) unsigned DEFAULT NULL,
  `s31` int(255) unsigned DEFAULT NULL,
  `s32` int(255) unsigned DEFAULT NULL,
  `s33` int(255) unsigned DEFAULT NULL,
  `s34` int(255) unsigned DEFAULT NULL,
  `s35` int(255) unsigned DEFAULT NULL,
  `s36` int(255) unsigned DEFAULT NULL,
  `s37` int(255) unsigned DEFAULT NULL,
  `s38` int(255) unsigned DEFAULT NULL,
  `s39` int(255) unsigned DEFAULT NULL,
  `s40` int(255) unsigned DEFAULT NULL,
  `s41` int(255) unsigned DEFAULT NULL,
  `s42` int(255) unsigned DEFAULT NULL,
  `s43` int(255) unsigned DEFAULT NULL,
  `s44` int(255) unsigned DEFAULT NULL,
  `s45` int(255) unsigned DEFAULT NULL,
  `s46` int(255) unsigned DEFAULT NULL,
  `s47` int(255) unsigned DEFAULT NULL,
  `s48` int(255) unsigned DEFAULT NULL,
  `s49` int(255) unsigned DEFAULT NULL,
  `s50` int(255) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `space`
-- ----------------------------
DROP TABLE IF EXISTS `space`;
CREATE TABLE `space` (
  `x` float DEFAULT NULL,
  `y` float DEFAULT NULL,
  `id` int(99) unsigned NOT NULL AUTO_INCREMENT,
  `up` varchar(255) DEFAULT NULL,
  `down` varchar(255) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `height` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40648 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
