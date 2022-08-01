-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 31, 2022 at 08:33 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 7.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quiz`
--

-- --------------------------------------------------------

--
-- Table structure for table `login_session`
--

CREATE TABLE `login_session` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `access_token` varchar(100) NOT NULL,
  `last_access` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `question` varchar(1000) NOT NULL,
  `option_a` varchar(45) NOT NULL,
  `option_b` varchar(45) NOT NULL,
  `option_c` varchar(45) NOT NULL,
  `option_d` varchar(45) NOT NULL,
  `right_option` varchar(1) NOT NULL,
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `created_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_on` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `question`, `option_a`, `option_b`, `option_c`, `option_d`, `right_option`, `deleted`, `created_on`, `updated_on`) VALUES
(1, 'Ques1', '1.0', '2.0', '3.0', '4.0', 'A', 'Y', '2022-07-23 13:17:55', '2022-07-23 13:17:55'),
(2, 'Ques2', '1.0', '2.0', '3.0', '4.0', 'C', 'N', '2022-07-23 13:17:55', '2022-07-23 13:17:55'),
(3, 'Ques3', '1.0', '2.0', '3.0', '4.0', 'C', 'N', '2022-07-23 13:17:55', '2022-07-23 13:17:55'),
(4, 'Ques4', '1.0', '2.0', '3.0', '4.0', 'D', 'N', '2022-07-23 13:17:55', '2022-07-23 13:17:55'),
(5, 'Ques5', '1.0', '2.0', '3.0', '4.0', 'A', 'N', '2022-07-23 13:17:55', '2022-07-23 13:17:55'),
(6, 'Ques6', '1.0', '2.0', '3.0', '4.0', 'B', 'N', '2022-07-23 13:17:55', '2022-07-23 13:17:55'),
(7, 'Ques7', '1.0', '2.0', '3.0', '4.0', 'C', 'N', '2022-07-23 13:17:55', '2022-07-23 13:17:55'),
(8, 'Ques8', '1.0', '2.0', '3.0', '4.0', 'D', 'N', '2022-07-23 13:17:55', '2022-07-23 13:17:55'),
(9, 'Ques9', '1.0', '2.0', '3.0', '4.0', 'A', 'N', '2022-07-23 13:17:55', '2022-07-23 13:17:55'),
(10, 'Ques10', '1.0', '2.0', '3.0', '4.0', 'B', 'N', '2022-07-23 13:17:55', '2022-07-23 13:17:55'),
(11, 'Ques11', '1.0', '2.0', '3.0', '4.0', 'C', 'Y', '2022-07-23 13:17:55', '2022-07-23 13:17:55'),
(12, 'What does DNA stand for?', 'A', 'B', 'C', 'D', 'B', 'N', '2022-07-24 07:49:40', '2022-07-24 07:49:40'),
(13, 'How many bones are in the human body?', '200', '157', '209', '206', 'D', 'N', '2022-07-24 07:49:40', '2022-07-24 07:49:40');

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE `quiz` (
  `id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `created_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_on` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `quiz`
--

INSERT INTO `quiz` (`id`, `title`, `category`, `deleted`, `created_on`, `updated_on`) VALUES
(1, 'Quiz 1', 'SCIENCE', 'N', '2022-07-23 01:22:33', '2022-07-23 01:22:33'),
(2, 'Q2', 'MATH', 'N', '2022-07-23 12:19:29', '2022-07-23 12:19:29'),
(3, 'Q3', 'MATH', 'N', '2022-07-23 12:23:15', '2022-07-23 12:23:15'),
(4, 'Q4', 'MATH', 'N', '2022-07-23 12:29:56', '2022-07-23 12:29:56'),
(5, 'Q5', 'SCIENCE', 'N', '2022-07-23 12:34:26', '2022-07-23 12:34:26'),
(6, 'Q6', 'MATH', 'N', '2022-07-23 12:45:04', '2022-07-23 12:45:04'),
(7, '', '', 'Y', '2022-07-24 06:51:27', '2022-07-24 06:51:27'),
(8, 'Sci00100', 'SCIENCE', 'N', '2022-07-24 07:30:14', '2022-07-24 07:30:14');

-- --------------------------------------------------------

--
-- Table structure for table `quiz_question`
--

CREATE TABLE `quiz_question` (
  `id` int(11) NOT NULL,
  `quiz_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `created_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_on` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `quiz_question`
--

INSERT INTO `quiz_question` (`id`, `quiz_id`, `question_id`, `deleted`, `created_on`, `updated_on`) VALUES
(1, 6, 5, 'N', '2022-07-23 16:16:12', '2022-07-23 16:16:12'),
(2, 6, 7, 'N', '2022-07-23 16:16:12', '2022-07-23 16:16:12'),
(3, 6, 2, 'N', '2022-07-23 16:16:24', '2022-07-23 16:16:24'),
(4, 6, 3, 'N', '2022-07-23 16:16:24', '2022-07-23 16:16:24'),
(5, 1, 10, 'N', '2022-07-23 16:34:09', '2022-07-23 16:34:09'),
(6, 8, 12, 'N', '2022-07-24 07:49:40', '2022-07-24 07:49:40'),
(7, 8, 13, 'N', '2022-07-24 07:49:40', '2022-07-24 07:49:40');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  `password` varchar(45) NOT NULL,
  `mobile_number` varchar(10) NOT NULL,
  `is_admin` varchar(1) NOT NULL DEFAULT 'N',
  `created_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_on` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `email_id`, `password`, `mobile_number`, `is_admin`, `created_on`, `updated_on`) VALUES
(1, 'Jhon', 'Deo', 'admin@gmail.com', '12345678', '9900887766', 'Y', '2022-07-21 05:56:24', '2022-07-21 05:56:24'),
(2, 'qwe', 'qwr', 'ery', 'asd', 'io', 'N', '2022-07-22 20:59:52', '2022-07-22 20:59:52'),
(3, 'Anand', 'Tiwari', 'anand@gmail.com', '123', '124123', 'N', '2022-07-23 16:47:05', '2022-07-23 16:47:05'),
(4, 'Mahesh', 'Shittlani', 'mahesh@yopmail.com', '123456', '1122334455', 'N', '2022-07-24 12:31:22', '2022-07-24 12:31:22'),
(6, 'X', 'Y', 'XY@yopmail.com', '123456', '1122334455', 'N', '2022-07-24 13:34:33', '2022-07-24 13:34:33');

-- --------------------------------------------------------

--
-- Table structure for table `user_quiz_ques_ans`
--

CREATE TABLE `user_quiz_ques_ans` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `quiz_question_id` int(11) NOT NULL,
  `selected_option` char(1) NOT NULL,
  `created_on` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_quiz_ques_ans`
--

INSERT INTO `user_quiz_ques_ans` (`id`, `user_id`, `quiz_question_id`, `selected_option`, `created_on`) VALUES
(10, 3, 7, 'B', '2022-07-24 15:03:50'),
(11, 3, 6, 'B', '2022-07-24 15:03:54');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login_session`
--
ALTER TABLE `login_session`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_LOGIN_SESSION_USER_ID_idx` (`user_id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `quiz_question`
--
ALTER TABLE `quiz_question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_QUIZ_ID_idx` (`quiz_id`),
  ADD KEY `FK_QUESTION_ID_idx` (`question_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email_id_UNIQUE` (`email_id`);

--
-- Indexes for table `user_quiz_ques_ans`
--
ALTER TABLE `user_quiz_ques_ans`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_QUIZ_QUES_ID_idx` (`quiz_question_id`),
  ADD KEY `FK_USER_ID_idx` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login_session`
--
ALTER TABLE `login_session`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `quiz_question`
--
ALTER TABLE `quiz_question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user_quiz_ques_ans`
--
ALTER TABLE `user_quiz_ques_ans`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `login_session`
--
ALTER TABLE `login_session`
  ADD CONSTRAINT `FK_LOGIN_SESSION_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `quiz_question`
--
ALTER TABLE `quiz_question`
  ADD CONSTRAINT `FK_QUESTION_ID` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_QUIZ_ID` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`);

--
-- Constraints for table `user_quiz_ques_ans`
--
ALTER TABLE `user_quiz_ques_ans`
  ADD CONSTRAINT `FK_QUIZ_QUES_ID` FOREIGN KEY (`quiz_question_id`) REFERENCES `quiz_question` (`id`),
  ADD CONSTRAINT `FK_USER_ID` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
