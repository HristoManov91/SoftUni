CREATE TABLE `people`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    `picture` BLOB,
    `height` DOUBLE(10,2),
    `weight` DOUBLE (10,2),
    `gender` CHAR(1) NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` TEXT
    );
    
INSERT INTO `people` (`name` , `height` , `weight` , `gender` , `birthdate`)
VALUES
('Hristo Manov' , 1.90 , 97.9 , 'm' , '1991-08-26'),
('Vladislava Manova' , 1.75 , 57.9 , 'f' , '1996-09-11'),
('Hrisiq Manova' , 0.68 , 8.0 , 'f' , '2020-11-30'),
('Ivan Ivanov' , 2.90 , 107.9 , 'm' , '1981-05-22'),
('Krum Manov' , 1.70 , 87.90 , 'm' , '2991-01-16');
    
