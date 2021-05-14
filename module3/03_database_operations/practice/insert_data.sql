INSERT INTO class
VALUE
(1,'A1', '2008/12/20',1),
(2,'A2', '2008/12/22',1),
(3,'B3', Current_date(),0);

INSERT INTO student
VALUE
(1,'Hung', 'Ha noi', '0912113113', 1, 1),
(2,'Hoa', 'Hai phong','', 1, 1),
(3,'Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO `subject`
VALUE
(1,'CF', 5, 1),
(2,'C', 6, 1),
(3,'HDJ', 5, 1),
(4,'RDBMS', 10, 1);

INSERT INTO mark
VALUE
(1,1,1,8,1),
(2,3,2,10,2),
(3,2,3,12,1);