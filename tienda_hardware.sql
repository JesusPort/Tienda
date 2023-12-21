-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2023 a las 17:38:57
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda_hardware`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `componente`
--

CREATE TABLE `componente` (
  `ID_componente` int(10) NOT NULL,
  `nombre_componente` varchar(100) NOT NULL,
  `Fabricante` varchar(100) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `Descripcion` varchar(500) NOT NULL,
  `ID_tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `componente`
--

INSERT INTO `componente` (`ID_componente`, `nombre_componente`, `Fabricante`, `precio`, `Descripcion`, `ID_tipo`) VALUES
(1, 'Componente1', 'Fabricante1', 100.00, 'Descripcion1', 1),
(2, 'Componente2', 'Fabricante2', 200.00, 'Descripcion2', 2),
(3, 'Componente3', 'Fabricante3', 300.00, 'Descripcion3', 3),
(4, 'Componente4', 'Fabricante4', 400.00, 'Descripcion4', 4),
(5, 'Componente5', 'Fabricante5', 500.00, 'Descripcion5', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `id_tipo` int(11) NOT NULL,
  `nombre_tipo` enum('CPU','GPU','RAM','PLACA_BASE','ALMACENAMIENTO') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`id_tipo`, `nombre_tipo`) VALUES
(1, 'CPU'),
(2, 'GPU'),
(3, 'RAM'),
(4, ''),
(5, 'PLACA_BASE'),
(6, 'ALMACENAMIENTO'),
(7, 'CPU'),
(8, 'PLACA_BASE');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `componente`
--
ALTER TABLE `componente`
  ADD PRIMARY KEY (`ID_componente`),
  ADD UNIQUE KEY `ID_tipo` (`ID_tipo`),
  ADD UNIQUE KEY `ID_tipo_3` (`ID_tipo`),
  ADD KEY `ID_tipo_2` (`ID_tipo`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`id_tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `componente`
--
ALTER TABLE `componente`
  MODIFY `ID_componente` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `componente`
--
ALTER TABLE `componente`
  ADD CONSTRAINT `fk_componente_tipo` FOREIGN KEY (`ID_tipo`) REFERENCES `tipo` (`id_tipo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
