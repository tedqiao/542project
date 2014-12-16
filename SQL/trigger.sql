DROP TABLE IF EXISTS `hold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hold` (
  `userID` varchar(50) NOT NULL,
  `Sid` varchar(50) NOT NULL,
  `shares` int(11) DEFAULT NULL,
  PRIMARY KEY (`userID`,`Sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hold`
--

LOCK TABLES `hold` WRITE;
/*!40000 ALTER TABLE `hold` DISABLE KEYS */;
INSERT INTO `hold` VALUES ('1','000001',750),('1','000003',18),('1','000004',121),('1','000005',2),('1','000006',12),('1','000007',1),('1','000008',78),('1','000009',1680),('1','000010',2),('1','000011',900),('1','000012',444),('1','000013',892),('1','000015',11),('1','000018',293),('1','000020',200),('1','000021',3670),('1','000022',20),('1','000025',421),('1','000026',100),('1','000029',137),('2','000001',284),('2','000002',42),('2','000003',111),('2','000019',611),('3','000002',2342),('3','000003',235),('4','000001',235),('4','000003',551);
/*!40000 ALTER TABLE `hold` ENABLE KEYS */;
UNLOCK TABLES;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`cs542`@`%`*/ /*!50003 TRIGGER `cs542`.`hold_BEFORE_INSERT` BEFORE INSERT ON `hold` FOR EACH ROW
insert into cs542.transactionrecord values (sysdate(),userID,(select cid from cs542.stock where sid = New.sid), sysdate(), New.shares) */;;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`cs542`@`%`*/ /*!50003 TRIGGER `cs542`.`hold_BEFORE_UPDATE` BEFORE UPDATE ON `hold` FOR EACH ROW
insert into cs542.transactionrecord values (sysdate(),userID,(select cid from cs542.stock where sid = OLD.sid), sysdate(), old.shares) */;;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`cs542`@`%`*/ /*!50003 TRIGGER `cs542`.`hold_BEFORE_DELETE` BEFORE DELETE ON `hold` FOR EACH ROW
insert into cs542.transactionrecord values (sysdate(),userID,(select cid from cs542.stock where sid = OLD.sid), sysdate(), old.shares) */;;
DELIMITER ;
