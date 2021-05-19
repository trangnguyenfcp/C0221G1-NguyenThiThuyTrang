-- TASK 25
create table messages(
id int not null auto_increment primary key,
message varchar(45) default null,
time timestamp null default current_timestamp on update current_timestamp );

delimiter //
create trigger tr_1
after delete
on contract for each row
begin
declare count int;
select count(*) 
into count from contract;
insert into messages(message) values (count);
end //
delimiter ;

delete from contract
where contract_id = 3;
select* from messages;

-- TASK 26
delimiter //
create trigger tr_2
before update
on contract for each row
begin
declare start_date datetime;
declare end_date datetime;
declare old_end_date datetime;
select new.contract_start_date into start_date from contract limit 1;
select new.contract_end_date into end_date from contract limit 1;
select old.contract_end_date into old_end_date from contract limit 1;
if(datediff(end_date,start_date) < 2) then 
insert into messages(message) values ('end date> start date at least 2 days');
set new.contract_end_date = old_end_date;
end if;
end //
delimiter ;

update contract
set contract_end_date = '2019/11/17'
where contract_id = 4;
select* from messages;
