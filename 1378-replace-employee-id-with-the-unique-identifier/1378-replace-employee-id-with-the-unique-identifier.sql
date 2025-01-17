# Write your MySQL query statement below
SELECT unique_id,name
FROM EmployeeUNI as a
RIGHT JOIN Employees as b
ON a.id = b.id;