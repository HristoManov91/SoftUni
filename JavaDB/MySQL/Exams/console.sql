CREATE SCHEMA `restaurant_db`;
USE `restaurant_db`;

-- 1 --
CREATE TABLE `waiters`
(
    `id`         INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name`  VARCHAR(50) NOT NULL,
    `email`      VARCHAR(50) NOT NULL,
    `phone`      VARCHAR(50),
    `salary`     DECIMAL(10, 2)
);

CREATE TABLE `tables`
(
    `id`       INT PRIMARY KEY AUTO_INCREMENT,
    `floor`    INT NOT NULL,
    `reserved` BOOLEAN,
    `capacity` INT NOT NULL
);

CREATE TABLE `products`
(
    `id`    INT PRIMARY KEY AUTO_INCREMENT,
    `name`  VARCHAR(30)    NOT NULL UNIQUE,
    `type`  VARCHAR(30)    NOT NULL,
    `price` DECIMAL(10, 2) NOT NULL
);

CREATE TABLE `clients`
(
    `id`         INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name`  VARCHAR(50) NOT NULL,
    `birthdate`  DATE        NOT NULL,
    `card`       VARCHAR(50),
    `review`     TEXT
);

CREATE TABLE `orders`
(
    `id`           INT PRIMARY KEY AUTO_INCREMENT,
    `table_id`     INT  NOT NULL,
    CONSTRAINT fk_orders_tables
        FOREIGN KEY (`table_id`)
            REFERENCES `tables` (`id`),
    `waiter_id`    INT  NOT NULL,
    CONSTRAINT fk_orders_waiters
        FOREIGN KEY (`waiter_id`)
            REFERENCES `waiters` (`id`),
    `order_time`   TIME NOT NULL,
    `payed_status` BOOLEAN
);

CREATE TABLE `orders_clients`
(
    `order_id`  INT,
    CONSTRAINT fk_orders_clients_orders
        FOREIGN KEY (`order_id`)
            REFERENCES `clients` (`id`),
    `client_id` INT,
    CONSTRAINT fk_orders_clients_clients
        FOREIGN KEY (`client_id`)
            REFERENCES `clients` (`id`)
);

CREATE TABLE `orders_products`
(
    `order_id`   INT,
    CONSTRAINT fk_movie_actors_movie
        FOREIGN KEY (`order_id`)
            REFERENCES `orders` (`id`),
    `product_id` INT,
    CONSTRAINT fk_movie_products_products
        FOREIGN KEY (`product_id`)
            REFERENCES `products` (`id`)
);

-- 2 --

INSERT INTO products(name, type, price)
SELECT concat_ws(' ', last_name, 'specialty'),
       'Cocktail',
       CEIL(salary * 0.01)
FROM waiters
where id > 6;

-- 3 --

UPDATE orders
SET `table_id` = `table_id` - 1
WHERE id BETWEEN 12 and 23;

-- 4 --

DELETE w
FROM waiters as w
         LEFT JOIN orders as o on w.id = o.waiter_id
WHERE o.id IS NULL;

-- 5 --

SELECT *
FROM clients
ORDER BY birthdate DESC, id DESC;

-- 6 --

SELECT first_name, last_name, birthdate, review
FROM clients
WHERE card IS NULL
  AND YEAR(birthdate) BETWEEN 1978 AND 1993
ORDER BY last_name DESC, id
LIMIT 5;

-- 7 --

SELECT CONCAT(last_name, first_name, LENGTH(first_name), 'Restaurant') as `username`,
       REVERSE(SUBSTRING(email, 2, 12))                                as `password`
FROM waiters
WHERE salary IS NOT NULL
ORDER BY password DESC;

-- 8 --

SELECT p.id, p.name, COUNT(op.product_id) as `count`
FROM `products` as p
         JOIN orders_products as op ON p.id = op.product_id
GROUP BY op.product_id
HAVING `count` >= 5
ORDER BY `count` DESC, p.name;

-- 9 --

SELECT t.id                as 'table_id',
       t.capacity,
       COUNT(oc.client_id) as 'count_clients',
       (CASE
            WHEN COUNT(oc.client_id) = t.capacity THEN 'Full'
            WHEN COUNT(oc.client_id) < t.capacity THEN 'Free seats'
            WHEN COUNT(oc.client_id) > t.capacity THEN 'Extra seats'
           END)            as availability
FROM tables as t
         JOIN orders as o on t.id = o.table_id
         JOIN orders_clients as oc on o.id = oc.order_id
WHERE t.floor = 1
GROUP BY o.table_id
ORDER BY t.id DESC;

-- 10 --

CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))
    RETURNS DECIMAL(10, 2)
    DETERMINISTIC
BEGIN
    DECLARE bill DECIMAL(10, 2);
    SET bill := (SELECT SUM(p.price)
                 FROM clients as c
                          JOIN
                      orders_clients as oc on c.id = oc.client_id
                          JOIN
                      orders as o on oc.order_id = o.id
                          JOIN
                      orders_products as op on o.id = op.order_id
                          JOIN
                      products as p ON op.product_id = p.id
                 WHERE concat_ws(' ', c.first_name, c.last_name) = full_name);
    RETURN bill;
END;

SELECT c.first_name, c.last_name, udf_client_bill('Silvio Blyth') as 'bill'
FROM clients c
WHERE c.first_name = 'Silvio'
  AND c.last_name = 'Blyth';


-- 11 --

CREATE PROCEDURE udp_happy_hour(type VARCHAR(50))
BEGIN
    UPDATE products as p
    SET p.price = p.price * 0.8
    WHERE p.`type` = type
      and p.price >= 10.00;
END;

CALL udp_happy_hour('Cognac');