-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 11, 2020 at 03:52 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cornet`
--

-- --------------------------------------------------------

--
-- Table structure for table `aksesoris`
--

CREATE TABLE `aksesoris` (
  `id` int(11) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `satuan` varchar(5) NOT NULL,
  `harga` int(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `aksesoris`
--

INSERT INTO `aksesoris` (`id`, `nama`, `satuan`, `harga`) VALUES
(1, 'Danger plate + Number plate', 'tower', 142033),
(2, 'anti clambing', 'tower', 177542),
(3, 'vibration damper opgw', 'buah', 90794),
(4, 'Joint Box+Mounting clamp', 'buah', 1835226),
(5, 'vibration damper gsw', 'buah', 71835),
(6, 'mid span joint gsw', 'buah', 141611),
(7, 'jumper spacer acsr', 'buah', 30842),
(8, 'spacer span acsr', 'buah', 38129),
(9, 'stock bridge vibration damper', 'buah', 25150),
(10, 'compresion mid span join ACSR', 'buah', 156780),
(11, 'Locknut tipe AA', 'tower', 221373),
(12, 'Locknut tipe BB', 'tower', 324149),
(13, 'Locknut tipe CC', 'tower', 393460),
(14, 'Locknut tipe DD', 'tower', 437624),
(15, 'Locknut tipe DDR', 'tower', 414664),
(16, 'Locknut tipe EE', 'tower', 627026);

-- --------------------------------------------------------

--
-- Table structure for table `insulator`
--

CREATE TABLE `insulator` (
  `id` int(11) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `satuan` varchar(5) NOT NULL,
  `harga` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `insulator`
--

INSERT INTO `insulator` (`id`, `nama`, `satuan`, `harga`) VALUES
(1, 'Tension set single string', 'Tower', '145846.78823529'),
(2, 'Tension set  double string', 'Tower', '175891.60441176'),
(3, 'Suspension set single string', 'Tower', '133588.66323529'),
(4, 'Suspension set  double string', 'Tower', '162291.60441176'),
(5, 'sagging ACSR', 'Tower', '5019053.1'),
(6, 'clamping ACSR', 'Tower', '1296314.8'),
(7, 'sagging OPGW', 'Tower', '130751.825'),
(8, 'clamping OPGW', 'Tower', '97418.075'),
(9, 'armour rod OPGW', 'Tower', '97418.075'),
(10, 'sagging GSW', 'Tower', '130751.825'),
(11, 'clamping GSW', 'Tower', '97418.075'),
(12, 'armour rod GSW', 'Tower', '97418.075');

-- --------------------------------------------------------

--
-- Table structure for table `lock_nut`
--

CREATE TABLE `lock_nut` (
  `id` int(11) NOT NULL,
  `tipe_tower` varchar(4) NOT NULL,
  `harga` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lock_nut`
--

INSERT INTO `lock_nut` (`id`, `tipe_tower`, `harga`) VALUES
(1, 'AA', '6149115.7736667'),
(2, 'BB', '7503017.8117947'),
(3, 'CC', '9138637.7583714'),
(4, 'DD', '8987372.0062573'),
(5, 'DDR', '9464299.7223594'),
(6, 'EE', '13546240.216528');

-- --------------------------------------------------------

--
-- Table structure for table `material_em`
--

CREATE TABLE `material_em` (
  `id` int(11) NOT NULL,
  `material` varchar(60) NOT NULL,
  `harga` varchar(20) NOT NULL,
  `satuan` varchar(15) NOT NULL,
  `referensi` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `material_em`
--

INSERT INTO `material_em` (`id`, `material`, `harga`, `satuan`, `referensi`) VALUES
(2, 'Tension set single string (U 210 BP)', '13780015.40', 'Set', 'Harga Riset pasar 2020'),
(3, 'Tension set  double string (U 210 BP)', '26161479.80', 'Set', 'Harga Riset pasar 2020'),
(4, 'Suspension set single string (U 120 BP)', '8745316.67', 'Set', 'Harga Riset pasar 2020'),
(5, 'Suspension set  double string (U 120 BP)', '17354433.80', 'Set', 'Harga Riset pasar 2020'),
(6, 'Inverted Single string (U 210 BP)', '15699628.00', 'Set', 'Harga Riset pasar 2020'),
(7, 'Inverted Double string (U 210 BP)', '27353656.00', 'Set', 'Harga Riset pasar 2020'),
(8, 'Jumper Suspension Set Single String ( U 120 BP)', '8103624.60', 'Set', 'Harga Riset pasar 2020'),
(9, 'Set of Joint boxes of OPGW', '11348844.40', 'Set', 'Harga Riset pasar 2020'),
(10, 'Set of Gantry Boxes (GB) complete, installed on substation g', '11348844.40', 'Set', 'Harga Riset pasar 2020'),
(11, 'Armour Rod for OPGW 70 mm2', '130077.20', 'Set', 'Harga Riset pasar 2020'),
(12, 'Armour Rod for earthwire AS 70', '94098.40', 'Set', 'Harga Riset pasar 2020'),
(13, 'Line conductor vibration dampers', '492263.93', 'Set', 'Harga Riset pasar 2020'),
(14, 'Mid span joint', '672600.80', 'Set', 'Harga Riset pasar 2020'),
(15, 'Repair sleeves', '179990.40', 'Set', 'Harga Riset pasar 2020'),
(16, 'Armour Rod for conductor ACSR/AS 1 x 250', '367623.00', 'Set', 'Harga Riset pasar 2020'),
(17, 'Ground Wire OPGW vibration dampers', '407640.27', 'Set', 'Harga Riset pasar 2020'),
(18, 'Ground wire suspension set (OPGW 70 mm)', '1545997.20', 'Set', 'Harga Riset pasar 2020'),
(19, 'Ground wire tension set (OPGW 70 mm)', '1746233.27', 'Set', 'Harga Riset pasar 2020'),
(20, 'Ground Wire AS vibration dampers', '415306.93', 'Set', 'Harga Riset pasar 2020'),
(21, 'Comp. Joint', '320616.07', 'Set', 'Harga Riset pasar 2020'),
(22, 'Ground wire suspension clamp (AS 70)', '955620.60', 'Set', 'Harga Riset pasar 2020'),
(23, 'Ground wire tension clamp (AS 70)', '1327748.40', 'Set', 'Harga Riset pasar 2020'),
(24, 'ACSR 250 mm2', '61000.00', 'Meter', 'Harga Riset pasar 2020'),
(25, 'GSW 55 mm2', '21083.33', 'Meter', 'Harga Riset pasar 2020'),
(26, 'GSW 70 mm2', '26463.33', 'Meter', 'Harga Riset pasar 2020'),
(27, 'GSW AS 55 mm2', '21340.00', 'Meter', 'Harga Riset pasar 2020'),
(28, 'GSW AS 70 mm2', '24693.33', 'Meter', 'Harga Riset pasar 2020'),
(29, 'OPGW 70 mm2, 24 core', '68000.00', 'Meter', 'Harga Riset pasar 2020'),
(30, 'Danger plate', '900000.00', 'tower', 'Harga Riset pasar 2020'),
(31, 'Number plate', '900000.00', 'tower', 'Harga Riset pasar 2020'),
(32, 'Anti clambing', '1500000.00', 'tower', 'Harga Riset pasar 2020'),
(33, 'Locknut tipe AA', '5814857.00', 'tower', 'Harga Riset pasar 2020'),
(34, 'Locknut tipe BB', '7016571.00', 'tower', 'Harga Riset pasar 2020'),
(35, 'Locknut tipe CC', '8548114.00', 'tower', 'Harga Riset pasar 2020'),
(36, 'Locknut tipe DD', '8332914.00', 'tower', 'Harga Riset pasar 2020'),
(37, 'Locknut tipe DDR', '8842286.00', 'tower', 'Harga Riset pasar 2020'),
(38, 'Locknut tipe EE', '12607200.00', 'tower', 'Harga Riset pasar 2020');

-- --------------------------------------------------------

--
-- Table structure for table `material_sipil`
--

CREATE TABLE `material_sipil` (
  `id` int(11) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `harga` varchar(20) NOT NULL,
  `satuan` varchar(5) NOT NULL,
  `referensi` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `material_sipil`
--

INSERT INTO `material_sipil` (`id`, `nama`, `harga`, `satuan`, `referensi`) VALUES
(1, 'Batu kali', '232000', 'm³', 'Pemprov NTB 2020'),
(2, 'Kerikil 1-2 cm', '389000', 'm³', 'Pemprov NTB 2020'),
(3, 'Pasir Beton', '217000', 'm³', 'Pemprov NTB 2020'),
(4, 'Air', '1000', 'Liter', 'Pemprov NTB 2020'),
(5, 'Semen/kg', '1600', 'Kg', 'Pemprov NTB 2020'),
(6, 'Batu belah 15-20 cm', '217000', 'm³', 'Pemprov NTB 2020'),
(7, 'Batu Split 5-7cm', '297000', 'm³', 'Pemprov NTB 2020'),
(8, 'Batu Split 3-5cm', '373000', 'm³', 'Pemprov NTB 2020'),
(9, 'Batu Split 2-3cm', '403000', 'm³', 'Pemprov NTB 2020'),
(10, 'Pasir pasang', '195000', 'm³', 'Pemprov NTB 2020'),
(11, 'Pasir urug', '173000', 'm³', 'Pemprov NTB 2020'),
(12, 'Besi beton Ulir', '22000', 'kg', 'Pemprov NTB 2020'),
(13, 'Besi beton Polos', '20000', 'kg', 'Pemprov NTB 2020'),
(14, 'Kawat Ikat beton', '33000', 'kg', 'Pemprov NTB 2020'),
(15, 'Kawat bronjong', '42000', 'Kg', 'Pemprov NTB 2020'),
(16, 'Besi Strip 5mm', '33000', 'Kg', 'Pemprov NTB 2020'),
(17, 'Multipleks 12mm', '270000', 'Lbr', 'Pemprov NTB 2020'),
(18, 'Multipleks 9mm', '202000', 'Lbr', 'Pemprov NTB 2020'),
(19, 'Multipleks 6mm', '118000', 'Lbr', 'Pemprov NTB 2020'),
(20, 'Multipleks 4mm', '115000', 'Lbr', 'Pemprov NTB 2020'),
(21, 'Papan kayu kls I', '23752000', 'm³', 'Pemprov NTB 2020'),
(22, 'Papan kayu kls II', '17994000', 'm³', 'Pemprov NTB 2020'),
(23, 'Papan Kayu kls III', '6478000', 'm³', 'Pemprov NTB 2020'),
(24, 'Balok Kayu kls I', '23032000', 'm³', 'Pemprov NTB 2020'),
(25, 'Balok Kayu kls II', '17274000', 'm³', 'Pemprov NTB 2020'),
(26, 'Balok Kayu Kelas III', '5758000', 'm³', 'Pemprov NTB 2020'),
(27, 'Paku 5 - 7 cm', '24500', 'kg', 'Pemprov NTB 2020'),
(28, 'Paku 5 - 12 cm', '23000', 'kg', 'Pemprov NTB 2020'),
(29, 'Paku 1 - 2,5 cm', '26500', 'kg', 'Pemprov NTB 2020'),
(30, 'Beton Mutu K-225', '1398795.7777778', 'm³', 'Riset Pasar 2020'),
(31, 'Beton Mutu K-100', '1143782.037037', 'm³', 'Riset Pasar 2020');

-- --------------------------------------------------------

--
-- Table structure for table `material_tower`
--

CREATE TABLE `material_tower` (
  `id` int(11) NOT NULL,
  `tipe_tower` varchar(10) NOT NULL,
  `basis` varchar(10) NOT NULL,
  `berat` varchar(20) NOT NULL,
  `harga_permenperin` varchar(20) NOT NULL,
  `harga_transport` varchar(20) NOT NULL,
  `harga_erection` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `material_tower`
--

INSERT INTO `material_tower` (`id`, `tipe_tower`, `basis`, `berat`, `harga_permenperin`, `harga_transport`, `harga_erection`) VALUES
(222, 'AA', 'BASIS +0', '  4,270.35 ', '95830924.35', '18361269.74', '8590016.85'),
(223, 'AA', 'BASIS +3', '  4,827.45 ', '107941782.00', '20756638.59', '9709868.56'),
(224, 'AA', 'BASIS +6', '  5,269.29 ', '118543217.13', '22656422.78', '10600023.43'),
(225, 'AA', 'BASIS +9', '  5,923.94 ', '132139405.64', '25471228.41', '11914694.14'),
(226, 'AA', 'BASIS +12', '  6,663.71 ', '149147157.22', '28652025.42', '13403590.65'),
(227, 'AA', 'BASIS +15', '  7,508.92 ', '166848202.40', '32286183.93', '15101239.07'),
(228, 'BB', 'BASIS +0', '  5,344.96 ', '120288324.80', '22981781.89', '10752331.32'),
(229, 'BB', 'BASIS +3', '  5,995.30 ', '134564508.50', '25778055.77', '12059885.68'),
(230, 'BB', 'BASIS +6', '  6,525.36 ', '146128911.84', '28057160.44', '13125465.82'),
(231, 'BB', 'BASIS +9', '  7,258.10 ', '161659661.30', '31207730.49', '14597582.66'),
(232, 'BB', 'BASIS +12', '  8,010.43 ', '178232067.50', '34442531.87', '16110309.80'),
(233, 'BB', 'BASIS +15', '  8,967.47 ', '199454467.74', '38557527.03', '18034933.27'),
(234, 'BB', 'BASIS +18', '  10,760.96 ', '239345361.29', '46269032.43', '21641919.92'),
(235, 'CC', 'BASIS +0', '  6,264.04 ', '140922107.88', '26933560.03', '12601122.88'),
(236, 'CC', 'BASIS +3', '  7,235.49 ', '161886853.26', '31110514.03', '14553570.71'),
(237, 'CC', 'BASIS +6', '  8,121.66 ', '181778994.12', '34920788.69', '16336155.99'),
(238, 'CC', 'BASIS +9', '  8,956.80 ', '200265091.20', '38511649.11', '18015570.18'),
(239, 'CC', 'BASIS +12', '  10,180.74 ', '227040682.74', '43774237.07', '20476203.37'),
(240, 'CC', 'BASIS +15', '  11,561.85 ', '257898626.10', '49712610.56', '23254102.25'),
(241, 'DD', 'BASIS +0', '  8,846.54 ', '196578965.34', '38037563.01', '17791353.26'),
(242, 'DD', 'BASIS +3', '  9,771.94 ', '218109700.80', '42016515.32', '19654368.07'),
(243, 'DD', 'BASIS +6', '  10,788.20 ', '239767745.00', '46386139.35', '21696328.82'),
(244, 'DD', 'BASIS +9', '  11,859.13 ', '263865642.50', '50990828.57', '23850686.95'),
(245, 'DD', 'BASIS +12', '  13,256.56 ', '293738856.48', '56999373.35', '26658712.38'),
(246, 'DD', 'BASIS +15', '  14,441.30 ', '320654625.20', '62093412.64', '29042532.58'),
(247, 'DDR', 'BASIS +0', '  9,323.22 ', '210630186.24', '40087149.12', '18756926.37'),
(248, 'DDR', 'BASIS +3', '  10,248.62 ', '231096132.38', '44066101.44', '20617811.60'),
(249, 'DDR', 'BASIS +6', '  11,264.09 ', '253937644.96', '48432328.70', '22660585.62'),
(250, 'DDR', 'BASIS +9', '  12,335.81 ', '278098500.64', '53040414.69', '24816623.33'),
(251, 'DDR', 'BASIS +12', '  13,730.95 ', '309550536.80', '59039113.12', '27623302.74'),
(252, 'DDR', 'BASIS +15', '  14,951.26 ', '337061205.44', '64286093.13', '30078267.08'),
(253, 'EE', 'BASIS +0', '  9,323.22 ', '211142963.34', '40087149.12', '18757951.93'),
(254, 'EE', 'BASIS +3', '  10,248.62 ', '231536823.04', '44066101.44', '20618692.98'),
(255, 'EE', 'BASIS +6', '  11,264.09 ', '253993965.41', '48432328.70', '22660698.26'),
(256, 'EE', 'BASIS +9', '  12,335.81 ', '278098500.64', '53040414.69', '24816623.33'),
(257, 'EE', 'BASIS +12', '  13,730.95 ', '309550536.80', '59039113.12', '27623302.74'),
(258, 'EE', 'BASIS +15', '  14,951.26 ', '337061205.44', '64286093.13', '30078267.08');

-- --------------------------------------------------------

--
-- Table structure for table `pondasi_tower`
--

CREATE TABLE `pondasi_tower` (
  `id` int(11) NOT NULL,
  `tipe` varchar(3) NOT NULL,
  `class` varchar(2) NOT NULL,
  `harga_pondasi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pondasi_tower`
--

INSERT INTO `pondasi_tower` (`id`, `tipe`, `class`, `harga_pondasi`) VALUES
(92, 'AA', '1', '103932375.89'),
(93, 'AA', '2', '118636133.11'),
(94, 'AA', '3', '145980721.60'),
(95, 'AA', '4A', '133318964.31'),
(96, 'AA', '7', '262160174.66'),
(97, 'BB', '1', '149755798.35'),
(98, 'BB', '2', '167920452.01'),
(99, 'BB', '3', '212877228.99'),
(100, 'BB', '4A', '199212409.12'),
(101, 'BB', '7', '326606130.55'),
(102, 'CC', '1', '205230299.72'),
(103, 'CC', '2', '242489876.77'),
(104, 'CC', '3', '266336477.65'),
(105, 'CC', '4A', '295783226.56'),
(106, 'CC', '7', '459559969.69'),
(107, 'DD', '1', '270700899.76'),
(108, 'DD', '2', '298865309.68'),
(109, 'DD', '3', '384081560.45'),
(110, 'DD', '4A', '330829058.32'),
(111, 'DD', '7', '524957031.55'),
(112, 'DDR', '1', '445693413.57'),
(113, 'DDR', '2', '479744877.12'),
(114, 'DDR', '3', '540408344.50'),
(115, 'DDR', '4A', '546004279.53'),
(116, 'DDR', '7', '950127623.74'),
(117, 'EE', '1', '427273169.72'),
(118, 'EE', '2', '460727301.75'),
(119, 'EE', '3', '495225026.57'),
(120, 'EE', '4A', '514636404.35'),
(121, 'EE', '7', '890695022.66');

-- --------------------------------------------------------

--
-- Table structure for table `sewa_alat`
--

CREATE TABLE `sewa_alat` (
  `id` int(11) NOT NULL,
  `material` varchar(60) NOT NULL,
  `harga` varchar(20) NOT NULL,
  `satuan` varchar(15) NOT NULL,
  `referensi` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sewa_alat`
--

INSERT INTO `sewa_alat` (`id`, `material`, `harga`, `satuan`, `referensi`) VALUES
(1, 'Dump Truck 3.5 Ton', '2416000', 'Hari', 'Riset Pasar 2020'),
(2, 'Dump Truck 10 Ton', '3864000', 'Hari', 'Riset Pasar 2020'),
(3, 'Flat bed truck 10 ton', '515000', 'Jam', 'Riset Pasar 2020'),
(4, 'Excavator', '580000', 'Jam', 'Riset Pasar 2020'),
(5, 'Crane 5 Ton', '3463440.2945818', 'Shift', 'Riset Pasar 2020'),
(6, 'Forklift 2,5 Ton (8jam)', '2597580.2209363', 'Hari', 'Riset Pasar 2020'),
(7, 'Truck Crane 10 Ton', '4156128.3534982', 'Hari', 'Riset Pasar 2020'),
(8, 'Trailer 20 feet', '7165115.5809066', 'Hari', 'Riset Pasar 2020'),
(9, 'Concrete vibrator', '40000', 'Jam', 'Riset Pasar 2020'),
(10, 'Chain Saw', '103725', 'Hari', 'Riset Pasar 2020'),
(11, 'Jack hammer', '27000', 'Hari', 'Riset Pasar 2020'),
(12, 'Insulation Test Equipment', '10000', 'Jam', 'Riset Pasar 2020'),
(13, 'Supporting of Earthing Device', '10000', 'Jam', 'Riset Pasar 2020'),
(14, 'Theodolit', '53316.666666667', 'Hari', 'Riset Pasar 2020'),
(15, 'Total Station', '274200', 'Hari', 'Riset Pasar 2020'),
(16, 'GPS Handy', '30466.666666667', 'Hari', 'Riset Pasar 2020'),
(17, 'GPS Geodetik', '216465.01841136', 'Hari', 'Riset Pasar 2020'),
(18, 'Handy Talky', '43293.003682272', 'Hari', 'Riset Pasar 2020');

-- --------------------------------------------------------

--
-- Table structure for table `stringing`
--

CREATE TABLE `stringing` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `satuan` varchar(5) NOT NULL,
  `harga` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stringing`
--

INSERT INTO `stringing` (`id`, `nama`, `satuan`, `harga`) VALUES
(1, 'Eret-eret', 'KMR', '13489303'),
(2, 'ACSR 250 mm', 'KMR', '45871786.233895'),
(3, 'OPGW', 'KMR', '6119723.8421959'),
(4, 'GSW', 'KMR', '6119723.8421959');

-- --------------------------------------------------------

--
-- Table structure for table `transport_material`
--

CREATE TABLE `transport_material` (
  `id` int(11) NOT NULL,
  `material` varchar(60) NOT NULL,
  `harga_material` varchar(20) NOT NULL,
  `transport_lombok` varchar(20) NOT NULL,
  `transport_sumbawa` varchar(20) NOT NULL,
  `transport_flores` varchar(20) NOT NULL,
  `transport_timor` varchar(20) NOT NULL,
  `biaya_bongkar` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transport_material`
--

INSERT INTO `transport_material` (`id`, `material`, `harga_material`, `transport_lombok`, `transport_sumbawa`, `transport_flores`, `transport_timor`, `biaya_bongkar`) VALUES
(1, 'Tension set single string (U 210 BP)', '13780015.4', '285166.66666667', '323229.16666667', '353638.88888889', '451111.11111111', '56907.154333333'),
(2, 'Tension set  double string (U 210 BP)', '26161479.8', '531000', '601875', '658500', '840000', '105965.046'),
(3, 'Suspension set single string (U 120 BP)', '8745316.6666667', '161266.66666667', '182791.66666667', '199988.88888889', '255111.11111111', '32181.976933333'),
(4, 'Suspension set  double string (U 120 BP)', '17354433.8', '295000', '334375', '365833.33333333', '466666.66666667', '58869.47'),
(5, 'Inverted Single string (U 210 BP)', '15699628', '275333.33333333', '312083.33333333', '341444.44444444', '435555.55555556', '54944.838666667'),
(6, 'Inverted Double string (U 210 BP)', '27353656', '531000', '601875', '658500', '840000', '105965.046'),
(7, 'Jumper Suspension Set Single String ( U 120 BP)', '8103624.6', '141600', '160500', '175600', '224000', '28257.3456'),
(8, 'Set of Joint boxes of OPGW', '11348844.4', '25566.666666667', '28979.166666667', '31705.555555556', '40444.444444444', '5102.0207333333'),
(9, 'Set of Gantry Boxes (GB) complete, installed on substation g', '10365511.066667', '25566.666666667', '28979.166666667', '31705.555555556', '40444.444444444', '5102.0207333333'),
(10, 'Armour Rod for OPGW 70 mm2', '130077.2', '668.66666666667', '757.91666666667', '829.22222222222', '1057.7777777778', '133.43746533333'),
(11, 'Armour Rod for earthwire AS 70', '94098.4', '668.66666666667', '757.91666666667', '829.22222222222', '1057.7777777778', '133.43746533333'),
(12, 'Line conductor vibration dampers', '492263.93333333', '9046.6666666667', '10254.166666667', '11218.888888889', '14311.111111111', '1805.3304133333'),
(13, 'Mid span joint', '672600.8', '6096.6666666667', '6910.4166666667', '7560.5555555556', '9644.4444444444', '1216.6357133333'),
(14, 'Repair sleeves', '179990.4', '2360', '2675', '2926.6666666667', '3733.3333333333', '470.95576'),
(15, 'Armour Rod for conductor ACSR/AS 1 x 250', '367623', '1966.6666666667', '2229.1666666667', '2438.8888888889', '3111.1111111111', '392.46313333333'),
(16, 'Ground Wire OPGW vibration dampers', '407640.26666667', '983.33333333333', '1114.5833333333', '1219.4444444444', '1555.5555555556', '196.23156666667'),
(17, 'Ground wire suspension set (OPGW 70 mm)', '1545997.2', '5900', '6687.5', '7316.6666666667', '9333.3333333333', '1177.3894'),
(18, 'Ground wire tension set (OPGW 70 mm)', '1746233.2666667', '19666.666666667', '22291.666666667', '24388.888888889', '31111.111111111', '3924.6313333333'),
(19, 'Ground Wire AS vibration dampers', '415306.93333333', '983.33333333333', '1114.5833333333', '1219.4444444444', '1555.5555555556', '196.23156666667'),
(20, 'Comp. Joint', '320616.06666667', '2360', '2675', '2926.6666666667', '3733.3333333333', '470.95576'),
(21, 'Ground wire suspension clamp (AS 70)', '955620.6', '5900', '6687.5', '7316.6666666667', '9333.3333333333', '1177.3894'),
(22, 'Ground wire tension clamp (AS 70)', '1327748.4', '5900', '6687.5', '7316.6666666667', '9333.3333333333', '1177.3894'),
(23, 'ACSR 250', '262124271.84466', '13193167', '14954119.375', '16361017.833333', '20870546.666667', '2632795.759022'),
(24, 'OPGW', '66019417.475728', '969281.5', '1098655.9375', '1202018.5833333', '1533326.6666667', '193427.417579'),
(25, 'GSW', '31553398.058252', '1147540.1666667', '1300707.6041667', '1423079.4722222', '1815317.7777778', '229000.27598433'),
(26, 'Lock Nut Type AA', '5814857.1428571', '101255.23809524', '114770.23809524', '125567.93650794', '160177.77777778', '20206.244750476'),
(27, 'Lock Nut Type BB', '7016571.4285714', '148264.19047619', '168053.69047619', '183864.34920635', '234542.22222222', '29587.234960381'),
(28, 'Lock Nut Type CC', '8548114.2857143', '179966.85714286', '203987.85714286', '223179.23809524', '284693.33333333', '35913.740669714'),
(29, 'Lock Nut Type DD', '8332914.2857143', '200167.33333333', '226884.58333333', '248230.11111111', '316648.88888889', '39944.897710667'),
(30, 'Lock Nut Type DDR', '8842285.7142857', '189665.33333333', '214980.83333333', '235206.44444444', '300035.55555556', '37849.144578667'),
(31, 'Lock Nut Type EE', '12607200', '286799', '325079.375', '355663.16666667', '453693.33333333', '57232.898734');

-- --------------------------------------------------------

--
-- Table structure for table `upah_tenaga_kerja`
--

CREATE TABLE `upah_tenaga_kerja` (
  `id` int(11) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `harga` varchar(20) NOT NULL,
  `referensi` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `upah_tenaga_kerja`
--

INSERT INTO `upah_tenaga_kerja` (`id`, `nama`, `harga`, `referensi`) VALUES
(1, 'Pekerja', '82500', 'Pemprov NTB 2020'),
(2, 'Mandor', '110500', 'Pemprov NTB 2020'),
(3, 'Tukang batu', '98500', 'Pemprov NTB 2020'),
(5, 'Tukang kayu', '104000', 'Pemprov NTB 2020'),
(6, 'Kepala tukang kayu', '104000', 'Pemprov NTB 2020'),
(7, 'Tukang besi', '98500', 'Pemprov NTB 2020'),
(8, 'Kepala tukang besi', '104000', 'Pemprov NTB 2020'),
(9, 'Tukang cat', '98500', 'Pemprov NTB 2020'),
(10, 'Kepala tukang cat', '104000', 'Pemprov NTB 2020'),
(11, 'Tukang las', '98500', 'Pemprov NTB 2020'),
(12, 'Kepala tukang las', '107000', 'Pemprov NTB 2020'),
(13, 'Tukang pipa', '84000', 'Pemprov NTB 2020'),
(14, 'Kepala tukang pipa', '95500', 'Pemprov NTB 2020'),
(15, 'Tukang Listrik', '87000', 'Pemprov NTB 2020'),
(16, 'Kepala tukang Listrik', '95500', 'Pemprov NTB 2020'),
(17, 'Tukang Alumunium', '98500', 'Pemprov NTB 2020'),
(18, 'Pekerja terlatih', '85000', 'Pemprov NTB 2020'),
(19, 'Penjaga malam', '100909.0909', 'Pemprov NTB 2020'),
(20, 'Sopir', '92500', 'Pemprov NTB 2020'),
(21, 'Pekerja Stringing', '150000', 'Pemprov NTB 2020'),
(22, 'Operator stringing', '113000', 'Pemprov NTB 2020'),
(23, 'Pembantu operator', '81000', 'Pemprov NTB 2020'),
(24, 'Operator alat berat', '113000', 'Harga Pasar'),
(25, ' Pekerja Erection', '125000', 'Harga Pasar'),
(26, 'Pekerja Erection Terampil 1', '200000', 'Harga Pasar'),
(27, 'Pekerjan Erection Terampil 2', '150000', 'Harga Pasar'),
(28, 'Pekerja Stringing', '125000', 'Harga Pasar'),
(29, 'Pekerja Stringing Terampil 1', '200000', 'Harga Pasar'),
(30, 'Pekerjan Stringing Terampil 2', '150000', 'Inkindo 2020'),
(31, 'Pekerja  Sondir', '269760', 'Inkindo 2020'),
(32, 'Asisten Sondir ', '134880', 'Inkindo 2020'),
(33, 'Spesial Teknisi', '550057.5', 'Inkindo 2020'),
(34, 'Teknisi', '474187.5', 'Inkindo 2020'),
(35, 'Pengawas K3', '550057.5', 'Inkindo 2020'),
(36, 'Suveyor', '448897.5', 'Inkindo 2020'),
(37, 'Supervisor ', '474187.5', 'Inkindo 2020'),
(38, 'Asistan Surveyor', '269760', 'Inkindo 2020'),
(39, 'Ahli Geodesi', '569025', 'Inkindo 2020'),
(40, 'Ahli Geoteknik', '569025', 'Inkindo 2020'),
(41, 'Computer Operator/Drafter', '269760', 'Inkindo 2020'),
(42, 'Administrator', '432037.5', 'Inkindo 2020'),
(43, 'CAD/CAM Operator', '448897.5', 'Inkindo 2020'),
(44, 'Engineer Gardu Induk', '12623333.33', 'Rata-rata harga Riset Pasar 2020'),
(45, 'Engineer Telekomunikasi', '12623333.33', 'Rata-rata harga Riset Pasar 2020'),
(46, 'Engineer SOGI', '12623333.33', 'Rata-rata harga Riset Pasar 2020');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('admin', 'admin'),
('ilham', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aksesoris`
--
ALTER TABLE `aksesoris`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `insulator`
--
ALTER TABLE `insulator`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lock_nut`
--
ALTER TABLE `lock_nut`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `material_em`
--
ALTER TABLE `material_em`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `material_sipil`
--
ALTER TABLE `material_sipil`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `material_tower`
--
ALTER TABLE `material_tower`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pondasi_tower`
--
ALTER TABLE `pondasi_tower`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sewa_alat`
--
ALTER TABLE `sewa_alat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stringing`
--
ALTER TABLE `stringing`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transport_material`
--
ALTER TABLE `transport_material`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `upah_tenaga_kerja`
--
ALTER TABLE `upah_tenaga_kerja`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aksesoris`
--
ALTER TABLE `aksesoris`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `insulator`
--
ALTER TABLE `insulator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `lock_nut`
--
ALTER TABLE `lock_nut`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `material_em`
--
ALTER TABLE `material_em`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `material_sipil`
--
ALTER TABLE `material_sipil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `material_tower`
--
ALTER TABLE `material_tower`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=259;

--
-- AUTO_INCREMENT for table `pondasi_tower`
--
ALTER TABLE `pondasi_tower`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=122;

--
-- AUTO_INCREMENT for table `sewa_alat`
--
ALTER TABLE `sewa_alat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `stringing`
--
ALTER TABLE `stringing`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transport_material`
--
ALTER TABLE `transport_material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `upah_tenaga_kerja`
--
ALTER TABLE `upah_tenaga_kerja`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
