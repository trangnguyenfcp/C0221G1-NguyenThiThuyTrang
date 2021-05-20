insert into faculty
value(1, 'Geography & NRM', '0946738973'),
(2, 'Biotechnology', '0637238973'),
(3, 'Mathematics', '0949378900');

insert into instructor
value(1,'Tran Son',400,2),
(2,'Thuy Trang',900,1);
insert into instructor
value(3,'Van Hoang',500,null);

insert into student
value(1,'Huynh',1,'1996/12/03','Da Nang'),
(2,'Ngoc',2,'1999/11/12','Hue'),
(3,'Le Van Son',1,'2002/01/03','HCM'),
(4,'Dat',1,'1997/01/03','Da Nang');

insert into project
value(1,'Project 1', 1000, 'Da Nang'),
(2,'Project 2', 400, 'Da Nang'),
(3,'Project 3', 800, 'HCM');

insert into instructor_student
value(1,1,1,3.6),
(2,2,1,2.0),
(2,2,2,3.6);
