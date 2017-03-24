/*
SQLyog v10.2 
MySQL - 5.6.27 : Database - snna
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`snna` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `snna`;

/*Table structure for table `authorized` */

DROP TABLE IF EXISTS `authorized`;

CREATE TABLE `authorized` (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '授权ID 自增长',
  `deviceId` int(11) NOT NULL COMMENT '设备ID',
  `buserId` int(11) NOT NULL COMMENT '设备所属用户ID',
  `auserId` int(11) NOT NULL COMMENT '被授权用户ID',
  `note` text COLLATE utf8_bin COMMENT '备注',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `authorized` */

insert  into `authorized`(`aid`,`deviceId`,`buserId`,`auserId`,`note`) values (9,77,88,99,'给99用户授权'),(10,11,22,33,'给33用户授权'),(11,44,55,66,'给66用户授权'),(12,12,21,31,'给31用户授权');

/*Table structure for table `deviceclass` */

DROP TABLE IF EXISTS `deviceclass`;

CREATE TABLE `deviceclass` (
  `dcld` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备类ID',
  `dcName` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '设备名称',
  `description` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '设备描述',
  `note` text COLLATE utf8_bin COMMENT '备注',
  PRIMARY KEY (`dcld`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `deviceclass` */

/*Table structure for table `deviceinfo` */

DROP TABLE IF EXISTS `deviceinfo`;

CREATE TABLE `deviceinfo` (
  `deviceId` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `dcld` int(11) NOT NULL COMMENT '设备类型（设备分类ID）',
  `dName` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '设备名称',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `fVersion` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '固件版本',
  `hVersion` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '硬件版本',
  `mac` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '设备唯一标识（MAC）',
  `note` text COLLATE utf8_bin COMMENT '备注',
  PRIMARY KEY (`deviceId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `deviceinfo` */

insert  into `deviceinfo`(`deviceId`,`dcld`,`dName`,`userId`,`fVersion`,`hVersion`,`mac`,`note`) values (1,1000,'测试',1,'XXXXXXXX','YYYYYYY','fc8e3022d4ca44aaa522398237ce8082',NULL),(2,1001,'Test',1,'AAAAAA','BBBBBBBB','fc8e3022d4ca44aaa522398237ce1998',NULL),(3,1002,'AATest',1,'CCCCDFFF','DDDEEQDFDF','feee3022d4ca44aaa522398237c12998',NULL),(4,1111,'111112',1,'YYYYYYYY','IIIIIIIIII','XVGGDAFUAYFS126','awqe'),(5,2222,'11dddd2',1,'GGGGGG','XDSSDSDF','OIUIGH!KUE','awqe'),(6,333333,'11d9999dd2',2,'PPPPPPP','LPKPKPKPKP','CUOIU(*(Y(111','adfsdfasdf');

/*Table structure for table `deviceonline` */

DROP TABLE IF EXISTS `deviceonline`;

CREATE TABLE `deviceonline` (
  `doId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `deviceId` int(11) NOT NULL COMMENT '设备ID',
  `isOnline` int(1) NOT NULL DEFAULT '0' COMMENT '0为不在线 1为在线',
  `note` text COLLATE utf8_bin COMMENT '备注',
  `isOpen` int(1) DEFAULT '0' COMMENT '0为关闭状态，1为打开状态',
  PRIMARY KEY (`doId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `deviceonline` */

insert  into `deviceonline`(`doId`,`deviceId`,`isOnline`,`note`,`isOpen`) values (1,1,0,NULL,1),(3,3,1,'jiangduxi',0),(4,2,1,'jiangduxi2',0),(5,4,1,'jiangduxi4',0);

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID自增',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `title` varchar(80) COLLATE utf8_bin NOT NULL COMMENT '问题标题',
  `content` text COLLATE utf8_bin COMMENT '问题内容',
  `note` text COLLATE utf8_bin COMMENT '备注',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `feedback` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `roleType` int(11) NOT NULL COMMENT '角色类型',
  `description` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '角色描述',
  `note` text COLLATE utf8_bin COMMENT '备注',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `role` */

/*Table structure for table `scheduledtask` */

DROP TABLE IF EXISTS `scheduledtask`;

CREATE TABLE `scheduledtask` (
  `sid` int(11) DEFAULT NULL,
  `deviceId` int(11) DEFAULT NULL,
  `taskTime` varchar(192) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `setTime` date DEFAULT NULL,
  `note` blob,
  `isActive` tinyint(1) DEFAULT NULL,
  `message` varchar(48) DEFAULT NULL,
  `mac` varchar(192) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `scheduledtask` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID主键，自增',
  `account` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `roleId` int(11) NOT NULL COMMENT '角色ID',
  `note` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `activate` int(2) DEFAULT '0',
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_user` */

insert  into `t_user`(`userId`,`account`,`password`,`roleId`,`note`) values (1,'p256225','123456',2,NULL);

/*Table structure for table `t_userinfo` */

DROP TABLE IF EXISTS `t_userinfo`;

CREATE TABLE `t_userinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `nickName` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  `sex` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '性别： 1：男 0 女',
  `img` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '用户头像存放路径',
  `url` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '域名URL',
  `mphone` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '移动电话号码',
  `tPhone` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '固定电话',
  `email` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `address` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `reTime` date DEFAULT NULL COMMENT '注册日期',
  `note` text COLLATE utf8_bin COMMENT '备注',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_userinfo` */

insert  into `t_userinfo`(`Id`,`userId`,`nickName`,`sex`,`img`,`url`,`mphone`,`tPhone`,`email`,`address`,`reTime`,`note`) values (1,1,NULL,'0',NULL,NULL,'13698521477',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `scheduledId` int(11) NOT NULL COMMENT '排程ID',
  `deviceId` int(11) NOT NULL COMMENT '设备ID',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `task` */

insert  into `task`(`Id`,`scheduledId`,`deviceId`) values (1,1,1),(2,1,2),(3,1,3),(4,2,1),(5,2,3);

/*Table structure for table `upgrade` */

DROP TABLE IF EXISTS `upgrade`;

CREATE TABLE `upgrade` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID自增',
  `versionCode` int(11) NOT NULL COMMENT '当前APP版本',
  `versionName` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'app版本名称',
  `filePath` text COLLATE utf8_bin COMMENT 'APP下载路径',
  `description` text COLLATE utf8_bin COMMENT '描述',
  `note` text COLLATE utf8_bin COMMENT '备注',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `upgrade` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
