
create table users(
id int(3) primary key auto_increment,
`name` varchar(120) not null,
email varchar(220) not null,
country varchar(120)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

select* from users where id=1;

insert into users
value(?, ?, ?, ?);

update users
set `name`=?, email=?, country = ?
where id = ?;

select* from users
where country like ?;

select* from users
order by `name`;

DELIMITER $$

CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.name, users.email, users.country

    FROM users

    where users.id = user_id;

    END$$

DELIMITER ;

  

DELIMITER $$

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);

    END$$

DELIMITER ;   


create table Permission(
  
id int(11) primary key,

name varchar(50)

);

create table User_Permission(

permission_id int(11),

user_id int(11)

);

insert into Permission(id, name) values(1, 'add');

insert into Permission(id, name) values(2, 'edit');

insert into Permission(id, name) values(3, 'delete');

insert into Permission(id, name) values(4, 'view');

delimiter $$
create procedure user_list()
begin 
select* from users;
end$$
delimiter ;

call user_list;

delimiter $$
create procedure update_user(in id2 int, in `name2` varchar(45), in email2 varchar(45), in country2 varchar(45))
begin 
update users
set `name` = `name2`, email = email2, country = country2
where id = id2;
end$$
delimiter ;

drop procedure update_user;
call update_user(1,"Chang 2","chang@gmail.com","USA");

delimiter $$
create procedure delete_user(in id2 int)
begin 
delete from users
where id = id2;
end$$
delimiter ;

call delete_user(1);