# Write your MySQL query statement below
SELECT s.student_id, s.student_name, sub.subject_name, count(e.student_id) AS attended_exams
FROM Students AS s
CROSS JOIN Subjects sub
LEFT JOIN Examinations AS e
ON s.student_id = e.student_id AND sub.subject_name = e.subject_name
GROUP BY sub.subject_name, s.student_name, s.student_id
ORDER by s.student_id, sub.subject_name