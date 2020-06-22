-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2020 at 06:14 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pergudangan_ratnamd`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_admin`
--

CREATE TABLE `tb_admin` (
  `id_admin` varchar(18) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_admin`
--

INSERT INTO `tb_admin` (`id_admin`, `name`, `password`) VALUES
('admin1', 'Vian Azis', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `tb_aktifitas`
--

CREATE TABLE `tb_aktifitas` (
  `no_aktifitas` int(11) NOT NULL,
  `id_user` varchar(18) NOT NULL,
  `aktifitas` text NOT NULL,
  `tanggal` date NOT NULL,
  `waktu` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_aktifitas`
--

INSERT INTO `tb_aktifitas` (`no_aktifitas`, `id_user`, `aktifitas`, `tanggal`, `waktu`) VALUES
(23, 'user1', 'Telah menambahkan barang (43752398 / Brownies Tape)', '2020-06-07', '11:45:51'),
(24, 'user1', 'Telah menambahkan barang (38672309 / Pia Tape)', '2020-06-07', '11:46:27'),
(25, 'user1', 'Telah menambahkan barang (45671209 / Suwar-Suwir)', '2020-06-07', '11:47:06'),
(26, 'user1', 'Telah menambahkan barang (47359238 / Tape Bondowoso)', '2020-06-07', '15:56:15'),
(27, 'user1', 'Telah menambahkan barang (43981276 / Jenang Waluh)', '2020-06-07', '15:59:51'),
(28, 'user1', 'Telah menambahkan barang (34983276 / Jenang)', '2020-06-07', '16:12:15'),
(29, 'user1', 'Telah menambahkan barang (23985467 / Onde-Onde)', '2020-06-07', '16:26:00'),
(40, 'user2', 'Telah menambahkan barang (34984590 / Kerupuk Ikan)', '2020-06-08', '01:58:06'),
(41, 'user2', 'Telah mengeluarkan barang dari Gudang (45671209 , dengan jumlah keluar : 48)', '2020-06-08', '04:03:04'),
(42, 'user1', 'Telah mengeluarkan barang dari Gudang (38672309 , dengan jumlah keluar : 28)', '2020-06-08', '04:05:49'),
(52, 'user1', 'Telah menambahkan barang (38496183 / Terasi Udang Puger Jember)', '2020-06-09', '21:06:34'),
(53, 'user3', 'Telah menambahkan barang (78346172 / Pia)', '2020-06-22', '21:47:08'),
(54, 'user3', 'Telah mengeluarkan barang dari Gudang (78346172 , dengan jumlah keluar : 90)', '2020-06-22', '21:47:39'),
(55, 'user4', 'Telah menambahkan barang (93847623 / Prol Tape)', '2020-06-22', '22:03:29'),
(56, 'user4', 'Telah mengeluarkan barang dari Gudang (93847623 , dengan jumlah keluar : 20)', '2020-06-22', '22:03:54');

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang`
--

CREATE TABLE `tb_barang` (
  `kode_order` int(8) NOT NULL,
  `nama_brg` varchar(50) NOT NULL,
  `merek_brg` varchar(50) NOT NULL,
  `jumlah_brg` int(11) NOT NULL,
  `tgl_kadaluarsa` date NOT NULL,
  `id_user` varchar(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`kode_order`, `nama_brg`, `merek_brg`, `jumlah_brg`, `tgl_kadaluarsa`, `id_user`) VALUES
(23985467, 'Onde-Onde', 'Dapur SIP', 15, '2020-06-07', 'user1'),
(34983276, 'Jenang', 'Kue SIP', 23, '2020-09-07', 'user1'),
(34984590, 'Kerupuk Ikan', 'Dapur SIP', 38, '2020-07-08', 'user2'),
(38496183, 'Terasi Udang Puger Jember', 'Terasi SIP', 48, '2020-09-09', 'user1'),
(38672309, 'Pia Tape', 'Tape SIP', 112, '2020-08-07', 'user1'),
(43752398, 'Brownies Tape', 'Tape SIP', 30, '2020-06-11', 'user1'),
(43981276, 'Jenang Waluh', 'Jenang Mantap', 99, '2020-08-07', 'user1'),
(45671209, 'Suwar-Suwir', 'Dapur SIP', 213, '2020-09-18', 'user1'),
(47359238, 'Tape Bondowoso', 'Tapeku Enak', 40, '2020-06-07', 'user1'),
(78346172, 'Pia', 'Pia SIP', 210, '2020-08-30', 'user3'),
(93847623, 'Prol Tape', 'Tape SIP', 67, '2020-07-23', 'user4');

-- --------------------------------------------------------

--
-- Table structure for table `tb_gudang`
--

CREATE TABLE `tb_gudang` (
  `no` int(8) NOT NULL,
  `kode_order` int(8) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_gudang`
--

INSERT INTO `tb_gudang` (`no`, `kode_order`, `tgl_masuk`, `stock`) VALUES
(28, 43752398, '2020-06-07', 30),
(29, 38672309, '2020-06-07', 84),
(30, 45671209, '2020-06-07', 165),
(31, 47359238, '2020-06-07', 40),
(32, 43981276, '2020-06-07', 99),
(33, 34983276, '2020-06-07', 23),
(34, 23985467, '2020-06-07', 15),
(52, 34984590, '2020-06-08', 38),
(61, 38496183, '2020-06-09', 48),
(65, 78346172, '2020-06-22', 120),
(66, 93847623, '2020-06-22', 47);

-- --------------------------------------------------------

--
-- Table structure for table `tb_harga`
--

CREATE TABLE `tb_harga` (
  `kode_order` int(8) NOT NULL,
  `id_admin` varchar(18) DEFAULT NULL,
  `harga_brg` bigint(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_harga`
--

INSERT INTO `tb_harga` (`kode_order`, `id_admin`, `harga_brg`) VALUES
(23985467, 'admin1', 2000),
(34983276, 'admin1', 19000),
(34984590, 'admin1', 3000),
(38496183, 'admin1', 21000),
(38672309, 'admin1', 20000),
(43752398, 'admin1', 30000),
(43981276, 'admin1', 120000),
(45671209, 'admin1', 12000),
(47359238, 'admin1', 21000),
(78346172, 'admin1', 10000),
(93847623, 'admin1', 20000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_toko`
--

CREATE TABLE `tb_toko` (
  `no` int(8) NOT NULL,
  `kode_order` int(8) NOT NULL,
  `tgl_keluar` date NOT NULL,
  `jumlah_keluar` int(11) NOT NULL,
  `id_user` varchar(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_toko`
--

INSERT INTO `tb_toko` (`no`, `kode_order`, `tgl_keluar`, `jumlah_keluar`, `id_user`) VALUES
(37, 45671209, '2020-06-08', 48, 'user2'),
(38, 38672309, '2020-06-08', 28, 'user1'),
(41, 78346172, '2020-06-22', 90, 'user3'),
(42, 93847623, '2020-06-22', 20, 'user4');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` varchar(18) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `no_telp` bigint(12) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `name`, `password`, `no_telp`, `alamat`) VALUES
('user1', 'Vian Azis', 'user', 81234567890, 'Puger'),
('user2', 'Vian Azis Tio Riwanto', 'user', 81234567890, 'Grenden, Puger'),
('user3', 'Vian Azis', 'user', 28982371652, 'Puger, Jember'),
('user4', 'Vian Azis T', 'user', 82136278743, 'Puger, Jember');

-- --------------------------------------------------------

--
-- Table structure for table `tostring`
--

CREATE TABLE `tostring` (
  `aktifitas` text DEFAULT NULL,
  `pengumuman` text DEFAULT NULL,
  `no` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tostring`
--

INSERT INTO `tostring` (`aktifitas`, `pengumuman`, `no`) VALUES
('+ 2020-06-07 11:45:51 : user1 Telah menambahkan barang (43752398 / Brownies Tape)\r\n\r\n+ 2020-06-07 11:46:27 : user1 Telah menambahkan barang (38672309 / Pia Tape)\r\n\r\n+ 2020-06-07 11:47:06 : user1 Telah menambahkan barang (45671209 / Suwar-Suwir)\r\n\r\n+ 2020-06-07 15:56:15 : user1 Telah menambahkan barang (47359238 / Tape Bondowoso)\r\n\r\n+ 2020-06-07 15:59:51 : user1 Telah menambahkan barang (43981276 / Jenang Waluh)\r\n\r\n+ 2020-06-07 16:12:15 : user1 Telah menambahkan barang (34983276 / Jenang)\r\n\r\n+ 2020-06-07 16:26:00 : user1 Telah menambahkan barang (23985467 / Onde-Onde)\r\n\r\n+ 2020-06-08 01:58:06 : user2 Telah menambahkan barang (34984590 / Kerupuk Ikan)\r\n\r\n- 2020-06-08 04:03:04 : user2 Telah mengeluarkan barang dari Gudang (45671209 , dengan jumlah keluar : 48)\r\n\r\n- 2020-06-08 04:05:49 : user1 Telah mengeluarkan barang dari Gudang (38672309 , dengan jumlah keluar : 28)\r\n\r\n+ 2020-06-09 21:06:34 : user1 Telah menambahkan barang (38496183 / Terasi Udang Puger Jember)\r\n\r\n+ 2020-06-22 21:47:08 : user3 Telah menambahkan barang (78346172 / Pia)\n\n- 2020-06-22 21:47:39 : user3 Telah mengeluarkan barang dari Gudang (78346172 , dengan jumlah keluar : 90)\n\n+ 2020-06-22 22:03:29 : user4 Telah menambahkan barang (93847623 / Prol Tape)\n\n- 2020-06-22 22:03:54 : user4 Telah mengeluarkan barang dari Gudang (93847623 , dengan jumlah keluar : 20)\n\n', NULL, 1),
(NULL, '1. Untuk Format Tanggal Gunakan : YYYY/MM/DD\r\n\r\n2. Untuk tanggal merah Karyawan diliburkan\r\n\r\n3. Setiap hari Karyawan dimohon Untuk Mengecek Tanggal Kadaluarsa\n\n4. Jangan lupa Sign Out atau Logout setelah selesai menggunakan aplikasi, untuk menghindari hal yang tidak diinginkan\n\n5. Ini Pengumuman', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `tb_aktifitas`
--
ALTER TABLE `tb_aktifitas`
  ADD PRIMARY KEY (`no_aktifitas`),
  ADD KEY `fk_user_aktifitas` (`id_user`);

--
-- Indexes for table `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD PRIMARY KEY (`kode_order`),
  ADD KEY `fk_user` (`id_user`) USING BTREE;

--
-- Indexes for table `tb_gudang`
--
ALTER TABLE `tb_gudang`
  ADD PRIMARY KEY (`no`),
  ADD KEY `fk_barang` (`kode_order`) USING BTREE;

--
-- Indexes for table `tb_harga`
--
ALTER TABLE `tb_harga`
  ADD PRIMARY KEY (`kode_order`),
  ADD UNIQUE KEY `kode_order_2` (`kode_order`),
  ADD KEY `kode_order` (`kode_order`) USING BTREE,
  ADD KEY `id_admin` (`id_admin`);

--
-- Indexes for table `tb_toko`
--
ALTER TABLE `tb_toko`
  ADD PRIMARY KEY (`no`),
  ADD KEY `fk_user2` (`id_user`) USING BTREE,
  ADD KEY `kode_order` (`kode_order`) USING BTREE;

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `tostring`
--
ALTER TABLE `tostring`
  ADD PRIMARY KEY (`no`),
  ADD UNIQUE KEY `aktifitas` (`aktifitas`,`pengumuman`) USING HASH;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_aktifitas`
--
ALTER TABLE `tb_aktifitas`
  MODIFY `no_aktifitas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `tb_gudang`
--
ALTER TABLE `tb_gudang`
  MODIFY `no` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT for table `tb_toko`
--
ALTER TABLE `tb_toko`
  MODIFY `no` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `tostring`
--
ALTER TABLE `tostring`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_aktifitas`
--
ALTER TABLE `tb_aktifitas`
  ADD CONSTRAINT `fk_user_aktifitas` FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id_user`);

--
-- Constraints for table `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id_user`);

--
-- Constraints for table `tb_gudang`
--
ALTER TABLE `tb_gudang`
  ADD CONSTRAINT `fk_barang` FOREIGN KEY (`kode_order`) REFERENCES `tb_barang` (`kode_order`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_harga`
--
ALTER TABLE `tb_harga`
  ADD CONSTRAINT `fk_barang2` FOREIGN KEY (`kode_order`) REFERENCES `tb_barang` (`kode_order`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_admin` FOREIGN KEY (`id_admin`) REFERENCES `tb_admin` (`id_admin`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tb_toko`
--
ALTER TABLE `tb_toko`
  ADD CONSTRAINT `fk_gudang` FOREIGN KEY (`kode_order`) REFERENCES `tb_gudang` (`kode_order`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user2` FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
