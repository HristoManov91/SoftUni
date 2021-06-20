CREATE SCHEMA `stc`;

-- 1 --
CREATE TABLE `addresses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL
);

CREATE TABLE `clients` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `full_name` VARCHAR(50) NOT NULL,
    `phone_number` VARCHAR(20) NOT NULL
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(10) NOT NULL
);

CREATE TABLE `drivers` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `age` INT NOT NULL,
    `rating` FLOAT DEFAULT 5.5
);

CREATE TABLE `cars` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `make` VARCHAR(20) NOT NULL,
    `model` VARCHAR(20),
    `year` INT NOT NULL DEFAULT 0,
    `mileage` INT DEFAULT 0,
    `condition` CHAR(1) NOT NULL,
    `category_id` INT NOT NULL,
    CONSTRAINT fk_cars_categories
    FOREIGN KEY (`category_id`)
    REFERENCES `categories`(`id`)
);

CREATE TABLE `cars_drivers`(
	`car_id` INT NOT NULL,
    CONSTRAINT fk_cd_c
    FOREIGN KEY (`car_id`)
    REFERENCES `cars`(`id`),
    `driver_id` INT NOT NULL,
    CONSTRAINT fk_cd_d
    FOREIGN KEY (`driver_id`)
    REFERENCES `drivers`(`id`),
    CONSTRAINT pk_car_criver
    PRIMARY KEY (`car_id` , `driver_id`)
);

CREATE TABLE `courses`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `from_address_id` INT NOT NULL,
    CONSTRAINT fk_c_a
    FOREIGN KEY (`from_address_id`)
    REFERENCES `addresses`(`id`),
    `start` DATETIME NOT NULL,
    `car_id` INT NOT NULL,
    CONSTRAINT fk_courses_cars
    FOREIGN KEY (`car_id`)
    REFERENCES `cars`(`id`),
    `client_id` INT NOT NULL,
    CONSTRAINT fk_courses_clients
    FOREIGN KEY (`client_id`)
    REFERENCES `clients`(`id`),
    `bill` DECIMAL(10,2)
);

-- 2 --

INSERT INTO `clients` (`full_name` , `phone_number`)
SELECT CONCAT(d.`first_name` , ' ' , d.`last_name`) AS `full_name` , CONCAT('(088) 9999' , d.`id`  * 2) FROM `drivers` AS d
WHERE d.`id` BETWEEN 10 AND 20;

-- 3 --

UPDATE `cars`
SET `condition` = 'C'
WHERE `mileage` IS NULL OR `mileage` > 800000 AND `year` <= 2010;

-- 4 --

DELETE FROM `clients`
WHERE `clients`.`id` NOT IN (SELECT `client_id` FROM `courses`);

-- 5 --

SELECT `make` , `model` , `condition` FROM `cars`
ORDER BY `id`;

-- 6 --

SELECT d.`first_name` , d.`last_name` , c.`make` , c.`model` , c.`mileage` FROM `cars` AS c
JOIN `cars_drivers` AS cd
ON c.`id` = cd.`car_id`
JOIN `drivers` AS d
ON cd.`driver_id` = d.`id`
WHERE c.`mileage` IS NOT NULL
ORDER BY c.`mileage` DESC, d.`first_name`;

-- 7 --

SELECT c.`id` AS `car_id` , c.`make` , c.`mileage`, COUNT(cour.`id`) AS `count_of_courses` , ROUND(AVG(cour.`bill`) , 2) AS `avg_bill` 
FROM `cars` AS c
LEFT JOIN `courses` AS cour
ON cour.`car_id` = c.`id`
GROUP BY c.`id`
HAVING `count_of_courses` NOT IN (2)
ORDER BY `count_of_courses` DESC , c.`id`;

-- 8 --

SELECT cl.`full_name` , COUNT(`car_id`) AS `count_of_cars` , SUM(cour.`bill`) AS `total_sum` FROM `clients` AS cl
JOIN `courses` AS cour
ON cour.`client_id` = cl.`id`
WHERE substring(cl.`full_name` , 2 , 1) = 'A'
GROUP BY cl.`full_name`
HAVING `count_of_cars` > 1
ORDER BY cl.`full_name`;

-- 9 --

SELECT a.`name` , IF(HOUR(cour.`start`) BETWEEN 6 AND 20 , 'Day' , 'Night') AS `day_time` , cour.`bill` , cl.`full_name`,
		c.`make` , c.`model` , cat.`name` FROM `courses` AS cour
JOIN `addresses` AS a
ON cour.`from_address_id` = a.`id`
JOIN `clients` AS cl
ON cour.`client_id` = cl.`id`
JOIN `cars` AS c
ON cour.`car_id` = c.`id`
JOIN `categories` AS cat
ON c.`category_id` = cat.`id`
ORDER BY cour.`id`;

-- 10 --

DELIMITER //
CREATE FUNCTION `udf_courses_by_client`(`phone_num` VARCHAR(20))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*) FROM `courses` AS cour
			JOIN `clients` AS cl
            ON cour.`client_id` = cl.`id`
            WHERE cl.`phone_number` = `phone_num`
			);
END//
DELIMITER ;

SELECT udf_courses_by_client ('(803) 6386812') as `count`;

-- 11 --

DELIMITER //
CREATE PROCEDURE `udp_courses_by_address`(`address_name` VARCHAR(100))
BEGIN
	SELECT a.`name` , cl.`full_name` , 
		(CASE
			WHEN cour.`bill` <= 20 THEN 'Low'
			WHEN cour.`bill` BETWEEN 21 AND 30 THEN 'Medium'
			WHEN cour.`bill` > 30 THEN 'High'
		END
		) AS `level_of_bill` ,
		c.`make` , c.`condition` , cat.`name` FROM `cars` AS c
    JOIN `courses` AS cour
    ON c.`id` = cour.`car_id`
    JOIN `clients` AS cl
    ON cour.`client_id` = cl.`id`
    JOIN `addresses` AS a
    ON cour.`from_address_id` = a.`id`
    JOIN `categories` AS cat
    ON c.`category_id` = cat.`id`
    WHERE a.`name` = `address_name`
    ORDER BY c.`make` , cl.`full_name`;
END//
DELIMITER ;

CALL udp_courses_by_address('700 Monterey Avenue');