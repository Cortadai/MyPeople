DROP TABLE IF EXISTS `shareholders`;
DROP TABLE IF EXISTS `stockshares`;
DROP TABLE IF EXISTS `sales`;
DROP TABLE IF EXISTS `offers`;


# actionista
# puede tener muchas ofertas
# puede tener 1 tipo de acciones
CREATE TABLE `shareholders`
(
    `shareholder_id`   bigint NOT NULL AUTO_INCREMENT,
    `first_name` varchar(60) NOT NULL,
    `last_name` varchar(60) NOT NULL,
    `email` varchar(60) DEFAULT NULL,
    PRIMARY KEY (`shareholder_id`)
);

# acciones
# pertene a 1 accionista
# puede tener muchas ventas
CREATE TABLE `stockshares`
(
    `stockshare_id`   bigint NOT NULL AUTO_INCREMENT,
    `numTotal` integer NOT NULL,
    `stock_type` varchar(60) NOT NULL,
    `shareholder_id` bigint NOT NULL,
    PRIMARY KEY (`stockshare_id`),
    FOREIGN KEY (`shareholder_id`) REFERENCES shareholders (`shareholder_id`)
);

# ventas
# pertenece a 1 tipo de acciones
# puede tener muchas ofertas
CREATE TABLE `sales`
(
    `sale_id`   bigint NOT NULL AUTO_INCREMENT,
    `min_price` decimal NOT NULL,
    `publication_date` DATE NOT NULL,
    `expiration_date` DATE NOT NULL,
    `status` varchar(60) DEFAULT NULL,
    `stockshare_id` bigint NOT NULL,
    PRIMARY KEY (`sale_id`),
    FOREIGN KEY (`stockshare_id`) REFERENCES stockshares (`stockshare_id`)
);

# ofertas
# pertenece a 1 venta
# pertenece a 1 accionista
CREATE TABLE `offers`
(
    `offer_id`   bigint NOT NULL AUTO_INCREMENT,
    `price` decimal NOT NULL,
    `initial_date` DATE NOT NULL,
    `status` varchar(60) DEFAULT NULL,
    `sale_id` bigint NOT NULL,
    `shareholder_id` bigint NOT NULL,
    PRIMARY KEY (`offer_id`),
    FOREIGN KEY (`sale_id`) REFERENCES sales (`sale_id`),
    FOREIGN KEY (`shareholder_id`) REFERENCES shareholders (`shareholder_id`)

);