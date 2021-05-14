SELECT* FROM student
WHERE student_name LIKE "H%";

SELECT* FROM class
WHERE MONTH(start_date) = 12;

SELECT* FROM `subject`
WHERE credit BETWEEN 3 AND 5;

UPDATE student
SET class_id = 2
WHERE student_name = 'Hung';

SELECT stu.student_name, sub.sub_name, mark.mark FROM student stu
JOIN mark 
ON stu.student_id = mark.student_id
JOIN `subject`sub
ON sub.sub_id = mark.sub_id
ORDER BY mark DESC, student_name;