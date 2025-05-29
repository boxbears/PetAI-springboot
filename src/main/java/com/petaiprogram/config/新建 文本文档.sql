-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: petai
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `icon` varchar(1000) DEFAULT NULL COMMENT '图标路径',
  `name` varchar(20) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='前台分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'icon/01.png','冰淇淋'),(2,'icon/02.png','拐杖'),(3,'icon/03.png','果子'),(4,'icon/04.png','礼盒'),(5,'icon/05.png','礼物'),(6,'icon/06.png','帽子'),(7,'icon/07.png','球'),(8,'icon/08.png','晚餐'),(9,'icon/09.png','雪帽');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `community`
--

DROP TABLE IF EXISTS `community`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community` (
  `id` int NOT NULL AUTO_INCREMENT,
  `com_ava` varchar(100) DEFAULT NULL,
  `com_name` varchar(10) DEFAULT NULL,
  `com_intro` varchar(1000) DEFAULT NULL,
  `titleContent` varchar(1000) DEFAULT NULL,
  `text` varchar(1000) DEFAULT NULL,
  `com_pic` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community`
--

LOCK TABLES `community` WRITE;
/*!40000 ALTER TABLE `community` DISABLE KEYS */;
INSERT INTO `community` VALUES (1,'https://c-ssl.duitang.com/uploads/item/201909/15/20190915154013_gmukm.jpg','张三','我是快乐的养狗人','领养狗狗，有意者私信','狗子一岁，身体健康，打过疫苗，希望找个对他好的下家','https://img.zcool.cn/community/012e285a1ea496a8012171323c6bf1.jpg@3000w_1l_0o_100sh.jpg,https://tse3-mm.cn.bing.net/th/id/OIP-C.FRZh6FryVcYvQa5KVRpUCwHaFj?rs=1&pid=ImgDetMain,https://tse4-mm.cn.bing.net/th/id/OIP-C.12MmFldI3GfBRH9xld_EogAAAA?rs=1&pid=ImgDetMain'),(2,'https://pic2.zhimg.com/50/v2-32a990ddbca062edf2a6f6d19607e209_hd.jpg?source=1940ef5c','李四','喜欢猫，更喜欢狗','今天遇见一个狗狗','今天在路上遇见一个狗狗，感觉好可爱，但是好大不敢摸，呜呜呜','https://tse4-mm.cn.bing.net/th/id/OIP-C.eXHNsASGfv-v4La9rKOv7AHaFj?rs=1&pid=ImgDetMain,https://ts1.cn.mm.bing.net/th/id/R-C.89f11cee59ee09e3a58a3ca2a18c9b0a?rik=CDxw22iHca3RWA&riu=http%3a%2f%2fwww.kuaipng.com%2fUploads%2fpic%2fw%2f2020%2f09-14%2f92046%2fwater_92046_698_879.1_.png&ehk=QT0utEhmXRRY1qSd0dxXr1OULsi4BSdKsor3paahHxs%3d&risl=&pid=ImgRaw&r=0,https://ts1.cn.mm.bing.net/th/id/R-C.be2711bf5dfa9c112401b07478461dca?rik=q7ZGPpxtB%2ffzsg&riu=http%3a%2f%2fpic.bizhi360.com%2fbpic%2f24%2f8424.jpg&ehk=qQkQ%2f%2fApI%2bPhK%2bLRTkHTYLfDCc0%2bYy6j1ATjBYWQlnA%3d&risl=&pid=ImgRaw&r=0,https://ts1.cn.mm.bing.net/th/id/R-C.a75a3b4eb1afc116279b7bcede27b887?rik=8l0dtG1%2feun1ug&riu=http%3a%2f%2fwww.baobeita.com%2fupload%2fimage%2fproduct%2f201412%2f10116103%2f0831de17-b5be-45fc-a48d-fca0750e8598-large.jpg&ehk=cCYbZX%2bH%2fajpH6JqKl7BfMIHymgg5WxoyNHyrHjgC9s%3d&risl=&pid=ImgRaw&r=0'),(3,'https://pic1.zhimg.com/v2-bfded6ae9ab73f8e422dfd6d20325d8c_r.jpg?source=1940ef5c','王五','喜欢狗','狗子叛逆','吐槽一下我家狗子，天天闹腾闹腾的，从早闹到晚','https://pic2.zhimg.com/v2-29a8e4397e46659c52776550ae4cdd78_r.jpg,https://ts1.cn.mm.bing.net/th/id/R-C.f5036a1b4f9e8482b93ea6453437f88d?rik=kYF%2bSNuPI98i4A&riu=http%3a%2f%2fwww.baobeita.com%2fupload%2fimage%2fproduct%2f201401%2f10087000%2ff64e32ec-2058-4b95-87a3-cf1ee5c2db6b-large.jpg&ehk=%2fvO0dIs2OxYE1XyKZeYge5bmXR85WalmkIbEMs5XLE4%3d&risl=&pid=ImgRaw&r=0,https://img1.pconline.com.cn/piclib/200902/05/batch/1/21808/1233825719734z402on4djk.jpg,https://img1.pconline.com.cn/piclib/200902/05/batch/1/21808/1233825719734l86go80u0p.jpg,https://img1.pconline.com.cn/piclib/200902/05/batch/1/21808/1233825719734gbvtlhpjsl.jpg');
/*!40000 ALTER TABLE `community` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guesslike`
--

DROP TABLE IF EXISTS `guesslike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guesslike` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(30) DEFAULT NULL COMMENT '食谱名称',
  `picture` varchar(1000) DEFAULT NULL COMMENT '图片',
  `text_dec` varchar(500) DEFAULT NULL COMMENT '菜谱描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guesslike`
--

LOCK TABLES `guesslike` WRITE;
/*!40000 ALTER TABLE `guesslike` DISABLE KEYS */;
INSERT INTO `guesslike` VALUES (1,'鸡肉饭','https://ts1.cn.mm.bing.net/th/id/R-C.63e4b0a881283cbd46f07e77c2bbd491?rik=vWq%2fKkimZ5n2XQ&riu=http%3a%2f%2fseopic.699pic.com%2fphoto%2f50014%2f5917.jpg_wh1200.jpg&ehk=KCX2DzgqaiIJnMJZUyFc%2btT9ILzKGslHE8oaSAKORdE%3d&risl=&pid=ImgRaw&r=0','1'),(2,'猪肉饭','https://img.zcool.cn/community/01bb075bbc92ada8012099c88f6d65.jpg@1280w_1l_2o_100sh.jpg','1'),(3,'牛肉饭','https://img.zcool.cn/community/0189d85c3c421aa80121fbb0284f6c.jpg@1280w_1l_2o_100sh.jpg','1'),(4,'虾仁饭','https://ts1.cn.mm.bing.net/th/id/R-C.23597d0f3aeae5478a96a3e12b592415?rik=Zpe%2bbRSZEZ%2fViA&riu=http%3a%2f%2fwww.deskcar.com%2fdesktop%2felse%2f20113900602%2f14.jpg&ehk=sr6Ql4Big52LkuwveNdLr7lVGrrIqXbpJsC0Bsl6Ktc%3d&risl=&pid=ImgRaw&r=0','1'),(5,'鱼肉饭','https://img.zcool.cn/community/018ce95a3a5640a801201a1ff00c83.jpg@1280w_1l_2o_100sh.jpg','1'),(6,'白米饭','https://img.zcool.cn/community/0142235b681b0ea801206a35a2db31.JPG@1280w_1l_2o_100sh.jpg','1'),(7,'稀饭','https://ts1.cn.mm.bing.net/th/id/R-C.802a0a8b66b9965de3fd49b33c970bea?rik=C%2fArDzfQPNA%2bVg&riu=http%3a%2f%2fseopic.699pic.com%2fphoto%2f50014%2f9021.jpg_wh1200.jpg&ehk=MTs%2biICdAdXvbOYNkToV9AsVYT1Z%2fkC9T3eH%2fCQSlq4%3d&risl=&pid=ImgRaw&r=0','1'),(8,'甜粥','https://img.zcool.cn/community/010c98554310e30000019ae9c151bf.jpg@1280w_1l_2o_100sh.jpg','1');
/*!40000 ALTER TABLE `guesslike` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `sex` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='人物表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'张三',14,'https://tse4-mm.cn.bing.net/th/id/OIP-C.dB3WhWCbbODt_6wFjxWBNQAAAA?pid=ImgDet&rs=1',1),(2,'李小四',0,'https://tse4-mm.cn.bing.net/th/id/OIP-C.M9Zpeh4-nn2dg9LrPJzdGgAAAA?pid=ImgDet&rs=1',0),(3,'王五',22,'https://tupian.qqw21.com/article/UploadPic/2020-3/202033121445481477.jpg',0),(4,'赵六',23,'https://img.zcool.cn/community/01795058158d43a84a0d304f64b44d.png@2o.png',1);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pethealthsupplements`
--

DROP TABLE IF EXISTS `pethealthsupplements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pethealthsupplements` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(10) DEFAULT NULL COMMENT '名称',
  `pic` varchar(1000) DEFAULT NULL COMMENT '图片链接',
  `text` varchar(1000) DEFAULT NULL COMMENT '文本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pethealthsupplements`
--

LOCK TABLES `pethealthsupplements` WRITE;
/*!40000 ALTER TABLE `pethealthsupplements` DISABLE KEYS */;
INSERT INTO `pethealthsupplements` VALUES (1,'鸡肉饭','https://ts1.cn.mm.bing.net/th/id/R-C.63e4b0a881283cbd46f07e77c2bbd491?rik=vWq%2fKkimZ5n2XQ&riu=http%3a%2f%2fseopic.699pic.com%2fphoto%2f50014%2f5917.jpg_wh1200.jpg&ehk=KCX2DzgqaiIJnMJZUyFc%2btT9ILzKGslHE8oaSAKORdE%3d&risl=&pid=ImgRaw&r=0','123'),(2,'猪肉饭','https://img.zcool.cn/community/01bb075bbc92ada8012099c88f6d65.jpg@1280w_1l_2o_100sh.jpg','123'),(3,'牛肉饭','https://img.zcool.cn/community/0189d85c3c421aa80121fbb0284f6c.jpg@1280w_1l_2o_100sh.jpg','123'),(4,'虾仁饭','https://ts1.cn.mm.bing.net/th/id/R-C.23597d0f3aeae5478a96a3e12b592415?rik=Zpe%2bbRSZEZ%2fViA&riu=http%3a%2f%2fwww.deskcar.com%2fdesktop%2felse%2f20113900602%2f14.jpg&ehk=sr6Ql4Big52LkuwveNdLr7lVGrrIqXbpJsC0Bsl6Ktc%3d&risl=&pid=ImgRaw&r=0','123'),(5,'鱼肉饭','https://img.zcool.cn/community/018ce95a3a5640a801201a1ff00c83.jpg@1280w_1l_2o_100sh.jpg','123'),(6,'1','https://ts1.cn.mm.bing.net/th/id/R-C.b3a7697d2793ba094a861d546c31190d?rik=NevOIW4XmkUuMA&riu=http%3a%2f%2fseopic.699pic.com%2fphoto%2f50069%2f5445.jpg_wh1200.jpg&ehk=wuLPicg%2b9wXz8QAwp%2fAVFBtJQ6loBUiVfQZu2bbZODA%3d&risl=&pid=ImgRaw&r=0','11'),(7,'2','https://img.zcool.cn/community/01b70e5b5ac3cca801215c8f1ae499.jpg%401280w_1l_2o_100sh.jpg','11'),(8,'1','https://img.zcool.cn/community/01152f5b7b72c6a801218d32035a1e.jpg@1280w_1l_2o_100sh.jpg','11'),(9,'1','https://tse1-mm.cn.bing.net/th/id/OIP-C.aYVrq9Jv5DQ-FSbQgcVh7QHaLo?w=980&h=1539&rs=1&pid=ImgDetMain','11');
/*!40000 ALTER TABLE `pethealthsupplements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `picture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `herfUrl` varchar(1000) DEFAULT NULL,
  `imgUrl` varchar(1000) DEFAULT NULL,
  `type` int DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES (1,'美食','https://img.zcool.cn/community/016c325543065e0000019ae909489a.jpg@3000w_1l_0o_100sh.jpg',1),(2,'运动','https://img2.pconline.com.cn/pconline/0707/13/1057264_070717dog18.jpg',1),(3,'电竞','https://img.zcool.cn/community/012e285a1ea496a8012171323c6bf1.jpg@3000w_1l_0o_100sh.jpg',1);
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommendedrecipes`
--

DROP TABLE IF EXISTS `recommendedrecipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommendedrecipes` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(10) DEFAULT NULL COMMENT '名称',
  `pic` varchar(1000) DEFAULT NULL COMMENT '图片链接',
  `text` varchar(1000) DEFAULT NULL COMMENT '文本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendedrecipes`
--

LOCK TABLES `recommendedrecipes` WRITE;
/*!40000 ALTER TABLE `recommendedrecipes` DISABLE KEYS */;
INSERT INTO `recommendedrecipes` VALUES (1,'1','https://ts1.cn.mm.bing.net/th/id/R-C.633901d07a3d18cdf6d58a0ccc74078d?rik=8evNNQvJj91%2bjg&riu=http%3a%2f%2fimg.hkwb.net%2fatt%2fsite2%2f20120308%2f633901d07a3d18cdf6d58a0ccc74078d.jpg&ehk=mupUGFlfxfEilMIkHoDFPVYnfR%2bSaF86fmgOkvvU8YM%3d&risl=&pid=ImgRaw&r=0','11'),(2,'2','https://ts1.cn.mm.bing.net/th/id/R-C.bd53096921883dc16d2d43ae9b13beb2?rik=hAVg5u2Bswf%2f6w&riu=http%3a%2f%2fdimg03.c-ctrip.com%2fimages%2ffd%2ftg%2fg1%2fM04%2fCB%2f99%2fCghzflWw7F2ATxCcABtxFWU_LNw686.jpg&ehk=O0khPGFITeE3EYpaMmGp%2fmoqaxywztOVmBqbiH6PV7c%3d&risl=&pid=ImgRaw&r=0','122'),(3,'3','https://tr-osdcp.qunarzz.com/tr-osd-tr-manager/img/01f38b12683bca66440c8e3b391c776b.jpg_r_720x400x95_7d37d0e9.jpg','33'),(4,'4','https://tr-osdcp.qunarzz.com/tr-osd-tr-manager/img/c325ac741827699bedfa681696edda38.jpg_r_720x400x95_792b82c0.jpg','44'),(5,'5','https://tse2-mm.cn.bing.net/th/id/OIP-C.pU0kUQbcRF9N7oFStePi_wHaEo?rs=1&pid=ImgDetMain','11'),(6,'7','https://img.zcool.cn/community/010c98554310e30000019ae9c151bf.jpg@3000w_1l_0o_100sh.jpg','11'),(7,'8','https://img.zcool.cn/community/018ce95a3a5640a801201a1ff00c83.jpg@2o.jpg','11');
/*!40000 ALTER TABLE `recommendedrecipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop` (
  `product_id` int NOT NULL COMMENT '商品所属分类id',
  `id` int NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `picture` varchar(1000) DEFAULT NULL,
  `shop_name` varchar(20) DEFAULT NULL COMMENT '商品名字',
  `shop_address` varchar(100) DEFAULT NULL,
  `shop_phonenumber` varchar(20) DEFAULT NULL COMMENT '商品联系电话',
  `product_desciption` varchar(1000) DEFAULT NULL COMMENT '商品介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (1,1,'https://ts1.cn.mm.bing.net/th/id/R-C.633901d07a3d18cdf6d58a0ccc74078d?rik=8evNNQvJj91%2bjg&riu=http%3a%2f%2fimg.hkwb.net%2fatt%2fsite2%2f20120308%2f633901d07a3d18cdf6d58a0ccc74078d.jpg&ehk=mupUGFlfxfEilMIkHoDFPVYnfR%2bSaF86fmgOkvvU8YM%3d&risl=&pid=ImgRaw&r=0','风情沿海-大理度假','四川省云南是大理白族自治州','+86-12313131',NULL),(1,2,'https://ts1.cn.mm.bing.net/th/id/R-C.bd53096921883dc16d2d43ae9b13beb2?rik=hAVg5u2Bswf%2f6w&riu=http%3a%2f%2fdimg03.c-ctrip.com%2fimages%2ffd%2ftg%2fg1%2fM04%2fCB%2f99%2fCghzflWw7F2ATxCcABtxFWU_LNw686.jpg&ehk=O0khPGFITeE3EYpaMmGp%2fmoqaxywztOVmBqbiH6PV7c%3d&risl=&pid=ImgRaw&r=0','醉美江南-姑苏情调','江苏省苏州市','+86-12331232',NULL),(1,5,'https://tr-osdcp.qunarzz.com/tr-osd-tr-manager/img/01f38b12683bca66440c8e3b391c776b.jpg_r_720x400x95_7d37d0e9.jpg','东郊记忆','四川省成都市','+86-13131444','四川的798，原来是成都东区的音乐公园，现在改造成文化创意基地'),(1,6,'https://tr-osdcp.qunarzz.com/tr-osd-tr-manager/img/c325ac741827699bedfa681696edda38.jpg_r_720x400x95_792b82c0.jpg','茂业中心','四川省成都市','+86-12365748','茂业中心等于视觉大片，新晋超人气出片地，拍照打卡圣地哦'),(1,7,'https://tr-osdcp.qunarzz.com/tr-osd-tr-space/img/cd419a66e353716ab14b1197ee09b41e.jpg_r_720x400x95_73a96d9e.jpg','方所书店','四川省成都市','+86-12365748','铺满行星轨迹的地面，像是一个独立于世的魔幻空间'),(1,8,'https://img1.qunarzz.com/travel/d7/1706/5c/36548b29a31afab5.jpg_r_720x400x95_5b62bf42.jpg','蜀风雅韵川剧馆','四川省成都市','+86-12365748','成都“蜀风雅韵”的川剧表演，是中国戏曲宝库中的一颗光彩照人的明珠'),(1,9,'https://tr-osdcp.qunarzz.com/tr-osd-tr-manager/img/f63cba3648be34706896f31dfa6a7ab7.jpg_r_720x400x95_fe6c32f4.jpg','文殊院','四川省成都市','+86-12365748','文殊院内供奉着大小300余尊佛像，其中有一尊缅甸玉佛，极其珍贵'),(1,10,'https://tr-osdcp.qunarzz.com/tr-osd-tr-manager/img/a77dd70f5d927e173d716f73641747b3.jpg_r_720x400x95_480549d3.jpg','锦里古街','四川省成都市','+86-12365748','锦里古街最成都最古老的街道之一，被誉“西蜀第一街”'),(1,11,'https://img1.qunarzz.com/travel/d2/1704/cc/ca5fa771f797bcb5.jpg_r_720x400x95_3efeea9a.jpg','杜甫草堂','四川省成都市','+86-12365748','保存最完好的杜甫遗迹，杜甫在此写240余篇佳作');
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-22 16:21:22
