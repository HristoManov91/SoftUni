CREATE SCHEMA `SoftUniStoresSystem`;
-- 1
CREATE TABLE `pictures` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `url` VARCHAR(100) NOT NULL,
    `added_on` DATETIME NOT NULL
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `products` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL UNIQUE,
    `best_before` DATE,
    `price` DECIMAL (10,2) NOT NULL,
    `description` TEXT,
    `category_id` INT NOT NULL,
    CONSTRAINT fk_products_categories
    FOREIGN KEY (`category_id`)
    REFERENCES `categories`(`id`),
    `picture_id` INT NOT NULL,
    CONSTRAINT fk_products_pictures
    FOREIGN KEY (`picture_id`)
    REFERENCES `pictures`(`id`)
);

CREATE TABLE `towns` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE `addresses`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL UNIQUE,
    `town_id` INT NOT NULL,
    CONSTRAINT fk_addresses_towns
    FOREIGN KEY (`town_id`)
    REFERENCES `towns`(`id`)
);

CREATE TABLE `stores`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL UNIQUE,
    `rating` FLOAT NOT NULL,
    `has_parking` TINYINT(1) DEFAULT 0,
    `address_id` INT NOT NULL,
    CONSTRAINT fk_stores_addresses
    FOREIGN KEY (`address_id`)
    REFERENCES `addresses`(`id`)
);

CREATE TABLE `products_stores`(
	`product_id` INT,
    CONSTRAINT fk_products_stores_products
    FOREIGN KEY (`product_id`)
    REFERENCES `products`(`id`),
    `store_id` INT,
    CONSTRAINT fk_products_stores_stores
    FOREIGN KEY (`store_id`)
    REFERENCES `stores`(`id`),
    CONSTRAINT pk_product_id_store_id
    PRIMARY KEY (`product_id` , `store_id`)
);

CREATE TABLE `employees`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(15) NOT NULL,
    `middle_name` CHAR(1),
    `last_name` VARCHAR(20) NOT NULL,
    `salary` DECIMAL(19,2) NOT NULL DEFAULT 0,
    `hire_date` DATE NOT NULL,
    `manager_id` INT,
    `store_id` INT NOT NULL,
    CONSTRAINT fk_employees_stores
    FOREIGN KEY (`store_id`)
    REFERENCES `stores`(`id`)
);

ALTER TABLE `employees`
ADD CONSTRAINT fk_employees_employees
FOREIGN KEY (`manager_id`)
REFERENCES `employees`(`id`);

-- 2 --

INSERT INTO `products_stores` (`product_id` , `store_id`)
SELECT `id` , 1 FROM `products`
WHERE `id` NOT IN (SELECT `product_id` FROM `products_stores`);

-- 3 --

UPDATE `employees`
SET 
	`manager_id` = 3,
	`salary` = `salary` - 500
WHERE YEAR(`hire_date`) > 2003 AND `store_id` NOT IN (5,14); 

-- 4 --

DELETE FROM `employees`
WHERE `salary` >= 6000 AND `manager_id` IS NOT NULL;

-- 5 --

SELECT `first_name` , `middle_name` , `last_name` , `salary` , `hire_date` FROM `employees`
ORDER BY `hire_date` DESC;

-- 6 --

SELECT p.`name` , p.`price` , p.`best_before` , CONCAT( SUBSTRING(p.`description` , 1 , 10) , '...') AS `short_description` ,
	pic.`url`
FROM `products` AS p
JOIN `pictures` AS pic
ON p.`picture_id` = pic.`id`
WHERE char_length(p.`description`) > 100 AND YEAR(pic.`added_on`) < 2019 AND p.`price` > 20
ORDER BY p.`price` DESC;

-- 7 --

SELECT s.`name` , COUNT(ps.`store_id`) AS `product_count` , ROUND(AVG(p.`price`), 2) AS `avg` FROM `stores` AS s
LEFT JOIN `products_stores` AS ps
ON s.`id` = ps.`store_id`
LEFT JOIN `products` AS p
ON ps.`product_id` = p.`id`
GROUP BY s.`name`
ORDER BY `product_count` DESC , `avg` DESC , s.`id`;

-- 8 --

SELECT CONCAT(e.`first_name` , ' ' , e.`last_name`) AS `Full_name` , s.`name` AS `Store_name` ,
	a.`name` AS `address` , e.`salary`
FROM `employees` AS e
JOIN `stores` AS s
ON e.`store_id` = s.`id`
JOIN `addresses` AS a
ON s.`address_id` = a.`id`
WHERE e.`salary` < 4000 AND char_length(a.`name`) > 8 AND e.`last_name` LIKE '%n' AND a.`name` LIKE '%5%';

-- 9 --

SELECT REVERSE(s.`name`) AS `reversed_name` , CONCAT(UPPER(t.`name`) , '-' , a.`name`) AS `full_address` ,
	COUNT(e.`store_id`) AS `employees_count`
FROM `stores` AS s
JOIN `addresses` AS a
ON s.`address_id` = a.`id`
JOIN `towns` AS t
ON a.`town_id` = t.`id`
JOIN `employees` AS e
ON e.`store_id` = s.`id`
GROUP BY s.`name`
HAVING `employees_count` >= 1
ORDER BY `full_address`;

-- 10 --

DELIMITER //
CREATE FUNCTION `udf_top_paid_employee_by_store`(`store_name` VARCHAR(50))
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
	RETURN (SELECT CONCAT(e.`first_name`, ' ' , e.`middle_name` , '. ' , e.`last_name` , ' works in store for ' , 
			TIMESTAMPDIFF(YEAR , e.`hire_date` , '2020-10-18') , ' years') FROM `employees` AS e
	JOIN `stores` AS s
    ON e.`store_id` = s.`id`
    WHERE s.`name` = `store_name`
    ORDER BY e.`salary` DESC
    LIMIT 1);
END//
DELIMITER ;

SELECT udf_top_paid_employee_by_store('Keylex') as 'full_info';

-- 11 --

DELIMITER //
CREATE PROCEDURE `udp_update_product_price`(`address_name` VARCHAR(50))
BEGIN
	UPDATE `products` AS p
    JOIN `products_stores` AS ps
    ON p.`id` = ps.`product_id`
    JOIN `stores` AS s
    ON ps.`store_id` = s.`id`
    JOIN `addresses` AS a
    ON s.`address_id` = a.`id`
    SET p.`price` = p.`price` + (
		CASE
			WHEN SUBSTRING(`address_name` , 1 , 1) = '0' THEN 100
            ELSE 200
		END)
	WHERE a.`name` = `address_name`;
END //
DELIMITER ;

CALL udp_update_product_price('07 Armistice Parkway');
SELECT name, price FROM products WHERE id = 15;
