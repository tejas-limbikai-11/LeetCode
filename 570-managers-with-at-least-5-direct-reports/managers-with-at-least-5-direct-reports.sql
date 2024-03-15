# Write your MySQL query statement below
SELECT name 
FROM Employee 
WHERE id IN 
(SELECT managerID FROM employee GROUP BY managerId HAVING count(*)>=5);

