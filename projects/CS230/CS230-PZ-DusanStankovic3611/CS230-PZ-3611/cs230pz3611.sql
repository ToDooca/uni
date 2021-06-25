-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 25, 2021 at 12:34 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cs230pz3611`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `COMMENT_ID` int(10) NOT NULL,
  `USERID` int(10) DEFAULT NULL,
  `EVENTID` int(10) DEFAULT NULL,
  `NEWSID` int(10) DEFAULT NULL,
  `COMMENT_TEXT` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `EVENTID` int(10) NOT NULL,
  `EVENTTITLE` varchar(612) COLLATE utf8_unicode_ci NOT NULL,
  `EVENTDATE` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `EVENTTEXT` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`EVENTID`, `EVENTTITLE`, `EVENTDATE`, `EVENTTEXT`) VALUES
(1, 'Metallica U Nisu!', '30.7.2021.', 'Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum '),
(3, 'Rekonstrukcija Centra', '30.6.2021.', 'Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. Krece rekonstrukcija trga u Nisu. '),
(5, 'Lorem', '30.6.2021.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent placerat interdum nisi et consequat. Pellentesque efficitur ex a enim euismod tristique. Morbi condimentum urna viverra metus scelerisque dignissim. Ut diam ex, ultrices vel gravida vel, auctor tincidunt felis. Mauris in felis mi. Duis vehicula, tellus nec luctus aliquet, elit magna consequat nisl, vestibulum eleifend mauris erat non nisl. Sed semper porttitor porta. Vestibulum fringilla arcu metus, maximus vulputate nunc pulvinar in. Duis ut ex ac diam semper ullamcorper.\r\n\r\nQuisque eu elit ac quam pellentesque imperdiet. Donec tempus gravida molestie. Vestibulum aliquet arcu tellus. Integer maximus felis in leo suscipit, sollicitudin dictum metus sollicitudin. Donec at ex a tellus rutrum egestas. Nullam tincidunt tristique mauris ut molestie. Aliquam erat volutpat. Duis at venenatis urna, at ultrices ante. Nunc non nisl elementum, porta nisi quis, porta quam. Praesent convallis nunc in metus gravida finibus. Nam ullamcorper mi eget turpis fermentum, quis pulvinar augue lobortis. Aenean tellus sem, ultricies sit amet lobortis suscipit, bibendum nec mi. Suspendisse condimentum diam quis dolor suscipit dignissim nec id orci. Aliquam bibendum, dolor in ultrices hendrerit, dolor nisi semper mauris, a lacinia lacus risus sit amet odio.'),
(6, 'dapibus', '30.10.2021.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc vehicula quam ut dui molestie ultricies. Donec id risus egestas nisi bibendum maximus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus congue vulputate dolor, sit amet faucibus ipsum euismod non. Phasellus aliquet efficitur ante, egestas viverra velit rhoncus a. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Quisque dignissim erat ac erat aliquet dapibus. Proin nec nisl nec est feugiat molestie mollis ac neque. Aliquam iaculis in lectus efficitur congue. Integer pellentesque, tortor vel auctor viverra, diam lacus rutrum erat, a fringilla enim augue vel ligula. Nulla facilisi. Morbi a tellus et lorem pulvinar aliquet quis blandit est.'),
(7, 'Aliquam ', '30.12.2021.', 'Suspendisse semper commodo enim, id congue lectus pretium sit amet. Phasellus mollis accumsan turpis sed dapibus. Nullam ac ipsum ornare neque aliquam efficitur at nec urna. Quisque ultrices facilisis eros ut condimentum. Ut quis congue neque. Vivamus elementum mauris nec orci lobortis suscipit. Interdum et malesuada fames ac ante ipsum primis in faucibus. Curabitur et nunc eget nibh faucibus vehicula blandit vel eros. In nec mi quis tortor iaculis varius sed eget dui. Suspendisse augue diam, molestie eget turpis lobortis, aliquet dignissim sapien. Ut in convallis ligula. Pellentesque ex diam, imperdiet sed sapien sit amet, mollis sollicitudin lorem. Suspendisse porttitor blandit massa posuere fringilla. Vivamus consequat malesuada purus in auctor.\r\n\r\nEtiam ac magna justo. Quisque tempor tempor ante, eget finibus felis faucibus non. Sed ac magna ligula. Etiam mattis viverra massa non luctus. Cras sed elit purus. Integer fringilla odio quis massa pretium blandit. Maecenas eget massa aliquet, eleifend mi maximus, consequat leo. Morbi ornare purus scelerisque auctor rhoncus. Phasellus tincidunt faucibus dolor ullamcorper rhoncus.\r\n\r\nNulla vel tristique nulla, nec feugiat urna. Cras efficitur nibh a bibendum interdum. Nam egestas et est vel tempor. In sed rhoncus arcu. Fusce molestie pulvinar consectetur. Duis blandit, massa et viverra dictum, nisl sapien aliquam mauris, id pharetra mi est sit amet metus. Sed dignissim est eget ex vehicula cursus. Proin eget sapien accumsan, hendrerit odio et, feugiat ex. Praesent in viverra odio.\r\n\r\nAliquam '),
(8, 'pretium ', '30.12.2021.', 'Etiam ac magna justo. Quisque tempor tempor ante, eget finibus felis faucibus non. Sed ac magna ligula. Etiam mattis viverra massa non luctus. Cras sed elit purus. Integer fringilla odio quis massa pretium blandit. Maecenas eget massa aliquet, eleifend mi maximus, consequat leo. Morbi ornare purus scelerisque auctor rhoncus. Phasellus tincidunt faucibus dolor ullamcorper rhoncus.\r\n\r\nNulla vel tristique nulla, nec feugiat urna. Cras efficitur nibh a bibendum interdum. Nam egestas et est vel tempor. In sed rhoncus arcu. Fusce molestie pulvinar consectetur. Duis blandit, massa et viverra dictum, nisl sapien aliquam mauris, id pharetra mi est sit amet metus. Sed dignissim est eget ex vehicula cursus. Proin eget sapien accumsan, hendrerit odio et, feugiat ex. Praesent in viverra odio.'),
(9, 'maximus', '20.12.2021.', 'Aliquam suscipit nunc eget libero tristique iaculis. Sed mauris nunc, blandit vitae pulvinar nec, pellentesque et arcu. Integer efficitur, erat vitae facilisis ornare, justo felis iaculis justo, ac aliquam massa ex quis ex. Cras consectetur feugiat libero, in vulputate ex porta quis. Sed neque nunc, mattis sit amet ante quis, varius varius ipsum. Pellentesque dolor augue, hendrerit in leo sed, fermentum bibendum nisl. Nullam pulvinar eu ipsum ac molestie. Ut lectus mauris, condimentum quis molestie at, rhoncus et sapien. In tempor cursus ligula quis scelerisque. Etiam quam sem, mollis eget dolor ac, fringilla efficitur enim. Aliquam at blandit nunc. In id odio a eros luctus efficitur in eu leo.'),
(10, '', '21.7.2021.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc vehicula quam ut dui molestie ultricies. Donec id risus egestas nisi bibendum maximus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus congue vulputate dolor, sit amet faucibus ipsum euismod non. Phasellus aliquet efficitur ante, egestas viverra velit rhoncus a. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Quisque dignissim erat ac erat aliquet dapibus. Proin nec nisl nec est feugiat molestie mollis ac neque. Aliquam iaculis in lectus efficitur congue. Integer pellentesque, tortor vel auctor viverra, diam lacus rutrum erat, a fringilla enim augue vel ligula. Nulla facilisi. Morbi a tellus et lorem pulvinar aliquet quis blandit est.');

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `NEWSID` int(10) NOT NULL,
  `NEWSTITLE` varchar(612) COLLATE utf8_unicode_ci NOT NULL,
  `NEWSDATE` varchar(612) COLLATE utf8_unicode_ci NOT NULL,
  `NEWSTEXT` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`NEWSID`, `NEWSTITLE`, `NEWSDATE`, `NEWSTEXT`) VALUES
(1, 'Krecemo sa radom', '3.7.2021.', 'Nova aplikacijia o nasem gradu krece sa radom 4.7.2021. godine.\r\nPridruzite nam se!'),
(2, 'Ipsum', '23.9.2021.', 'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don\'t look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn\'t anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc'),
(3, 'Dolor Sit', '11.8.2021.', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.'),
(4, 'consectetur ', '30.12.2021.', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \'Content here, content here\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\r\n\r\n'),
(5, 'Nunc ', '30.12.2021.', 'Suspendisse semper commodo enim, id congue lectus pretium sit amet. Phasellus mollis accumsan turpis sed dapibus. Nullam ac ipsum ornare neque aliquam efficitur at nec urna. Quisque ultrices facilisis eros ut condimentum. Ut quis congue neque. Vivamus elementum mauris nec orci lobortis suscipit. Interdum et malesuada fames ac ante ipsum primis in faucibus. Curabitur et nunc eget nibh faucibus vehicula blandit vel eros. In nec mi quis tortor iaculis varius sed eget dui. Suspendisse augue diam, molestie eget turpis lobortis, aliquet dignissim sapien. Ut in convallis ligula. Pellentesque ex diam, imperdiet sed sapien sit amet, mollis sollicitudin lorem. Suspendisse porttitor blandit massa posuere fringilla. Vivamus consequat malesuada purus in auctor.\r\n\r\nEtiam ac magna justo. Quisque tempor tempor ante, eget finibus felis faucibus non. Sed ac magna ligula. Etiam mattis viverra massa non luctus. Cras sed elit purus. Integer fringilla odio quis massa pretium blandit. Maecenas eget massa aliquet, eleifend mi maximus, consequat leo. Morbi ornare purus scelerisque auctor rhoncus. Phasellus tincidunt faucibus dolor ullamcorper rhoncus.');

-- --------------------------------------------------------

--
-- Table structure for table `place`
--

CREATE TABLE `place` (
  `PLACEID` int(10) NOT NULL,
  `USERID` int(10) DEFAULT NULL,
  `PLACENAME` varchar(612) COLLATE utf8_unicode_ci NOT NULL,
  `PLACEDESCRIPTION` text COLLATE utf8_unicode_ci NOT NULL,
  `PLACEADRESS` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `PLACETYPE` varchar(612) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `place`
--

INSERT INTO `place` (`PLACEID`, `USERID`, `PLACENAME`, `PLACEDESCRIPTION`, `PLACEADRESS`, `PLACETYPE`) VALUES
(1, 2, 'McDonalds', 'Restoran Brze hrane u centru Nisa', 'Trg Kralja Milana ', 'Restoran');

-- --------------------------------------------------------

--
-- Table structure for table `problem`
--

CREATE TABLE `problem` (
  `PROBLEMID` int(10) NOT NULL,
  `USERID` int(10) DEFAULT NULL,
  `PROBLEMNAME` varchar(612) COLLATE utf8_unicode_ci NOT NULL,
  `PROBLEMDETALIS` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `problem`
--

INSERT INTO `problem` (`PROBLEMID`, `USERID`, `PROBLEMNAME`, `PROBLEMDETALIS`) VALUES
(1, 2, 'Rupe', 'Rupe ispred gradske bolnice, hitno resiti!'),
(2, NULL, 'asd', 'fgsdfg');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `ROLEID` int(10) NOT NULL,
  `ROLENAME` varchar(612) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`ROLEID`, `ROLENAME`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `USERID` int(10) NOT NULL,
  `ROLEID` int(10) NOT NULL,
  `USERNAME` varchar(612) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMAIL` varchar(612) COLLATE utf8_unicode_ci NOT NULL,
  `FIRSTNAME` varchar(612) COLLATE utf8_unicode_ci NOT NULL,
  `LASTNAME` varchar(612) COLLATE utf8_unicode_ci NOT NULL,
  `PASSWORD` varchar(612) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`USERID`, `ROLEID`, `USERNAME`, `EMAIL`, `FIRSTNAME`, `LASTNAME`, `PASSWORD`) VALUES
(2, 1, 'stankovicd', 'stankovicd941@gmail.com', 'Dusan', 'Stankovic', '123'),
(3, 2, 'petar', 'pera@gmail.com', 'Petar', 'Petrovic', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`COMMENT_ID`),
  ADD KEY `FK_RELATIONSHIP_11` (`NEWSID`),
  ADD KEY `FK_RELATIONSHIP_13` (`USERID`),
  ADD KEY `FK_RELATIONSHIP_21` (`EVENTID`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`EVENTID`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`NEWSID`);

--
-- Indexes for table `place`
--
ALTER TABLE `place`
  ADD PRIMARY KEY (`PLACEID`),
  ADD KEY `FK_RELATIONSHIP_17` (`USERID`);

--
-- Indexes for table `problem`
--
ALTER TABLE `problem`
  ADD PRIMARY KEY (`PROBLEMID`),
  ADD KEY `FK_RELATIONSHIP_23` (`USERID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`ROLEID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`USERID`),
  ADD KEY `FK_RELATIONSHIP_12` (`ROLEID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `COMMENT_ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `EVENTID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `NEWSID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `place`
--
ALTER TABLE `place`
  MODIFY `PLACEID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `problem`
--
ALTER TABLE `problem`
  MODIFY `PROBLEMID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `ROLEID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `USERID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK_RELATIONSHIP_11` FOREIGN KEY (`NEWSID`) REFERENCES `news` (`NEWSID`),
  ADD CONSTRAINT `FK_RELATIONSHIP_13` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`),
  ADD CONSTRAINT `FK_RELATIONSHIP_21` FOREIGN KEY (`EVENTID`) REFERENCES `event` (`EVENTID`);

--
-- Constraints for table `place`
--
ALTER TABLE `place`
  ADD CONSTRAINT `FK_RELATIONSHIP_17` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`);

--
-- Constraints for table `problem`
--
ALTER TABLE `problem`
  ADD CONSTRAINT `FK_RELATIONSHIP_23` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_RELATIONSHIP_12` FOREIGN KEY (`ROLEID`) REFERENCES `role` (`ROLEID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
