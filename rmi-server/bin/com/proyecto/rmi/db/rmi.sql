-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.40-0ubuntu0.14.04.1 - (Ubuntu)
-- SO del servidor:              debian-linux-gnu
-- HeidiSQL Versión:             8.3.0.4843
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para libreriarmi
CREATE DATABASE IF NOT EXISTS `libreriarmi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `libreriarmi`;


-- Volcando estructura para tabla libreriarmi.Libros
CREATE TABLE IF NOT EXISTS `Libros` (
  `id` int(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla libreriarmi.Libros: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `Libros` DISABLE KEYS */;
INSERT INTO `Libros` (`id`, `nombre`) VALUES
	(1, 'El caballero Carmelo'),
	(2, 'Las mil y una noches'),
	(3, 'El cisne'),
	(4, 'Romeo y Julieta');
/*!40000 ALTER TABLE `Libros` ENABLE KEYS */;


-- Volcando estructura para tabla libreriarmi.LibrosDisponibles
CREATE TABLE IF NOT EXISTS `LibrosDisponibles` (
  `id` int(11) DEFAULT NULL,
  `libro_id` int(11) NOT NULL,
  `isbn` varchar(50) DEFAULT NULL,
  `fecha_registro` date NOT NULL,
  `estado` char(50) DEFAULT NULL,
  KEY `id` (`id`),
  KEY `FK_LibrosDisponibles_Libros` (`libro_id`),
  CONSTRAINT `FK_LibrosDisponibles_Libros` FOREIGN KEY (`libro_id`) REFERENCES `Libros` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla libreriarmi.LibrosDisponibles: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `LibrosDisponibles` DISABLE KEYS */;
INSERT INTO `LibrosDisponibles` (`id`, `libro_id`, `isbn`, `fecha_registro`, `estado`) VALUES
	(1, 1, '1000000010', '2014-10-10', 'D'),
	(2, 1, '1000000011', '2014-10-10', 'D'),
	(3, 2, '1000000012', '2014-10-10', 'D'),
	(4, 2, '1000000013', '2014-10-10', 'D');
/*!40000 ALTER TABLE `LibrosDisponibles` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
