-- TASK 19
update attach_service Att
set attach_service_cost = attach_service_cost*2
where attach_service_id in (
	select CD.attach_service_id from contract_detail CD
	join contract Con on CD.contract_id = Con.contract_id
	where year(Con.contract_start_date) = 2019
	group by CD.attach_service_id
	having count(CD.attach_service_id)>10);


-- TASK 20
select customer_id as id, customer_name as `name`, customer_email as email, customer_phone as phone, customer_birthday as birthday, customer_address as address, 1 as `type`
from customer 
union all 
select employee_id, employee_name, employee_email, employee_phone, employee_birthday, employee_address, 0 as `type`
from employee;