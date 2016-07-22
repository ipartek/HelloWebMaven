-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.17 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.5027
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para hwm
DROP DATABASE IF EXISTS `hwm`;
CREATE DATABASE IF NOT EXISTS `hwm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hwm`;


-- Volcando estructura para procedimiento hwm.getAllPlanetas
DROP PROCEDURE IF EXISTS `getAllPlanetas`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllPlanetas`()
    COMMENT 'ultimos 1000 planetas creados'
BEGIN

SELECT id,nombre,imagen FROM `planet` ORDER BY id DESC LIMIT 1000;

END//
DELIMITER ;


-- Volcando estructura para tabla hwm.planet
DROP TABLE IF EXISTS `planet`;
CREATE TABLE IF NOT EXISTS `planet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) NOT NULL DEFAULT 'sin nombre',
  `imagen` varchar(250) NOT NULL DEFAULT 'http://icdn.pro/images/en/a/s/astroid-moon-planet-icone-5626-128.png',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='Pl';

-- Volcando datos para la tabla hwm.planet: ~1 rows (aproximadamente)
DELETE FROM `planet`;
/*!40000 ALTER TABLE `planet` DISABLE KEYS */;
INSERT INTO `planet` (`id`, `nombre`, `imagen`) VALUES
	(4, 'jupiter', 'http://icdn.pro/images/en/a/s/astroid-moon-planet-icone-5626-128.png'),
	(8, 'saturno', 'http://icdn.pro/images/en/a/s/astroid-moon-planet-icone-5626-128.png');
/*!40000 ALTER TABLE `planet` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
