# Crear la base de datos
CREATE DATABASE Actividad3;

# Crear usuario
CREATE USER 'actividad3'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON Actividad3.* TO 'actividad3'@'localhost';
FLUSH PRIVILEGES;

CREATE DATABASE IF NOT EXISTS Actividad3;
USE Actividad3;

CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS asignaturas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_id VARCHAR(20) NOT NULL,
    nombre VARCHAR(100),
    nombre_completo VARCHAR(200),
    descripcion TEXT,
    area_conocimiento VARCHAR(100),
    carrera VARCHAR(100),
    numero_creditos INT,
    contenido_tematico TEXT,
    semestre INT,
    profesor VARCHAR(100),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES usuario(id) ON DELETE CASCADE
);