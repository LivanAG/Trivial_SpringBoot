
use trivial;


-- Insertar preguntas
INSERT INTO pregunta (pregunta) VALUES ('¿Cuál es la capital de Francia?');      -- ID 1
INSERT INTO pregunta (pregunta) VALUES ('¿Cuánto es 2 + 2?');                    -- ID 2
INSERT INTO pregunta (pregunta) VALUES ('¿Qué color resulta de mezclar rojo y azul?'); -- ID 3
INSERT INTO pregunta (pregunta) VALUES ('¿Quién escribió Don Quijote?');         -- ID 4
INSERT INTO pregunta (pregunta) VALUES ('¿Cuál es el planeta más grande?');      -- ID 5

-- Insertar opciones para cada pregunta

-- Pregunta 1
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('París', true, 1);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Madrid', false, 1);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Londres', false, 1);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Roma', false, 1);

-- Pregunta 2
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('4', true, 2);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('3', false, 2);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('5', false, 2);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('22', false, 2);

-- Pregunta 3
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Violeta', true, 3);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Verde', false, 3);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Amarillo', false, 3);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Naranja', false, 3);

-- Pregunta 4
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Miguel de Cervantes', true, 4);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Gabriel García Márquez', false, 4);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Pablo Neruda', false, 4);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Jorge Luis Borges', false, 4);

-- Pregunta 5
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Júpiter', true, 5);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Tierra', false, 5);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Marte', false, 5);
INSERT INTO opcion (enunciado, es_correcta, id_pregunta) VALUES ('Saturno', false, 5);




-- Insertar 5 usuarios
INSERT INTO usuario (nombre, username, email, password, rol) VALUES
('Ana Pérez', 'ana', 'ana@email.com', '$2a$10$9kwcS1MD7f.t9kz8WkGLeeP3M7GMmuGLfvMAZDUcS7LXMeI/CuDji', 'USER'),
('Carlos López', 'carlos', 'carlos@email.com', '$2a$10$9kwcS1MD7f.t9kz8WkGLeeP3M7GMmuGLfvMAZDUcS7LXMeI/CuDji', 'USER'),
('Laura Díaz', 'laura', 'laura@email.com', '$2a$10$9kwcS1MD7f.t9kz8WkGLeeP3M7GMmuGLfvMAZDUcS7LXMeI/CuDji', 'USER'),
('Marcos Ruiz', 'marcos', 'marcos@email.com', '$2a$10$9kwcS1MD7f.t9kz8WkGLeeP3M7GMmuGLfvMAZDUcS7LXMeI/CuDji', 'USER'),
('Elena Gómez', 'elena', 'elena@email.com', '$2a$10$9kwcS1MD7f.t9kz8WkGLeeP3M7GMmuGLfvMAZDUcS7LXMeI/CuDji', 'USER');

-- Insertar 20 partidas con puntuaciones aleatorias entre 1 y 5
-- Asumiendo que los IDs de usuario van del 1 al 5

INSERT INTO partida (puntuacion, jugador) VALUES (3, 1);
INSERT INTO partida (puntuacion, jugador) VALUES (5, 1);
INSERT INTO partida (puntuacion, jugador) VALUES (2, 1);
INSERT INTO partida (puntuacion, jugador) VALUES (4, 1);

INSERT INTO partida (puntuacion, jugador) VALUES (1, 2);
INSERT INTO partida (puntuacion, jugador) VALUES (5, 2);
INSERT INTO partida (puntuacion, jugador) VALUES (3, 2);
INSERT INTO partida (puntuacion, jugador) VALUES (2, 2);

INSERT INTO partida (puntuacion, jugador) VALUES (4, 3);
INSERT INTO partida (puntuacion, jugador) VALUES (5, 3);
INSERT INTO partida (puntuacion, jugador) VALUES (2, 3);
INSERT INTO partida (puntuacion, jugador) VALUES (1, 3);

INSERT INTO partida (puntuacion, jugador) VALUES (3, 4);
INSERT INTO partida (puntuacion, jugador) VALUES (4, 4);
INSERT INTO partida (puntuacion, jugador) VALUES (2, 4);
INSERT INTO partida (puntuacion, jugador) VALUES (5, 4);

INSERT INTO partida (puntuacion, jugador) VALUES (1, 5);
INSERT INTO partida (puntuacion, jugador) VALUES (2, 5);
INSERT INTO partida (puntuacion, jugador) VALUES (3, 5);
INSERT INTO partida (puntuacion, jugador) VALUES (5, 5);



