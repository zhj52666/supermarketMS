/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.26 : Database - smsdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`smsdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `smsdb`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `recommend` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`name`,`recommend`) values (11,'食品',97),(12,'日用品',90),(13,'饮品',100),(16,'化妆品',97);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL COMMENT '类别',
  `name` varchar(255) NOT NULL DEFAULT '',
  `yieldDate` datetime DEFAULT NULL COMMENT '生产日期',
  `manufacturers` varchar(255) NOT NULL DEFAULT '' COMMENT '生产工厂',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '进价',
  `stock` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '库存',
  `nowPrice` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '售价',
  `saleCount` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '销售量',
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `fk_product_category` (`cid`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`cid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`cid`,`name`,`yieldDate`,`manufacturers`,`price`,`stock`,`nowPrice`,`saleCount`,`createDate`) values (15,11,'饼干','2020-07-03 10:48:16','奥利奥','5.00',997,'7.00',3,'2020-07-13 09:31:32'),(16,12,'牙刷','2020-07-02 10:48:20','舒克','3.00',260,'6.00',40,'2020-07-13 09:31:32'),(17,12,'牙膏','2020-07-02 10:48:24','舒克','8.00',90,'16.00',410,'2020-07-13 09:31:32'),(18,13,'绿茶','2020-07-02 10:38:34','达利园','1.50',3797,'3.00',203,'2020-07-13 09:31:32'),(19,16,'口红','2020-02-05 00:00:00','迪奥','200.00',300,'399.00',0,'2020-07-13 10:33:50');

/*Table structure for table `sale` */

DROP TABLE IF EXISTS `sale`;

CREATE TABLE `sale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `saleCount` int(11) unsigned NOT NULL DEFAULT '0',
  `saleroom` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '销售额',
  `profit` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '利润',
  PRIMARY KEY (`id`),
  KEY `fk_sale_product` (`pid`),
  CONSTRAINT `fk_sale_product` FOREIGN KEY (`pid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `sale` */

insert  into `sale`(`id`,`pid`,`createDate`,`saleCount`,`saleroom`,`profit`) values (1,15,'2020-07-12 14:46:24',2,'14.00','4.00'),(16,15,'2020-07-12 16:46:49',1,'7.00','2.00'),(17,16,'2020-07-12 16:51:09',10,'60.00','30.00'),(18,17,'2020-07-12 16:53:30',10,'160.00','80.00'),(19,18,'2020-07-12 19:59:48',3,'9.00','4.50'),(20,16,'2020-07-12 22:17:41',10,'60.00','30.00'),(21,17,'2020-07-13 09:09:43',400,'6400.00','3200.00');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'LiHua','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
