-- CREATE TABLE AND DATABASE
create database demo;
create table products(
id int primary key,
product_code varchar(45),
product_name varchar(45),
product_price int,
product_amount int,
product_description varchar(45),
product_status varchar(45));

-- INSERT VALUE
insert into products
value(1,'a1','iphone',100,5,'good','available');
insert into products
value(2,'s2','samsung',120,4,'not good','not available'),
(3,'ssdds2','samsung',120,4,'not good','not available'),
(4,'fa2','nokia',120,4,'not good','not available'),
(5,'s2d2','samsung',120,4,'not good','not available');

-- INDEX
explain select product_code from products where product_code = 'a1';
alter table products
add unique ind_product_code(product_code);

explain select product_name, product_price from products
where product_name = 'iphone' and product_price = 100;
alter table products
add index ind_name_price(product_name, product_price);

-- VIEW 
create view product_view as
select product_code, product_name, product_price, product_status from products;

create or replace view product_view as
select product_code, product_name, product_price, product_status from products
where product_name = 'iphone';

drop view product_view;

-- STORED PROCEDURE
delimiter //
create procedure find_all_products()
begin
select* from products;
end //
delimiter ;
call find_all_products;

delimiter //
create procedure insert_new_product
(in p_id int, in p_code varchar(45), in p_name varchar(45),in p_price int, in p_amount int, in p_des varchar(45), in p_status varchar(45))
begin
insert into products
value(p_id,p_code,p_name,p_price,p_amount,p_des,p_status);
end //
delimiter ;
call insert_new_product(7,'g1','Loli',200,2,'no','no');

delimiter //
create procedure update_product
(in p_id int, in p_code varchar(45), in p_name varchar(45),in p_price int, in p_amount int, in p_des varchar(45), in p_status varchar(45))
begin
update products
set product_code = p_code, product_name = p_name, product_price = p_price, product_amount = p_amount, product_description = p_des, product_status = p_status
where id = p_id;
end //
delimiter ;
call update_product(3,'p20','Chang Chang',1000,1,'no','no');

delimiter //
create procedure delete_product
(in pro_id int)
begin
delete from products
where id = pro_id;
end //
delimiter ;
call delete_product(3);