CREATE TABLE users (
    user_id VARCHAR(36) PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(255),
    email VARCHAR(100),
    phone_number VARCHAR(15),
    full_name VARCHAR(100),
    is_active BOOLEAN,
    role_id VARCHAR(36)
);

CREATE TABLE products (
    product_id INT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    price DOUBLE PRECISION,
    quantity INT
);

CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    user_id VARCHAR(36),
    total_amount INT,
    order_date TIMESTAMP,
    status VARCHAR(20)
);

CREATE TABLE order_items (
    order_item_id INT PRIMARY KEY,
    product_id INT,
    quantity INT,
    price DOUBLE PRECISION,
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE
);

