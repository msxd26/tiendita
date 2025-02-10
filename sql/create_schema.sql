CREATE DATABASE IF NOT EXISTS gestion_usuarios;
USE gestion_usuarios;

CREATE TABLE IF NOT EXISTS usuarios (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS productos (
                                         id INT AUTO_INCREMENT PRIMARY KEY,
                                         nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio FLOAT NOT NULL,
    stock INT NOT NULL
    );

CREATE TABLE IF NOT EXISTS pedidos (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       id_usuario INT,
                                       fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                       total FLOAT NOT NULL,
                                       FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
    );

CREATE TABLE IF NOT EXISTS detalle_pedidos (
                                               id INT AUTO_INCREMENT PRIMARY KEY,
                                               id_pedido INT,
                                               id_producto INT,
                                               cantidad INT NOT NULL,
                                               precio FLOAT NOT NULL,
                                               FOREIGN KEY (id_pedido) REFERENCES pedidos(id),
    FOREIGN KEY (id_producto) REFERENCES productos(id)
    );
