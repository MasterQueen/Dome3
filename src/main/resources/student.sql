DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `payID` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(255) DEFAULT NULL,
  `studentAge` int(11) DEFAULT NULL,
  `studentSex` varchar(255) DEFAULT NULL,
  `studentParents` varchar(255) DEFAULT NULL,
  `studentPhone` int(15) DEFAULT NULL,
  `payDate` varchar(255) DEFAULT NULL,
  `payMoney` int(20) NOT NULL ,
  `payMan` varchar(255) DEFAULT NULL,
  `payRemark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`payID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sponsor`;
CREATE TABLE `sponsor` (
  `sponsor_payID` int(11) NOT NULL AUTO_INCREMENT,
  `sponsorName` varchar(255) DEFAULT NULL,
  `studentPhone` int(15) DEFAULT NULL,
  `payDate` varchar(255) DEFAULT NULL,
  `payMoney` int(20) NOT NULL ,
  `payRemark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sponsor_payID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `income_other`;
CREATE TABLE `income_other` (
  `other_payID` int(11) NOT NULL AUTO_INCREMENT,
  `other_payDate` varchar(255) DEFAULT NULL,
  `other_payMoney` int(20) NOT NULL ,
  `other_payRemark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`other_payID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
