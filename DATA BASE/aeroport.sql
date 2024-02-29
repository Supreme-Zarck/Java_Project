-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2024 at 04:41 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE aeroport;
USE aeroport;
--
-- Database: `aeroport`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`, `nom`, `prenom`) VALUES
(1, 'admin', 'admin', 'El omari', 'Zakaria'),
(2, 'taha', 'taha', 'Taabani', 'Taha Yassine'),
(3, 'mohammed', 'mohammed', 'El ouardi', 'Mohammed');

-- --------------------------------------------------------

--
-- Table structure for table `avion`
--

CREATE TABLE `avion` (
  `id` int(11) NOT NULL,
  `modele` varchar(255) DEFAULT NULL,
  `capacite_max` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `avion`
--

INSERT INTO `avion` (`id`, `modele`, `capacite_max`) VALUES
(1, 'Airbus A380', 853),
(2, 'Boeing 737', 230),
(3, 'Embraer E190', 114),
(4, 'Bombardier CRJ900', 76),
(5, 'Airbus A320', 240);

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE `employe` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `departement` varchar(50) DEFAULT NULL,
  `salaire` double DEFAULT NULL,
  `emploi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`id`, `username`, `password`, `nom`, `prenom`, `role`, `departement`, `salaire`, `emploi`) VALUES
(1, 'zakaria', '0000', 'El omari', 'Zakaria', 'pilote', 'Flight Stuff', 10000, '  | Dimanche 1:00 AM - Dimanche 9:00 AM | Lundi 9:11 PM - Mardi 5:00 AM'),
(2, 'mohammed', '0000', 'El ouardi', 'Mohammed', 'pilote', 'Flight Stuff', 10000, '  | Lundi 9:00 PM - Mardi 5:00 AM'),
(3, 'taha', '0000', 'Taabani', 'Taha Yassine', 'pilote', 'Flight Stuff', 10000, '  | Mardi 19:00 PM - Mercredi 1:00 AM'),
(4, 'employe4', '0000', 'employe4', 'employe4', 'security', 'Ground Stuff', 4000, ' | Lundi 21h - 5h| Mardi 6h - 14h| Mercredi 9h - 17h| Jeudi 4h - 12h| Vendredi 13h - 21h| Samedi 3h - 11h'),
(5, 'employe5', '0000', 'employe5', 'employe5', 'secretaire', 'Ground Stuff', 5000, ' | Lundi 5h - 13h| Mardi 11h - 19h| Mercredi 12h - 20h| Jeudi 2h - 10h| Vendredi 6h - 14h| Samedi 18h - 2h');

-- --------------------------------------------------------

--
-- Table structure for table `passenger`
--

CREATE TABLE `passenger` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `num_passport` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `passenger`
--

INSERT INTO `passenger` (`id`, `username`, `password`, `nom`, `prenom`, `num_passport`) VALUES
(1, 'zakaria', '0000', 'El omari', 'Zakaria', '1234'),
(2, 'taha', '0000', 'taha', 'taha', '2212'),
(3, 'mohammed', '0000', 'El ouardi', 'Mohammed', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `vol`
--

CREATE TABLE `vol` (
  `id` int(11) NOT NULL,
  `destination` varchar(50) NOT NULL,
  `origine` varchar(50) NOT NULL,
  `id_pilote` int(11) NOT NULL,
  `id_avion` int(11) NOT NULL,
  `depart` varchar(50) NOT NULL,
  `arrive` varchar(50) NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vol`
--

INSERT INTO `vol` (`id`, `destination`, `origine`, `id_pilote`, `id_avion`, `depart`, `arrive`, `prix`) VALUES
(1, 'Abidjan', 'Fes', 3, 3, 'Mardi 19:00 PM', 'Mercredi 1:00 AM', 211),
(2, 'Meka', 'Fes', 2, 2, 'Lundi 9:00 PM', 'Mardi 5:00 AM', 324),
(3, 'Tokyo', 'Casa', 1, 1, 'Jeudi 1:00 PM', 'Jeudi 11:00 PM', 543),
(4, 'London', 'Agadir', 1, 4, 'Dimanche 1:00 AM', 'Dimanche 9:00 AM', 324),
(5, 'Boines Aeres', 'Rabat', 1, 5, 'Mardi 19:00 PM', 'Mercredi 3:00 AM', 435),
(6, 'Kasakhistan', 'Casa', 1, 5, 'Lundi 9:11 PM', 'Mardi 5:00 AM', 232);

-- --------------------------------------------------------

--
-- Table structure for table `vol_passenger`
--

CREATE TABLE `vol_passenger` (
  `passenger_id` int(11) NOT NULL,
  `vol_id` int(11) NOT NULL,
  `class` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vol_passenger`
--

INSERT INTO `vol_passenger` (`passenger_id`, `vol_id`, `class`) VALUES
(3, 1, 'business'),
(1, 2, 'economie'),
(2, 5, 'economie');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `passenger`
--
ALTER TABLE `passenger`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vol`
--
ALTER TABLE `vol`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pilote` (`id_pilote`),
  ADD KEY `avion` (`id_avion`);

--
-- Indexes for table `vol_passenger`
--
ALTER TABLE `vol_passenger`
  ADD PRIMARY KEY (`vol_id`,`passenger_id`),
  ADD KEY `vol_passenger_ibfk_2` (`passenger_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `avion`
--
ALTER TABLE `avion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `employe`
--
ALTER TABLE `employe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `passenger`
--
ALTER TABLE `passenger`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `vol`
--
ALTER TABLE `vol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `vol`
--
ALTER TABLE `vol`
  ADD CONSTRAINT `avion` FOREIGN KEY (`id_avion`) REFERENCES `avion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pilote` FOREIGN KEY (`id_pilote`) REFERENCES `employe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `vol_passenger`
--
ALTER TABLE `vol_passenger`
  ADD CONSTRAINT `vol_passenger_ibfk_1` FOREIGN KEY (`vol_id`) REFERENCES `vol` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vol_passenger_ibfk_2` FOREIGN KEY (`passenger_id`) REFERENCES `passenger` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
