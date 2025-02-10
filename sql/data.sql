-- Insertar un usuario
INSERT INTO usuarios (nombre, email, password)
VALUES ('Juan Pérez', 'juan@example.com', 'password123');

-- Insertar un producto
INSERT INTO productos (nombre, descripcion, precio, stock)
VALUES ('Camiseta', 'Camiseta de algodón', 15.99, 100);

-- Crear un pedido
INSERT INTO pedidos (id_usuario, total)
VALUES (1, 47.97);

-- Agregar detalles del pedido
INSERT INTO detalle_pedidos (id_pedido, id_producto, cantidad, precio)
VALUES (1, 1, 3, 15.99);
