-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 07, 2019 lúc 10:20 AM
-- Phiên bản máy phục vụ: 10.4.6-MariaDB
-- Phiên bản PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ltm`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `idStudent` int(11) NOT NULL,
  `code` int(4) NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int(2) NOT NULL,
  `gender` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `className` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `idRoom` int(10) DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `history` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `role` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`idStudent`, `code`, `password`, `name`, `age`, `gender`, `className`, `idRoom`, `status`, `history`, `role`) VALUES
(111111, 1420, '1420', 'Nguyễn Văn Anh', 20, 'Nam', '17SPT', 1211, 'No', NULL, 0),
(141111, 1411, '1411', 'Lê Thị Kim Phượng', 21, 'Nữ', '1312', 1211, 'No', NULL, 0),
(141112, 1412, '1412', 'Phan Thị Liểu', 21, 'Nữ', '1312', 1211, 'No', NULL, 0),
(141113, 1413, '1413', 'Nguyễn Thị Thu Uyên', 21, 'Nữ', '1312', 1212, 'No', NULL, 0),
(141114, 2222, '2222', 'Huỳnh Đắc Phú', 21, 'Nam', '', 0, '', NULL, 1),
(141115, 1111, '1111', 'Mai Tuấn Anh', 21, 'Nam', '', 0, '', NULL, 1),
(141116, 1416, '1416', 'Bùi Thị Như Ngọc', 21, 'Nữ', '1312', 1212, 'No', NULL, 0),
(141117, 1417, '1417', 'Bùi Tiến Dũng', 21, 'Nam', '1311', 1211, 'No', NULL, 0),
(141118, 1418, '1418', 'Tr?n Quang Duy', 0, 'nam', '16CNTT1', 1215, 'Waiting', NULL, 0),
(141127, 1419, '1419', 'Nguyen Anh Thy', 20, 'Nam', '16SPT', 1211, 'Yes', NULL, 0),
(141128, 1421, '1421', 'Nguyen Hữu Nho', 21, 'Nam', '16CNTT1', 1211, 'Yes', NULL, 0),
(141129, 1422, '1423', 'Nguyen Văn Hưng', 21, 'Nam', '15SPT', 1213, 'No', NULL, 0),
(141130, 1423, '1423', 'Lê Thanh Hoàng', 19, 'Nam', '18CNTT1', 1213, 'Yes', NULL, 0),
(141131, 1424, '1424', 'Trần Văn Minh', 19, 'Nam', '18CNTT2', 1213, 'No', NULL, 1),
(141132, 1425, '1425', 'Lê Thị Huyền', 19, 'Nu', '18CNTT2', 1212, 'Yes', NULL, 0),
(141133, 1426, '1426', 'Trần Thị Thuỳ Chi', 20, 'Nu', '17CNTT2', 1212, 'Yes', NULL, 0),
(141134, 1427, '1427', 'Hà Thị Minh Anh', 19, 'Nu', '18CNTT2', 1214, 'Yes', NULL, 0),
(141135, 1428, '1428', 'Nguyễn Thị Mai', 20, 'Nu', '18CNTT2', 1214, 'Yes', NULL, 0),
(141136, 1429, '1429', 'Đào Thị Hòa', 19, 'Nu', '18CNTT2', 1214, 'Yes', NULL, 0),
(141137, 1430, '1430', 'Trần Hữu Thịnh', 19, 'Nam', '18CNTT2', 1217, 'Yes', NULL, 1),
(141138, 1431, '1431', 'Nguyễn Văn Bình', 19, 'Nam', '18CNTT1', 1217, 'Yes', NULL, 1),
(141139, 1432, '1432', 'Nguyễn Thùy Linh', 19, 'Nữ', '18CNTT1', 1218, 'Yes', NULL, 0),
(141140, 1433, '1433', 'Lê Thị Thúy Na', 20, 'Nữ', '17SPT', 1218, 'Yes', NULL, 0),
(141141, 1434, '1434', 'Trần Thị Minh Vy', 21, 'Nữ', '16CNTT1', 1218, 'Yes', NULL, 0),
(141142, 1435, '1435', 'Lê Thị Hạnh', 20, 'Nữ', '17SPT', 1221, 'Yes', NULL, 0),
(141143, 1450, '1450', 'Trần Thị Nhã', 21, 'Nữ', '16CNTT1', 1221, 'No', NULL, 0),
(141144, 1436, '1436', 'Hồ Ngọc Hà', 21, 'Nữ', '16SPT', 1221, 'Yes', NULL, 0),
(141145, 1435, '1435', 'Lê Văn Đạt', 20, 'Nam', '17SPT', 1219, 'Yes', NULL, 1),
(141146, 1437, '1437', 'Cao Hữu Bằng', 19, 'Nam', '18SPT', 1219, 'Yes', NULL, 1),
(141147, 1425, '1425', 'Phan V?n', 20, 'nam', '17CNTT1', NULL, NULL, NULL, 0),
(141148, 1426, '1426', 'Lê Su', 20, 'nu', '17SPT', 1212, 'Yes', NULL, 0),
(141149, 1451, '1451', 'Lê Th? Anh Mai', 20, 'nu', '17CNTT1', NULL, NULL, NULL, 0),
(141150, 1452, '1452', 'Lê Huyền', 21, 'nu', '16CNTT1', NULL, NULL, NULL, 0),
(141151, 1453, '1453', 'Nguyễn Thúy', 20, 'nu', '17CNTT1', NULL, 'no', NULL, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `flat`
--

CREATE TABLE `flat` (
  `idFlat` int(4) NOT NULL,
  `nameFlat` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `idHouse` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `flat`
--

INSERT INTO `flat` (`idFlat`, `nameFlat`, `idHouse`) VALUES
(2221, 'Tầng 1', 1112),
(2222, 'Tầng 2', 1112),
(2223, 'Tầng 1', 1111),
(2224, 'Tầng 2', 1111),
(2225, 'Tầng 1', 1113),
(2226, 'Tầng 2', 1113);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `house`
--

CREATE TABLE `house` (
  `idHouse` int(4) NOT NULL,
  `nameHouse` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `house`
--

INSERT INTO `house` (`idHouse`, `nameHouse`) VALUES
(1111, 'Nhà 1'),
(1112, 'Nhà 2'),
(1113, 'Nhà 3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `room`
--

CREATE TABLE `room` (
  `idRoom` int(4) NOT NULL,
  `nameRoom` varchar(10) NOT NULL,
  `idFlat` int(4) NOT NULL,
  `idHouse` int(4) NOT NULL,
  `gender` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `amount` int(4) NOT NULL,
  `currentAmount` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `room`
--

INSERT INTO `room` (`idRoom`, `nameRoom`, `idFlat`, `idHouse`, `gender`, `amount`, `currentAmount`) VALUES
(1211, 'Phòng 1', 2221, 1111, 'Nam', 6, 0),
(1212, 'Phòng 2', 2221, 1111, 'Nữ', 6, 0),
(1213, 'Phòng 3', 2221, 1111, 'Nam', 6, 0),
(1214, 'Phòng 1', 2222, 1111, 'Nữ', 6, 0),
(1215, 'Phòng 2', 2222, 1111, 'Nam', 6, 0),
(1216, 'Phòng 3', 2221, 1111, 'Nam', 6, 0),
(1217, 'Phòng 1', 2221, 1112, 'Nam', 6, 0),
(1218, 'Phòng 2', 2221, 1112, 'Nữ', 6, 0),
(1219, 'Phòng 3', 2221, 1112, 'Nam', 6, 0),
(1220, 'Phòng 1', 2222, 1112, 'Nam', 6, 0),
(1221, 'Phòng 1', 2222, 1112, 'Nữ', 6, 0),
(1222, 'Phòng 2', 2222, 1112, 'Nam', 6, 0),
(1223, 'Phòng 3', 2222, 1112, 'Nữ', 6, 0),
(1224, 'Phòng 1', 2221, 1113, 'Nam', 6, 0),
(1225, 'Phòng 2', 2221, 1113, 'Nữ', 6, 0),
(1226, 'Phòng 3', 2221, 1113, 'Nam', 6, 0),
(1227, 'Phòng 1', 2222, 1113, 'Nữ', 6, 0),
(1228, 'Phòng 2', 2222, 1113, 'Nam', 6, 0),
(1229, 'Phòng 3', 2222, 1113, 'Nam', 6, 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`idStudent`);

--
-- Chỉ mục cho bảng `flat`
--
ALTER TABLE `flat`
  ADD PRIMARY KEY (`idFlat`);

--
-- Chỉ mục cho bảng `house`
--
ALTER TABLE `house`
  ADD PRIMARY KEY (`idHouse`);

--
-- Chỉ mục cho bảng `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`idRoom`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `idStudent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=141152;

--
-- AUTO_INCREMENT cho bảng `flat`
--
ALTER TABLE `flat`
  MODIFY `idFlat` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2227;

--
-- AUTO_INCREMENT cho bảng `house`
--
ALTER TABLE `house`
  MODIFY `idHouse` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1114;

--
-- AUTO_INCREMENT cho bảng `room`
--
ALTER TABLE `room`
  MODIFY `idRoom` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1230;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
