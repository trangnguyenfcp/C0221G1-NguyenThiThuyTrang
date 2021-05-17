select * from `subject`
where `subject`.credit >= all (select `subject`.credit from `subject`);

select Sub.sub_name, M.mark from `subject` Sub
join mark M on Sub.sub_id = M.sub_id
where M.mark >= all (select mark from mark);

select S.student_id, S.student_name, avg(M.mark) 
from student S join mark M on S.student_id = M.student_id
group by S.student_id
order by M.mark desc;