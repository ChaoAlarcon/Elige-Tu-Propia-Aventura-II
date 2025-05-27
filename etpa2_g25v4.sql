-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2025 a las 10:02:21
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `etpa2_g25v4`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ataques`
--

CREATE TABLE `ataques` (
  `id_ataques` int(11) NOT NULL,
  `nombreBasico` varchar(100) DEFAULT NULL,
  `danoBasico` int(11) DEFAULT NULL,
  `descripcionBasico` text DEFAULT NULL,
  `nombreFuerte` varchar(100) DEFAULT NULL,
  `danoFuerte` int(11) DEFAULT NULL,
  `descripcionFuerte` text DEFAULT NULL,
  `nombreHabilidad` varchar(100) DEFAULT NULL,
  `datosHabilidad` int(11) DEFAULT NULL,
  `descripcionHabilidad` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ataques_enemigos`
--

CREATE TABLE `ataques_enemigos` (
  `id_ataques_enemigos` int(11) NOT NULL,
  `nombreBasico` varchar(100) DEFAULT NULL,
  `danoBasico` int(11) DEFAULT NULL,
  `descripcionBasico` text DEFAULT NULL,
  `nombreFuerte` varchar(100) DEFAULT NULL,
  `danoFuerte` int(11) DEFAULT NULL,
  `descripcionFuerte` text DEFAULT NULL,
  `nombreHabilidad` varchar(100) DEFAULT NULL,
  `datosHabilidad` int(11) DEFAULT NULL,
  `descripcionHabilidad` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `batallas`
--

CREATE TABLE `batallas` (
  `id_batallas` int(11) NOT NULL,
  `nombreBatalla` varchar(100) DEFAULT NULL,
  `escenario` varchar(100) DEFAULT NULL,
  `enemigo` varchar(100) DEFAULT NULL,
  `id_enemigos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `climas`
--

CREATE TABLE `climas` (
  `id_climas` int(11) NOT NULL,
  `nombreClima` varchar(100) DEFAULT NULL,
  `buff` int(11) DEFAULT NULL,
  `descripcionBuff` text DEFAULT NULL,
  `penalizacion` int(11) DEFAULT NULL,
  `descripcionPenalizacion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enemigos`
--

CREATE TABLE `enemigos` (
  `id_enemigos` int(11) NOT NULL,
  `nombreEnemigo` varchar(100) DEFAULT NULL,
  `especie` varchar(100) DEFAULT NULL,
  `vida` int(11) DEFAULT NULL,
  `id_ataques_enemigos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escenarios`
--

CREATE TABLE `escenarios` (
  `id_escenarios` int(11) NOT NULL,
  `nombreEscenario` varchar(100) DEFAULT NULL,
  `nombreBatalla` varchar(100) DEFAULT NULL,
  `id_batallas` int(11) DEFAULT NULL,
  `nombrePuzzle` varchar(100) DEFAULT NULL,
  `id_puzzles` int(11) DEFAULT NULL,
  `terreno` varchar(100) DEFAULT NULL,
  `id_terrenos` int(11) DEFAULT NULL,
  `clima` varchar(100) DEFAULT NULL,
  `id_climas` int(11) DEFAULT NULL,
  `hora_del_dia` varchar(100) DEFAULT NULL,
  `id_horas_del_dia` int(11) DEFAULT NULL,
  `id_npc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horas_del_dia`
--

CREATE TABLE `horas_del_dia` (
  `id_horas_del_dia` int(11) NOT NULL,
  `nombreHora` varchar(50) DEFAULT NULL,
  `buff` int(11) DEFAULT NULL,
  `descripcionBuff` text DEFAULT NULL,
  `penalizacion` int(11) DEFAULT NULL,
  `descripcionPenalizacion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `id` int(11) NOT NULL,
  `nombreJugador` varchar(100) DEFAULT NULL,
  `contrasena` varchar(100) DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `npc`
--

CREATE TABLE `npc` (
  `id_npc` int(11) NOT NULL,
  `nombreNPC` varchar(100) DEFAULT NULL,
  `especie` varchar(100) DEFAULT NULL,
  `frase_1` text DEFAULT NULL,
  `frase_2` text DEFAULT NULL,
  `frase_3` text DEFAULT NULL,
  `ayuda_1` int(11) DEFAULT NULL,
  `ayuda_2` int(11) DEFAULT NULL,
  `ayuda_3` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personajes`
--

CREATE TABLE `personajes` (
  `id_personajes` int(11) NOT NULL,
  `nombrePersonaje` varchar(100) DEFAULT NULL,
  `vida` int(11) DEFAULT NULL,
  `final_1` text DEFAULT NULL,
  `final_2` text DEFAULT NULL,
  `final_3` text DEFAULT NULL,
  `final_4` text DEFAULT NULL,
  `final_5` text DEFAULT NULL,
  `id_ataques` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puzzles`
--

CREATE TABLE `puzzles` (
  `id_puzzles` int(11) NOT NULL,
  `nombrePuzzle` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `terrenos`
--

CREATE TABLE `terrenos` (
  `id_terrenos` int(11) NOT NULL,
  `nombreTerreno` varchar(100) DEFAULT NULL,
  `buff` int(11) DEFAULT NULL,
  `descripcionBuff` text DEFAULT NULL,
  `penalizacion` int(11) DEFAULT NULL,
  `descripcionPenalizacion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ataques`
--
ALTER TABLE `ataques`
  ADD PRIMARY KEY (`id_ataques`);

--
-- Indices de la tabla `ataques_enemigos`
--
ALTER TABLE `ataques_enemigos`
  ADD PRIMARY KEY (`id_ataques_enemigos`);

--
-- Indices de la tabla `batallas`
--
ALTER TABLE `batallas`
  ADD PRIMARY KEY (`id_batallas`),
  ADD KEY `id_enemigos` (`id_enemigos`);

--
-- Indices de la tabla `climas`
--
ALTER TABLE `climas`
  ADD PRIMARY KEY (`id_climas`);

--
-- Indices de la tabla `enemigos`
--
ALTER TABLE `enemigos`
  ADD PRIMARY KEY (`id_enemigos`),
  ADD KEY `id_ataques_enemigos` (`id_ataques_enemigos`);

--
-- Indices de la tabla `escenarios`
--
ALTER TABLE `escenarios`
  ADD PRIMARY KEY (`id_escenarios`),
  ADD KEY `id_batallas` (`id_batallas`),
  ADD KEY `id_puzzles` (`id_puzzles`),
  ADD KEY `id_terrenos` (`id_terrenos`),
  ADD KEY `id_climas` (`id_climas`),
  ADD KEY `id_horas_del_dia` (`id_horas_del_dia`),
  ADD KEY `id_npc` (`id_npc`);

--
-- Indices de la tabla `horas_del_dia`
--
ALTER TABLE `horas_del_dia`
  ADD PRIMARY KEY (`id_horas_del_dia`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `npc`
--
ALTER TABLE `npc`
  ADD PRIMARY KEY (`id_npc`);

--
-- Indices de la tabla `personajes`
--
ALTER TABLE `personajes`
  ADD PRIMARY KEY (`id_personajes`),
  ADD KEY `id_ataques` (`id_ataques`);

--
-- Indices de la tabla `puzzles`
--
ALTER TABLE `puzzles`
  ADD PRIMARY KEY (`id_puzzles`);

--
-- Indices de la tabla `terrenos`
--
ALTER TABLE `terrenos`
  ADD PRIMARY KEY (`id_terrenos`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ataques`
--
ALTER TABLE `ataques`
  MODIFY `id_ataques` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ataques_enemigos`
--
ALTER TABLE `ataques_enemigos`
  MODIFY `id_ataques_enemigos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `batallas`
--
ALTER TABLE `batallas`
  MODIFY `id_batallas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `climas`
--
ALTER TABLE `climas`
  MODIFY `id_climas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `enemigos`
--
ALTER TABLE `enemigos`
  MODIFY `id_enemigos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `escenarios`
--
ALTER TABLE `escenarios`
  MODIFY `id_escenarios` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `horas_del_dia`
--
ALTER TABLE `horas_del_dia`
  MODIFY `id_horas_del_dia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `npc`
--
ALTER TABLE `npc`
  MODIFY `id_npc` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `personajes`
--
ALTER TABLE `personajes`
  MODIFY `id_personajes` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `puzzles`
--
ALTER TABLE `puzzles`
  MODIFY `id_puzzles` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `terrenos`
--
ALTER TABLE `terrenos`
  MODIFY `id_terrenos` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `batallas`
--
ALTER TABLE `batallas`
  ADD CONSTRAINT `batallas_ibfk_1` FOREIGN KEY (`id_enemigos`) REFERENCES `enemigos` (`id_enemigos`);

--
-- Filtros para la tabla `enemigos`
--
ALTER TABLE `enemigos`
  ADD CONSTRAINT `enemigos_ibfk_1` FOREIGN KEY (`id_ataques_enemigos`) REFERENCES `ataques_enemigos` (`id_ataques_enemigos`);

--
-- Filtros para la tabla `escenarios`
--
ALTER TABLE `escenarios`
  ADD CONSTRAINT `escenarios_ibfk_1` FOREIGN KEY (`id_batallas`) REFERENCES `batallas` (`id_batallas`),
  ADD CONSTRAINT `escenarios_ibfk_2` FOREIGN KEY (`id_puzzles`) REFERENCES `puzzles` (`id_puzzles`),
  ADD CONSTRAINT `escenarios_ibfk_3` FOREIGN KEY (`id_terrenos`) REFERENCES `terrenos` (`id_terrenos`),
  ADD CONSTRAINT `escenarios_ibfk_4` FOREIGN KEY (`id_climas`) REFERENCES `climas` (`id_climas`),
  ADD CONSTRAINT `escenarios_ibfk_5` FOREIGN KEY (`id_horas_del_dia`) REFERENCES `horas_del_dia` (`id_horas_del_dia`),
  ADD CONSTRAINT `escenarios_ibfk_6` FOREIGN KEY (`id_npc`) REFERENCES `npc` (`id_npc`);

--
-- Filtros para la tabla `personajes`
--
ALTER TABLE `personajes`
  ADD CONSTRAINT `personajes_ibfk_1` FOREIGN KEY (`id_ataques`) REFERENCES `ataques` (`id_ataques`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
