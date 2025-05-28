-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-05-2025 a las 10:45:43
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

--
-- Volcado de datos para la tabla `ataques`
--

INSERT INTO `ataques` (`id_ataques`, `nombreBasico`, `danoBasico`, `descripcionBasico`, `nombreFuerte`, `danoFuerte`, `descripcionFuerte`, `nombreHabilidad`, `datosHabilidad`, `descripcionHabilidad`) VALUES
(1, 'Cetro', 30, 'Bonk', 'Invocación de bestias', 130, 'Ánuket invoca dos hellhounds que muerden al enemigo', 'Aegis etéreo', 20, 'Invoca un escudo alrededor de Ánuket'),
(2, 'Dagas', 30, 'Bastet lanza afiladas dagas contra su enemigo', 'Flor fatal', 140, 'Bastet lanza dagas impregnadas en veneno', 'Alma voraz', 40, 'Bastet lanza un hechizo que restaura algo de salud'),
(3, 'Espada', 40, 'Slash', 'Doble espada', 120, 'Slash x2', 'Señal de Rhyon', 30, 'Gerald recibe un aumento de daño');

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

--
-- Volcado de datos para la tabla `ataques_enemigos`
--

INSERT INTO `ataques_enemigos` (`id_ataques_enemigos`, `nombreBasico`, `danoBasico`, `descripcionBasico`, `nombreFuerte`, `danoFuerte`, `descripcionFuerte`, `nombreHabilidad`, `datosHabilidad`, `descripcionHabilidad`) VALUES
(1, 'Básico', 20, 'dano', 'Fuerte', 40, 'dano', 'Bonk', 60, 'dano'),
(2, 'Básico', 30, 'dano', 'Fuerte', 60, 'dano', 'Cambio x1', 1, 'Cambia terreno'),
(3, 'Básico', 30, 'dano', 'Fuerte', 60, 'dano', 'Cambio x1', 1, 'Cambia terreno'),
(4, 'Básico', 40, 'dano', 'Fuerte', 80, 'dano', 'Cambio x1', 1, 'Cambia terreno'),
(5, 'Básico', 50, 'dano', 'Fuerte', 100, 'dano', 'Cambio x2', 2, 'Cambia terreno y clima'),
(6, 'Básico', 50, 'dano', 'Fuerte', 100, 'dano', 'Cambio x2', 2, 'Cambia terreno y clima'),
(7, 'Básico', 70, 'dano', 'Fuerte', 140, 'dano', 'Cambio x3', 3, 'Cambia terreno clima y hora');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `batallas`
--

CREATE TABLE `batallas` (
  `id_batallas` int(11) NOT NULL,
  `nombreBatalla` varchar(100) DEFAULT NULL,
  `id_enemigos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `batallas`
--

INSERT INTO `batallas` (`id_batallas`, `nombreBatalla`, `id_enemigos`) VALUES
(1, 'Batalla 1', 1),
(2, 'Batalla 2', 2),
(3, 'Batalla 3', 3),
(4, 'Batalla 4', 4),
(5, 'Batalla 5', 5),
(6, 'Batalla 6', 6),
(7, 'Batalla Final', 7);

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

--
-- Volcado de datos para la tabla `climas`
--

INSERT INTO `climas` (`id_climas`, `nombreClima`, `buff`, `descripcionBuff`, `penalizacion`, `descripcionPenalizacion`) VALUES
(1, 'Nublado', 10, '+defensa', 0, NULL),
(2, 'Despejado', 20, '+defensa', 0, NULL),
(3, 'Calor extremo', 0, NULL, 30, '-defensa'),
(4, 'Frío extremo', 0, NULL, 20, '-defensa'),
(5, 'Tormenta de arena', 0, NULL, 25, '-defensa'),
(6, 'i0_io_0rr0r', 0, 'class~#descriptionBuff:notfound', 0, 'class~#descriptionDeBuff:notfound');

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

--
-- Volcado de datos para la tabla `enemigos`
--

INSERT INTO `enemigos` (`id_enemigos`, `nombreEnemigo`, `especie`, `vida`, `id_ataques_enemigos`) VALUES
(1, 'Uno', 'Uno', 200, 1),
(2, 'Dos', 'Dos', 300, 2),
(3, 'Tres', 'Tres', 500, 3),
(4, 'Cuatro', 'Cuatro', 700, 4),
(5, 'Cinco', 'Cinco', 1000, 5),
(6, 'Seis', 'Seis', 1500, 6),
(7, 'Taharka', 'Siete', 2000, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escenarios`
--

CREATE TABLE `escenarios` (
  `id_escenarios` int(11) NOT NULL,
  `nombreEscenario` varchar(100) DEFAULT NULL,
  `id_batallas` int(11) DEFAULT NULL,
  `id_puzzles` int(11) DEFAULT NULL,
  `id_terrenos` int(11) DEFAULT NULL,
  `id_climas` int(11) DEFAULT NULL,
  `id_horas_del_dia` int(11) DEFAULT NULL,
  `id_npc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `escenarios`
--

INSERT INTO `escenarios` (`id_escenarios`, `nombreEscenario`, `id_batallas`, `id_puzzles`, `id_terrenos`, `id_climas`, `id_horas_del_dia`, `id_npc`) VALUES
(1, 'Escenario 1', 1, NULL, 6, 6, 5, 1),
(2, 'Escenario 2', 2, 1, 6, 6, 5, 1),
(3, 'Escenario 3', NULL, 2, 6, 6, 5, 1),
(4, 'Escenario 4', 3, NULL, 6, 6, 5, 1),
(5, 'Escenario 5', 4, 3, 6, 6, 5, 1),
(6, 'Escenario 6', NULL, 4, 6, 6, 5, 2),
(7, 'Escenario 7', 5, NULL, 6, 6, 5, 1),
(8, 'Escenario 8', 6, NULL, 6, 6, 5, 1),
(9, 'Escenario 9', NULL, 5, 6, 6, 5, 3),
(10, 'Escenario 10', 7, NULL, 6, 6, 5, 1);

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

--
-- Volcado de datos para la tabla `horas_del_dia`
--

INSERT INTO `horas_del_dia` (`id_horas_del_dia`, `nombreHora`, `buff`, `descripcionBuff`, `penalizacion`, `descripcionPenalizacion`) VALUES
(1, 'Mañana', 20, '+ataque', 0, NULL),
(2, 'Mediodía', 10, '+ataque', 0, NULL),
(3, 'Tarde', 0, NULL, 5, '-ataque'),
(4, 'Noche', 0, NULL, 10, '-ataque'),
(5, 'crypt_id404', 0, 'class~#descriptionBuff:notfound', 0, 'class~#descriptionDeBuff:notfound');

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

--
-- Volcado de datos para la tabla `npc`
--

INSERT INTO `npc` (`id_npc`, `nombreNPC`, `especie`, `frase_1`, `frase_2`, `frase_3`, `ayuda_1`, `ayuda_2`, `ayuda_3`) VALUES
(1, 'Compa', 'Humano', 'frase1_dano', 'frase2_dano', 'frase3_dano', 35, 75, 150),
(2, 'Randi', 'Desconocida', 'frase1_vidaMax', 'frase2_vidaMax', 'frase3_vidaMax', 100, 150, 200),
(3, 'Ammet', 'Dios', 'frase1_-vida', 'frase2_+def', 'frase3_+dano', 9999, 50, 9999);

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

--
-- Volcado de datos para la tabla `personajes`
--

INSERT INTO `personajes` (`id_personajes`, `nombrePersonaje`, `vida`, `final_1`, `final_2`, `final_3`, `final_4`, `final_5`, `id_ataques`) VALUES
(1, 'Ánuket', 650, 'texto final...', 'texto final...', 'texto final...', 'texto final...', 'texto final...', 1),
(2, 'Bastet', 700, 'texto final...', 'texto final...', 'texto final...', 'texto final...', 'texto final...', 2),
(3, 'Gerald', 600, 'texto final...', 'texto final...', 'texto final...', 'texto final...', 'texto final...', 3);

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

--
-- Volcado de datos para la tabla `puzzles`
--

INSERT INTO `puzzles` (`id_puzzles`, `nombrePuzzle`, `descripcion`, `puntos`) VALUES
(1, 'Puzzle1', 'Adivina el número', 10),
(2, 'Puzzle2', 'Acertijo Esfinge', 10),
(3, 'Puzzle3', 'Ahorcado', 10),
(4, 'Puzzle4', 'Piedra papel o tijeras', 10),
(5, 'Puzzle5', 'Trivial Egipto', 10);

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
-- Volcado de datos para la tabla `terrenos`
--

INSERT INTO `terrenos` (`id_terrenos`, `nombreTerreno`, `buff`, `descripcionBuff`, `penalizacion`, `descripcionPenalizacion`) VALUES
(1, 'Suelo de hierbas raras y brillantes', 5, '+vida', 0, NULL),
(2, 'Suelo pixelado (rollo glitch digital)', 20, '+vida', 0, NULL),
(3, 'Suelo mágico', 10, '+vida', 10, '-vida'),
(4, 'Suelo de hielo', 0, NULL, 5, '-vida'),
(5, 'Suelo de magma', 0, NULL, 15, '-vida'),
(6, 'VOID999x_dump', 0, 'class~#descriptionBuff:notfound', 0, 'class~#descriptionDeBuff:notfound');

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
  MODIFY `id_ataques` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ataques_enemigos`
--
ALTER TABLE `ataques_enemigos`
  MODIFY `id_ataques_enemigos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `batallas`
--
ALTER TABLE `batallas`
  MODIFY `id_batallas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `climas`
--
ALTER TABLE `climas`
  MODIFY `id_climas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `enemigos`
--
ALTER TABLE `enemigos`
  MODIFY `id_enemigos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `escenarios`
--
ALTER TABLE `escenarios`
  MODIFY `id_escenarios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `horas_del_dia`
--
ALTER TABLE `horas_del_dia`
  MODIFY `id_horas_del_dia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `npc`
--
ALTER TABLE `npc`
  MODIFY `id_npc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `personajes`
--
ALTER TABLE `personajes`
  MODIFY `id_personajes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `puzzles`
--
ALTER TABLE `puzzles`
  MODIFY `id_puzzles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `terrenos`
--
ALTER TABLE `terrenos`
  MODIFY `id_terrenos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
