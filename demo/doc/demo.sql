-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 23, 2025 alle 10:34
-- Versione del server: 10.4.10-MariaDB
-- Versione PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `demo`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `film`
--

CREATE TABLE `film` (
  `id` bigint(20) NOT NULL,
  `titolo` varchar(255) NOT NULL,
  `anno` int(11) DEFAULT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  `regista` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='programmazione film';

--
-- Dump dei dati per la tabella `film`
--

INSERT INTO `film` (`id`, `titolo`, `anno`, `descrizione`, `regista`) VALUES
(1, 'Profondo rosso', 1975, 'Durante una conferenza sul paranormale, la sensitiva tedesca Helga Ulmann percepisce la presenza di un omicida tra il pubblico e, spaventata, è costretta a interrompere la seduta. ', 'Dario Argento');

-- --------------------------------------------------------

--
-- Struttura della tabella `programmazione`
--

CREATE TABLE `programmazione` (
  `id` bigint(20) NOT NULL,
  `data` date DEFAULT NULL,
  `sala` varchar(255) DEFAULT NULL,
  `id_film` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `programmazione`
--

INSERT INTO `programmazione` (`id`, `data`, `sala`, `id_film`) VALUES
(1, '2025-01-25', 'A', 1),
(2, '2025-01-26', 'A', 1),
(3, '2025-01-11', 'B', 1),
(4, '2024-12-29', 'C', 1);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `programmazione`
--
ALTER TABLE `programmazione`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqusqe4h0ylsxia45wxx5rriua` (`id_film`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `film`
--
ALTER TABLE `film`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `programmazione`
--
ALTER TABLE `programmazione`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `programmazione`
--
ALTER TABLE `programmazione`
  ADD CONSTRAINT `FKqusqe4h0ylsxia45wxx5rriua` FOREIGN KEY (`id_film`) REFERENCES `film` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
