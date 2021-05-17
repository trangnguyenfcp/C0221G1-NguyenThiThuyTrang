select Con.contract_id, count(CD.attach_service_id)
from contract Con join contract_detail CD 
where Con.contract_id = CD.contract_id
group by contract_id;

select  C.customer_id,C.customer_name, CT.customer_type_name, Att.attach_service_name
from customer C join customer_type CT on C.customer_type_id = CT.customer_type_id
join contract Con on C.customer_id = Con.customer_id
join contract_detail CD on Con.contract_id = CD.contract_id
join attach_service Att on Att.attach_service_id =  CD.attach_service_id
where (CT.customer_type_name = 'Diamond') and (C.customer_address in ('Vinh', 'Quang Ngai'))
group by C.customer_id, Att.attach_service_id;

select Con.contract_id, Con.employee_id, C.customer_name, C.customer_phone, S.service_name, count(CD.attach_service_id), Con.contract_deposit
from contract Con join customer C on C.customer_id = Con.customer_id
join service S on Con.service_id = S.service_id
join contract_detail CD on Con.contract_id = CD.contract_id
where (Con.contract_start_date between '2019/10/01' and '2019/12/31') and Con.service_id not in (
select Con.service_id
from contract Con 
join service S on Con.service_id = S.service_id
where Con.contract_start_date between '2019/01/01' and '2019/06/30')
group by C.customer_id, CD.attach_service_id;
