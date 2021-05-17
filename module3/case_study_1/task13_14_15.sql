-- TASK 13 
select Att.attach_service_id, Att.attach_service_name, count(CD.attach_service_id)
from contract Con join contract_detail CD on Con.contract_id = CD.contract_id
join customer C on C.customer_id = Con.customer_id
join attach_service Att on Att.attach_service_id = CD.attach_service_id
group by CD.attach_service_id
having count(CD.attach_service_id)>= all(select count(CD.attach_service_id)
from contract Con join contract_detail CD on Con.contract_id = CD.contract_id
join customer C on C.customer_id = Con.customer_id
join attach_service Att on Att.attach_service_id = CD.attach_service_id
group by CD.attach_service_id);

-- TASK 14
select Con.contract_id, ST.service_type_name, Att.attach_service_name, count(CD.attach_service_id)
from contract Con join contract_detail CD on Con.contract_id = CD.contract_id
join attach_service Att on Att.attach_service_id = CD.attach_service_id
join service S on S.service_id = Con.service_id
join service_type ST on S.service_type_id = ST.service_type_id
group by Att.attach_service_id
having count(CD.attach_service_id) = 1;

-- TASK 15
select E.employee_id, E.employee_name, Edu.education_degree_name, D.division_name, E.employee_phone, E.employee_address, count(Con.employee_id)
from employee E join education_degree Edu on Edu.education_degree_id = E.education_degree_id
join division D on E.division_id = D.division_id
join contract Con on E.employee_id = Con.employee_id
where (year(Con.contract_start_date)) between 2018 and 2019
group by Con.employee_id
having count(Con.employee_id) <=3

