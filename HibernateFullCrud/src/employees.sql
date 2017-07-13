-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 13, 2017 at 04:19 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employees`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  `username` varchar(50) NOT NULL,
  `info_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `email`, `password`, `username`, `info_id`) VALUES
(1, 'mail_1@gmail.com', 'pass1', 'username1', 1),
(2, 'mail_2@gmail.com', 'pass2', 'mego', 2),
(3, 'mail_3@gmail.com', 'pass3', 'username3', 3),
(4, 'mail_4@gmail.com', 'pass4', 'username4', 4),
(5, 'mail_5@gmail.com', 'pass5', 'username5', 5),
(6, 'mail_6@gmail.com', 'pass6', 'username6', 6),
(7, 'mail_7@gmail.com', 'pass7', 'username7', 7),
(8, 'mail_8@gmail.com', 'pass8', 'username8', 8),
(9, 'mail_9@gmail.com', 'pass9', 'username9', 9),
(10, 'mail_10@gmail.com', 'pass10', 'username10', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_76snkombmttoxvdljjqo42mmc` (`email`),
  ADD UNIQUE KEY `UK_peuagpqo8r51tyig2ch8jmmos` (`username`),
  ADD KEY `FK_e5q2eiv7xoam8on7ax0d0akmp` (`info_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `FK_e5q2eiv7xoam8on7ax0d0akmp` FOREIGN KEY (`info_id`) REFERENCES `employee_info` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
