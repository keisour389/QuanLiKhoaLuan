-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: master_db
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `criteria`
--

DROP TABLE IF EXISTS `criteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criteria` (
  `id` bigint NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `deleted` tinyint NOT NULL,
  `created_by` int NOT NULL,
  `last_modifed_by` int DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `last_modifed_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criteria`
--

LOCK TABLES `criteria` WRITE;
/*!40000 ALTER TABLE `criteria` DISABLE KEYS */;
/*!40000 ALTER TABLE `criteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criteria_study`
--

DROP TABLE IF EXISTS `criteria_study`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criteria_study` (
  `criteria_id` bigint NOT NULL,
  `study_id` bigint NOT NULL,
  `score` double NOT NULL,
  PRIMARY KEY (`criteria_id`,`study_id`),
  KEY `fk_criteria_has_study_study1_idx` (`study_id`),
  KEY `fk_criteria_has_study_criteria1_idx` (`criteria_id`),
  CONSTRAINT `fk_criteria_has_study_criteria1` FOREIGN KEY (`criteria_id`) REFERENCES `criteria` (`id`),
  CONSTRAINT `fk_criteria_has_study_study1` FOREIGN KEY (`study_id`) REFERENCES `study` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criteria_study`
--

LOCK TABLES `criteria_study` WRITE;
/*!40000 ALTER TABLE `criteria_study` DISABLE KEYS */;
/*!40000 ALTER TABLE `criteria_study` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study`
--

DROP TABLE IF EXISTS `study`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study` (
  `id` bigint NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `school_year` varchar(20) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `deleted` tinyint NOT NULL,
  `created_by` int NOT NULL,
  `last_modifed_by` int DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `last_modifed_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study`
--

LOCK TABLES `study` WRITE;
/*!40000 ALTER TABLE `study` DISABLE KEYS */;
/*!40000 ALTER TABLE `study` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thesis_defense`
--

DROP TABLE IF EXISTS `thesis_defense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thesis_defense` (
  `id` bigint NOT NULL,
  `deleted` tinyint NOT NULL,
  `created_by` int NOT NULL,
  `last_modifed_by` int DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `last_modifed_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thesis_defense`
--

LOCK TABLES `thesis_defense` WRITE;
/*!40000 ALTER TABLE `thesis_defense` DISABLE KEYS */;
/*!40000 ALTER TABLE `thesis_defense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thesis_defense_user`
--

DROP TABLE IF EXISTS `thesis_defense_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thesis_defense_user` (
  `thesis_defense_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `role` varchar(45) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`thesis_defense_id`,`user_id`),
  KEY `fk_thesis_defense_has_user_user1_idx` (`user_id`),
  KEY `fk_thesis_defense_has_user_thesis_defense1_idx` (`thesis_defense_id`),
  CONSTRAINT `fk_thesis_defense_has_user_thesis_defense1` FOREIGN KEY (`thesis_defense_id`) REFERENCES `thesis_defense` (`id`),
  CONSTRAINT `fk_thesis_defense_has_user_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thesis_defense_user`
--

LOCK TABLES `thesis_defense_user` WRITE;
/*!40000 ALTER TABLE `thesis_defense_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `thesis_defense_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `last_name` varchar(20) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `first_name` varchar(50) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `email` varchar(45) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `password_hash` varchar(200) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `role` varchar(45) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `last_login_date` datetime NOT NULL,
  `deleted` tinyint NOT NULL,
  `created_by` int DEFAULT NULL,
  `last_modifed_by` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modifed_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test','test','admin@mail.com','$2a$12$YN5vLiAeCKYJk2pEla.nTuZMzgDaPTgEG5zlT2Zk0rKPG/PZoQiVG','ROLE_ADMIN','2021-01-01 00:00:00',0,1,NULL,'2021-01-01 00:00:00',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_study`
--

DROP TABLE IF EXISTS `user_study`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_study` (
  `study_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`study_id`,`user_id`),
  KEY `fk_study_has_user_user1_idx` (`user_id`),
  KEY `fk_study_has_user_study_idx` (`study_id`),
  CONSTRAINT `fk_study_has_user_study` FOREIGN KEY (`study_id`) REFERENCES `study` (`id`),
  CONSTRAINT `fk_study_has_user_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_study`
--

LOCK TABLES `user_study` WRITE;
/*!40000 ALTER TABLE `user_study` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_study` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-28 14:11:48
