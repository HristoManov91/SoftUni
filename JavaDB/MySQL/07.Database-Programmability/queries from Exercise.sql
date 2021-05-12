#1
DELIMITER //
CREATE PROCEDURE usp_get_employees_salary_above_35000() 
BEGIN
	SELECT first_name , last_name FROM employees
    WHERE salary > 35000
    ORDER BY first_name , last_name , employee_id;
END//
DELIMITER ;

CALL usp_get_employees_salary_above_35000();

#2
DROP PROCEDURE IF EXISTS usp_get_employees_salary_above;
DELIMITER //
CREATE PROCEDURE usp_get_employees_salary_above(min_salary DECIMAL (19,4)) 
BEGIN
	SELECT first_name , last_name FROM employees
    WHERE salary >= min_salary
    ORDER BY first_name , last_name , employee_id;
END//
DELIMITER ;

CALL usp_get_employees_salary_above(45000);

#3
DELIMITER //
CREATE PROCEDURE usp_get_towns_starting_with(start_with VARCHAR(20))
BEGIN
	SELECT t.`name` AS town_name FROM towns AS t
    WHERE t.`name` LIKE concat(start_with , '%')
    ORDER BY t.`name`;
END//
DELIMITER ;

CALL usp_get_towns_starting_with('b');

#4
DELIMITER //
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(20))
BEGIN
	SELECT e.`first_name` , e.`last_name` FROM `employees` AS e
    JOIN `addresses` AS a ON a.`address_id` = e.`address_id`
    JOIN `towns` AS t ON  t.`town_id` = a.`town_id`
    WHERE t.`name` = town_name
    ORDER BY e.`first_name` , e.`last_name` , e.`employee_id`;
END//
DELIMITER ;

CALL usp_get_employees_from_town('Sofia');

#5
DELIMITER //
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL)
RETURNS VARCHAR(10)
DETERMINISTIC
	BEGIN
    RETURN CASE
    WHEN salary < 30000 THEN 'Low'
    WHEN salary BETWEEN 30000 AND 50000 THEN 'Average'
    WHEN salary > 50000 THEN 'High'
    END;
END //
DELIMITER ;

SELECT ufn_get_salary_level(13500);
SELECT ufn_get_salary_level(43500);
SELECT ufn_get_salary_level(63500);

#6
DELIMITER //
CREATE PROCEDURE usp_get_employees_by_salary_level(s_level VARCHAR(10))
BEGIN
	SELECT `first_name` , `last_name` FROM employees
    WHERE ufn_get_salary_level(`salary`) = s_level
    ORDER BY `first_name` DESC , `last_name` DESC;
END//
DELIMITER ;

CALL usp_get_employees_by_salary_level('High');