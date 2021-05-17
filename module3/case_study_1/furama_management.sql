
create database furama_management;
create table `position`(
position_id int primary key,
position_name varchar(45)
);
create table education_degree(
education_degree_id int primary key,
education_degree_name varchar(45)
);
create table division(
division_id int primary key,
division_name varchar(45)
);


CREATE TABLE employee(
employee_id INT PRIMARY KEY,
employee_name VARCHAR(45),
position_id INT,
education_degree_id INT,
division_id INT,
employee_birthday DATE,
employee_id_card VARCHAR(45),
employee_salary VARCHAR(45),
employee_phone VARCHAR(45),
employee_email VARCHAR(45),
employee_address VARCHAR(45),
FOREIGN KEY(position_id) REFERENCES `position`(position_id),
FOREIGN KEY(education_degree_id) REFERENCES education_degree(education_degree_id),
FOREIGN KEY(division_id) REFERENCES division(division_id)
);
CREATE TABLE customer_type(
customer_type_id INT PRIMARY KEY,
customer_type_name VARCHAR(45)
);
CREATE TABLE customer(
customer_id INT PRIMARY KEY,
customer_type_id INT,
customer_name VARCHAR(45),
customer_birthday DATE,
customer_id_card VARCHAR(45),
customer_phone VARCHAR(45),
customer_email VARCHAR(45),
customer_address VARCHAR(45),
FOREIGN KEY(customer_type_id) REFERENCES customer_type(customer_type_id)
);
CREATE TABLE service_type(
service_type_id INT PRIMARY KEY,
service_type_name VARCHAR(45)
);
CREATE TABLE rent_type(
rent_type_id INT PRIMARY KEY,
rent_type_name VARCHAR(45),
rent_type_cost DOUBLE
);

CREATE TABLE service(
service_id INT PRIMARY KEY,
service_name VARCHAR(45),
service_area INT,
service_cost DOUBLE,
number_of_floors INT,
service_max_people INT,
service_type_id INT,
rent_type_id INT,
`status` VARCHAR(45),
FOREIGN KEY(rent_type_id) REFERENCES rent_type(rent_type_id),
FOREIGN KEY(service_type_id) REFERENCES service_type(service_type_id)

);

CREATE TABLE attach_service(
attach_service_id INT PRIMARY KEY,
attach_service_name VARCHAR(45),
attach_service_cost INT,
attach_service_unit INT,
attach_service_status VARCHAR(45)
);
CREATE TABLE contract(
contract_id INT PRIMARY KEY,
employee_id INT,
customer_id INT,
service_id INT,
contract_start_date DATETIME,
contract_end_date DATETIME,
contract_deposit INT,
contract_total_money INT,
FOREIGN KEY(employee_id) REFERENCES employee(employee_id),
FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
FOREIGN KEY(service_id) REFERENCES service(service_id)

);
CREATE TABLE contract_detail(
contract_detail_id INT PRIMARY KEY,
contract_id INT,
attach_service_id INT,
quantity INT,
FOREIGN KEY(contract_id) REFERENCES contract(contract_id),
FOREIGN KEY(attach_service_id) REFERENCES attach_service(attach_service_id)
);

