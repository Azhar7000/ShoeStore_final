CREATE TABLE product (
                         product_id INT NOT NULL PRIMARY KEY,
                         product_name VARCHAR(255) NOT NULL,
                         product_description VARCHAR(500),
                         product_color VARCHAR(50),
                         product_size INT,
                         product_price DOUBLE
);
