# Write your MySQL query statement below
-- SELECT s.student_id,s.student_name, su.subject_name, count(e.subject_name) as attended_exams
-- FROM Students s LEFT OUTER JOIN Examinations e ON s.student_id = e.student_id CROSS JOIN subjects su on su.subject_name=e.subject_name Group by s.student_id,su.subject_name order by s.student_id,su.subject_name

select s.student_id, student_name, su.subject_name, count(e.subject_name) as attended_exams from Students s join Subjects su left join Examinations e on s.student_id = e.student_id and su.subject_name = e.subject_name group by s.student_id, su.subject_name order by s.student_id, su.subject_name;
