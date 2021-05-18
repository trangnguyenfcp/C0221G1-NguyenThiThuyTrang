insert into `position`
value(1,'Trainee'),(2,'Staff'),(3,'Team leader'), (4,'Manager'),(5,'Department head');

insert into education_degree
value(1,'High school'),(2,'College'),(3,'University'),(4,'Master'),(5,'Pd.D');

insert into division
value(1,'Production'), (2,'R&D'),(3,'Purchasing'),(4,'Marketing'),(5,'HR'),(6,'Accounting and Finance');

insert into employee 
value(1,'Le Phuoc Sy Phu',2,3,2,'1992/10/02','193718281','10000000','0937837103','syphu121@gmail.com', 'Da Nang'),
(2,'Hoang Pham Dong',1,2,3,'2002/02/04','836193648','5000000','0783748294','dongpham@gmail.com', 'Dak lak'),
(3,'Le Nhu Tam',4,2,4,'2005/03/05','193682916','15000000','0905627194','tamtam@gmail.com', 'Quang Tri'),
(4,'Phan Gia Khanh',3,4,5,'1945/12/10','819465194','8600000','0736185931','phamgiakhanh@gmail.com', 'Ha Noi'),
(5,'Nguyen Thi Thuy Trang',2,4,5,'1998/02/18','192125322','12000000','0773554340','trangnguyenfcp@gmail.com', 'Hue'),
(6,'Hoang Nhu Phong',1,1,1,'1998/02/17','192125323','14900000','0764917603','phongmmo1990@gmail.com', 'Ha Noi'),
(7,'Tran Thanh Thu',4,2,1,'1996/11/01','193718281','10000000','0937837103','syphu121@gmail.com', 'Da Nang'),
(8,'Khanh',4,2,1,'1996/11/01','193718281','10000000','0937837103','syphu121@gmail.com', 'Ho Chi Minh'),
(9,'Tran Thanh Thu Thien',4,2,1,'1996/11/01','193718281','10000000','0937837103','syphu121@gmail.com', 'Da Nang');

insert into customer_type
value(1,"Silver"),(2,"Gold"),(3,"Platinum"),(4,"Diamond");

insert into customer
value(1,1,'Dao Ngoc Phuong Thao','1994/04/15','165930104','927491748','thao@gmail.com','Vinh');
insert into customer
value(2,2,'Nguyen Phuong Nam','1997/02/12','139174610','02745184364','pn@gmail.com','Quang Ngai'),
(3,4,'Nguyen Thanh Tung','1973/05/30','37418464','02745184364','thanhtung@gmail.com','Da Nang'),
(4,1,'Tran Quoc Tuan','1972/01/31','37458464','3545184364','qtuan@gmail.com','Gia Lai');

insert into customer
value(5,null,'Nguyen Phuong Nam','1997/02/12','139174610','02745184364','pn@gmail.com','Quang Ngai');

insert into rent_type
value(1,'Hourly',100000),(2,'Weekly',650000),(3,'Monthly',4000000);

insert into service_type
value(1,'Room'),(2,'House'),(3,'Villa');

insert into service
value(1,'Room 1','30',100000,1,2,1,1,'avalable');
insert into service
value(2,'Room 2','25',80000,1,1,1,2,'avalable');
insert into service
value(3,'Villa 1','150',25000000,3,15,3,2,'avalable');

insert into attach_service
value(1,'Bike',0,10,'avalable'),
(2,'Swimming pool',200000,1,'avalable');


insert into contract
value(1,3,1,1,'2018/09/12','2018/09/15','500000',0),
(2,1,3,2,'2019/03/14','2019/04/23','2000000',0),
(3,2,3,1,'2019/04/24','2019/05/23','2000000',0),
(4,3,2,1,'2019/11/12','2019/11/15','500000',0);
insert into contract
value(5,2,3,3,'2018/09/12','2018/09/15','500000',0);

insert into contract_detail
value(1,1,1,2),
(2,2,1,1),
(3,3,1,3),
(4,4,2,1);
insert into contract_detail
value(5,5,2,2);
