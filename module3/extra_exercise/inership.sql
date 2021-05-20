create database internship;
create table faculty(
faculty_id char(10) primary key,
faculty_name char(30),
phone char(10)
);

create table instructor(
instructor_id int primary key,
instructor_name char(30),
salary decimal(5,2),
faculty_id char(10),
foreign key(faculty_id) references faculty(faculty_id)
);

create table student(
student_id int primary key,
student_name char(40),
faculty_id char(10),
date_of_birth date,
place_of_birth char(30),
foreign key(faculty_id) references faculty(faculty_id)
);

create table project(
project_id char(10) primary key,
project_name char(30),
expense int,
place_of_intern char(30)
);

create table instructor_student(
student_id int,
project_id char(10),
instructor_id int,
grade decimal(5,2),
primary key(student_id, project_id,instructor_id),
foreign key(student_id) references student(student_id),
foreign key(project_id) references project(project_id),
foreign key(instructor_id) references instructor(instructor_id)
);



