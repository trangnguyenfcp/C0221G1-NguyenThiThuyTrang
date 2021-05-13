CREATE TABLE received_note(
received_note_id INT PRIMARY KEY,
received_date DATETIME,
received_quantity VARCHAR(20),
received_unit_price VARCHAR(20)
);
create table delivery_note(
delivery_note_id int primary key,
delivery_date datetime,
delivery_quantity VARCHAR(20),
delivery_unit_price VARCHAR(20)
);

CREATE TABLE supplier(
supplier_id INT PRIMARY KEY,
supplier_name VARCHAR(45),
address VARCHAR(45),
SDT VARCHAR(45)
);
CREATE TABLE supplies(
supplies_id INT PRIMARY KEY,
supplies_name VARCHAR(45)
);
CREATE TABLE purchase_order(
purchase_order_id INT PRIMARY KEY,
order_date DATETIME,
supplier_id INT,
FOREIGN KEY(supplier_id) REFERENCES supplier(supplier_id)
);
create table delivery(
delivery_note_id INT,
supplies_id INT,
delivery_quantity INT,
delivery_unit_price INT,
FOREIGN KEY(supplies_id) REFERENCES supplies(supplies_id),
FOREIGN KEY(delivery_note_id) REFERENCES delivery_note(delivery_note_id),
CONSTRAINT pk_delivery PRIMARY KEY(delivery_note_id, supplies_id)
);
create table received(
received_note_id INT,
supplies_id int,
received_quantity VARCHAR(20),
received_unit_price VARCHAR(20),
FOREIGN KEY(supplies_id) REFERENCES supplies(supplies_id),
FOREIGN KEY(received_note_id) REFERENCES received_note(received_note_id),
CONSTRAINT pk_received PRIMARY KEY(received_note_id, supplies_id)
);
CREATE TABLE `order`(
supplies_id INT,
purchase_order_id INT,
FOREIGN KEY(supplies_id) REFERENCES supplies(supplies_id),
FOREIGN KEY(purchase_order_id) REFERENCES purchase_order(purchase_order_id),
CONSTRAINT pk_order PRIMARY KEY(supplies_id,purchase_order_id)
);

DROP TABLE `order`;

