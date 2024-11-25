-- Insert sample users
INSERT INTO users (user_id, username, password, email, phone_number, full_name, is_active, role_id)
VALUES
('U001', 'john_doe', 'password123', 'john.doe@example.com', '1234567890', 'John Doe', true, 'R001'),
('U002', 'jane_smith', 'password456', 'jane.smith@example.com', '0987654321', 'Jane Smith', true, 'R002'),
('U003', 'alice_wonder', 'alice123', 'alice.wonder@example.com', '1112223334', 'Alice Wonder', true, 'R003'),
('U004', 'bob_builder', 'builder123', 'bob.builder@example.com', '5556667778', 'Bob Builder', true, 'R001'),
('U005', 'emma_brown', 'emma123', 'emma.brown@example.com', '1231231234', 'Emma Brown', true, 'R002'),
('U006', 'liam_jones', 'liam456', 'liam.jones@example.com', '5551112223', 'Liam Jones', true, 'R003'),
('U007', 'olivia_davis', 'olivia789', 'olivia.davis@example.com', '4443332221', 'Olivia Davis', true, 'R001'),
('U008', 'noah_wilson', 'noah000', 'noah.wilson@example.com', '6665554443', 'Noah Wilson', true, 'R002'),
('U009', 'ava_clark', 'ava111', 'ava.clark@example.com', '7778889990', 'Ava Clark', true, 'R003'),
('U010', 'sophia_taylor', 'sophia222', 'sophia.taylor@example.com', '9990001112', 'Sophia Taylor', true, 'R001');

-- Insert sample products
INSERT INTO products (product_id, name, description, price, quantity)
VALUES
(1, 'Laptop Pro', 'A high-end laptop with powerful specs.', 1500.00, 10),
(2, 'Smartphone X', 'Latest smartphone with advanced features.', 800.00, 25),
(3, 'Wireless Headphones', 'Noise-canceling over-ear headphones.', 200.00, 50),
(4, 'Gaming Mouse', 'Ergonomic mouse with customizable buttons.', 50.00, 75),
(5, '4K Monitor', 'Ultra HD monitor for professionals.', 300.00, 20),
(6, 'Mechanical Keyboard', 'Backlit keyboard with tactile switches.', 120.00, 40),
(7, 'External SSD', 'Portable solid-state drive with 1TB capacity.', 150.00, 30),
(8, 'Bluetooth Speaker', 'Compact speaker with powerful sound.', 90.00, 60),
(9, 'Fitness Tracker', 'Wearable device with health monitoring.', 70.00, 100),
(10, 'Drone Camera', 'High-performance drone with 4K recording.', 500.00, 15);

-- Insert sample orders
INSERT INTO orders (order_id, user_id, total_amount, order_date, status)
VALUES
(1, 'U001', 1200, '2024-11-01 10:30:00', 'PENDING'),
(2, 'U002', 800, '2024-11-02 11:00:00', 'SHIPPED'),
(3, 'U003', 1500, '2024-11-03 14:45:00', 'DELIVERED'),
(4, 'U004', 500, '2024-11-04 16:20:00', 'PENDING'),
(5, 'U005', 900, '2024-11-05 09:15:00', 'CANCELLED'),
(6, 'U006', 1100, '2024-11-06 12:00:00', 'PENDING'),
(7, 'U007', 1350, '2024-11-07 13:30:00', 'SHIPPED'),
(8, 'U008', 2000, '2024-11-08 15:50:00', 'DELIVERED'),
(9, 'U009', 800, '2024-11-09 17:40:00', 'PENDING'),
(10, 'U010', 1200, '2024-11-10 18:10:00', 'CANCELLED');

-- Insert sample order items
INSERT INTO order_items (order_item_id, product_id, quantity, price, order_id)
VALUES
(1, 1, 2, 600, 1),
(2, 2, 1, 200, 1),
(3, 3, 3, 500, 2),
(4, 1, 1, 150, 3),
(5, 4, 2, 250, 4),
(6, 5, 5, 100, 5),
(7, 6, 1, 150, 6),
(8, 2, 4, 300, 7),
(9, 3, 2, 450, 8),
(10, 4, 3, 200, 9);

