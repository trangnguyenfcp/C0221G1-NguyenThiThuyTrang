-- TASK 6 
select S.service_id, S.service_name, S.service_area, S.service_cost, ST.service_type_name, Con.contract_start_date
from service S join service_type ST on S.service_type_id = ST.service_type_id
join contract Con on Con.service_id = S.service_id
where month(Con.contract_start_date) in (1,2,3);
-- TASK 7 
select S.service_id, S.service_name, S.service_area, S.service_max_people, S.service_cost, ST.service_type_name, Con.contract_start_date
from service S join service_type ST on S.service_type_id = ST.service_type_id
join contract Con on Con.service_id = S.service_id
where (year(Con.contract_start_date) = 2018) and (ST.service_type_id not in 
(select ST.service_type_id
from service S join service_type ST on S.service_type_id = ST.service_type_id
join contract Con on Con.service_id = S.service_id 
where year(Con.contract_start_date) = 2019));
-- TASK 8 - 1
select customer.customer_name from customer
group by customer_name;
-- TASK 8 - 2
select distinct customer_name from customer;
-- TASK 8 - 3
select customer_name from customer where customer_name  not in
(select customer_name from customer
group by customer_name 
having count(customer_name) > 1);
-- TASK 9
select month(Con.contract_start_date), count(contract_id) from contract Con
where year(Con.contract_start_date) = 2019
group by month(Con.contract_start_date);



