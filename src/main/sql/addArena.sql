-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.17-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para clash_calculetor
CREATE DATABASE IF NOT EXISTS `clash_calculetor` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `clash_calculetor`;

-- Copiando dados para a tabela clash_calculetor.arena: ~20 rows (aproximadamente)
/*!40000 ALTER TABLE `arena` DISABLE KEYS */;
INSERT INTO `arena` (`id_arena`, `name`, `min_trophy`) VALUES
	(1, 'Goblin Stadium', 0),
	(2, 'Bone Pit', 400),
	(3, 'Barbarian Bowl', 800),
	(4, 'P.E.K.K.A\'s Playhouse', 1100),
	(5, 'Spell Valley', 1400),
	(6, 'Builder\'s Workshop', 1700),
	(7, 'Royal Arena', 2000),
	(8, 'Frozen Peak', 2300),
	(9, 'Jungle Arena', 2600),
	(10, 'Hog Mountain', 3000),
	(11, 'Legendary Arena', 3800),
	(12, 'Challenger I', 4000),
	(13, 'Challenger II', 4300),
	(14, 'Challenger III', 4600),
	(15, 'Master I', 4900),
	(16, 'Master II', 5200),
	(17, 'Master III', 5500),
	(18, 'Champion', 5800),
	(19, 'Grand Champion', 6100),
	(20, 'Ultimate Champion', 6400);
/*!40000 ALTER TABLE `arena` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
