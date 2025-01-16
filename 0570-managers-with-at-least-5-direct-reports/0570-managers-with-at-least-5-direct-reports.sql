# Write your MySQL query statement below
SELECT e.name
FROM Employee e
JOIN Employee m
ON e.id = m.managerId 
GROUP BY m.managerID
HAVING COUNT(*)>=5;