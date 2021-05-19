-- TASK 23
delimiter //
create procedure sp_1(in id int)
begin
delete from customer
where customer_id = id;
end //
delimiter ;
call sp_1(5);

-- TASK 24
delimiter //
create procedure sp_2(in con_id int,in e_id int, in c_id int, in s_id int, in csd datetime,in ced datetime, in dep varchar(45), in total int)
begin
insert into contract
value(con_id,e_id,c_id,s_id,csd,ced,dep,total);
end //
delimiter ;
   call sp_2(6,3,3,2,'2018/03/01', '2018/04/01','1000000',0);