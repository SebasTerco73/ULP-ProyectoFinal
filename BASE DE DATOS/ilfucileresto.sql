-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-11-2023 a las 21:39:12
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ilfucileresto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `DNI` varchar(15) NOT NULL,
  `puesto` varchar(30) NOT NULL,
  `user` varchar(20) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idEmpleado`, `apellido`, `nombre`, `DNI`, `puesto`, `user`, `password`, `estado`) VALUES
(4, 'Rubio', 'Loana', '42622026', 'ENCARGADO', '42622026', 'loana', 1),
(5, 'Kadlec', 'Fernando', '45782654', 'ENCARGADO', '45782654', '45782654', 1),
(6, 'Puche', 'Sebastian', '43784512', 'ENCARGADO', '43784512', '43784512', 1),
(7, 'Perez', 'Juan', '40587451', 'MESERO', '40587451', '1', 1),
(8, 'Rodriguez', 'Franco', '41569832', 'MESERO', '41569832', '41569832', 1),
(9, 'Sanchez', 'Marta', '37854125', 'MESERO', '37854125', '37854125', 1),
(10, 'Ramirez', 'Marcela', '36547812', 'MESERO', '36547812', '36547812', 1),
(11, 'Iorio', 'Richard', '1', 'ENCARGADO', '1', '1', 1),
(12, 'Garcia', 'Charly', '2', 'MESERO', '2', '2', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idEmpleado`),
  ADD UNIQUE KEY `DNI` (`DNI`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
