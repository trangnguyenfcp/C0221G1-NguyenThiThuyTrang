-- TASK 16
delete from employee
where employee_id not in (
select employee_id from contract
where year(contract_start_date) between 2017 and 2019
);

-- TASK 17
update customer 
set customer_type_id = '4'
where customer_type_id = '3' and customer_id in (select B.A from
(select C.customer_id as A
from customer C left join customer_type CT on C.customer_type_id = CT.customer_type_id
left join contract Con on C.customer_id = Con.customer_id
left join service S on S.service_id = Con.service_id
left join contract_detail CD on Con.contract_id = CD.contract_id
left join attach_service ATT on ATT.attach_service_id = CD.attach_service_id
group by C.customer_id
having sum(S.service_cost+ATT.attach_service_cost*CD.quantity) > 10000000) as B);

-- TASK 18
alter table contract
drop foreign key customer;
alter table contract_detail
drop foreign key contract_detail_ibfk_1;

alter table contract 
add constraint customer_fk foreign key(customer_id) references customer(customer_id) on delete cascade;
alter table contract_detail 
add constraint customer_fk2 foreign key(contract_id) references contract(contract_id) on delete cascade;

delete from customer
where customer_id in (
select customer_id from contract
where year(contract_start_date) < 2016); 