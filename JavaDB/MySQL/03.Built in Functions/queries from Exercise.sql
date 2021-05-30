#1
SELECT `first_name` , `last_name` FROM `employees`
WHERE SUBSTRING(`first_name` , 1 , 2) = 'Sa';

#2
SELECT `first_name` , `last_name` FROM `employees`
WHERE `last_name` LIKE '%ei%';

#3
SELECT `first_name` FROM `employees`
WHERE department_id IN (3 , 10) AND YEAR(`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

#4
SELECT `first_name` , `last_name` FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%';