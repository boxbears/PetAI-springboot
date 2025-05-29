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
  `concern` int DEFAULT NULL,
  `userId` int NOT NULL COMMENT '用户的ID',
  `choosePetId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community`
--

LOCK TABLES `community` WRITE;
/*!40000 ALTER TABLE `community` DISABLE KEYS */;
INSERT INTO `community` VALUES (1,'https://c-ssl.duitang.com/uploads/item/201909/15/20190915154013_gmukm.jpg','张三','我是快乐的养狗人','领养狗狗，有意者私信','狗子一岁，身体健康，打过疫苗，希望找个对他好的下家','https://img.zcool.cn/community/012e285a1ea496a8012171323c6bf1.jpg@3000w_1l_0o_100sh.jpg,https://tse3-mm.cn.bing.net/th/id/OIP-C.FRZh6FryVcYvQa5KVRpUCwHaFj?rs=1&pid=ImgDetMain,https://tse4-mm.cn.bing.net/th/id/OIP-C.12MmFldI3GfBRH9xld_EogAAAA?rs=1&pid=ImgDetMain',0,0,NULL),(2,'https://pic2.zhimg.com/50/v2-32a990ddbca062edf2a6f6d19607e209_hd.jpg?source=1940ef5c','李四','喜欢猫，更喜欢狗','今天遇见一个狗狗','今天在路上遇见一个狗狗，感觉好可爱，但是好大不敢摸，呜呜呜','https://tse4-mm.cn.bing.net/th/id/OIP-C.eXHNsASGfv-v4La9rKOv7AHaFj?rs=1&pid=ImgDetMain,https://ts1.cn.mm.bing.net/th/id/R-C.89f11cee59ee09e3a58a3ca2a18c9b0a?rik=CDxw22iHca3RWA&riu=http%3a%2f%2fwww.kuaipng.com%2fUploads%2fpic%2fw%2f2020%2f09-14%2f92046%2fwater_92046_698_879.1_.png&ehk=QT0utEhmXRRY1qSd0dxXr1OULsi4BSdKsor3paahHxs%3d&risl=&pid=ImgRaw&r=0,https://ts1.cn.mm.bing.net/th/id/R-C.be2711bf5dfa9c112401b07478461dca?rik=q7ZGPpxtB%2ffzsg&riu=http%3a%2f%2fpic.bizhi360.com%2fbpic%2f24%2f8424.jpg&ehk=qQkQ%2f%2fApI%2bPhK%2bLRTkHTYLfDCc0%2bYy6j1ATjBYWQlnA%3d&risl=&pid=ImgRaw&r=0,https://ts1.cn.mm.bing.net/th/id/R-C.a75a3b4eb1afc116279b7bcede27b887?rik=8l0dtG1%2feun1ug&riu=http%3a%2f%2fwww.baobeita.com%2fupload%2fimage%2fproduct%2f201412%2f10116103%2f0831de17-b5be-45fc-a48d-fca0750e8598-large.jpg&ehk=cCYbZX%2bH%2fajpH6JqKl7BfMIHymgg5WxoyNHyrHjgC9s%3d&risl=&pid=ImgRaw&r=0',0,0,NULL),(3,'https://pic1.zhimg.com/v2-bfded6ae9ab73f8e422dfd6d20325d8c_r.jpg?source=1940ef5c','王五','喜欢狗','狗子叛逆','吐槽一下我家狗子，天天闹腾闹腾的，从早闹到晚','https://pic2.zhimg.com/v2-29a8e4397e46659c52776550ae4cdd78_r.jpg,https://ts1.cn.mm.bing.net/th/id/R-C.f5036a1b4f9e8482b93ea6453437f88d?rik=kYF%2bSNuPI98i4A&riu=http%3a%2f%2fwww.baobeita.com%2fupload%2fimage%2fproduct%2f201401%2f10087000%2ff64e32ec-2058-4b95-87a3-cf1ee5c2db6b-large.jpg&ehk=%2fvO0dIs2OxYE1XyKZeYge5bmXR85WalmkIbEMs5XLE4%3d&risl=&pid=ImgRaw&r=0,https://img1.pconline.com.cn/piclib/200902/05/batch/1/21808/1233825719734z402on4djk.jpg,https://img1.pconline.com.cn/piclib/200902/05/batch/1/21808/1233825719734l86go80u0p.jpg,https://img1.pconline.com.cn/piclib/200902/05/batch/1/21808/1233825719734gbvtlhpjsl.jpg',0,0,NULL);
/*!40000 ALTER TABLE `community` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-01 23:04:42
