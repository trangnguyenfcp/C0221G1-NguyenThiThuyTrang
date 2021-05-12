CREATE TABLE students
(`student_id` INT PRIMARY KEY,
`student_name` VARCHAR(45),
`date_of_birth` DATE,
`class` VARCHAR(45),
`gender` VARCHAR(45));

CREATE TABLE subjects
(`subject_id` INT PRIMARY KEY,
`subject_name` VARCHAR(45),
`teacher_id` INT);

CREATE TABLE transcripts
(`student_id` INT,
`subject_id` INT,
`score` INT,
`test_day` DATE,
PRIMARY KEY(student_id, subject_id));

CREATE TABLE teachers
(`teacher_id` INT PRIMARY KEY,
`teacher_name` VARCHAR(45),
`phone_number` VARCHAR(20));
DROP TABLE subjects;
ALTER TABLE subjects
ADD FOREIGN KEY(teacher_id) REFERENCES teachers(teacher_id);

ALTER TABLE transcripts
ADD FOREIGN KEY(student_id) REFERENCES students(student_id),
ADD FOREIGN KEY(subject_id) REFERENCES subjects(subject_id);
