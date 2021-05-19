-- TASK 27 - A
delimiter //
create function func_1(total_money int)
returns int
deterministic 
begin
declare count int;
set count =  (
select count(A.count_service_type) as sum_count from
(select count(ST.service_type_id) as count_service_type
from customer C left join customer_type CT on C.customer_type_id = CT.customer_type_id
join contract Con on C.customer_id = Con.customer_id
join service S on S.service_id = Con.service_id
join contract_detail CD on Con.contract_id = CD.contract_id
join attach_service ATT on ATT.attach_service_id = CD.attach_service_id
join service_type ST on ST.service_type_id = S.service_type_id
group by ST.service_type_id
having sum(S.service_cost+ATT.attach_service_cost*CD.quantity) > total_money) as A);
return count;

end //
delimiter ;

select func_1(2000000);

-- TASK 27 - B
delimiter //
create function func_2(cus_id int)
returns int
deterministic
begin
declare max_time int;
set max_time = (select max(A.date_diff) from (select datediff(contract_end_date, contract_start_date) as date_diff from contract
where customer_id = cus_id) as A );
return max_time;
end //
delimiter ;

select func_2(3);

-- TASK 28
delimiter //
create procedure sp_3(in s_type_name varchar(45))
begin
alter table contract
drop foreign key contract_ibfk_3;

alter table contract 
add constraint contract_ibfk_3 foreign key(service_id) references service(service_id) on delete cascade;

delete from service
where (service_type_id in (
select service_type_id from service_type
where service_type_name = s_type_name)) and (service_id in (
select service_id from contract
where year(contract_start_date) between 2015 and 2019));
end //
delimiter ;

call sp_3('Villa');