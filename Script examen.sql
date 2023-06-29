create database test_examen;
use  test_examen;
/*DROP TABLE examen;
DROP TABLE respuestas_examen
DROP TABLE estudiante
DROP TABLE respuestas
DROP TABLE preguntas*/
CREATE TABLE examen (
    id_examen integer UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    ciudad VARCHAR(50) ,
    zona_horaria VARCHAR(150),
    fecha_realizacion datetime
);

CREATE TABLE preguntas (
	id_registro integer UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_pregunta integer ,
    pregunta VARCHAR(50),
    porcentaje smallint,
    respuesta_correcta tinyint,
    id_examen integer
);

CREATE TABLE respuestas (
    id_respuesta integer UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    respuesta VARCHAR(50),
    id_pregunta integer
);

CREATE TABLE estudiante (
    id_estudiante integer UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    edad smallint,
    ciudad VARCHAR(50) ,
    zona_horaria VARCHAR(150) 
);

CREATE TABLE respuestas_examen (
    id_registro integer UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_estudiante integer ,
    id_examen integer,
    id_pregunta integer,
    id_respuesta integer
);

