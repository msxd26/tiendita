-- Insertar un usuario
INSERT INTO usuarios (nombre, email, password)
VALUES ('Juan Pérez', 'juan@example.com', 'password123');

-- Insertar un producto
INSERT INTO productos (nombre, descripcion, precio, stock) VALUES
                                                               ('Laptop HP', 'Laptop de 15 pulgadas con 8GB de RAM y 256GB SSD', 1200.00, 10),
                                                               ('Smartphone Samsung', 'Teléfono inteligente con pantalla AMOLED de 6.5 pulgadas', 800.00, 25),
                                                               ('Tablet Apple iPad', 'Tablet de 10.2 pulgadas con 128GB de almacenamiento', 500.00, 15),
                                                               ('Teclado mecánico', 'Teclado mecánico RGB con switches Cherry MX', 150.00, 30),
                                                               ('Monitor LG 27"', 'Monitor de 27 pulgadas con resolución 4K', 400.00, 20),
                                                               ('Impresora Epson', 'Impresora multifuncional con WiFi y escáner', 300.00, 12),
                                                               ('Auriculares Sony', 'Auriculares inalámbricos con cancelación de ruido', 250.00, 18),
                                                               ('Disco Duro Externo', 'Disco duro externo de 1TB USB 3.0', 80.00, 22),
                                                               ('Cámara Canon', 'Cámara réflex digital con lente 18-55mm', 700.00, 8),
                                                               ('Router WiFi', 'Router de doble banda con soporte para 300Mbps', 120.00, 14);

-- Crear un pedido
INSERT INTO pedidos (id_usuario, total)
VALUES (1, 47.97);

-- Agregar detalles del pedido
INSERT INTO detalle_pedidos (id_pedido, id_producto, cantidad, precio)
VALUES (1, 1, 3, 15.99);
