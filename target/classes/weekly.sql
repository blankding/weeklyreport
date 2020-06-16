DROP DATABASE IF EXISTS weekly;

CREATE DATABASE weekly DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE weekly;


--
-- Table structure for table `ms_member`
--

DROP TABLE IF EXISTS `ms_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `ms_student` (
  `student_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `student_number` INT(11) NOT NULL COMMENT '学号',
  `class_id` VARCHAR(11) NOT NULL COMMENT '班级号',
  `student_name` VARCHAR(50) NOT NULL COMMENT '学生姓名',
  `password` VARCHAR(50) NOT NULL COMMENT '密码',
  `email` VARCHAR(50) NOT NULL COMMENT '邮箱',
  `sex` SMALLINT(6) DEFAULT NULL COMMENT '性别',
  `mobile` VARCHAR(50) DEFAULT NULL COMMENT '手机号',
  `creatime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NULL DEFAULT NULL COMMENT '当前时间',
  PRIMARY KEY (`student_id`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_member`
--

LOCK TABLES `ms_student` WRITE;
/*!40000 ALTER TABLE `ms_student` DISABLE KEYS */;
INSERT INTO ms_student(student_id,student_number,class_id,student_name,PASSWORD,email,sex,mobile,creatime,modifytime) 
VALUES (1,'2017313101','313','admin','4QrcOUm6Wau+VuBX8g+IPg==','ls@qq.com',0,'13887432165',SYSDATE(),SYSDATE());
INSERT INTO `ms_student` VALUES (2,'2017313102','313','李四','4QrcOUm6Wau+VuBX8g+IPg==','ls@qq.com',0,'13887432165','2016-09-07 06:31:05',NULL),(3,'2017313103','313','王五','4QrcOUm6Wau+VuBX8g+IPg==','ww@qq.com',0,'13643218765','2016-09-07 06:32:50',NULL);
/*!40000 ALTER TABLE `ms_student` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `ms_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_admin` (
  `admin_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(50) NOT NULL COMMENT '密码',
  `email` VARCHAR(50) NOT NULL COMMENT '邮箱',
  `sex` SMALLINT(6) DEFAULT NULL COMMENT '性别',
  `mobile` VARCHAR(50) DEFAULT NULL COMMENT '手机号',
  `creatime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '当前时间',
  PRIMARY KEY (`admin_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

LOCK TABLES `ms_admin` WRITE;
INSERT INTO ms_admin(username,PASSWORD,email,sex,mobile,creatime,modifytime)
VALUE('admin', '4QrcOUm6Wau+VuBX8g+IPg==','admin@qq.com',0,'13813812386',SYSDATE(),SYSDATE());
UNLOCK TABLES;



DROP TABLE IF EXISTS `ms_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_class` (
  `class_id` VARCHAR(11) NOT NULL COMMENT '班级号',
  `class_name` VARCHAR(50) NOT NULL COMMENT '班级名称',
   `creator_id` INT(11) NOT NULL COMMENT '创建id',
  `creatime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`class_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

LOCK TABLES `ms_class` WRITE;
INSERT INTO ms_class(class_id,class_name,creator_id,creatime)
VALUE('313','17物联网1',1,SYSDATE());
UNLOCK TABLES;


DROP TABLE IF EXISTS `ms_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_report` (
  `report_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '周报id',
  `student_number` INT(11) NOT NULL COMMENT '学号',
  `class_id` VARCHAR(11) NOT NULL COMMENT '班级号',
  `teacher_num` INT(11) NOT NULL COMMENT '教师工号',
  `study_aim` VARCHAR(300) COMMENT '学习目标',
  `reason` VARCHAR(300) COMMENT '原因',
  `problem` VARCHAR(300) COMMENT '问题',
  `next_aim` VARCHAR(300) COMMENT '今后目标',
  `answer` VARCHAR(300) COMMENT '回复',
  `creatime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '当前时间',
  PRIMARY KEY (`report_id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

LOCK TABLES `ms_report` WRITE;
INSERT INTO ms_report(report_id,student_number,class_id,teacher_num,study_aim,reason,problem,next_aim,answer,creatime,modifytime)
VALUE(1,2017313101,'313',001,'aaaa','bbbb','cccc','dddd','ffff',SYSDATE(),SYSDATE());
UNLOCK TABLES;

DROP TABLE IF EXISTS `ms_teacher`;


CREATE TABLE `ms_teacher` (
  `teacher_id`   INT(11) NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `teacher_num`  INT(11) NOT NULL COMMENT '教师工号',
  `teacher_name` VARCHAR(50) NOT NULL COMMENT '教师姓名',
  `username`     VARCHAR(20) NOT NULL COMMENT '用户名',
  `PASSWORD`     VARCHAR(50) NOT NULL COMMENT '密码',
  `email`        VARCHAR(50) NOT NULL COMMENT '邮箱',
  `mobile_phone` VARCHAR(11) NOT NULL COMMENT '手机号',
  `creatime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '当前时间',
  PRIMARY KEY (`teacher_id`)
)ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

LOCK TABLES `ms_teacher` WRITE;
INSERT INTO ms_teacher(teacher_id,teacher_num,teacher_name,username,PASSWORD,email,mobile_phone,creatime,modifytime)
VALUE(1,001,'陈老师','Mr.chen','4QrcOUm6Wau+VuBX8g+IPg==','admin@qq.com','13813812386',SYSDATE(),SYSDATE());
UNLOCK TABLES; 
