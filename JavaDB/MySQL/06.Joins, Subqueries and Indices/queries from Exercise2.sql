#1
SELECT e.`employee_id` , e.`job_title` , e.`address_id` , a.`address_text` FROM `employees` AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
ORDER BY e.`address_id`
LIMIT 5;

#2
SELECT e.`first_name` , e.`last_name` , t.`name` , a.`address_text` FROM `employees` AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
JOIN `towns` AS t
ON a.`town_id` = t.`town_id`
WHERE a.`town_id` = t.`town_id`
ORDER BY e.`first_name` , e.`last_name`
LIMIT 5;

#3
SELECT e.`employee_id` , e.`first_name` , e.`last_name` , d.`name` FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE d.`name` = 'Sales'
ORDER BY `employee_id` DESC;

#4
SELECT e.`employee_id` , e.`first_name` , e.`salary` , d.`name` FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE e.`salary` > 15000
ORDER BY d.`department_id` DESC
LIMIT 5;

#5
SELECT e.`employee_id` , e.`first_name` FROM `employees` AS e
LEFT JOIN `employees_projects` AS ep
ON e.`employee_id` = ep.`employee_id`
WHERE ep.`project_id` IS NULL
ORDER BY e.`employee_id` DESC
LIMIT 3;

#6
SELECT e.`first_name` , e.`last_name` , e.`hire_date` , d.`name` AS `dept_name` FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE e.`hire_date` > '1989/12/31' AND d.`name` IN ('Sales','Finance')
ORDER BY e.`hire_date`;

#7
SELECT e.`employee_id` , e.`first_name` , p.`name`AS `project_name` FROM `employees` AS e
JOIN `employees_projects` AS ep
ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p
ON ep.`project_id` = p.`project_id`
WHERE p.`start_date` > '2002/08/13' AND p.`end_date` IS NULL
ORDER BY e.`first_name` , p.`name`
LIMIT 5;

#8
SELECT 
    e.`employee_id`,
    e.`first_name`,
    IF(YEAR(p.`start_date`) < 2005, p.`name`, NULL) AS `project_name`
FROM
    `employees` AS e
        JOIN
    `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
        JOIN
    `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE
    e.`employee_id` = 24
ORDER BY p.`name`;

#9
SELECT e.`employee_id` , e.`first_name` , e.`manager_id` , 
	(SELECT em.`first_name` FROM `employees` AS em WHERE e.`manager_id` = em.`employee_id`) AS `manager_name` FROM `employees` AS e
WHERE e.`manager_id` IN (3 , 7)
ORDER BY e.`first_name`;

#10
SELECT e.`employee_id` , CONCAT(e.`first_name` , ' ' , e.`last_name`) AS `employee_name` , 
	(SELECT CONCAT(em.`first_name` , ' ' , em.`last_name`) FROM `employees` AS em WHERE e.`manager_id` = `employee_id`) AS `manager_name` ,
    d.`name` AS `department_name`
    FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE e.`manager_id` IS NOT NULL
ORDER BY e.`employee_id`
LIMIT 5;

#11
SELECT AVG(`salary`) AS `min_average_salary`  FROM `employees`
GROUP BY `department_id`
ORDER BY `min_average_salary`
LIMIT 1;

#12
SELECT mc.`country_code` , m.`mountain_range` , p.`peak_name` , p.`elevation` FROM `peaks` AS p
JOIN `mountains` as m
ON p.`mountain_id` = m.`id`
JOIN `mountains_countries` AS mc
ON m.`id` = mc.`mountain_id`
WHERE mc.`country_code` = 'BG' AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;

#13
SELECT `country_code` , COUNT(*) AS `mountain_range` FROM `mountains_countries`
WHERE `country_code` IN ('BG' , 'RU' , 'US')
GROUP BY `country_code`
ORDER BY `mountain_range` DESC;

#14
SELECT c.`country_name` , r.`river_name` FROM `countries` AS c
LEFT JOIN `countries_rivers` AS cr
ON c.`country_code` = cr.`country_code`
LEFT JOIN `rivers` AS r
ON cr.`river_id` = r.`id`
WHERE c.`continent_code` = 'AF'
ORDER BY c.`country_name`
LIMIT 5;

#15


#16
SELECT COUNT(*) AS `country_count` FROM `countries`
WHERE `country_code` NOT IN (SELECT `country_code` FROM `mountains_countries`)

#17
