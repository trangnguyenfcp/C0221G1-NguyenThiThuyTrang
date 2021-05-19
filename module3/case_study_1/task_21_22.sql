-- TASK 21
create view v_employee as
select* from employee 
where employee_address = 'Hai Chau' and employee_id in(
select employee_id from contract
where contract_start_date = '2019/12/12');

-- TASK 22
update v_employee
set employee_address = 'Lien Chieu';