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
CREATE DATABASE IF NOT EXISTS `hwm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hwm`;


-- Volcando estructura para procedimiento hwm.buscarPlanetas
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarPlanetas`(IN `pCriterio` VARCHAR(150))
    COMMENT 'Busca Planetas por su nombre siempre que contenga el ''criterio '' de busqueda. Limitado a 1000'
BEGIN
	SELECT id, nombre, imagen
	FROM `planet`
	WHERE nombre
	LIKE BINARY CONCAT ('%',pCriterio,'%')
	ORDER BY id
	DESC LIMIT 1000;
END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.deletePersona
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `deletePersona`(IN `pId` INT)
BEGIN
	DELETE FROM `persona` WHERE  `id`=pId;
END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.deletePlaneta
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `deletePlaneta`(IN `pId` INT)
BEGIN

DELETE FROM `planet` WHERE  `id`=pId;

END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.getAllPersonas
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllPersonas`()
BEGIN
	SELECT `id`, `nombre`, `email` FROM `persona`
	ORDER BY `id` DESC
	LIMIT 100;
END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.getAllPlanetas
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllPlanetas`()
    COMMENT 'ultimos 1000 planetas creados'
BEGIN

SELECT id,nombre,imagen FROM `planet` ORDER BY id DESC LIMIT 1000;

END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.getByIdPersona
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getByIdPersona`(IN `pId` INT)
BEGIN
	SELECT nombre, email FROM `persona` WHERE id = pId;
END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.getByIdPlaneta
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getByIdPlaneta`(IN `pId` INT)
    COMMENT 'detalle del Planeta solicitado por ''id'''
BEGIN
	SELECT nombre, imagen FROM `planet` WHERE id = pId;
END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.insertPersona
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertPersona`(IN `pNombre` VARCHAR(250), IN `pEmail` VARCHAR(250), OUT `pId` INT)
BEGIN
	-- insercion
	 INSERT INTO `persona` (`nombre`, `email`) VALUES (pNombre, pEmail);
	 
	 -- buscar ultimo id generado
	SET pId = LAST_INSERT_ID();
END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.insertPlaneta
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertPlaneta`(IN `pNombre` VARCHAR(150), IN `pImagen` VARCHAR(250), OUT `pId` INT)
    COMMENT 'Insertar nuevo Planeta'
BEGIN

-- insercion
 INSERT INTO `hwm`.`planet` (`nombre`, `imagen`) VALUES (pNombre, pImagen);
 
 -- buscar ultimo id generado
SET pId = LAST_INSERT_ID();
 
END//
DELIMITER ;


-- Volcando estructura para tabla hwm.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) NOT NULL DEFAULT 'Anonimo',
  `email` varchar(250) NOT NULL DEFAULT 'anonimo@dominio.com',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hwm.persona: ~1 rows (aproximadamente)
DELETE FROM `persona`;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`id`, `nombre`, `email`) VALUES
	(20, 'Anonimo', 'anonimo@dominio.com'),
	(21, 'Anonimo2', 'anonimo2@dominio.com');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;


-- Volcando estructura para tabla hwm.planet
CREATE TABLE IF NOT EXISTS `planet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) NOT NULL DEFAULT 'sin nombre',
  `imagen` varchar(250) NOT NULL DEFAULT 'http://icdn.pro/images/en/a/s/astroid-moon-planet-icone-5626-128.png',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='Pl';

-- Volcando datos para la tabla hwm.planet: ~3 rows (aproximadamente)
DELETE FROM `planet`;
/*!40000 ALTER TABLE `planet` DISABLE KEYS */;
INSERT INTO `planet` (`id`, `nombre`, `imagen`) VALUES
	(8, 'Nuevo Planeta9', 'http://www.sharecg.com/images/medium/14274.jpg'),
	(15, 'Nuevo Planeta3', 'https://d30y9cdsu7xlg0.cloudfront.net/png/792-200.png'),
	(17, 'planeta x', 'https://d30y9cdsu7xlg0.cloudfront.net/png/792-200.png');
/*!40000 ALTER TABLE `planet` ENABLE KEYS */;


-- Volcando estructura para procedimiento hwm.updatePersona
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `updatePersona`(IN `pNombre` VARCHAR(250), IN `pEmail` VARCHAR(250), IN `pId` INT)
BEGIN
	UPDATE `persona` SET `nombre`=pNombre,`email`=pEmail WHERE  `id`=pId;
END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.updatePlaneta
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `updatePlaneta`(IN `pNombre` VARCHAR(150), IN `pImagen` VARCHAR(250), IN `pId` INT)
BEGIN

UPDATE `planet` SET `nombre`=pNombre,`imagen`=pImagen WHERE  `id`=pId;

END//
DELIMITER ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
