CREATE SCHEMA `softuni_imdb`;

-- 1 --
CREATE TABLE `countries` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL UNIQUE,
    `continent` VARCHAR(30) NOT NULL,
    `currency` VARCHAR(5) NOT NULL
);

CREATE TABLE `genres` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE `actors` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `birthdate` DATE NOT NULL,
    `height` INT,
    `awards` INT,
    `country_id` INT NOT NULL,
    CONSTRAINT fk_actors_countries
    FOREIGN KEY (`country_id`)
    REFERENCES `countries`(`id`)
);

CREATE TABLE `movies_additional_info` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `rating` DECIMAL(10,2) NOT NULL,
    `runtime` INT NOT NULL,
    `picture_url` VARCHAR(80) NOT NULL,
    `budget` DECIMAL(10,2),
    `release_date` DATE NOT NULL,
    `has_subtitles` TINYINT(1),
    `description` TEXT
);

CREATE TABLE `movies` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(70) UNIQUE NOT NULL,
    `country_id` INT NOT NULL,
    CONSTRAINT fk_movies_country
    FOREIGN KEY (`country_id`)
    REFERENCES `countries`(`id`),
    `movie_info_id` INT NOT NULL,
    CONSTRAINT fk_movies_movies_additional_info
    FOREIGN KEY (`movie_info_id`)
    REFERENCES `movies_additional_info` (`id`)
);

CREATE TABLE `movies_actors` (
	`movie_id` INT,
    CONSTRAINT fk_movie_actors_movie
    FOREIGN KEY (`movie_id`)
    REFERENCES `movies`(`id`),
    `actor_id` INT,
    CONSTRAINT fk_movie_actors_actors
    FOREIGN KEY (`actor_id`)
    REFERENCES `actors`(`id`)
);

CREATE TABLE `genres_movies` (
	`genre_id` INT,
	CONSTRAINT fk_genres_movies_genres
    FOREIGN KEY (`genre_id`)
    REFERENCES `genres`(`id`),
    `movie_id` INT,
    CONSTRAINT fk_genres_movies_movie
    FOREIGN KEY (`movie_id`)
    REFERENCES `movies`(`id`)
);

-- 2 --
INSERT INTO `actors` (`first_name` , `last_name` , `birthdate` , `height` , `awards` , `country_id`)
SELECT REVERSE(a.`first_name`) ,  reverse(a.`last_name`) , date_sub(a.`birthdate` , INTERVAL 2 DAY) , a.`height` + 10 , a.`country_id` , (SELECT id FROM countries WHERE `name` = 'Armenia') FROM actors AS a
WHERE `id` <= 10;

-- 3 -- 
SELECT SUM(`runtime`) FROM `movies_additional_info`;

UPDATE `movies_additional_info`
SET `runtime` = `runtime` - 10
WHERE `runtime` BETWEEN 15 AND 25;

-- 4 --
DELETE FROM `countries` AS c
WHERE c.id NOT IN (SELECT m.`country_id` FROM `movies` AS m);

-- 5 --
SELECT * FROM `countries`
ORDER BY `currency` DESC , `id`;

-- 6 --
SELECT mai.`id` , m.`title` , mai.`runtime` , mai.`budget` , mai.`release_date` FROM `movies_additional_info` AS mai
JOIN `movies` AS m
ON m.`movie_info_id` = mai.`id`
WHERE YEAR(`release_date`) IN (1996,1997,1998,1999)
ORDER BY mai.`runtime` , mai.`id`
LIMIT 20;

-- 7 --
SELECT concat(a.`first_name` , ' ' ,  a.`last_name`) as `full_name` , 
	   concat(reverse(a.`last_name`) , char_length(a.`last_name`) , '@cast.com') as `email` , 
       YEAR(curdate()) - YEAR(a.`birthdate`) as `age` , a.`height` FROM actors AS a
WHERE a.`id` NOT IN (SELECT `actor_id` FROM `movies_actors`)
ORDER BY a.`height`;

-- 8 --
SELECT c.name , COUNT(m.country_id) AS movies_count FROM countries AS c
JOIN movies AS m
ON m.country_id = c.id
GROUP BY m.country_id
HAVING `movies_count` >= 7
ORDER BY c.name DESC;

-- 9 --
SELECT m.title ,
	(CASE 
		WHEN mai.rating <= 4 THEN 'poor'
        WHEN mai.rating <= 7 THEN 'good'
        WHEN mai.rating > 7 THEN 'excellent'
	END) as rating ,
    IF(mai.has_subtitles = 1 , 'english' , '-') AS subtitles,
    mai.budget FROM movies AS m
JOIN movies_additional_info AS mai
ON m.movie_info_id = mai.id
ORDER BY mai.budget DESC;

-- 10 --
DELIMITER //
CREATE FUNCTION `udf_actor_history_movies_count`(`full_name` VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*) FROM movies_actors AS ma
            JOIN actors AS a
            ON ma.actor_id = a.id
            WHERE concat(a.first_name , ' ' , a.last_name) = `full_name`
    );
END//
DELIMITER ;

SELECT udf_actor_history_movies_count('Stephan Lundberg')  AS 'history_movies';

-- 11 --
DELIMITER //
CREATE PROCEDURE `udp_award_movie`(`movie_title` VARCHAR(50))
BEGIN
	UPDATE `actors` AS a
    JOIN `movies_actors` AS ma
    ON ma.`actor_id` = a.`id`
    JOIN `movies` AS m
    ON m.`id` = ma.`movie_id`
    SET a.`awards` = a.`awards` + 1
    WHERE m.`title` = `movie_title`;
END//
DELIMITER ;