-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.27-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for csdl_duanquocte
CREATE DATABASE IF NOT EXISTS `csdl_duanquocte` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `csdl_duanquocte`;

-- Dumping structure for table csdl_duanquocte.bang_chucvu
CREATE TABLE IF NOT EXISTS `bang_chucvu` (
  `machucvu` int(50) NOT NULL AUTO_INCREMENT,
  `tenchucvu` varchar(700) DEFAULT NULL,
  `ngaytao` timestamp NULL DEFAULT NULL,
  `ngaycapnhat` timestamp NULL DEFAULT NULL,
  `nguoitao` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`machucvu`)
) ENGINE=InnoDB AUTO_INCREMENT=9993 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_chucvu: ~5 rows (approximately)
INSERT INTO `bang_chucvu` (`machucvu`, `tenchucvu`, `ngaytao`, `ngaycapnhat`, `nguoitao`) VALUES
	(0, 'NULL', '2023-02-24 06:58:12', '2023-02-24 06:58:12', NULL),
	(3, 'Giảng viên', '2023-02-06 17:00:00', '2023-02-06 17:00:00', NULL),
	(4, 'Chuyên viên', '2023-02-16 13:15:26', '2023-02-16 13:15:27', NULL),
	(5, 'Khác', '2023-02-16 13:15:28', '2023-02-16 13:15:29', NULL),
	(5172, 'Trưởng khoa', '2023-04-12 07:15:07', '2023-05-06 07:50:47', NULL);

-- Dumping structure for table csdl_duanquocte.bang_coquanpheduyet
CREATE TABLE IF NOT EXISTS `bang_coquanpheduyet` (
  `macoquanpheduyet` int(50) NOT NULL AUTO_INCREMENT,
  `tencoquanpheduyet` varchar(700) DEFAULT NULL,
  `ngaytao` timestamp NULL DEFAULT NULL,
  `ngaycapnhat` timestamp NULL DEFAULT NULL,
  `nguoitao` int(70) DEFAULT NULL,
  PRIMARY KEY (`macoquanpheduyet`)
) ENGINE=InnoDB AUTO_INCREMENT=8818 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_coquanpheduyet: ~10 rows (approximately)
INSERT INTO `bang_coquanpheduyet` (`macoquanpheduyet`, `tencoquanpheduyet`, `ngaytao`, `ngaycapnhat`, `nguoitao`) VALUES
	(0, 'NULL', '2023-03-16 12:57:50', NULL, NULL),
	(2029, 'Sở du lịch truyền thông', '2023-04-05 07:38:07', NULL, 8),
	(3491, 'Rister Company', '2023-04-06 05:19:45', NULL, 1),
	(4900, 'Hiệp hội Oiter', '2023-04-12 02:11:29', NULL, 7),
	(4990, 'Bộ y tế', '2023-04-05 07:50:38', NULL, 1),
	(5497, 'Đại học An Giang', '2023-04-05 06:33:12', NULL, 4),
	(5617, 'Trung tâm khoa học Vinnos ', '2023-04-05 07:17:45', NULL, 1),
	(5675, 'Bộ giáo dục', '2023-04-05 07:07:53', NULL, 4),
	(7280, 'Sở nông nghiệp An Giang', '2023-04-06 05:45:31', NULL, 3),
	(8274, 'Sở thông tin truyền thông', '2023-04-05 06:37:08', NULL, 4);

-- Dumping structure for table csdl_duanquocte.bang_danhmuc
CREATE TABLE IF NOT EXISTS `bang_danhmuc` (
  `madanhmuc` int(50) NOT NULL AUTO_INCREMENT,
  `tendanhmuc` varchar(700) DEFAULT NULL,
  `ngaytao` timestamp NULL DEFAULT NULL,
  `ngaycapnhat` timestamp NULL DEFAULT NULL,
  `nguoitao` int(50) DEFAULT NULL,
  PRIMARY KEY (`madanhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=9944 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_danhmuc: ~8 rows (approximately)
INSERT INTO `bang_danhmuc` (`madanhmuc`, `tendanhmuc`, `ngaytao`, `ngaycapnhat`, `nguoitao`) VALUES
	(0, 'NULL', '2023-02-24 06:55:28', '2023-02-24 06:55:29', NULL),
	(7033, 'Đời sống', '2023-04-05 06:31:56', NULL, 4),
	(7322, 'Giáo dục', '2023-04-05 06:35:12', NULL, 4),
	(8350, 'Du lịch', '2023-04-05 07:37:12', NULL, 8),
	(8871, 'Văn hóa', '2023-05-09 15:54:35', NULL, 8),
	(9660, 'Công nghệ', '2023-04-05 07:16:27', NULL, 1),
	(9752, 'Khoa học', '2023-04-06 05:18:39', NULL, 1),
	(9782, 'Nông nghiệp', '2023-04-06 05:44:55', NULL, 3),
	(9943, 'Ngôn ngữ', '2023-04-12 02:10:45', NULL, 7);

-- Dumping structure for table csdl_duanquocte.bang_doitacthuchien
CREATE TABLE IF NOT EXISTS `bang_doitacthuchien` (
  `madoitac` int(50) NOT NULL AUTO_INCREMENT,
  `tendoitac` varchar(700) DEFAULT NULL,
  `ngaytao` timestamp NULL DEFAULT NULL,
  `ngaycapnhat` timestamp NULL DEFAULT NULL,
  `nguoitao` int(50) DEFAULT NULL,
  PRIMARY KEY (`madoitac`)
) ENGINE=InnoDB AUTO_INCREMENT=9906 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_doitacthuchien: ~9 rows (approximately)
INSERT INTO `bang_doitacthuchien` (`madoitac`, `tendoitac`, `ngaytao`, `ngaycapnhat`, `nguoitao`) VALUES
	(0, 'NULL', '2023-02-24 06:55:41', '2023-02-24 06:55:42', NULL),
	(522, 'OpenAI', '2023-04-05 07:08:08', NULL, 4),
	(2097, 'Công ty AVF', '2023-04-06 05:20:25', NULL, 1),
	(3080, 'Công ty công nghệ TrayX', '2023-04-05 07:21:39', NULL, 1),
	(3879, 'Bệnh viện đa khoa An Giang', '2023-04-05 07:50:55', NULL, 1),
	(3973, 'Viện nghiên cứu Invertion', '2023-04-05 06:34:05', NULL, 4),
	(4055, 'Công ty phân bón Phú Mỹ', '2023-04-06 05:45:52', NULL, 3),
	(9666, 'Công ty anh ngữ ISORA', '2023-04-12 03:31:51', NULL, 7),
	(9697, 'Công ty Hành Trình Xanh', '2023-04-05 07:18:15', NULL, 1),
	(9905, 'Khoa Du Lịch Đại Học Đồng Tháp', '2023-05-09 15:55:57', NULL, 8);

-- Dumping structure for table csdl_duanquocte.bang_donvitiente
CREATE TABLE IF NOT EXISTS `bang_donvitiente` (
  `madonvitiente` int(50) NOT NULL AUTO_INCREMENT,
  `tendonvitiente` varchar(100) DEFAULT NULL,
  `ngaytao` timestamp NULL DEFAULT NULL,
  `ngaycapnhat` timestamp NULL DEFAULT NULL,
  `nguoitao` int(50) DEFAULT NULL,
  PRIMARY KEY (`madonvitiente`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3719 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_donvitiente: ~6 rows (approximately)
INSERT INTO `bang_donvitiente` (`madonvitiente`, `tendonvitiente`, `ngaytao`, `ngaycapnhat`, `nguoitao`) VALUES
	(0, 'NULL', '2023-03-03 09:55:22', '2023-03-03 09:55:23', NULL),
	(1, 'TFT', '2023-02-15 12:47:55', '2023-02-15 12:47:57', NULL),
	(839, 'CND', '2023-03-03 09:40:49', NULL, NULL),
	(841, 'VND', '2023-03-03 10:28:57', '2023-03-03 10:28:58', NULL),
	(842, 'USD', '2023-03-03 10:29:10', '2023-03-03 10:29:11', NULL),
	(1855, 'MVN', '2023-03-16 08:34:15', NULL, NULL);

-- Dumping structure for table csdl_duanquocte.bang_donvitructhuoc
CREATE TABLE IF NOT EXISTS `bang_donvitructhuoc` (
  `madonvitructhuoc` int(50) NOT NULL AUTO_INCREMENT,
  `tendonvitructhuoc` varchar(700) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaytao` timestamp NULL DEFAULT NULL,
  `ngaycapnhat` timestamp NULL DEFAULT NULL,
  `nguoitao` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`madonvitructhuoc`)
) ENGINE=InnoDB AUTO_INCREMENT=9615 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_donvitructhuoc: ~11 rows (approximately)
INSERT INTO `bang_donvitructhuoc` (`madonvitructhuoc`, `tendonvitructhuoc`, `ngaytao`, `ngaycapnhat`, `nguoitao`) VALUES
	(1, 'Khoa Công nghệ thông tin', '2023-02-01 17:00:00', '2023-02-01 17:00:00', NULL),
	(2, 'Khoa Kinh tế', '2023-02-01 17:00:00', '2023-02-01 17:00:00', NULL),
	(3, 'Khoa Nông nghiệp,Tài nguyên thiên nhiên', '2023-03-27 14:57:05', NULL, NULL),
	(4, 'Khoa Sư phạm', '2023-03-27 14:57:06', NULL, NULL),
	(5, 'Khoa Khoa học chính trị', '2023-03-27 14:57:06', NULL, NULL),
	(6, 'Khoa Công nghệ kỹ thuật môi trường', '2023-03-27 14:57:07', NULL, NULL),
	(7, 'Khoa Ngoại ngữ', '2023-03-27 14:57:08', NULL, NULL),
	(8, 'Khoa Du lịch,văn hóa nghệ thuật', '2023-03-27 14:57:08', NULL, NULL),
	(3010, 'Phòng thực nghiệm hóa học', '2023-03-18 07:37:32', NULL, NULL),
	(4647, 'Phòng hành chính tổng hợp', '2023-03-18 07:36:22', NULL, NULL),
	(8351, 'Phòng quan hệ đối ngoại', '2023-03-15 07:34:02', NULL, NULL);

-- Dumping structure for table csdl_duanquocte.bang_duanquocte
CREATE TABLE IF NOT EXISTS `bang_duanquocte` (
  `maduan` int(50) NOT NULL AUTO_INCREMENT,
  `manguoidung` int(50) NOT NULL DEFAULT 0,
  `madonvitructhuoc` int(50) DEFAULT NULL,
  `madanhmuc` int(50) DEFAULT NULL,
  `manhataitro` int(50) DEFAULT NULL,
  `maloaivientro` int(50) DEFAULT NULL,
  `macoquanpheduyet` int(50) DEFAULT NULL,
  `madoitacthuchien` int(50) DEFAULT NULL,
  `tenduan_tiengviet` varchar(700) DEFAULT NULL,
  `tenduan_tienganh` varchar(700) DEFAULT NULL,
  `thanhvienthamgia` varchar(700) DEFAULT NULL,
  `muctieuduan` text DEFAULT NULL,
  `noidungthuchien` text DEFAULT NULL,
  `thietbitaitro` varchar(700) DEFAULT NULL,
  `kinhphiduannamtruoc` varchar(700) DEFAULT NULL,
  `tongvonthuchien` float DEFAULT NULL,
  `vontaitro` float DEFAULT NULL,
  `vonvay` float DEFAULT NULL,
  `vonkhac` float DEFAULT NULL,
  `vondoiung` float DEFAULT NULL,
  `madonvitiente` int(50) DEFAULT NULL,
  `thoigianthuchien` varchar(70) DEFAULT NULL,
  `thoigianbatdau` timestamp NULL DEFAULT NULL,
  `thoigianketthuc` timestamp NULL DEFAULT NULL,
  `tiendothuchien` text DEFAULT NULL,
  `phantramtiendo` varchar(100) DEFAULT NULL,
  `ngaytao` timestamp NULL DEFAULT NULL,
  `ngaycapnhat` timestamp NULL DEFAULT NULL,
  `trangthaiduan` int(11) DEFAULT 0,
  `trangthaiketthuc` int(11) DEFAULT 0,
  `donvitiente_vontaitro` varchar(100) DEFAULT NULL,
  `donvitiente_vonvay` varchar(100) DEFAULT NULL,
  `donvitiente_vonkhac` varchar(100) DEFAULT NULL,
  `donvitiente_vondoiung` varchar(100) DEFAULT NULL,
  `donvitiente_tongvonthuchien` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`maduan`),
  KEY `FK_bang_duanquocte_bang_donvitructhuoc` (`madonvitructhuoc`),
  KEY `FK_bang_duanquocte_bang_danhmuc` (`madanhmuc`),
  KEY `FK_bang_duanquocte_bang_nhataitro` (`manhataitro`),
  KEY `FK_bang_duanquocte_bang_loaivientro` (`maloaivientro`),
  KEY `FK_bang_duanquocte_bang_coquanpheduyet` (`macoquanpheduyet`),
  KEY `FK_bang_duanquocte_bang_doitacthuchien` (`madoitacthuchien`),
  KEY `FK_bang_duanquocte_bang_nguoidung` (`manguoidung`),
  KEY `FK_bang_duanquocte_bang_donvitiente` (`madonvitiente`) USING BTREE,
  CONSTRAINT `FK_bang_duanquocte_bang_coquanpheduyet` FOREIGN KEY (`macoquanpheduyet`) REFERENCES `bang_coquanpheduyet` (`macoquanpheduyet`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_bang_duanquocte_bang_danhmuc` FOREIGN KEY (`madanhmuc`) REFERENCES `bang_danhmuc` (`madanhmuc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_bang_duanquocte_bang_doitacthuchien` FOREIGN KEY (`madoitacthuchien`) REFERENCES `bang_doitacthuchien` (`madoitac`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_bang_duanquocte_bang_donvitiente` FOREIGN KEY (`madonvitiente`) REFERENCES `bang_donvitiente` (`madonvitiente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_bang_duanquocte_bang_donvitructhuoc` FOREIGN KEY (`madonvitructhuoc`) REFERENCES `bang_donvitructhuoc` (`madonvitructhuoc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_bang_duanquocte_bang_loaivientro` FOREIGN KEY (`maloaivientro`) REFERENCES `bang_loaivientro` (`maloaivientro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_bang_duanquocte_bang_nguoidung` FOREIGN KEY (`manguoidung`) REFERENCES `bang_nguoidung` (`manguoidung`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_bang_duanquocte_bang_nhataitro` FOREIGN KEY (`manhataitro`) REFERENCES `bang_nhataitro` (`manhataitro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=89548 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_duanquocte: ~34 rows (approximately)
INSERT INTO `bang_duanquocte` (`maduan`, `manguoidung`, `madonvitructhuoc`, `madanhmuc`, `manhataitro`, `maloaivientro`, `macoquanpheduyet`, `madoitacthuchien`, `tenduan_tiengviet`, `tenduan_tienganh`, `thanhvienthamgia`, `muctieuduan`, `noidungthuchien`, `thietbitaitro`, `kinhphiduannamtruoc`, `tongvonthuchien`, `vontaitro`, `vonvay`, `vonkhac`, `vondoiung`, `madonvitiente`, `thoigianthuchien`, `thoigianbatdau`, `thoigianketthuc`, `tiendothuchien`, `phantramtiendo`, `ngaytao`, `ngaycapnhat`, `trangthaiduan`, `trangthaiketthuc`, `donvitiente_vontaitro`, `donvitiente_vonvay`, `donvitiente_vonkhac`, `donvitiente_vondoiung`, `donvitiente_tongvonthuchien`) VALUES
	(94, 6244, 1, 9660, 3513, 6987, 0, 0, 'Nghiên cứu và xây dựng hệ thống quản lý nhân sự sử dụng AI nhận diện khuôn mặt trong phạm vi', 'Researching and building a human resource management system using AI face recognition in the scope of', NULL, 'Nghiên cứu và xây dựng hệ thống quản lý nhân sự', 'Nghiên cứu và xây dựng hệ thống quản lý nhân sự mạnh mẽ', 'Camera,IC,Nguồn', '5 tỷ', 235086000, 230000000, 0, 143000000, 235000000, 0, '5 năm', '2023-04-20 07:49:00', '2023-04-20 07:49:00', 'Đang triển khai', '10%', '2023-04-05 07:49:39', NULL, 0, 0, 'VND', 'VND', 'VND', 'CNY', 'CNY'),
	(355, 9524, 4, 7322, 8826, 6987, 8274, 522, 'Giải pháp mới cho công cuộc cải tổ nền giáo dục VN nhằm nâng cao khả năng tiếp cận giáo dục của vùng ĐBSCL 2', 'New solutions for the reform of Vietnam\'s education system to improve access to education in the Mekong Delta', NULL, 'Đổi mới cải tổ nền giáo dục chất lượng Việt Nam', 'Xây dựng giải pháp nâng cao chất lượng giáo dục tại vùng DBSCL', 'Không có thiết bị được tài trợ', 'Không có ', 24000, 200, 300, 100, 100, 0, '2 năm', '2018-01-07 02:06:00', '2020-03-06 14:12:00', 'Đang triển khai chờ thêm nguồn kinh phí viện trợ', '40%', '2023-04-04 02:07:16', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(644, 75, 1, 9660, 8782, 6987, 0, 0, 'Quản lý và điều hành trên Internet trong các tổ chức đào tạo và cơ quan quản lý nhà nước', 'Management and administration on the Internet in training organizations and state management agencies', NULL, 'Đánh giá hiệu mang lại tác động tích cực', 'Cãi thiện chất lượng chuyển đổi số', 'Laptop RST1200,Ram DDR4 500GB', '12.000 USD', 2000, 0, 6000, 3000, 3000, 0, '6 năm', '2023-04-19 15:10:00', '2023-04-29 15:10:00', 'Đang thu thập thiết bị', '35%', '2023-04-04 15:10:40', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(1120, 6244, 1, 9660, 4654, 3295, 0, 3879, 'Nghiên cứu sự tác động mạnh của dịch Covid-19 lên TMĐT ở Việt Nam', 'Research on the impact of the Covid-19 epidemic on e-commerce in Vietnam', NULL, 'Nghiên cứu sự tác động của dịch Covid-19 á', 'Nghiên cứu sự tác động của dịch Covid-19 hiện nay', 'Chưa có', '100 triệu', 3104880000, 500000000, 0, 6200000000, 6000, 0, '4 năm', '2023-04-05 07:51:00', '2023-04-20 07:51:00', 'Đang triển khai', '10%', '2023-04-05 07:52:01', NULL, 0, 0, 'Euro', 'VND', 'VND', 'CNY', 'CNY'),
	(1995, 6088, 7, 9943, 7299, 5089, 4900, 9666, 'Nhận thức của sinh viên chính tiếng Anh về Viết học thuật: Cuộc đấu tranh giữa Viết để học và Học viết ', 'Perceptions of primary English students about Academic Writing ', NULL, 'Đem đến nhận thức mới cho sinh viên', 'Không', 'Không', '123 triệu', 7358000000000, 40000000, 0, 238000000, 12000000000, 0, '6 tháng', '2023-04-29 02:13:00', '2023-04-21 02:13:00', 'Đang giải ngân', '10%', '2023-04-12 02:01:32', NULL, 0, 0, 'USD', 'VND', 'Euro', 'VND', 'VND'),
	(2567, 75, 1, 9752, 7557, 9061, 3491, 2097, 'Giải pháp làm mát tự động cho chuồng trại chăn nuôi', 'Automatic cooling solution for livestock barns', NULL, 'Giúp heo mát', 'Quạt cho con heo mát', 'Nguồn,Cap,Dây điện', '123 triệu', 662400000, 423000000, 120000000, 1200, 87000000, 0, '6 tháng', '2023-04-12 05:22:00', '2023-04-20 05:22:00', 'Đang giải ngân', '75%', '2023-04-06 05:22:55', NULL, 0, 0, 'VND', 'VND', 'Euro', 'VND', 'VND'),
	(2753, 1395, 8, 8350, 5559, 8827, 2029, 0, 'Tìm hiểu về văn hóa ứng xử trong công ty cổ phần du lịch và thương mại phương Đông', 'Learn about the culture of behavior in the Oriental tourism and trade joint stock company', NULL, 'Tìm hiểu về văn hóa ứng xử của công ty', 'Gặp gở trao đổi các bên', '', '250 triệu', 690376000000, 30000000, 141000000, 0, 235000000, 0, '6 tháng', '2023-04-07 07:39:00', '2023-04-20 07:39:00', 'Chưa triển khai', '100%', '2023-04-05 07:39:58', NULL, 0, 0, 'USD', 'VND', 'Euro', 'VND', 'VND'),
	(2800, 75, 1, 9660, 6907, 3295, 0, 3080, 'Nghiên cứu, xây dựng mạng truyền thông cáp quang tốc độ cao dựa trên HAP phục vụ khắc phục thảm họa thiên nhiên', 'Research and build a high-speed optical communication network based on HAP for natural disaster recovery', NULL, 'Đánh giá hiệu mang lại tác động tích cực', 'Cãi thiện chất lượng,nghiên cứu điện năng thủy lợi', 'Chưa có', '1000 USD', 74233600000000, 2460000000, 130000000, 620000000, 210000000, 0, '7 năm', '2023-04-12 15:21:00', '2023-04-27 15:21:00', 'Đang thu thập thiết bị', '90%', '2023-04-04 15:21:45', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'VND'),
	(2865, 1395, 8, 8350, 8836, 8827, 2029, 0, 'Nghiên cứu phát triển doanh nghiệp xã hội trong lĩnh vực du lịch cộng đồng tại Việt Nam', 'Research and develop social enterprises in the field of community tourism in Vietnam', NULL, 'Nghiên cứu phát triển doanh nghiệp', 'Gặp gở trao đổi các bên để tìm hướng giải quyết', 'Chưa có', '100 triệu', 1820730000, 15700000000, 3000, 1820000000, 235000, 0, '6 tháng', '2023-04-10 07:42:00', '2023-04-21 07:42:00', 'Chưa triển khai', '100%', '2023-04-05 07:42:25', NULL, 0, 0, 'VND', 'VND', 'USD', 'CNY', 'USD'),
	(3357, 1395, 8, 8350, 8836, 8827, 2029, 0, 'Nghiên cứu và đề xuất giải pháp phát triển loại hình du lịch văn hóa tâm linh trên địa bàn tỉnh An Giang', 'Research and propose solutions to develop spiritual cultural tourism in An Giang province', NULL, 'Nghiên cứu phát triển doanh nghiệp', 'Gặp gở trao đổi các bên để tìm hướng giải quyết', 'Chưa có', '100 triệu', 737367000, 3450000000, 3000, 628000000, 0, 0, '6 tháng', '2023-04-21 07:43:00', '2023-04-20 07:43:00', 'Chưa triển khai', '100%', '2023-04-05 07:43:32', NULL, 0, 0, 'VND', 'VND', 'Euro', 'CNY', 'USD'),
	(3622, 4527, 3, 9782, 497, 3434, 7280, 4055, 'Đánh giá tác động của đê bao đến đời sống kinh tế xã hội và môi trường tại các khu vực có đê bao ở tỉnh An Giang', 'Assessing the impact of the dike on the socio-economic life and the environment in the areas with the dike in An Giang province', NULL, 'Tái cơ cấu bao đê chống lủ', 'Xây dựng quy hoạch tái cơ cấu', 'Không', '', 352801000000, 80000000, 235000000, 8000, 4350000000, 0, '9 năm', '2023-04-13 05:48:00', '2023-04-13 05:48:00', 'Đang triển khai', '20%', '2023-04-06 05:48:51', NULL, 0, 0, 'CNY', 'VND', 'Euro', 'VND', 'VND'),
	(4122, 3985, 1, 9660, 6907, 6987, 0, 3080, 'Hệ thống hỗ trợ chấm công tự động bằng camera AI 2', 'Support system automatic timekeeping by AI camera', NULL, 'Kiếm tiền', 'Thực hiện xây dựng AI', 'Camera,nguồn điều khiển', '124 triệu', 11610100000, 450000, 8000, 1050000000, 6000, 0, '6 tháng', '2023-04-21 09:58:00', '2023-04-21 09:58:00', 'Đang triển khai', '20%', '2023-04-13 09:59:02', NULL, 0, 0, 'USD', 'USD', 'VND', 'CNY', 'VND'),
	(4909, 4527, 3, 9782, 497, 3434, 7280, 4055, 'Đánh giá hiện trạng bồi lắng phù sa vùng dự án Bắc Vàm Nao', 'Assessment of the current status of alluvial deposition in the Bac Vam Nao project area', NULL, 'Xem xét tình trạng phù sa', 'Nghiên cứu biến đổi phù sa', 'Không', '', 50792000000, 7280000000, 123000000, 7000, 43200000000, 0, '5 năm', '2023-04-13 05:50:00', '2023-04-04 05:50:00', 'Đang triển khai', '70%', '2023-04-06 05:50:19', NULL, 0, 0, 'VND', 'VND', 'Euro', 'VND', 'VND'),
	(7939, 75, 1, 9660, 4654, 6987, 5617, 9697, 'Xây dựng cơ sở dữ liệu và khai phá dữ liệu trong thủy lợi, thủy điện và tài nguyên nước ', 'Database building and data mining in irrigation, hydropower and water resources', NULL, 'Đánh giá hiệu mang lại tác động tích cực', 'Cãi thiện chất lượng,nghiên cứu điện năng thủy lợi', 'Chưa có', '1000 USD', 98419900000000, 4150000000, 232000000, 100000000, 62000000, 0, '6 năm', '2023-04-13 15:12:00', '2023-04-17 15:12:00', 'Đang thu thập thiết bị', '40%', '2023-04-04 15:12:42', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'VND'),
	(8069, 9524, 4, 7322, 5817, 3891, 8274, 3973, 'Tăng cường năng lực học tập cho các HS-SV bị thiệt thòi ở vùng ĐBSCL để có thể theo học tại Trường ĐHAG (PHE)', 'Strengthening learning capacity for students who are devastated in the gap to be able to study at AG University (PHE)', NULL, 'Cải thiện chất lượng giáo dục', 'Nghiên cứu tìm hướng giải quyết', 'Hiện tại chưa có.', '80000', 0, 0, 0, 0, 0, 0, '', '2001-01-01 06:01:00', '2003-01-01 06:01:00', 'Đang triển khai', '75%', '2023-04-04 03:04:22', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(8273, 3985, 1, 9752, 8782, 9061, 4990, 2097, 'Xây dựng sàn giao dịch các sản phẩm đặc thù (OCOP) của tỉnh An Giang ', 'Construction of the delivery floor translate products specific (OCOP) of An Giang province ', NULL, 'Kiếm tiền', 'Thực hiện xây dựng website ', 'Laptop', '233 triệu', 24408700000, 18000000000, 1000000000, 200000, 2000, 0, '6 tháng', '2023-04-21 10:00:00', '2023-04-16 10:00:00', 'Đang triển khai', '50%', '2023-04-13 10:00:31', NULL, 0, 0, 'VND', 'VND', 'Euro', 'CNY', 'VND'),
	(8278, 75, 1, 9660, 4654, 6987, 5617, 9697, 'Đánh giá hiệu quả việc thực hiện sản xuất theo hướng gap trong mô hình “cánh đồng mẫu lớn”  - Chương trình hỗ trợ kỹ thuật hậu gia nhập WTO - Dự án ICRE', 'Evaluating the effectiveness of gap-oriented production in the “large sample field” model - Post-WTO Technical Assistance Program - ICRE Project', NULL, 'Đánh giá hiệu quả việc thực hiện sản xuất', 'Cãi thiện chất lượng sản xuất', 'Máy đo độ PH,Laptop RST1200', '23.000 USD', 62381900000000, 2460000000, 6900000000, 25000000, 1200000000, 0, '4 năm', '2023-04-18 15:05:00', '2023-04-19 15:05:00', 'Đang thu thập thiết bị', '20%', '2023-04-04 15:05:41', NULL, 0, 0, 'USD', 'VND', 'USD', 'CNY', 'VND'),
	(8742, 6088, 7, 9943, 7299, 5089, 4900, 0, 'Một cái nhìn sâu sắc về niềm tin của sinh viên trung học về việc học tiếng Anh', 'An insight into secondary school students’ beliefs regarding learning English language', NULL, 'Giúp học sinh có cái nhìn khác về học TA', '', 'Không', '250 triệu', 3000, 5000, 2000, 3000, 3000, 0, '5 năm', '2023-04-18 02:15:00', '2023-04-18 02:15:00', 'đang triển khai', '10%', '2023-04-12 02:16:01', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(8867, 4527, 3, 9782, 497, 3434, 7280, 4055, 'Quyết định của người dân trong chuyển dịch cơ cấu cây trồng', 'People\'s decisions in the process of crop restructuring', NULL, 'Tái cơ cấu cây trồng', 'Trồng cây nhương nhương', 'Không', '', 7893.04, 6000, 40000, 0, 10000, 0, '4 năm', '2023-04-14 05:47:00', '2023-04-21 05:47:00', 'Đang triển khai', '20%', '2023-04-06 05:47:12', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(9242, 9524, 4, 7033, 631, 3891, 5497, 3973, 'Thanh niên tình nguyện phát triển nông thôn', 'Youth volunteering for rural development', NULL, 'Nâng cao đời sống nhân dân', 'Xây dựng mô hình thanh niên tình nguyên', 'Không có', 'Không có', 17600, 200, 0, 0, 0, 0, '3 năm', '2022-12-02 07:02:00', '2023-04-20 12:29:00', 'Đang triển khai chờ nguồn đầu tư ', '10%', '2023-04-04 12:29:34', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(9499, 9524, 4, 7033, 631, 3891, 0, 3973, 'Chương trình tập huấn về trưng bày dựa trên cơ sở cộng đồng: sưu tầm và trưng bày văn hóa vật chất tư liệu bảo tồn bảo tàng văn hóa cư dân ĐBSCL', 'Training program on community-based exhibitions: collection and display of material culture, preservation materials, museum of resident culture in the Mekong Delta', NULL, 'Tập huấn về cơ sở cộng đồng', 'Chưa nghĩ ra', 'Chưa nghĩ ra ', 'Không có', 14000, 205, 700, 0, 0, 0, '5 năm', '2023-04-12 12:33:00', '2023-04-19 12:33:00', 'Đang triển khai chờ nguồn đầu tư ', '10%', '2023-04-04 12:33:29', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(9673, 1, 4, 7322, 8826, 3891, 8274, 522, 'Khó khăn khi giảng dạy cho trẻ trầm cảm tại trường mầm non', 'Difficulty teaching children with depression at preschool', NULL, 'Hổ trợ học sinh khó khăn', 'Giúp đở hs nghèo', 'Không', 'không', 30000, 1200, 0, 0, 0, 0, '5 năm', '2023-04-07 05:53:00', '2023-04-12 05:53:00', 'Đang triển khai', '20%', '2023-04-14 05:53:45', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(10086, 3103, 8, 8871, 3490, 8827, 2029, 9905, 'Định Hướng Giá Trị Văn Hóa Của Học Viên Đào Tạo Sĩ Quan Trong Các Trường Quân Đội', 'Cultural Value Orientation of Officer Training Trainees in Military Schools', NULL, 'tạo ra giá trị văn hóa', 'tạo ra gì đó', 'không', '20.000 USD', 4676850000, 20000000, 0, 4640000000, 123000000, 0, '2 năm, 10 tháng, 21 ngày', '2020-07-07 15:57:00', '2023-05-24 15:57:00', 'đang giải ngân', '10%', '2023-05-09 15:57:52', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'Euro'),
	(17480, 1, 4, 7322, 8826, 3891, 5497, 3973, 'Đề án nâng cao chất lượng giảng dạy của cán bộ giáo viên tại trường tiểu học ', 'Project to improve teaching quality of teachers at primary schools ', NULL, 'Hổ trợ học sinh khó khăn vùng sâu xa', 'Giúp đở hs nghèo vượt khó', 'Không có', 'không có', 50000, 40000, 30000, 20000, 10000, 0, '4 năm rưỡi', '2023-04-15 05:52:00', '2023-04-15 05:52:00', 'Đang còn triển khai ', '40%', '2023-04-14 05:52:31', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(20698, 1, 4, 7322, 8826, 3891, 8274, 522, 'Chương trình Tiếng Anh dành cho HS có hoàn cảnh khó khăn (Access)', 'English program for students with difficult circumstances (Access)', NULL, 'Hổ trợ học sinh khó khăn', 'Giúp đở hs nghèo', 'Không', 'không', 30000, 1200, 0, 0, 0, 0, '5 năm', '2023-04-15 05:49:00', '2023-04-18 05:49:00', 'Đang triển khai', '20%', '2023-04-14 05:49:29', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(21403, 1, 4, 7322, 8826, 3891, 8274, 522, 'Giải pháp nâng cao vốn từ tiếng Anh cho trẻ mầm non tại trường', 'Solutions to improve English vocabulary for preschool children at school', NULL, 'Hổ trợ học sinh khó khăn', 'Giúp đở hs nghèo', 'Không', 'không', 30000, 1200, 0, 0, 0, 0, '5 năm', '2023-04-07 05:54:00', '2023-04-25 05:54:00', 'Đang triển khai', '20%', '2023-04-14 05:54:47', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(24044, 6244, 1, 9752, 7557, 9061, 5617, 9697, 'Xây dựng website hỗ trợ công việc kiểm kê tài sản', 'Building a website to support asset inventory work', NULL, 'Nâng cao phát triển hệ thống', 'Nghiên cứu', 'Mạch,Nguồn,Cap IC', '123 triệu', 3759000000, 3450000000, 0, 7000, 120000000, 0, '5 năm', '2023-04-14 01:54:00', '2023-04-21 01:54:00', 'Đang cần vốn ', '10%', '2023-04-16 01:54:39', NULL, 0, 0, 'VND', 'VND', 'Euro', 'VND', 'VND'),
	(25381, 5711, 3, 9782, 497, 3434, 7280, 4055, 'Hệ thống Aquaponic kêt hợp cá vơi rau trong nhà kính ', ' Aquaponic system to synthesize fish and vegetables in the greenhouse ', NULL, 'Mang lại sự hiệu quả ', 'Mang lại sự hiệu quả ', 'Không ', '123 triệu ', 896.296, 100, 200, 300, 400, 0, '25 ngày', '2023-04-01 02:24:00', '2023-04-26 02:24:00', 'Đang giải ngân ', '36% ', '2023-04-21 02:31:02', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(51620, 3103, 8, 8350, 5559, 8827, 2029, 9905, 'Di Sản Múa Chăm Qua Một Số Tác Phẩm Điêu Khắc Chăm Pa', 'Cham Dance Heritage Through Some Champa Sculptures', NULL, 'tạo ra giá trị văn hóa', 'tạo ra gì đó', 'không', '20.000 USD', 6836300000, 0, 2300000, 5000, 1540000, 0, '1 năm, 7 tháng, 13 ngày', '2021-10-13 15:57:00', '2023-05-24 15:57:00', 'đang giải ngân', '10%', '2023-05-09 16:00:35', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'VND'),
	(52838, 5711, 3, 9782, 497, 3434, 7280, 4055, 'Khảo nghiệm các giống cây dầu lai trên vùng triền núi', 'Testing of hybrid oil varieties on the mountainside', NULL, 'Test', 'Test', 'Test', '', 2874.07, 200, 2000, 400, 600, 0, '2 năm', '2023-04-07 02:24:00', '2023-04-18 02:24:00', 'Test', '10%', '2023-04-21 02:35:01', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD'),
	(57739, 5711, 3, 9782, 497, 3434, 7280, 4055, 'Tác động của xâm nhập mặn do biến đổi khí hậu tại Bến Tre', 'Impact of saline intrusion due to climate change in Ben Tre', NULL, 'Đem đến sự thuận tiện', 'Nghiên cứu tác động', 'Không', '', 634.785, 200, 50, 10000000, 0, 0, '2 năm', '2023-04-20 01:55:00', '2023-04-06 01:55:00', 'Đang triển khai', '10%', '2023-04-21 01:55:43', NULL, 0, 0, 'USD', 'VND', 'VND', 'CNY', 'USD'),
	(71784, 75, 1, 9660, 6907, 6987, 0, 3080, 'Công nghệ thông tin xây dựng bài toán ghép đôi không trọng số', 'Information technology builds unweighted pairing problem', NULL, 'Nâng cao phát triển hệ thống', 'Nghiên cứu', 'Mạch,Nguồn,Cap IC', '123 triệu', 2896000000, 2680000000, 0, 8000, 0, 0, '5 năm', '2023-04-11 01:53:00', '2023-04-22 01:53:00', 'Đang cần vốn ', '10%', '2023-04-16 01:53:23', NULL, 0, 0, 'VND', 'VND', 'Euro', 'CNY', 'VND'),
	(89497, 5711, 3, 9782, 497, 3434, 7280, 4055, 'Tác động của lũ thấp đối với người đánh bắt cá: trường hợp xã Phú Hữu, An Phú, An Giang', 'Impact of low floods on fishermen: the case of Phu Huu commune, An Phu, An Giang', NULL, 'Đem đến sự thuận tiện', 'Nghiên cứu tác động', 'Không', '', 5000, 0, 0, 5000, 0, 0, '2 năm', '2023-04-12 01:56:00', '2023-04-19 01:56:00', 'Đang triển khai', '10%', '2023-04-21 01:56:44', NULL, 0, 0, 'USD', 'VND', 'Euro', 'CNY', 'USD');

-- Dumping structure for table csdl_duanquocte.bang_duanquocte_dabaocao
CREATE TABLE IF NOT EXISTS `bang_duanquocte_dabaocao` (
  `maduan_dabaocao` int(50) NOT NULL AUTO_INCREMENT,
  `maduan` int(50) DEFAULT NULL,
  `chuduan` varchar(500) DEFAULT NULL,
  `tendonvitructhuoc` varchar(100) DEFAULT NULL,
  `tendanhmuc` varchar(100) DEFAULT NULL,
  `tennhataitro` varchar(100) DEFAULT NULL,
  `tenloaivientro` varchar(100) DEFAULT NULL,
  `tencoquanpheduyet` varchar(100) DEFAULT NULL,
  `tendoitacthuchien` varchar(100) DEFAULT NULL,
  `tenduantiengviet` varchar(900) DEFAULT NULL,
  `tenduantienganh` varchar(900) DEFAULT NULL,
  `thanhvienthamgia` varchar(900) DEFAULT NULL,
  `muctieuduan` varchar(900) DEFAULT NULL,
  `noidungthuchien` varchar(900) DEFAULT NULL,
  `thietbitaitro` varchar(900) DEFAULT NULL,
  `kinhphinamtruoc` varchar(100) DEFAULT NULL,
  `tongvonthuchien` varchar(100) DEFAULT NULL,
  `vontaitro` varchar(100) DEFAULT NULL,
  `vonvay` varchar(100) DEFAULT NULL,
  `vonkhac` varchar(100) DEFAULT NULL,
  `vondoiung` varchar(100) DEFAULT NULL,
  `tendonvitiente` varchar(100) DEFAULT NULL,
  `thoigianthuchien` varchar(100) DEFAULT NULL,
  `thoigianbatdau` varchar(100) DEFAULT NULL,
  `thoigianketthuc` varchar(100) DEFAULT NULL,
  `tiendothuchien` varchar(900) DEFAULT NULL,
  `phantramtiendo` varchar(100) DEFAULT NULL,
  `thuocquy` varchar(100) DEFAULT NULL,
  `thuocnam` varchar(100) DEFAULT NULL,
  `donvitientevontaitro` varchar(100) DEFAULT NULL,
  `donvitientevonvay` varchar(100) DEFAULT NULL,
  `donvitientevonkhac` varchar(100) DEFAULT NULL,
  `donvitientevondoiung` varchar(100) DEFAULT NULL,
  `donvitientetongvonthuchien` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`maduan_dabaocao`),
  KEY `FK_bang_duanquocte_dabaocao_bang_duanquocte` (`maduan`),
  CONSTRAINT `FK_bang_duanquocte_dabaocao_bang_duanquocte` FOREIGN KEY (`maduan`) REFERENCES `bang_duanquocte` (`maduan`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=89957 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_duanquocte_dabaocao: ~0 rows (approximately)

-- Dumping structure for table csdl_duanquocte.bang_file_dinhkem
CREATE TABLE IF NOT EXISTS `bang_file_dinhkem` (
  `mafileupload` int(50) NOT NULL AUTO_INCREMENT,
  `maduan` int(50) DEFAULT NULL,
  `file_decuongduan` varchar(700) DEFAULT NULL,
  `file_thucahpnhanthuchien` varchar(700) DEFAULT NULL,
  `file_totrinhxinphepthuchien` varchar(700) DEFAULT NULL,
  `file_quyetdinhgiaokinhphi` varchar(700) DEFAULT NULL,
  `file_quyetdinhthanhlapbanquanly` varchar(700) DEFAULT NULL,
  `file_quyetdinhchophepthuchien` varchar(700) DEFAULT NULL,
  `file_hopdongthoathuan_moa` varchar(700) DEFAULT NULL,
  `file_kehoachtrienkhaiduan` varchar(700) DEFAULT NULL,
  `file_baocaotiendogiuaky` varchar(700) DEFAULT NULL,
  `file_baocaotongket` varchar(700) DEFAULT NULL,
  `file_xacnhanketthucduan` varchar(700) DEFAULT NULL,
  `file_lylichkhoahoccuachunhiemduan` varchar(700) DEFAULT NULL,
  `file_bienbangiaitrinh` varchar(700) DEFAULT NULL,
  `file_hinhanhthongtinhoatdongtrienkhai` varchar(700) DEFAULT NULL,
  `file_cacminhchungkhac` varchar(700) DEFAULT NULL,
  `file_cacminhchungkhac_2` varchar(700) DEFAULT NULL,
  PRIMARY KEY (`mafileupload`),
  KEY `FK__bang_duanquocte` (`maduan`),
  CONSTRAINT `FK__bang_duanquocte` FOREIGN KEY (`maduan`) REFERENCES `bang_duanquocte` (`maduan`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=84147 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_file_dinhkem: ~0 rows (approximately)

-- Dumping structure for table csdl_duanquocte.bang_lichsucapnhat
CREATE TABLE IF NOT EXISTS `bang_lichsucapnhat` (
  `malichsucapnhat` int(50) NOT NULL AUTO_INCREMENT,
  `maduan` int(50) DEFAULT NULL,
  `manguoidung` int(50) DEFAULT NULL,
  `ngaycapnhat` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`malichsucapnhat`) USING BTREE,
  KEY `FK_bang_lichsucapnhat_bang_duanquocte` (`maduan`) USING BTREE,
  KEY `FK_bang_lichsucapnhat_bang_nguoidung` (`manguoidung`),
  CONSTRAINT `FK_bang_lichsucapnhat_bang_duanquocte` FOREIGN KEY (`maduan`) REFERENCES `bang_duanquocte` (`maduan`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_bang_lichsucapnhat_bang_nguoidung` FOREIGN KEY (`manguoidung`) REFERENCES `bang_nguoidung` (`manguoidung`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=89366 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_lichsucapnhat: ~0 rows (approximately)

-- Dumping structure for table csdl_duanquocte.bang_loaivientro
CREATE TABLE IF NOT EXISTS `bang_loaivientro` (
  `maloaivientro` int(50) NOT NULL AUTO_INCREMENT,
  `tenloaivientro` varchar(700) DEFAULT NULL,
  `ngaytao` date DEFAULT NULL,
  `ngaycapnhat` date DEFAULT NULL,
  `nguoitao` int(50) DEFAULT NULL,
  PRIMARY KEY (`maloaivientro`)
) ENGINE=InnoDB AUTO_INCREMENT=9324 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_loaivientro: ~9 rows (approximately)
INSERT INTO `bang_loaivientro` (`maloaivientro`, `tenloaivientro`, `ngaytao`, `ngaycapnhat`, `nguoitao`) VALUES
	(0, 'NULL', '2023-02-24', '2023-02-24', NULL),
	(3295, 'Viện trợ NPK', '2023-04-05', NULL, 1),
	(3434, 'Viện trợ chính phủ', '2023-04-06', NULL, 3),
	(3891, 'Viện trợ tư nhân', '2023-04-05', NULL, 4),
	(5089, 'Viện trợ tư nhân', '2023-04-12', NULL, 7),
	(6987, 'Viện trợ chính phủ', '2023-04-05', NULL, 1),
	(8733, 'Viện trợ chính phủ', '2023-04-14', NULL, 4),
	(8827, 'Viện trợ hợp tác', '2023-04-05', NULL, 8),
	(9061, 'Viện trợ tư nhân', '2023-04-06', NULL, 1);

-- Dumping structure for table csdl_duanquocte.bang_nguoidung
CREATE TABLE IF NOT EXISTS `bang_nguoidung` (
  `manguoidung` int(50) NOT NULL AUTO_INCREMENT,
  `madonvitructhuoc` int(50) DEFAULT 0,
  `machucvu` int(50) DEFAULT 5,
  `honguoidung` varchar(300) DEFAULT NULL,
  `tennguoidung` varchar(300) DEFAULT NULL,
  `sdt` varchar(300) DEFAULT NULL,
  `diachi` varchar(300) DEFAULT NULL,
  `gmail` varchar(300) DEFAULT NULL,
  `matkhau` varchar(300) DEFAULT NULL,
  `quyenhan` varchar(300) DEFAULT 'user',
  `trangthai` int(11) DEFAULT 1,
  `anhdaidien` varchar(900) DEFAULT NULL,
  `ngaylap` timestamp NULL DEFAULT NULL,
  `ngaycapnhat` timestamp NULL DEFAULT NULL,
  `maxacthuc_gmail` varchar(300) DEFAULT NULL,
  `trangthaixacthuc` tinyint(5) DEFAULT NULL,
  `thoigianhieuluc` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`manguoidung`),
  KEY `FK_bang_nguoidung_bang_chucvu` (`machucvu`),
  KEY `FK_bang_nguoidung_bang_donvitructhuoc` (`madonvitructhuoc`),
  CONSTRAINT `FK_bang_nguoidung_bang_chucvu` FOREIGN KEY (`machucvu`) REFERENCES `bang_chucvu` (`machucvu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_bang_nguoidung_bang_donvitructhuoc` FOREIGN KEY (`madonvitructhuoc`) REFERENCES `bang_donvitructhuoc` (`madonvitructhuoc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9803 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_nguoidung: ~15 rows (approximately)
INSERT INTO `bang_nguoidung` (`manguoidung`, `madonvitructhuoc`, `machucvu`, `honguoidung`, `tennguoidung`, `sdt`, `diachi`, `gmail`, `matkhau`, `quyenhan`, `trangthai`, `anhdaidien`, `ngaylap`, `ngaycapnhat`, `maxacthuc_gmail`, `trangthaixacthuc`, `thoigianhieuluc`) VALUES
	(1, 4, 5, 'Đỗ', 'Đức Anh', 'null', 'null', 'user_sp2@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'user', 1, '', NULL, NULL, '994106', 1, '2023-04-15 05:45:04'),
	(75, 1, 3, 'Huỳnh ', 'Phước Hải', '0906840882', '508 An Thái,Châu Thành,Cà Mau', 'user_cntt@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'user', 1, NULL, NULL, NULL, '728065', 1, '2023-04-04 16:17:08'),
	(1395, 8, 4, 'Đỗ', ' Duy Khánh', NULL, NULL, 'user_vhnt@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'user', 1, NULL, NULL, NULL, '220140', 1, '2023-04-06 07:26:14'),
	(2623, 8, 4, 'Đinh', 'Mỹ Ngân', NULL, NULL, 'manager_vhnt@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'manager', 1, NULL, NULL, NULL, '777467', 1, '2023-04-06 07:31:27'),
	(3103, 8, 3, 'Phan', 'Đình Thế', NULL, NULL, 'user_vhnt2@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'user', 1, NULL, NULL, NULL, '632343', 1, '2023-05-10 15:46:20'),
	(3770, 7, 3, 'Phạm', 'Minh Lộc', NULL, NULL, 'manager_eng@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'manager', 1, NULL, NULL, NULL, '416911', 1, '2023-04-13 03:41:12'),
	(3985, 1, 3, 'Nguyễn', 'Hoàng Cung', NULL, NULL, 'user_cntt3@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'user', 1, NULL, NULL, NULL, '265263', 1, '2023-04-14 09:41:54'),
	(4118, 1, 5, 'Lê Thị', 'Bích Tuyền', '0908880884', 'số nhà 508 An Thái,Lấp Vò,Đồng Tháp', 'manager_cntt@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'manager', 1, '', NULL, NULL, '051992', 1, '2023-04-04 16:13:55'),
	(4527, 3, 3, 'Cao', 'Hữu Thắng', NULL, NULL, 'user_nn@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'user', 1, NULL, NULL, NULL, '314933', 1, '2023-04-07 05:40:05'),
	(5711, 3, 4, 'Lê ', 'Văn Tài', NULL, NULL, 'user_nn2@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'user', 1, NULL, NULL, NULL, '646459', 1, '2023-04-22 01:46:39'),
	(6088, 7, 5, 'Võ ', 'Văn Zùng ', '0912330462', 'Lấp Vò,Đồng Tháp', 'user_eng@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'user', 1, '', NULL, NULL, '485878', 1, '2023-04-13 02:00:47'),
	(6244, 1, 3, 'Phạm Lâm', 'Nguyên Vinh', NULL, NULL, 'user_cntt2@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'user', 1, '1680682675495face19.jpg', NULL, NULL, '663014', 1, '2023-04-06 07:45:30'),
	(6500, 8351, 5, 'Võ', 'Kim Hoàng', '0907738912', '366 phường Bình Khánh,Long Xuyên', 'admin@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'admin', 1, '', NULL, NULL, '558599', 1, '2023-04-04 16:07:24'),
	(8913, 4, 4, 'Phạm', 'Văn Bản', '0982738930', 'Phường A,Châu Đốc,An Giang', 'manager_sp@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'manager', 1, NULL, NULL, NULL, '544843', 1, '2023-04-04 16:22:28'),
	(8991, 3, 3, 'Hồ', 'Phước Tín', NULL, NULL, 'manager_nn@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'manager', 1, NULL, NULL, NULL, '731832', 1, '2023-04-07 05:41:49'),
	(9524, 4, 3, 'Phan Văn', 'Long Em', NULL, NULL, 'user_sp@gmail.com', 'lgqTdIGVt7EfShWIP7on6FbL9aM=', 'user', 1, '1681452490991face12.jpg', NULL, NULL, '484187', 1, '2023-04-05 01:58:00');

-- Dumping structure for table csdl_duanquocte.bang_nhataitro
CREATE TABLE IF NOT EXISTS `bang_nhataitro` (
  `manhataitro` int(50) NOT NULL AUTO_INCREMENT,
  `tennhataitro` varchar(700) DEFAULT NULL,
  `ngaytao` timestamp NULL DEFAULT NULL,
  `ngaycapnhat` timestamp NULL DEFAULT NULL,
  `nguoitao` int(50) DEFAULT NULL,
  PRIMARY KEY (`manhataitro`)
) ENGINE=InnoDB AUTO_INCREMENT=9726 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_nhataitro: ~13 rows (approximately)
INSERT INTO `bang_nhataitro` (`manhataitro`, `tennhataitro`, `ngaytao`, `ngaycapnhat`, `nguoitao`) VALUES
	(0, 'NULL', '2023-04-05 06:23:47', '2023-04-05 06:23:48', NULL),
	(497, 'VNRP (CT Việt Nam - Hà Lan)', '2023-04-06 05:45:08', NULL, 3),
	(631, ' Ford Foundation - Mỹ', '2023-04-05 06:32:33', NULL, 4),
	(3490, 'Làng văn hóa Óc Eo', '2023-05-09 15:55:01', NULL, 8),
	(3513, 'Công ty NAB', '2023-04-05 07:47:57', NULL, 1),
	(4654, 'USAID Viện hàn lâm  khoa học Hoa Kỳ (NSF) ', '2023-04-05 07:16:58', NULL, 1),
	(5559, 'Công ty Phương Nam', '2023-04-05 07:37:38', NULL, 8),
	(5817, 'British Council - Anh', '2023-04-05 06:36:10', NULL, 4),
	(6907, 'Quỹ phát triển Liên Hợp Quốc', '2023-04-05 07:21:07', NULL, 1),
	(7299, 'Ngoại ngữ ISEE', '2023-04-12 02:11:03', NULL, 7),
	(7557, 'Công ty Topdev', '2023-04-06 05:19:03', NULL, 1),
	(8782, 'Liên hiệp hội Khoa học Châu Âu', '2023-04-05 07:19:27', NULL, 1),
	(8826, 'DANIDA - Đan Mạch', '2023-04-05 07:07:43', NULL, 4),
	(8836, 'Công ty TNHH ITravel', '2023-04-05 07:40:59', NULL, 8);

-- Dumping structure for table csdl_duanquocte.bang_thamgiaduan
CREATE TABLE IF NOT EXISTS `bang_thamgiaduan` (
  `mathamgia` int(50) NOT NULL AUTO_INCREMENT,
  `manguoidung` int(50) DEFAULT NULL,
  `maduan` int(50) DEFAULT NULL,
  `ngaythamgia` timestamp NULL DEFAULT NULL,
  `tinhtrang` varchar(200) DEFAULT NULL,
  `ghichu` text DEFAULT NULL,
  PRIMARY KEY (`mathamgia`),
  KEY `FK_bang_thamgiaduan_bang_nguoidung` (`manguoidung`),
  KEY `FK_bang_thamgiaduan_bang_duanquocte` (`maduan`),
  CONSTRAINT `FK_bang_thamgiaduan_bang_duanquocte` FOREIGN KEY (`maduan`) REFERENCES `bang_duanquocte` (`maduan`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_bang_thamgiaduan_bang_nguoidung` FOREIGN KEY (`manguoidung`) REFERENCES `bang_nguoidung` (`manguoidung`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=87532 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table csdl_duanquocte.bang_thamgiaduan: ~0 rows (approximately)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
