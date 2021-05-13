
CREATE TABLE customer(
customer_id INT PRIMARY KEY,
customer_name VARCHAR(45),
customer_age INT
);
CREATE TABLE product(
product_id INT PRIMARY KEY,
product_name VARCHAR(45),
product_price VARCHAR(45)
);
CREATE TABLE `order`(
order_id INT PRIMARY KEY,
customer_id INT,
order_date DATETIME,
order_total_price VARCHAR(45),
FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);
CREATE TABLE order_detail(
order_id INT,
product_id INT,
order_quantity VARCHAR(45),
FOREIGN KEY(product_id) REFERENCES product(product_id),
FOREIGN KEY(order_id) REFERENCES `order`(order_id),
CONSTRAINT pk_order_detail PRIMARY KEY(product_id,order_id)
);