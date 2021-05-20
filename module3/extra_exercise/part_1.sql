-- PART 1 - 1
select I.instructor_id, I.instructor_name, F.faculty_name 
from instructor I left join faculty F on I.faculty_id = F.faculty_id;

-- PART 1 - 2
select I.instructor_id, I.instructor_name, F.faculty_name 
from instructor I join faculty F on I.faculty_id = F.faculty_id
where F.faculty_name = 'Geography & NRM';

-- PART 1 - 3
select F.faculty_name, count(S.student_id) as numbers_of_students
from faculty F join student S on S.faculty_id = F.faculty_id
where F.faculty_name = 'Geography & NRM'
group by S.faculty_id;

-- PART 1 - 4
select F.faculty_name, S.student_id, S.student_name,round(datediff(curdate(),S.date_of_birth)/365) as age
from faculty F join student S on S.faculty_id = F.faculty_id
where F.faculty_name = 'Mathematics';

-- PART 1 - 5
select F.faculty_name, count(I.instructor_id) as numbers_of_instructors
from faculty F join instructor I on I.faculty_id = F.faculty_id
where F.faculty_name = 'Biotechnology'
group by I.instructor_id;

-- PART 1 - 6
select S.student_id, S.student_name from student S
left join instructor_student SI on S.student_id = SI.student_id
where SI.student_id is null;

-- PART 1 - 7
select F.faculty_id, F.faculty_name, count(I.instructor_id) as numbers_of_instructors
from faculty F join instructor I on F.faculty_id = I.instructor_id
where I.faculty_id is not null
group by F.faculty_id;

-- PART 1 - 8
select F.phone
from faculty F join student S on F.faculty_id = S.faculty_id
where S.student_name = 'Le Van Son';

