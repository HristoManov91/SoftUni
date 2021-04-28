#13
SELECT `department_id` , MIN(`salary`) AS `minimum_salary` FROM `employees`
WHERE `department_id` IN (2,5,7)
GROUP BY `department_id`
ORDER BY `department_id`;

#14
SELECT `department_id` , AVG(`salary`) AS `avg_salary` FROM `employees`;

#15
SELECT `department_id` , MAX(`salary`) AS `max_salary` FROM `employees`
WHERE MAX(`salary`) NOT BETWEEN 30000 AND 70000
GROUP BY `department_id`
ORDER BY `department_id`;
