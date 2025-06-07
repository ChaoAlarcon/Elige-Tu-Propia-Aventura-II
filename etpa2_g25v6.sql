-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-06-2025 a las 12:39:37
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
-- Base de datos: `etpa2_g25v6`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ataques`
--

CREATE TABLE `ataques` (
  `id` int(11) NOT NULL,
  `id_ataques` int(11) DEFAULT NULL,
  `nombreBasico` varchar(100) DEFAULT NULL,
  `danoBasico` int(11) DEFAULT NULL,
  `descripcionBasico` text DEFAULT NULL,
  `precisionBasico` int(11) DEFAULT NULL,
  `nombreFuerte` varchar(100) DEFAULT NULL,
  `danoFuerte` int(11) DEFAULT NULL,
  `descripcionFuerte` text DEFAULT NULL,
  `precisionFuerte` int(11) DEFAULT NULL,
  `nombreHabilidad` varchar(100) DEFAULT NULL,
  `datosHabilidad` int(11) DEFAULT NULL,
  `descripcionHabilidad` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ataques`
--

INSERT INTO `ataques` (`id`, `id_ataques`, `nombreBasico`, `danoBasico`, `descripcionBasico`, `precisionBasico`, `nombreFuerte`, `danoFuerte`, `descripcionFuerte`, `precisionFuerte`, `nombreHabilidad`, `datosHabilidad`, `descripcionHabilidad`) VALUES
(1, 1, 'Porrazo de cetro', 50, 'Ánuket empuña su cetro y le da un golpe al enemigo', 100, 'Invocación de bestias', 250, 'Ánuket invoca dos golems que muerden al enemigo', 70, 'Aegis etéreo', 25, 'Ánuket invoca un escudo alrededor suyo que reduce el daño recibido'),
(2, 2, 'Lanzamiento de dagas', 55, 'Bastet lanza afiladas dagas contra su enemigo', 100, 'Flor fatal', 150, 'Bastet lanza dagas impregnadas con veneno', 90, 'Alma voraz', 200, 'Bastet lanza un hechizo que restaura algo de su salud'),
(3, 3, 'Espadazo', 70, 'Gerald empuña su espada y corta al enemigo', 100, 'Doble espadazo', 200, 'Gerald empuña sus dos espadas para realizar un combo de cortes', 75, 'Modo berserker', 75, 'Gerald enfurece y recibe un aumento de daño');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ataques_enemigos`
--

CREATE TABLE `ataques_enemigos` (
  `id` int(11) NOT NULL,
  `id_ataques_enemigos` int(11) DEFAULT NULL,
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

INSERT INTO `ataques_enemigos` (`id`, `id_ataques_enemigos`, `nombreBasico`, `danoBasico`, `descripcionBasico`, `nombreFuerte`, `danoFuerte`, `descripcionFuerte`, `nombreHabilidad`, `datosHabilidad`, `descripcionHabilidad`) VALUES
(1, 1, 'Mirada punzante', 20, 'El cactus te mira fijamente y sientes como se te pinchara con todas sus espinas', 'Lanzamiento de espinas', 40, 'El cactus se hincha y dispara muchas espinas', 'Explosión floral', 60, 'Del cactus crece una flor que esparce una nube de veneno'),
(2, 2, 'Lanzamiento de hueso', 30, 'Cambises se arranca una costilla para lanzartela', 'Espadazo', 60, 'Cambises empuña su espada rota para hacer un corte', 'Danza de muerto', 1, 'Cambises la Momia invoca a los muert-\r\nERROR class_terreno:~random'),
(3, 3, 'Puñetazo de magma', 35, 'El Golem alza su puño de rocas ardientes y lo deja caer sobre ti', 'Llamarada', 70, 'Los ojos del Golem se encienden y de ellos salen unas potentes llamas', 'Invocación de llamas', 1, 'El Golem alza sus brazos y del suelo empiezan a surgi-\r\nERROR class_terreno:~random'),
(4, 4, 'Ramazo', 40, 'El Ent estrira las ramas de su brazo para apuñalarte', 'Martillo de madera', 80, 'El Ent forma un martillo gigante con sus brazos para aplastarte', 'Florecer de verano', 1, 'De las ramas del Ent empiezan a brotar hoj-\r\nERROR class_terreno:~random'),
(5, 5, 'Salpicar', 45, 'Salomón el Salmón Gigante le pega con la cola a la superficie del río para lanzar una gran ola de agua', 'Hidrocañón', 90, 'Salomón el Salmón Gigante acumula agua en su boca para luego lanzarla con muchísima presión', 'Salto de montañas', 2, 'Salomón el Salmón Gigante salta hacia el ciel- \r\nERROR class_terreno:~random\r\nERROR class_clima:~random'),
(6, 6, 'Bola de fuego infernal', 50, 'Tahorki conjura un hechizo para lanzar una bola de fuego negro', 'Luvia de rayos', 100, 'Tahorki conjura un hechizo que nubla el cielo, y de las nubes empiezan a caer rayos', 'Invocación de muertos', 2, 'Tahorki empieza a conjurar un hechizo, del suelo empiezan a sur- \r\nERROR class_terreno:~random\r\nERROR class_clima:~random'),
(7, 7, 'class_ataqueBasico:notfound', 100, 'Del extraño ser, salen una ráfaga de cubos disparados', 'class_ataqueFuerte:notfound', 200, 'Del extraño ser salen disparados cubos al cielo que empiezan a formar un cubo gigante que deja caer encima tuyo', 'class_habilidad:notfound', 3, 'ERROR class_terreno:~random\r\nERROR class_clima:~random\r\nERROR class_hora~random');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `batallas`
--

CREATE TABLE `batallas` (
  `id` int(11) NOT NULL,
  `id_batallas` int(11) DEFAULT NULL,
  `nombreBatalla` varchar(100) DEFAULT NULL,
  `id_enemigos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `batallas`
--

INSERT INTO `batallas` (`id`, `id_batallas`, `nombreBatalla`, `id_enemigos`) VALUES
(1, 1, 'Batalla contra el amenazante Cactus Amarillo', 1),
(2, 2, 'Batalla en la entrada de la Pirámide', 2),
(3, 3, 'Batalla contra el Golem de Magma', 3),
(4, 4, 'Batalla contra el Ent', 4),
(5, 5, 'Batalla contra Salomón el Salmón Gigante', 5),
(6, 6, 'Batalla contra El Aprendiz Tahorki', 6),
(7, 7, 'Batalla Final', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `climas`
--

CREATE TABLE `climas` (
  `id` int(11) NOT NULL,
  `id_climas` int(11) DEFAULT NULL,
  `nombreClima` varchar(100) DEFAULT NULL,
  `buff` int(11) DEFAULT NULL,
  `descripcionBuff` text DEFAULT NULL,
  `penalizacion` int(11) DEFAULT NULL,
  `descripcionPenalizacion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `climas`
--

INSERT INTO `climas` (`id`, `id_climas`, `nombreClima`, `buff`, `descripcionBuff`, `penalizacion`, `descripcionPenalizacion`) VALUES
(1, 1, 'Nublado', 10, '+precision', 0, NULL),
(2, 2, 'Despejado', 20, '+precision', 0, NULL),
(3, 3, 'Calor extremo', 0, NULL, 30, '-precision'),
(4, 4, 'Tormenta de nieve', 0, NULL, 20, '-defensa'),
(5, 5, 'Tormenta de arena', 0, NULL, 25, '-precision'),
(6, 6, 'i0_io_0rr0r', 0, 'class~#descriptionBuff:notfound', 0, 'class~#descriptionDeBuff:notfound');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enemigos`
--

CREATE TABLE `enemigos` (
  `id` int(11) NOT NULL,
  `id_enemigos` int(11) DEFAULT NULL,
  `nombreEnemigo` varchar(100) DEFAULT NULL,
  `especie` varchar(100) DEFAULT NULL,
  `vida` int(11) DEFAULT NULL,
  `id_ataques_enemigos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `enemigos`
--

INSERT INTO `enemigos` (`id`, `id_enemigos`, `nombreEnemigo`, `especie`, `vida`, `id_ataques_enemigos`) VALUES
(1, 1, 'Cactus Amarillo', 'Planta', 250, 1),
(2, 2, 'Cambises la Momia', 'Humano muerto', 500, 2),
(3, 3, 'Golem de magma', 'Rocas calientes', 750, 3),
(4, 4, 'Ent', 'Planta', 1000, 4),
(5, 5, 'Salomón el salmón gigante', 'Pez', 1500, 5),
(6, 6, 'Aprendiz Tahorki', 'Humano', 2000, 6),
(7, 7, 'class_jefeFinal:notfound', '???', 4000, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escenarios`
--

CREATE TABLE `escenarios` (
  `id` int(11) NOT NULL,
  `id_escenarios` int(11) DEFAULT NULL,
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

INSERT INTO `escenarios` (`id`, `id_escenarios`, `nombreEscenario`, `id_batallas`, `id_puzzles`, `id_terrenos`, `id_climas`, `id_horas_del_dia`, `id_npc`) VALUES
(1, 1, 'Desierto', 1, NULL, 3, 2, 1, 1),
(2, 2, 'Entrada a la Pirámide', 2, 1, 3, 2, 1, 1),
(3, 3, 'Pasillo oscuro', NULL, 2, 3, 1, 1, 1),
(4, 4, 'Sala Roja', 3, NULL, 5, 3, 2, 1),
(5, 5, 'Sala Verde', 4, 3, 1, 1, 2, 1),
(6, 6, 'Sala Blanca', NULL, 4, 6, 6, 3, 2),
(7, 7, 'Sala Azul', 5, NULL, 4, 4, 3, 1),
(8, 8, 'Sala Morada', 6, NULL, 2, 5, 4, 1),
(9, 9, 'Templo de Ammit', NULL, 5, 1, 2, 4, 3),
(10, 10, 'class_escenario:notfound', 7, NULL, 6, 6, 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horas_del_dia`
--

CREATE TABLE `horas_del_dia` (
  `id` int(11) NOT NULL,
  `id_horas_del_dia` int(11) DEFAULT NULL,
  `nombreHora` varchar(50) DEFAULT NULL,
  `buff` int(11) DEFAULT NULL,
  `descripcionBuff` text DEFAULT NULL,
  `penalizacion` int(11) DEFAULT NULL,
  `descripcionPenalizacion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `horas_del_dia`
--

INSERT INTO `horas_del_dia` (`id`, `id_horas_del_dia`, `nombreHora`, `buff`, `descripcionBuff`, `penalizacion`, `descripcionPenalizacion`) VALUES
(1, 1, 'Mañana', 20, '+ataque', 0, NULL),
(2, 2, 'Mediodía', 10, '+ataque', 0, NULL),
(3, 3, 'Tarde', 0, NULL, 5, '-ataque'),
(4, 4, 'Noche', 0, NULL, 10, '-ataque'),
(5, 5, 'crypt_id404', 0, 'class~#descriptionBuff:notfound', 0, 'class~#descriptionDeBuff:notfound');

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

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`id`, `nombreJugador`, `contrasena`, `puntos`) VALUES
(1, 'admin', 'admin', 0);

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
  `frase_4` text DEFAULT NULL,
  `ayuda_1` int(11) DEFAULT NULL,
  `ayuda_2` int(11) DEFAULT NULL,
  `ayuda_3` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `npc`
--

INSERT INTO `npc` (`id_npc`, `nombreNPC`, `especie`, `frase_1`, `frase_2`, `frase_3`, `frase_4`, `ayuda_1`, `ayuda_2`, `ayuda_3`) VALUES
(1, 'Obi', 'Humano', 'I have a bad feeling about this', 'Hello there!', 'Its over, I have the highground!', NULL, 35, 75, 150),
(2, 'Carlos el Fantasma', 'Fantasma', 'Has perdido estrepitosamente, alguien como tú, no es digno de llamarse guerrero', 'Casi me ganas, pero no has sido lo suficientemente bueno, no obstante has demostrado tu valor y te concederé una pequeña bendición, con ella te sentirás más vivo', '¡Bien hecho! ¡Por fin he conocido un guerrero digno! Ahora te daré mi bendición y te sentirás más vivo que nunca', NULL, 200, 750, 1500),
(3, 'Ammet', 'Dios', 'No consigues liberar a Ammit y ves cómo mata a Obi, después Ammit se dirige hacia ti y acaba contigo', 'No consigues liberar a Ammit y ves cómo mata a Obi, después Ammit se dirige hacia ti, pero gracias a que el hechizo está casi roto, Ammit recupera el control, hace aparecer una puerta y te dice: Rápido pasa por esta puerta y enfréntate al ser que me controla, así me salvarás a mí y a toda Eazima.', 'Consigues deshacer el hechizo, pero la diosa se queda sin fuerza y cae al suelo, con la poca fuerza que le queda, os cura y hace aparecer una puerta negra y dice: Cuando paseis por esta puerta, os encontrareis en la sala donde se encuentra el extraño ser, derrotarlo volverá a traer la paz a Eazima.', 'Consigues liberar a Ammit del hechizo.\\n” ”Gracias guerrero “ + nombrePersonaje “. He intentado adentrarme en el portal para recoger información de esa dimensión, pero he caído en una trampa que me ha hecho perder el control, pero gracias a ti el viaje no ha sido en vano, he descubierto la debilidad del extraño ser. Con esta bendición seréis capaces de acabar con él sin ningún problema.\\n \"\"La diosa hace aparecer una puerta negra y dice: Cuando paseis por esta puerta, os encontrareis en la sala donde se encuentra el extraño ser, derrotarlo volverá a traer la paz a Eazima.', 9999, 500, 9999);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personajes`
--

CREATE TABLE `personajes` (
  `id` int(11) NOT NULL,
  `id_personajes` int(11) DEFAULT NULL,
  `nombrePersonaje` varchar(100) DEFAULT NULL,
  `vida` int(11) DEFAULT NULL,
  `Muerte_antes_de_Boss` text DEFAULT NULL,
  `Muerte_Ammit` text DEFAULT NULL,
  `Muerte_Boss` text DEFAULT NULL,
  `Victoria_Boss` text DEFAULT NULL,
  `Bendicion_Ammit` text DEFAULT NULL,
  `id_ataques` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personajes`
--

INSERT INTO `personajes` (`id`, `id_personajes`, `nombrePersonaje`, `vida`, `Muerte_antes_de_Boss`, `Muerte_Ammit`, `Muerte_Boss`, `Victoria_Boss`, `Bendicion_Ammit`, `id_ataques`) VALUES
(1, 1, 'Ánuket', 1050, 'enemigo + \" Te da el golpe de gracia y acaba contigo. Contigo derrotado no queda tiempo para que nadie pueda salvar Eazima.\\n—FIN DEL JUEGO—', 'No consigues liberar a Ammit y ves cómo mata a Obi, después Ammit se dirige hacia ti y acaba contigo.\\n—FIN DEL JUEGO—', 'El extraño ser acaba contigo y pronto conseguirá salir de la Pirámide y acabará con toda Eazima.\\n—FIN DEL JUEGO—', 'Con ese ataque, consigues acabar con el ser y la sala empieza a desaparecer poco a poco y cuando desaparece completamente, ves que toda la pirámide y el portal han desaparecido también, has conseguido acabar con el mal que amenazaba a Eazima.\\n —FIN DEL JUEGO—', 'Gracias a la bendición de Ammit lanzas un ataque que acaba con el ser de un golpe.\\nLa sala empieza a desaparecer poco a poco y cuando desaparece completamente, ves que toda la pirámide y el portal han desaparecido también, has conseguido acabar con el mal que amenazaba a Eazima.\\n —FIN DEL JUEGO—', 1),
(2, 2, 'Bastet', 900, 'enemigo + \" Te da el golpe de gracia y acaba contigo. Contigo derrotado no queda tiempo para que nadie pueda salvar Eazima.\\n—FIN DEL JUEGO—', 'No consigues liberar a Ammit y ves cómo mata a Obi, después Ammit se dirige hacia ti y acaba contigo.\\n—FIN DEL JUEGO—', 'El extraño ser acaba contigo y pronto conseguirá salir de la Pirámide y acabará con toda Eazima.\\n—FIN DEL JUEGO—', 'Con ese ataque, consigues acabar con el ser y la sala empieza a desaparecer poco a poco y cuando desaparece completamente, ves que toda la pirámide y el portal han desaparecido también, has conseguido acabar con el mal que amenazaba a Eazima.\\n —FIN DEL JUEGO—', 'Gracias a la bendición de Ammit lanzas un ataque que acaba con el ser de un golpe.\\nLa sala empieza a desaparecer poco a poco y cuando desaparece completamente, ves que toda la pirámide y el portal han desaparecido también, has conseguido acabar con el mal que amenazaba a Eazima.\\n —FIN DEL JUEGO—', 2),
(3, 3, 'Gerald', 1200, 'enemigo + \" Te da el golpe de gracia y acaba contigo. Contigo derrotado no queda tiempo para que nadie pueda salvar Eazima.\\n—FIN DEL JUEGO—', 'No consigues liberar a Ammit y ves cómo mata a Obi, después Ammit se dirige hacia ti y acaba contigo.\\n—FIN DEL JUEGO—', 'El extraño ser acaba contigo y pronto conseguirá salir de la Pirámide y acabará con toda Eazima.\\n—FIN DEL JUEGO—', 'Con ese ataque, consigues acabar con el ser y la sala empieza a desaparecer poco a poco y cuando desaparece completamente, ves que toda la pirámide y el portal han desaparecido también, has conseguido acabar con el mal que amenazaba a Eazima.\\n —FIN DEL JUEGO—', 'Gracias a la bendición de Ammit lanzas un ataque que acaba con el ser de un golpe.\\nLa sala empieza a desaparecer poco a poco y cuando desaparece completamente, ves que toda la pirámide y el portal han desaparecido también, has conseguido acabar con el mal que amenazaba a Eazima.\\n —FIN DEL JUEGO—', 3);

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
(2, 'Puzzle2', 'Acertijo Esfinge', 15),
(3, 'Puzzle3', 'Ahorcado', 20),
(4, 'Puzzle4', 'Piedra papel o tijeras', 25),
(5, 'Puzzle5', 'Trivial Egipto', 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `terrenos`
--

CREATE TABLE `terrenos` (
  `id` int(11) NOT NULL,
  `id_terrenos` int(11) DEFAULT NULL,
  `nombreTerreno` varchar(100) DEFAULT NULL,
  `buff` int(11) DEFAULT NULL,
  `descripcionBuff` text DEFAULT NULL,
  `penalizacion` int(11) DEFAULT NULL,
  `descripcionPenalizacion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `terrenos`
--

INSERT INTO `terrenos` (`id`, `id_terrenos`, `nombreTerreno`, `buff`, `descripcionBuff`, `penalizacion`, `descripcionPenalizacion`) VALUES
(1, 1, 'Suelo de hierba', 20, '+vida', 0, NULL),
(2, 2, 'Suelo de cristales mágicos', 10, '+vida', 0, NULL),
(3, 3, 'Suelo arenoso', 0, NULL, 5, '-vida'),
(4, 4, 'Suelo de hielo', 0, NULL, 10, '-vida'),
(5, 5, 'Suelo de magma', 0, NULL, 15, '-vida'),
(6, 6, 'VOID999x_dump', 0, 'class~#descriptionBuff:notfound', 0, 'class~#descriptionDeBuff:notfound');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ataques`
--
ALTER TABLE `ataques`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ataques_enemigos`
--
ALTER TABLE `ataques_enemigos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `batallas`
--
ALTER TABLE `batallas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_enemigos` (`id_enemigos`);

--
-- Indices de la tabla `climas`
--
ALTER TABLE `climas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `enemigos`
--
ALTER TABLE `enemigos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ataques_enemigos` (`id_ataques_enemigos`);

--
-- Indices de la tabla `escenarios`
--
ALTER TABLE `escenarios`
  ADD PRIMARY KEY (`id`),
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
  ADD PRIMARY KEY (`id`);

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
  ADD PRIMARY KEY (`id`),
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
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ataques`
--
ALTER TABLE `ataques`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ataques_enemigos`
--
ALTER TABLE `ataques_enemigos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `batallas`
--
ALTER TABLE `batallas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `climas`
--
ALTER TABLE `climas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `enemigos`
--
ALTER TABLE `enemigos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `escenarios`
--
ALTER TABLE `escenarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `horas_del_dia`
--
ALTER TABLE `horas_del_dia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `npc`
--
ALTER TABLE `npc`
  MODIFY `id_npc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `personajes`
--
ALTER TABLE `personajes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `puzzles`
--
ALTER TABLE `puzzles`
  MODIFY `id_puzzles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `terrenos`
--
ALTER TABLE `terrenos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `batallas`
--
ALTER TABLE `batallas`
  ADD CONSTRAINT `batallas_ibfk_1` FOREIGN KEY (`id_enemigos`) REFERENCES `enemigos` (`id`);

--
-- Filtros para la tabla `enemigos`
--
ALTER TABLE `enemigos`
  ADD CONSTRAINT `enemigos_ibfk_1` FOREIGN KEY (`id_ataques_enemigos`) REFERENCES `ataques_enemigos` (`id`);

--
-- Filtros para la tabla `escenarios`
--
ALTER TABLE `escenarios`
  ADD CONSTRAINT `escenarios_ibfk_1` FOREIGN KEY (`id_batallas`) REFERENCES `batallas` (`id`),
  ADD CONSTRAINT `escenarios_ibfk_2` FOREIGN KEY (`id_puzzles`) REFERENCES `puzzles` (`id_puzzles`),
  ADD CONSTRAINT `escenarios_ibfk_3` FOREIGN KEY (`id_terrenos`) REFERENCES `terrenos` (`id`),
  ADD CONSTRAINT `escenarios_ibfk_4` FOREIGN KEY (`id_climas`) REFERENCES `climas` (`id`),
  ADD CONSTRAINT `escenarios_ibfk_5` FOREIGN KEY (`id_horas_del_dia`) REFERENCES `horas_del_dia` (`id`),
  ADD CONSTRAINT `escenarios_ibfk_6` FOREIGN KEY (`id_npc`) REFERENCES `npc` (`id_npc`);

--
-- Filtros para la tabla `personajes`
--
ALTER TABLE `personajes`
  ADD CONSTRAINT `personajes_ibfk_1` FOREIGN KEY (`id_ataques`) REFERENCES `ataques` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
