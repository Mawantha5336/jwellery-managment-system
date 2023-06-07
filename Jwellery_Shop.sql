-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.27 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for jwellary_shop
CREATE DATABASE IF NOT EXISTS `jwellary_shop` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `jwellary_shop`;

-- Dumping structure for table jwellary_shop.add_design
CREATE TABLE IF NOT EXISTS `add_design` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Cus_name` varchar(45) NOT NULL,
  `NIC` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `design_name` varchar(45) NOT NULL,
  `image` varchar(222) NOT NULL,
  `description` varchar(45) NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_add_design_category1_idx` (`category_id`),
  CONSTRAINT `fk_add_design_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.attendance_status
CREATE TABLE IF NOT EXISTS `attendance_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.city
CREATE TABLE IF NOT EXISTS `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.company
CREATE TABLE IF NOT EXISTS `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `contact_number` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.company_branch
CREATE TABLE IF NOT EXISTS `company_branch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `branch_contact_number` varchar(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `company_id` int NOT NULL,
  `company_branch_address_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_company_branch_company1_idx` (`company_id`),
  KEY `fk_company_branch_company_branch_address1_idx` (`company_branch_address_id`),
  CONSTRAINT `fk_company_branch_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `fk_company_branch_company_branch_address1` FOREIGN KEY (`company_branch_address_id`) REFERENCES `company_branch_address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.company_branch_address
CREATE TABLE IF NOT EXISTS `company_branch_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Address` text NOT NULL,
  `city_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supplier_address_city1_idx` (`city_id`),
  CONSTRAINT `fk_supplier_address_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `contact_number` varchar(10) NOT NULL,
  `city_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_city1_idx` (`city_id`),
  CONSTRAINT `fk_customer_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.design
CREATE TABLE IF NOT EXISTS `design` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `NIC` varchar(45) NOT NULL,
  `matirial` varchar(45) NOT NULL,
  `caret_no` varchar(45) NOT NULL,
  `jwellary_id` int NOT NULL,
  `payment_type_id` int NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Design_jwellary1_idx` (`jwellary_id`),
  KEY `fk_Design_payment_type1_idx` (`payment_type_id`),
  KEY `fk_Design_category1_idx` (`category_id`),
  CONSTRAINT `fk_Design_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_Design_jwellary1` FOREIGN KEY (`jwellary_id`) REFERENCES `jwellary` (`id`),
  CONSTRAINT `fk_Design_payment_type1` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `NIC` varchar(45) NOT NULL,
  `emaill` varchar(45) NOT NULL,
  `Contact_No` varchar(10) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `category_id` int NOT NULL,
  `emp_category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_category1_idx` (`category_id`),
  KEY `fk_employee_emp_category1_idx` (`emp_category_id`),
  CONSTRAINT `fk_employee_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_employee_emp_category1` FOREIGN KEY (`emp_category_id`) REFERENCES `emp_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.emp_attendance
CREATE TABLE IF NOT EXISTS `emp_attendance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `employee_id` int NOT NULL,
  `attendance_status_id` int NOT NULL,
  `emp_category_id` int NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_emp_attendance_employee1_idx` (`employee_id`),
  KEY `fk_emp_attendance_attendance_status1_idx` (`attendance_status_id`),
  KEY `fk_emp_attendance_emp_category1_idx` (`emp_category_id`),
  KEY `fk_emp_attendance_category1_idx` (`category_id`),
  CONSTRAINT `fk_emp_attendance_attendance_status1` FOREIGN KEY (`attendance_status_id`) REFERENCES `attendance_status` (`id`),
  CONSTRAINT `fk_emp_attendance_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_emp_attendance_emp_category1` FOREIGN KEY (`emp_category_id`) REFERENCES `emp_category` (`id`),
  CONSTRAINT `fk_emp_attendance_employee1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.emp_category
CREATE TABLE IF NOT EXISTS `emp_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.exchange_item
CREATE TABLE IF NOT EXISTS `exchange_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `NIC` varchar(45) NOT NULL,
  `jwellary_id` int NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_exchange_item_jwellary1_idx` (`jwellary_id`),
  KEY `fk_exchange_item_category1_idx` (`category_id`),
  CONSTRAINT `fk_exchange_item_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_exchange_item_jwellary1` FOREIGN KEY (`jwellary_id`) REFERENCES `jwellary` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.grn
CREATE TABLE IF NOT EXISTS `grn` (
  `id` int NOT NULL AUTO_INCREMENT,
  `supplier_id` int NOT NULL,
  `date_time` datetime NOT NULL,
  `employee_id` int NOT NULL,
  `unique_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_supplier1_idx` (`supplier_id`),
  KEY `fk_grn_employee1_idx` (`employee_id`),
  CONSTRAINT `fk_grn_employee1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_grn_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.grn_item
CREATE TABLE IF NOT EXISTS `grn_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `buying_price` double NOT NULL,
  `grn_id` int NOT NULL,
  `stock_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_item_grn1_idx` (`grn_id`),
  KEY `fk_grn_item_stock1_idx` (`stock_id`),
  CONSTRAINT `fk_grn_item_grn1` FOREIGN KEY (`grn_id`) REFERENCES `grn` (`id`),
  CONSTRAINT `fk_grn_item_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.grn_payment
CREATE TABLE IF NOT EXISTS `grn_payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `grn_id` int NOT NULL,
  `payment_type_id` int NOT NULL,
  `payment` double NOT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_payment_grn1_idx` (`grn_id`),
  KEY `fk_grn_payment_payment_type1_idx` (`payment_type_id`),
  CONSTRAINT `fk_grn_payment_grn1` FOREIGN KEY (`grn_id`) REFERENCES `grn` (`id`),
  CONSTRAINT `fk_grn_payment_payment_type1` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.invoice
CREATE TABLE IF NOT EXISTS `invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_time` datetime DEFAULT NULL,
  `user_id` int NOT NULL,
  `employee_id` int NOT NULL,
  `unique_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_user1_idx` (`user_id`),
  KEY `fk_invoice_employee1_idx` (`employee_id`),
  CONSTRAINT `fk_invoice_employee1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_invoice_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.invoice_item
CREATE TABLE IF NOT EXISTS `invoice_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `stock_id` int NOT NULL,
  `qty` int DEFAULT NULL,
  `invoice_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_item_stock1_idx` (`stock_id`),
  KEY `fk_invoice_item_invoice1_idx` (`invoice_id`),
  CONSTRAINT `fk_invoice_item_invoice1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`),
  CONSTRAINT `fk_invoice_item_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.invoice_payment
CREATE TABLE IF NOT EXISTS `invoice_payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `invoice_id` int NOT NULL,
  `payment_type_id` int NOT NULL,
  `payment` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_invoice_payment_invoice1_idx` (`invoice_id`),
  KEY `fk_invoice_payment_payment_type1_idx` (`payment_type_id`),
  CONSTRAINT `fk_invoice_payment_invoice1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`),
  CONSTRAINT `fk_invoice_payment_payment_type1` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.jwellary
CREATE TABLE IF NOT EXISTS `jwellary` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `caret_no` varchar(45) NOT NULL,
  `supplier_id` int NOT NULL,
  `category_id` int NOT NULL,
  `material_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_category1_idx` (`category_id`),
  KEY `fk_jwellary_supplier1_idx` (`supplier_id`),
  KEY `fk_jwellary_material1_idx` (`material_id`),
  CONSTRAINT `fk_jwellary_material1` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  CONSTRAINT `fk_jwellary_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `fk_product_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.material
CREATE TABLE IF NOT EXISTS `material` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.owner
CREATE TABLE IF NOT EXISTS `owner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `emaill` varchar(45) NOT NULL,
  `passcode` varchar(45) NOT NULL,
  `emp_category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_owner_emp_category1_idx` (`emp_category_id`),
  CONSTRAINT `fk_owner_emp_category1` FOREIGN KEY (`emp_category_id`) REFERENCES `emp_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.payment_type
CREATE TABLE IF NOT EXISTS `payment_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.stock
CREATE TABLE IF NOT EXISTS `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `jwellary_id` int NOT NULL,
  `quantity` int NOT NULL,
  `selling_price` double NOT NULL,
  `mfd` date NOT NULL,
  `Status` varchar(20) DEFAULT 'Availble',
  PRIMARY KEY (`id`),
  KEY `fk_stock_jwellary1_idx` (`jwellary_id`),
  CONSTRAINT `fk_stock_jwellary1` FOREIGN KEY (`jwellary_id`) REFERENCES `jwellary` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `contact_number` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `company_branch_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supplier_company_branch1_idx` (`company_branch_id`),
  CONSTRAINT `fk_supplier_company_branch1` FOREIGN KEY (`company_branch_id`) REFERENCES `company_branch` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `contact_number` varchar(10) NOT NULL,
  `city_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_city1_idx` (`city_id`),
  CONSTRAINT `fk_user_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.user_status
CREATE TABLE IF NOT EXISTS `user_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

-- Dumping structure for table jwellary_shop.user_type
CREATE TABLE IF NOT EXISTS `user_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- Data exporting was unselected.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
