-- PART 2 - 1
select P.project_id, P.project_name, I.instructor_name
from project P join instructor_student SI on SI.project_id = P.project_id
join instructor I on SI.instructor_id = I.instructor_id
where I.instructor_name = 'Tran Son';

-- PART 2 - 2
select P.project_id, P.project_name
from project P left join instructor_student SI on SI.project_id = P.project_id
left join student S on S.student_id = SI.student_id
where SI.student_id is null;

-- PART 2 - 3
select I.instructor_id, I.instructor_name, F.faculty_name, count(SI.student_id)
from instructor I join faculty F on I.faculty_id = F.faculty_id
join instructor_student SI on I.instructor_id = SI.instructor_id
group by I.instructor_id
having count(SI.student_id) >=3;

-- PART 2 - 4
select project_id, project_name, expense from project
where expense >= all (select expense from project);

-- PART 2 - 5
select P.project_id, P.project_name 
from project P join instructor_student SI on SI.project_id = P.project_id
group by SI.project_id
having count(SI.student_id)>2;

-- PART 2 - 6
select S.student_id, S.student_name
from student S join faculty F on F.faculty_id = S.faculty_id
where F.faculty_name = 'Geography & NRM';

-- PART 2 - 7
select F.faculty_name, count(S.student_id) as number_of_students
from faculty F join student S on S.faculty_id = F.faculty_id
group by F.faculty_id;

-- PART 2 - 8
select* from student S join instructor_student SI on SI.student_id = S.student_id
join project P on P.project_id = SI.project_id
where S.place_of_birth = P.place_of_intern;

-- PART 2 - 9
select S.student_name, P.place_of_intern from student S join instructor_student SI on SI.student_id = S.student_id
join project P on P.project_id = SI.project_id
where P.place_of_intern is null;

-- PART 2 - 10
select S.student_id, S.student_name 
from student S join instructor_student SI on SI.student_id = S.student_id
where SI.grade = 0;
