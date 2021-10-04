DROP DATABASE IF EXISTS dbinventory;
CREATE DATABASE dbinventory;
USE dbinventory;

-- create tables
CREATE TABLE product(
    id INT AUTO_INCREMENT PRIMARY KEY,
    prodname VARCHAR(45) NOT NULL,
    price DECIMAL(6,2) NOT NULL,
    amount INT NOT NULL
);

-- DESC product;

INSERT INTO product(prodname, price, amount) VALUES
('mouse', 20.00, 0),
('teclado', 180.00, 0);

SELECT * FROM product;

-- CREATE TABLE tbinventory(
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     fk_product INT NOT NULL,
--     amount INT NOT NULL,
--     FOREIGN KEY (fk_product) REFERENCES product(id)
-- ); 

-- -- DESC tbinventory;

-- INSERT INTO tbinventory(fk_product, amount) VALUES 
-- (1, 10),
-- (1, 6);

-- SELECT * FROM tbinventory;