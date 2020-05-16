-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2020 at 01:13 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbpenggajian`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `nik` varchar(5) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`nik`, `password`) VALUES
('10001', 'ps'),
('10002', 'ps');

-- --------------------------------------------------------

--
-- Table structure for table `divisi`
--

CREATE TABLE `divisi` (
  `id` varchar(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `gaji_perjam` int(11) NOT NULL,
  `lembur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `divisi`
--

INSERT INTO `divisi` (`id`, `nama`, `gaji_perjam`, `lembur`) VALUES
('11101', 'Android Junior', 15000, 9000),
('11102', 'Android Senior', 19000, 13000),
('11103', 'Android Expert', 24000, 15000),
('11201', 'Web Junior', 13000, 8000),
('11202', 'Web Senior', 17000, 10000),
('11203', 'Web Expert', 22000, 13000),
('11301', 'Desain', 20000, 20000);

-- --------------------------------------------------------

--
-- Table structure for table `gaji`
--

CREATE TABLE `gaji` (
  `id` int(11) NOT NULL,
  `bulan` varchar(25) NOT NULL,
  `nik_admin` varchar(5) NOT NULL,
  `nik_sasaran` varchar(5) NOT NULL,
  `id_divisi` varchar(5) NOT NULL,
  `durasi_kerja` int(11) NOT NULL,
  `durasi_lembur` int(11) NOT NULL,
  `gaji` bigint(20) DEFAULT NULL,
  `bonus` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gaji`
--

INSERT INTO `gaji` (`id`, `bulan`, `nik_admin`, `nik_sasaran`, `id_divisi`, `durasi_kerja`, `durasi_lembur`, `gaji`, `bonus`) VALUES
(11002, 'Januari', '10001', '11002', '11102', 20, 5, 2280000, 65000),
(11103, 'Januari', '10001', '11001', '11102', 20, 5, 2280000, 65000);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `nik` varchar(5) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `no_hp` varchar(12) NOT NULL,
  `alamat` varchar(500) NOT NULL,
  `id_divisi` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`nik`, `password`, `nama`, `no_hp`, `alamat`, `id_divisi`) VALUES
('11001', 'ps', 'Budiartono', '078677895643', 'Solo', '11101'),
('11002', 'ps', 'Santosa', '085600934631', 'Jogja', '11101');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `divisi`
--
ALTER TABLE `divisi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gaji`
--
ALTER TABLE `gaji`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_divisi` (`id_divisi`),
  ADD KEY `nik_admin` (`nik_admin`),
  ADD KEY `nik_sasaran` (`nik_sasaran`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`nik`),
  ADD KEY `id_divisi` (`id_divisi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gaji`
--
ALTER TABLE `gaji`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11106;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gaji`
--
ALTER TABLE `gaji`
  ADD CONSTRAINT `gaji_ibfk_1` FOREIGN KEY (`id_divisi`) REFERENCES `divisi` (`id`),
  ADD CONSTRAINT `gaji_ibfk_2` FOREIGN KEY (`nik_admin`) REFERENCES `admin` (`nik`),
  ADD CONSTRAINT `gaji_ibfk_3` FOREIGN KEY (`nik_sasaran`) REFERENCES `karyawan` (`nik`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `karyawan_ibfk_1` FOREIGN KEY (`id_divisi`) REFERENCES `divisi` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
