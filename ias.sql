-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-02-2019 a las 15:26:42
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ias`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tont_aves`
--

CREATE TABLE `tont_aves` (
  `CDAVE` varchar(5) NOT NULL,
  `DSNOMBRE_COMUN` varchar(100) NOT NULL,
  `DSNOMBRE_CIENTIFICO` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tont_aves`
--

INSERT INTO `tont_aves` (`CDAVE`, `DSNOMBRE_COMUN`, `DSNOMBRE_CIENTIFICO`) VALUES
('1', 'codor', 'condorius'),
('2', 'loro', 'lorius'),
('3', 'colibri', 'colibrious'),
('5', 'Abejaruco', 'Merops apiaster'),
('6', 'Águila real', 'Aquila rapax');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tont_aves_pais`
--

CREATE TABLE `tont_aves_pais` (
  `CDPAIS` varchar(3) NOT NULL,
  `CDAVE` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tont_aves_pais`
--

INSERT INTO `tont_aves_pais` (`CDPAIS`, `CDAVE`) VALUES
('1', '1'),
('1', '2'),
('2', '3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tont_paises`
--

CREATE TABLE `tont_paises` (
  `CDPAIS` varchar(3) NOT NULL,
  `DSNOMBRE` varchar(100) NOT NULL,
  `CDZONA` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tont_paises`
--

INSERT INTO `tont_paises` (`CDPAIS`, `DSNOMBRE`, `CDZONA`) VALUES
('1', 'Colombia', '1'),
('2', 'Alemania', '2'),
('3', 'Italia', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tont_zonas`
--

CREATE TABLE `tont_zonas` (
  `CDZONA` varchar(3) NOT NULL,
  `DSNOMBRE` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tont_zonas`
--

INSERT INTO `tont_zonas` (`CDZONA`, `DSNOMBRE`) VALUES
('1', 'Zona1'),
('2', 'Zona2');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tont_aves`
--
ALTER TABLE `tont_aves`
  ADD PRIMARY KEY (`CDAVE`);

--
-- Indices de la tabla `tont_aves_pais`
--
ALTER TABLE `tont_aves_pais`
  ADD PRIMARY KEY (`CDPAIS`,`CDAVE`),
  ADD KEY `FKCDAVE` (`CDAVE`);

--
-- Indices de la tabla `tont_paises`
--
ALTER TABLE `tont_paises`
  ADD PRIMARY KEY (`CDPAIS`),
  ADD KEY `FKCDZONA` (`CDZONA`);

--
-- Indices de la tabla `tont_zonas`
--
ALTER TABLE `tont_zonas`
  ADD PRIMARY KEY (`CDZONA`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tont_aves_pais`
--
ALTER TABLE `tont_aves_pais`
  ADD CONSTRAINT `FKCDAVE` FOREIGN KEY (`CDAVE`) REFERENCES `tont_aves` (`CDAVE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FKCDPAIS` FOREIGN KEY (`CDPAIS`) REFERENCES `tont_paises` (`CDPAIS`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tont_paises`
--
ALTER TABLE `tont_paises`
  ADD CONSTRAINT `FKCDZONA` FOREIGN KEY (`CDZONA`) REFERENCES `tont_zonas` (`CDZONA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
