SELECT* FROM student;

SELECT* FROM student
WHERE status = true;

SELECT* FROM `subject`
WHERE credit<10;

SELECT* FROM student
JOIN class
ON student.class_id = class.class_id
WHERE class_name = "A1";

SELECT student.student_id, student.student_name, `subject`.sub_name, mark.mark 
FROM student
JOIN mark
ON student.student_id = mark.student_id
JOIN `subject`
ON `subject`.sub_id = mark.sub_id 
WHERE sub_name = "CF";