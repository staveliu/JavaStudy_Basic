drop database if exists studb;
create database studb;
use studb;

DROP TABLE IF EXISTS `studentInfo`;
CREATE TABLE `studentInfo` (
  `stuNo` char(4) NOT NULL COMMENT '学号',
  `stuName` varchar(30) NOT NULL COMMENT '姓名',
  `stuSex` char(2) NOT NULL COMMENT '性别',
  `stuAge` int(11) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`stuNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
delete
insert into studentInfo values
("0001","张三","男",18),
("0002","李四","女",17),
("0003","王五","男",18);
