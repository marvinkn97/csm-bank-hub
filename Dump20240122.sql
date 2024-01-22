CREATE DATABASE  IF NOT EXISTS `bankapp_crud` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bankapp_crud`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bankapp_crud
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `t_account_master`
--

DROP TABLE IF EXISTS `t_account_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_account_master` (
  `account_no` varchar(12) NOT NULL,
  `name` varchar(45) NOT NULL,
  `phone_no` varchar(12) NOT NULL,
  `email` varchar(45) NOT NULL,
  `account_type` varchar(8) NOT NULL,
  `bank_id` int NOT NULL,
  `balance` double NOT NULL,
  PRIMARY KEY (`account_no`),
  KEY `bank_id_fk_idx` (`bank_id`),
  CONSTRAINT `bank_id_fk` FOREIGN KEY (`bank_id`) REFERENCES `t_bank_master` (`bank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_account_master`
--

LOCK TABLES `t_account_master` WRITE;
/*!40000 ALTER TABLE `t_account_master` DISABLE KEYS */;
INSERT INTO `t_account_master` VALUES ('BKAC0001','Foo Bar','0793283645','foo@example.com','savings',4,1500),('BKACC4956','Tech CSM','0793283645','csm.tech@example.com','business',5,900);
/*!40000 ALTER TABLE `t_account_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_bank_master`
--

DROP TABLE IF EXISTS `t_bank_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_bank_master` (
  `bank_id` int NOT NULL AUTO_INCREMENT,
  `ifsc_code` varchar(16) NOT NULL,
  `bank_name` varchar(45) NOT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_bank_master`
--

LOCK TABLES `t_bank_master` WRITE;
/*!40000 ALTER TABLE `t_bank_master` DISABLE KEYS */;
INSERT INTO `t_bank_master` VALUES (4,'IMBLKENA','I&M'),(5,'BARCKENX','ABSA '),(6,'DTKEKENA','DTB'),(7,'ECOCKENA','ECOBANK'),(8,'EQBLKENA','EQUITY'),(9,'FABLKENA','FAMILY BANK');
/*!40000 ALTER TABLE `t_bank_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_transaction_master`
--

DROP TABLE IF EXISTS `t_transaction_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_transaction_master` (
  `transaction_id` int NOT NULL AUTO_INCREMENT,
  `transaction_date` datetime NOT NULL,
  `transaction_type` char(1) NOT NULL,
  `amount` double NOT NULL,
  `account_no` varchar(12) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `account_no_fk_idx` (`account_no`),
  CONSTRAINT `account_no_fk` FOREIGN KEY (`account_no`) REFERENCES `t_account_master` (`account_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_transaction_master`
--

LOCK TABLES `t_transaction_master` WRITE;
/*!40000 ALTER TABLE `t_transaction_master` DISABLE KEYS */;
INSERT INTO `t_transaction_master` VALUES (1,'2024-01-22 13:45:49','C',1500,'BKAC0001'),(2,'2024-01-22 13:46:22','C',1200,'BKACC4956'),(3,'2024-01-22 13:47:00','D',300,'BKACC4956');
/*!40000 ALTER TABLE `t_transaction_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-22 15:00:35
