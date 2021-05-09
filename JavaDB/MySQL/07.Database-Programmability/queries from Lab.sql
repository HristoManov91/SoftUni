#1
DELIMITER //
CREATE FUNCTION ufn_count_employees_by_town (town_name VARCHAR (50)) RETURNS INT DETERMINISTIC
BEGIN
DECLARE emp_count INT;
SET emp_count := (SELECT COUNT(*) FROM `employees`
	JOIN addresses USING (address_id)
    JOIN towns t USING (town_id)
    WHERE t.`name` = town_name);
RETURN emp_count;
END//
DELIMITER ;

SELECT ufn_count_employees_by_town('Sofia');

#2
DROP PROCEDURE IF EXISTS usp_select_employees_by_seniority()
DELIMITER $$
CREATE PROCEDURE usp_select_employees_by_seniority()
BEGIN
	SELECT employee_id FROM employees
	WHERE ROUND(DATEDIFF(NOW() , hire_date) / 365.25) < 15;
END $$
DELIMITER ;

CALL usp_select_employees_by_seniority();