-- TASK2 - CÁCH LÀM 1
select* from employee
where (employee_name LIKE "H%" OR employee_name LIKE "T%" OR employee_name LIKE "K%") AND (char_length(employee_name)<=15);
-- TASK2 - CÁCH LÀM 2
select* from employee
where (employee_name regexp '^H|^T|^K') AND (char_length(employee_name)<=15);

select*, round(datediff(current_date(),employee_birthday)/365) AS age from employee
where (round(datediff(current_date(),employee_birthday)/365) between 18 and 50) and employee_address in ('Da Nang', 'Quang Tri');

