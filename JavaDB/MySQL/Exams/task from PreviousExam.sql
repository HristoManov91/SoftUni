CREATE SCHEMA `fsd`;

CREATE TABLE `countries`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL
);

CREATE TABLE `towns`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `country_id` INT NOT NULL,
    CONSTRAINT fk_towns_countries
    FOREIGN KEY (`country_id`)
    REFERENCES `countries`(`id`)
);

CREATE TABLE `stadiums`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `capacity` INT NOT NULL,
    `town_id` INT NOT NULL,
    CONSTRAINT fk_stadiums_towns
    FOREIGN KEY (`town_id`)
    REFERENCES `towns`(`id`)
);

CREATE TABLE `teams`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `established` DATE NOT NULL,
    `fan_base` BIGINT NOT NULL DEFAULT 0,
    `stadium_id` INT NOT NULL,
    CONSTRAINT fk_teams_stadiums
    FOREIGN KEY (`stadium_id`)
    REFERENCES `stadiums`(`id`)
);

CREATE TABLE `skills_data`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `dribbling` INT DEFAULT 0,
    `pace` INT DEFAULT 0,
    `passing` INT DEFAULT 0,
    `shooting` INT DEFAULT 0,
    `speed` INT DEFAULT 0,
    `strength` INT DEFAULT 0
);

CREATE TABLE `coaches`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(10) NOT NULL,
    `last_name` VARCHAR(20) NOT NULL,
    `salary` DECIMAL(10,2) NOT NULL DEFAULT 0,
    `coach_level` INT NOT NULL DEFAULT 0
);

CREATE TABLE `players`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(10) NOT NULL,
    `last_name` VARCHAR(20) NOT NULL,
    `age` INT NOT NULL DEFAULT 0,
    `position` CHAR(1) NOT NULL,
    `salary` DECIMAL(10,2) NOT NULL DEFAULT 0,
    `hire_date` DATETIME,
    `skills_data_id` INT NOT NULL,
    CONSTRAINT fk_players_skills_data
    FOREIGN KEY (`skills_data_id`)
    REFERENCES `skills_data`(`id`),
    `team_id` INT,
    CONSTRAINT fk_players_teams
    FOREIGN KEY (`team_id`)
    REFERENCES `teams`(`id`)
);

CREATE TABLE `players_coaches`(
	`player_id` INT,
    CONSTRAINT fk_players_coaches_players
    FOREIGN KEY (`player_id`)
    REFERENCES `players`(`id`),
    `coach_id` INT,
    CONSTRAINT fk_players_coaches_coaches
    FOREIGN KEY (`coach_id`)
    REFERENCES `coaches`(`id`),
    CONSTRAINT pk_player_id_coach_id
    PRIMARY KEY (`player_id` , `coach_id`)
);

-- 2 --

INSERT INTO `coaches` (`first_name` , `last_name` , `salary` , `coach_level`)
SELECT `first_name` , `last_name` , `salary` , char_length(`first_name`) FROM `players`
WHERE `age` >= 45;

-- 3 --

UPDATE `coaches` AS c
SET `coach_level` = `coach_level` + 1
WHERE c.`first_name` LIKE 'A%' AND c.`id` IN (SELECT DISTINCT `coach_id` FROM `players_coaches`);

-- 4 --

DELETE FROM `players`
WHERE `age` >= 45;

-- 5 --

SELECT `first_name` , `age` , `salary` FROM `players`
ORDER BY `salary` DESC;

-- 6 --

SELECT a.`id` , CONCAT(a.`first_name` , ' ' , a.`last_name`) AS `full_name` , a.`age` , a.`position` , a.`hire_date` 
FROM `players` AS a
JOIN `skills_data` AS sd
ON a.`skills_data_id` = sd.`id`
WHERE a.`age` < 23 AND a.`position` = 'A' AND a.`hire_date` IS NULL AND sd.strength > 50
ORDER BY a.`salary` , a.`age`;

-- 7 --

SELECT t.`name` AS `team_name` , t.`established` , t.`fan_base` , 
	(SELECT COUNT(*) FROM `players` AS p2 WHERE p2.`team_id` = t.`id`) AS `player_count`
FROM `teams` AS t
LEFT JOIN `players` AS p
ON t.`id` = p.`team_id`
GROUP BY t.`id`
ORDER BY `player_count` DESC, t.`fan_base` DESC;

-- 8 --

SELECT MAX(sd.`speed`) AS `max_speed` , tw.`name` AS `town_name` FROM `skills_data` AS sd
RIGHT JOIN `players` AS p
ON sd.`id` = p.`skills_data_id`
RIGHT JOIN `teams` AS t
ON p.`team_id` = t.`id`
RIGHT JOIN `stadiums` AS s
ON t.`stadium_id` = s.`id`
RIGHT JOIN `towns` AS tw
ON s.`town_id` = tw.`id`
WHERE t.`name` NOT IN ('Devify')
GROUP BY tw.`name`
ORDER BY `max_speed` DESC , tw.`name`;

-- 9 --

SELECT c.`name`,
    (SELECT COUNT(*) FROM `players` AS p
                JOIN
            `teams` AS t ON p.`team_id` = t.`id`
                JOIN
            `stadiums` AS s ON t.`stadium_id` = s.`id`
                JOIN
            `towns` AS tw ON s.`town_id` = tw.`id`
                JOIN
            `countries` AS c2 ON tw.`country_id` = c2.`id`
        WHERE
            c.`id` = c2.`id`) AS `total_count_of_players`,
    (SELECT SUM(`salary`) FROM `players` AS p
                JOIN
            `teams` AS t ON p.`team_id` = t.`id`
                JOIN
            `stadiums` AS s ON t.`stadium_id` = s.`id`
                JOIN
            `towns` AS tw ON s.`town_id` = tw.`id`
                JOIN
            `countries` AS c2 ON tw.`country_id` = c2.`id`
        WHERE
            c.`id` = c2.`id`) AS `total_sum_of_salaries`
FROM
    `countries` AS c
ORDER BY `total_count_of_players` DESC , c.`name`;

-- 10 --

DELIMITER //
CREATE FUNCTION `udf_stadium_players_count`(`stadium_name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*) FROM `players` AS p
			JOIN `teams` AS t
			ON p.`team_id` = t.`id`
			JOIN `stadiums` AS s
			ON t.`stadium_id` = s.`id`
            WHERE s.`name` = `stadium_name`);
END //
DELIMITER ;

SELECT udf_stadium_players_count ('Jaxworks') as `count`;

-- 11 --

DELIMITER //
CREATE PROCEDURE `udp_find_playmaker`(`min_dribble_points` INT , `team_name` VARCHAR(45))
BEGIN
	SELECT CONCAT(p.`first_name`, ' ', p.`last_name`) AS `full_name`, p.`age`, p.`salary`, sd.`dribbling`, sd.`speed`, t.`name`
	FROM `players` AS p
    JOIN skills_data AS sd
    ON p.skills_data_id = sd.id
    JOIN teams AS t
    ON p.team_id = t.id
    WHERE sd.`dribbling` > `min_dribble_points` AND t.`name` = `team_name` AND sd.speed > (SELECT AVG(`speed`) FROM `skills_data`)
    ORDER BY sd.speed DESC
    LIMIT 1;
END //
DELIMITER ;

CALL udp_find_playmaker (20, 'Skyble');








