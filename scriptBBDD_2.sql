-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.24 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para hwm
CREATE DATABASE IF NOT EXISTS `hwm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hwm`;


-- Volcando estructura para procedimiento hwm.buscarPersona
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarPersona`(IN `personaId` INT)
BEGIN
SELECT id,nombre, email FROM `persona` WHERE id = personaId;
END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.buscarPlaneta
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarPlaneta`(IN `pId` INT)
    COMMENT 'Busca planeta por ID'
BEGIN

SELECT id,nombre, imagen FROM `planet` WHERE id = pId;

END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.buscarPlanetas
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarPlanetas`(IN `pCriterio` VARCHAR(150))
    COMMENT 'busca planetas por su nombre siempre que contenga el ''criterio'' de busqueda, limit 1000'
BEGIN
 	SELECT id,nombre,imagen 
	FROM `planet` 
	WHERE nombre like BINARY  CONCAT('%',pCriterio,'%')
	ORDER BY id 
	DESC LIMIT 1000;
END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.deletePersona
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `deletePersona`(IN `idPersona` INT)
    COMMENT 'Proceso para borrar persona por id en la base de datos'
BEGIN
DELETE FROM `persona` WHERE `id`= idPersona;
END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.deletePlaneta
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `deletePlaneta`(IN `pId` INT)
BEGIN

DELETE FROM `planet` WHERE `id`= pId;

END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.getAllPersonas
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllPersonas`()
    COMMENT 'Devuleve los ultimos 100 registros de la tabla persona'
BEGIN
select `id`,`nombre`,`email` from `persona` order by `id`desc limit 100;
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


-- Volcando estructura para procedimiento hwm.insertPersona
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertPersona`(IN `nombrePersona` VARCHAR(150), IN `emailPersona` VARCHAR(150), OUT `personaId` INT)
    COMMENT 'Proceso para insertar persona'
BEGIN
-- insert
INSERT INTO `persona` (`nombre`, `email`)  VALUES (nombrePersona, emailPersona);
-- buscar ultimo id generado
SET personaId = LAST_INSERT_ID();
END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.insertPlaneta
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertPlaneta`(IN `pNombre` VARCHAR(150), IN `pImagen` VARCHAR(250), OUT `pId` INT)
    COMMENT 'Inserccion nuevo planeta'
BEGIN

-- inserccion
INSERT INTO `planet` (`nombre`, `imagen`) VALUES (pNombre, pImagen);
-- buscar ultimo id generado
SET pId = LAST_INSERT_ID();

END//
DELIMITER ;


-- Volcando estructura para tabla hwm.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hwm.persona: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
REPLACE INTO `persona` (`id`, `nombre`, `email`) VALUES
	(1, 'astrako', 'astrako'),
	(2, 'jon', '@d');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;


-- Volcando estructura para tabla hwm.planet
CREATE TABLE IF NOT EXISTS `planet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) NOT NULL DEFAULT 'sin nombre',
  `imagen` varchar(250) NOT NULL DEFAULT 'http://icdn.pro/images/en/a/s/astroid-moon-planet-icone-5626-128.png',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='Pl';

-- Volcando datos para la tabla hwm.planet: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `planet` DISABLE KEYS */;
REPLACE INTO `planet` (`id`, `nombre`, `imagen`) VALUES
	(4, 'jupiter', 'https://img.rt.com/files/2015.10/original/561e6b71c46188796e8b45a7.jpg'),
	(8, 'Saturno', 'http://vignette4.wikia.nocookie.net/spore/images/b/ba/Saturno1.jpg/revision/latest?cb=20110423092538&path-prefix=es'),
	(11, 'ManoloPlanet2', 'http://www.abc.es/Media/201406/05/Theia-choque-Tierra-luna--644x362--644x362.jpg'),
	(12, 'color xy', 'http://static.t13.cl/images/sizes/1200x675/1426586153_saturno.jpg');
/*!40000 ALTER TABLE `planet` ENABLE KEYS */;


-- Volcando estructura para procedimiento hwm.updatePersona
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `updatePersona`(IN `personaNombre` VARCHAR(150), IN `personaEmail` VARCHAR(150), IN `personaId` INT)
    COMMENT 'Proceso para modificar persona por id'
BEGIN
UPDATE `persona` SET `nombre`=personaNombre,`email`=personaEmail WHERE `id`=personaId;
END//
DELIMITER ;


-- Volcando estructura para procedimiento hwm.updatePlaneta
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `updatePlaneta`(IN `pNombre` VARCHAR(150), IN `pImagen` VARCHAR(250), IN `pId` INT)
BEGIN

UPDATE `planet` SET `nombre`=pNombre,`imagen`=pImagen WHERE `id`=pId;

END//
DELIMITER ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
