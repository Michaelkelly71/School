-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: FeePaymentSystem
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `grad`
--

DROP TABLE IF EXISTS `grad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grad` (
  `GID` char(10) NOT NULL,
  `Lname` varchar(45) DEFAULT NULL,
  `Fname` varchar(45) DEFAULT NULL,
  `Mname` varchar(45) DEFAULT NULL,
  `AccCode` varchar(11) DEFAULT NULL,
  `Wallet` varchar(45) DEFAULT NULL,
  `Number` char(10) DEFAULT NULL,
  `Amount` double DEFAULT NULL,
  `Balance` double DEFAULT NULL,
  PRIMARY KEY (`GID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grad`
--

LOCK TABLES `grad` WRITE;
/*!40000 ALTER TABLE `grad` DISABLE KEYS */;
INSERT INTO `grad` VALUES ('g216hr0234','Danquah','Caleb','K.','sg216hr0234','MTN MOBILE MONEY','0245678654',3390,610),('g218sm0015','Acheampong','Belinda',NULL,'sg218sm0015',NULL,'0573540987',543,3457),('g219ba0001','Opoku','Francis','Akom','sg219ba0001',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `grad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `underGrad`
--

DROP TABLE IF EXISTS `underGrad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `underGrad` (
  `ID` char(13) NOT NULL,
  `Lname` varchar(45) DEFAULT NULL,
  `Fname` varchar(45) DEFAULT NULL,
  `Mname` varchar(45) DEFAULT NULL,
  `AccCode` varchar(14) DEFAULT NULL,
  `Wallet` varchar(45) DEFAULT NULL,
  `Number` char(10) DEFAULT NULL,
  `Amount` float DEFAULT NULL,
  `Balance` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `underGrad`
--

LOCK TABLES `underGrad` WRITE;
/*!40000 ALTER TABLE `underGrad` DISABLE KEYS */;
INSERT INTO `underGrad` VALUES ('218ns01000001','Twum','Felix',NULL,NULL,NULL,NULL,NULL,NULL),('219cs01090015','Osei','Michael','Kelly','s219cs01090015','MTN MOBILE MONEY','0248570832',1687,2313),('219it01000287','Annor','Samuel','Yankyera','s219cs01090014','Tigo Cash','0274567898',3678,322);
/*!40000 ALTER TABLE `underGrad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'FeePaymentSystem'
--

--
-- Dumping routines for database 'FeePaymentSystem'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-12 16:57:56
