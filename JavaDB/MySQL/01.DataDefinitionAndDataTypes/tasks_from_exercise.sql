CREATE SCHEMA `minions` ;

#1
CREATE TABLE `minions`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `age` INT
);

CREATE TABLE `towns`(
	`town_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

#2
ALTER TABLE `towns` 
CHANGE COLUMN `town_id` `id` INT PRIMARY KEY AUTO_INCREMENT;

ALTER TABLE `minions`
ADD COLUMN `town_id` INT;

ALTER TABLE `minions`
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`);

#3
INSERT INTO `towns` (`name`)
VALUES
('Sofia'),
('Plovdiv'),
('Varna');

INSERT INTO `minions` (`name` , `age` , `town_id`)
VALUES
('Kevin', 22 , 1),
('Bob', 15 , 3),
('Steward', NULL , 2);

#4
TRUNCATE `minions`;

#5
DROP TABLE `minions`;
DROP TABLE `towns`;

#6
CREATE TABLE `people`(
	`id` INT AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    `picture` BLOB,
    `height` DECIMAL (10 , 2),
    `weight` DECIMAL (10 , 2),
    `gender` CHAR(1) NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` TEXT
);

ALTER TABLE `people`
ADD CONSTRAINT pk_id
PRIMARY KEY(`id`);

INSERT INTO `people`
VALUES
(1 , 'Hristo Manov' , NULL , 1.87 , 96.96 , 'm' , 1991-08-26 , NULL),
(2 , 'Georgi Manov' , NULL , 1.97 , 106.96 , 'm' , 1999-02-18 , NULL),
(3 , 'Vladislava Manova' , NULL , 1.57 , 56.96 , 'f' , 1996-09-11 , NULL),
(4 , 'Pesho Manov' , NULL , 1.67 , 66.96 , 'm' , 2001-02-01 , NULL),
(5 , 'Iordan Manov' , NULL , 1.77 , 76.96 , 'm' , 1995-11-19 , NULL);

#7
CREATE TABLE `users`(
	`id` INT AUTO_INCREMENT,
    `username` VARCHAR(30),
    `password` VARCHAR(26),
    `profile_picture` BLOB,
    `last_login_time` DATETIME,
    `is_deleted` BOOLEAN
);

ALTER TABLE `users`
ADD CONSTRAINT pk_id
PRIMARY KEY (`id`);

INSERT INTO `users` (`username` , `password` , `profile_picture` , 
							`last_login_time` , `is_deleted`)
VALUES
('user1' , 'password1' , NULL , NOW() , TRUE),
('user2' , 'password2' , NULL , NOW() , FALSE),
('user3' , 'password3' , NULL , NOW() , TRUE),
('user4' , 'password4' , NULL , NOW() , FALSE),
('user5' , 'password5' , NULL , NOW() , TRUE);

#8
ALTER TABLE `users`;

#9
ALTER TABLE `users`
MODIFY `last_login_time` DATETIME DEFAULT NOW();

#10


#11
CREATE SCHEMA `movies`;

CREATE TABLE `directors`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `director_name` VARCHAR(50),
    `notes` TEXT
);

CREATE TABLE `genres`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `genre_name` VARCHAR(50),
    `notes` TEXT
);

CREATE TABLE `categories`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(50),
    `notes` TEXT
);

CREATE TABLE `movies`(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(100),
    `director_id` INT,
    CONSTRAINT fk_movies_directors
    FOREIGN KEY (`director_id`)
    REFERENCES `directors`(`id`),
    `copyright_year` DATE,
    `length` DECIMAL(10,2),
    `genre_id` INT,
    CONSTRAINT fk_movies_genres
    FOREIGN KEY (`genre_id`)
    REFERENCES `genres`(`id`),
    `category_id` INT,
    CONSTRAINT fk_movies_categories
    FOREIGN KEY (`category_id`)
    REFERENCES `categories`(`id`),
    `rating` DECIMAL (10,2),
    `notes` TEXT
);

INSERT INTO `directors`
VALUES
(1 , 'Ivan Ivanov' , 'asasddf'),
(2 , 'Hristo Ivanov' , 'assdf'),
(3 , 'Plamen Ivanov' , 'asddf'),
(4 , 'Georgi Ivanov' , 'sdada'),
(5 , 'Pesho Ivanov' , 'aasdasdf');

INSERT INTO `genres`(`genre_name` , `notes`)
VALUES
('acion' , 'asfasfas'),
('comedy' , 'asfasfas'),
('drama' , 'asfasfas'),
('fantazy' , 'asfasfas'),
('trilur' , 'asfasfas');

INSERT INTO `categories`
VALUES
(1 , '' , 'ASDAFSSA'),
(2 , '' , 'ASDAFSSA'),
(3 , '' , 'ASDAFSSA'),
(4 , '' , 'ASDAFSSA'),
(5 , '' , 'ASDAFSSA');

INSERT INTO `movies`
VALUES
(1 , 'Ted' , 5 , 2017 , 101.20 , 3 , 2 , 5.78 , 'asfasfafaf'),
(2 , 'Ted2' , 4 , 2016 , 111.20 , 2 , 3 , 6.78 , 'asfaasdASDAsfafaf'),
(3 , 'Ted3' , 3 , 2015 , 121.20 , 1 , 4 , 7.78 , 'asfaASDAsfafaf'),
(4 , 'Ted4' , 2 , 2014 , 131.20 , 5 , 5 , 8.78 , 'ASDasfasfafaf'),
(5 , 'Ted5' , 1 , 2013 , 141.20 , 4 , 1 , 9.78 , 'asfasfafafASD');