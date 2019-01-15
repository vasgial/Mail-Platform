-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: platform_mail
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receiver_id` int(11) NOT NULL,
  `senter_id` int(11) NOT NULL,
  `dateTime` varchar(40) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `receiverHasRead` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `receiver_fk_messages` (`receiver_id`),
  KEY `senter_fk_messages` (`senter_id`),
  CONSTRAINT `receiver_fk_messages` FOREIGN KEY (`receiver_id`) REFERENCES `users` (`id`),
  CONSTRAINT `senter_fk_messages` FOREIGN KEY (`senter_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,1,2,'0.000566331586719524','tripoli',0),(2,1,2,'2018-11-15','hjhjhj',0),(3,1,2,'2018-11-15','jkjkjk',0),(10,2,1,'2018-11-17 20:33:44','mmmmmmmmaaaaaaammmmmmm',0),(11,3,2,'2018-11-17 21:32:06','athen\'s marathon',0),(12,2,5,'2018-11-17 21:38:11','paraskyi',0),(14,3,2,'2018-11-17 21:41:54','tratra',0),(16,2,1,'2018-11-18 14:01:35','annaanna',0),(17,2,1,'2018-11-18 14:56:56','edit a message',0),(18,2,1,'2018-11-18 14:58:43','apple',0),(19,2,1,'2018-11-18 15:32:27','xaxa',0),(20,5,2,'2018-11-18 16:15:47','messagemess',0),(21,5,2,'2018-11-18 16:43:03','mariamaria',0),(22,5,1,'2018-11-18 17:20:13','xexe',0),(23,2,1,'2018-11-18 18:18:26','telephone',0),(28,5,2,'2018-11-18 18:52:27','hello',0),(29,25,2,'2018-11-18 18:58:27','lilikaki',0),(30,25,1,'2018-11-18 19:17:39','text',0),(32,25,12,'2018-11-18 19:23:17','texttext',0),(34,6,2,'2018-11-18 19:29:57','wake up!!',0),(35,6,5,'2018-11-18 19:33:48','ice',0),(36,25,2,'2018-11-18 19:36:12','house',0),(37,5,6,'2018-11-18 19:39:56','good morning!!',0),(38,12,6,'2018-11-18 19:42:21','yellow',0);
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','admin'),(2,'anna','11','UserViewEdit'),(3,'vasiliki','99','UserView'),(5,'maria','19','UserView'),(6,'ntina','ntina','UserViewEditDelete'),(7,'amalia','amalia','UserView'),(8,'vasilis','vasilis','UserViewEditDelete'),(11,'koulis','koulis','UserView'),(12,'kostas','kostas','UserViewEditDelete'),(14,'athina','athina','UserView'),(16,'petros','petros','UserView'),(24,'vasil','vasil','UserViewEditDelete'),(25,'lilika','lilika','UserViewEditDelete');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-18 20:05:13
