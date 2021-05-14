INSERT INTO customer
VALUE
(1,"Minh Quan",10),
(2,"Ngoc Oanh",10),
(3,"Hong Ha",50);

INSERT INTO `order`
VALUE 
(1,1,'2006/03/21',''),
(2,2,'2006/03/23',''),
(3,1,'2006/03/16','');

INSERT INTO product
VALUE
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

INSERT INTO order_detail
VALUE
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

SELECT O.order_id, O.order_date, P.product_price
FROM `order` O
JOIN order_detail OD
ON O.order_id = OD.order_id 
JOIN product P 
ON OD.product_id = P.product_id;

SELECT C.customer_name, P.product_name
FROM customer C 
JOIN `order` O
ON C.customer_id = O.customer_id
JOIN order_detail OD
ON O.order_id = OD.order_id
JOIN product P 
ON OD.product_id = P.product_id;

SELECT C.customer_name AS customer_didnt_buy_anything
FROM customer C
LEFT JOIN `order` O 
ON C.customer_id = O.customer_id
WHERE O.customer_id is null;


SELECT O.order_id, O.order_date, sum(OD.order_quantity*P.product_price) AS order_total_price
FROM `order`O
JOIN order_detail OD
ON O.order_id = OD.order_id
JOIN product P 
ON OD.product_id = P.product_id
GROUP BY O.order_id;




 