-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 03, 2023 at 08:53 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `devoteamdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `phase`
--

DROP TABLE IF EXISTS `phase`;
CREATE TABLE IF NOT EXISTS `phase` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `end_date` datetime(6) DEFAULT NULL,
  `name` varchar(191) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `project_project_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5ej2y5ll79qii89hqk5divh0k` (`project_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE IF NOT EXISTS `project` (
  `project_id` bigint NOT NULL AUTO_INCREMENT,
  `domain` varchar(191) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `nature` varchar(191) DEFAULT NULL,
  `project_name` varchar(191) DEFAULT NULL,
  `sponsor` varchar(191) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `project_description` varchar(191) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 ;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`project_id`, `domain`, `end_date`, `nature`, `project_name`, `sponsor`, `start_date`, `project_description`) VALUES
(42, 'dededed', '2023-08-05', 'dededed', 'ddeded', 'dededed', '2023-04-05', 'dededede'),
(43, 'ssssssssss', '2023-07-28', 'ssssssssssss', 'ssss', 'sssssssssssss', '2023-06-06', 'ssssssssssssss'),
(46, 'wwwwwwwwwwww', '2023-07-31', 'project 3', 'project 3', 'wwwwwwwwwwwwww', '2023-07-29', 'wwwwwwwwwwwwwwwww');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `role_name` varchar(191) NOT NULL,
  `role_description` varchar(191) DEFAULT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_name`, `role_description`) VALUES
('Admin', 'Admin role'),
('Consultant', 'Consultant'),
('PM', 'PM'),
('pmo', 'project manager officer');

-- --------------------------------------------------------

--
-- Table structure for table `step`
--

DROP TABLE IF EXISTS `step`;
CREATE TABLE IF NOT EXISTS `step` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `end_date` datetime(6) DEFAULT NULL,
  `name` varchar(191) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `phase_id` bigint DEFAULT NULL,
  `project_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK27tjo3xn08q8ths9baf4g5oer` (`phase_id`),
  KEY `FKmffqrbl522vp7kgimlptdwwjd` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 ;

--
-- Dumping data for table `step`
--

INSERT INTO `step` (`id`, `end_date`, `name`, `start_date`, `phase_id`, `project_id`) VALUES
(13, '2023-07-28 00:00:00.000000', 'waa', '2023-07-01 00:00:00.000000', NULL, 43),
(14, '2023-07-27 00:00:00.000000', 'weeeeee', '2023-07-26 00:00:00.000000', NULL, 43),
(15, '2023-07-21 00:00:00.000000', 'step 1', '2023-07-04 00:00:00.000000', NULL, 42),
(16, '2023-07-19 00:00:00.000000', 'step 2', '2023-07-03 00:00:00.000000', NULL, 42);

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE IF NOT EXISTS `task` (
  `task_id` bigint NOT NULL AUTO_INCREMENT,
  `due_date` date DEFAULT NULL,
  `ponderation` int NOT NULL,
  `ponderation_progress` int NOT NULL,
  `task_description` varchar(191) DEFAULT NULL,
  `task_progress` int NOT NULL,
  `step_id` bigint DEFAULT NULL,
  `user_name` varchar(191) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FKosro01wj6ldccmwwrde1i9ay1` (`step_id`),
  KEY `FK6w7b10pq67r2c0lh39m3s29ky` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`task_id`, `due_date`, `ponderation`, `ponderation_progress`, `task_description`, `task_progress`, `step_id`, `user_name`) VALUES
(1, '2023-05-17', 10, 10, 'task1', 10, 14, 'Devoteam'),
(2, '2023-05-17', 10, 10, 'task1', 10, 14, 'wadiijh123'),
(3, '2023-05-17', 10, 10, 'task2', 10, 14, NULL),
(4, '2023-05-17', 10, 10, 'task2', 10, 14, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_name` varchar(191) NOT NULL,
  `refresh_token` varchar(191) DEFAULT NULL,
  `user_first_name` varchar(191) DEFAULT NULL,
  `user_last_name` varchar(191) DEFAULT NULL,
  `user_password` varchar(191) DEFAULT NULL,
  `email` varchar(191) DEFAULT NULL,
  `user_email` varchar(191) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_name`, `refresh_token`, `user_first_name`, `user_last_name`, `user_password`, `email`, `user_email`) VALUES
('devopro', NULL, 'devopro', 'devopro', '$2a$10$qLRMNkrP4WE2XdDotOPs6OymTH9xIWvEUKc0INosV4ZzwTEgQXRsW', NULL, 'wadii.jhinaoui@esprit.tn'),
('Devoteam', 'eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODgzOTA2MDMsImV4cCI6MTY4ODM5MDYyMX0.2CTeMJM3yvqboD7nHsoGuE0fmcvp4E9w4mSm78HD9b4', 'Devoteam', 'Devoteam', '$2a$10$Y2ndhic1cx7CyohlStIp/Og6lODYzymmBG2z1JBVUxe0zP.uf/OhW', NULL, 'wadii.jhinaoui@esprit.tn'),
('wadiijh123', 'eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODgyNDU3MjIsImV4cCI6MTY4ODI0NTc0MH0.99jEZWDZTBsoqZAT8uQHlP2Z6jYqBNtDkWQfAh0o0N4', 'wadii', 'jhinaoui', '$2a$10$izyn1obOkEHl4nnd5EXecOZ0bAWkcTAjmPys28Qz38zeBf/capr3q', NULL, 'wadii.jhinaoui@esprit.tn');

-- --------------------------------------------------------

--
-- Table structure for table `user_project`
--

DROP TABLE IF EXISTS `user_project`;
CREATE TABLE IF NOT EXISTS `user_project` (
  `user_id` varchar(191) NOT NULL,
  `project_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`project_id`),
  KEY `FKocfkr6u2yh3w1qmybs8vxuv1c` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

--
-- Dumping data for table `user_project`
--

INSERT INTO `user_project` (`user_id`, `project_id`) VALUES
('Devoteam', 42),
('wadiijh123', 42),
('wadiijh123', 43),
('Devoteam', 46),
('wadiijh123', 46);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` varchar(191) NOT NULL,
  `role_id` varchar(191) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
('ddddddd', 'Admin'),
('devopro', 'Admin'),
('Devoteam', 'Admin'),
('devoteamAdmin', 'Admin'),
('dsqdqsdqsd', 'Admin'),
('rgrgrgrg', 'Admin'),
('sarbel1gg', 'Admin'),
('hhhhhhhhhhbbb', 'bbbbbb'),
('mmmmmmmmmmmm', 'dddd'),
('dededdd', 'pmo'),
('dlksq,dlsq', 'pmo'),
('dqdqdqd', 'pmo'),
('john_doe', 'pmo'),
('john_doev', 'pmo'),
('john_doex', 'pmo'),
('JohnDoe', 'pmo'),
('JohnDoe22222', 'pmo'),
('rrrrrrrrrrrr', 'pmo'),
('sssssssssss', 'pmo'),
('sssssssssssss', 'pmo'),
('ththt', 'pmo'),
('wadiifcb', 'pmo'),
('wadiijh123', 'pmo');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `phase`
--
ALTER TABLE `phase`
  ADD CONSTRAINT `FK5ej2y5ll79qii89hqk5divh0k` FOREIGN KEY (`project_project_id`) REFERENCES `project` (`project_id`);

--
-- Constraints for table `step`
--
ALTER TABLE `step`
  ADD CONSTRAINT `FK27tjo3xn08q8ths9baf4g5oer` FOREIGN KEY (`phase_id`) REFERENCES `phase` (`id`),
  ADD CONSTRAINT `FKmffqrbl522vp7kgimlptdwwjd` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`);

--
-- Constraints for table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `FK6w7b10pq67r2c0lh39m3s29ky` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`),
  ADD CONSTRAINT `FKosro01wj6ldccmwwrde1i9ay1` FOREIGN KEY (`step_id`) REFERENCES `step` (`id`);

--
-- Constraints for table `user_project`
--
ALTER TABLE `user_project`
  ADD CONSTRAINT `FKocfkr6u2yh3w1qmybs8vxuv1c` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`),
  ADD CONSTRAINT `FKpw81exe7fsdl7mddqujvu91kx` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_name`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_name`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
