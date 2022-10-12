DROP TABLE IF EXISTS `companies`;
DROP TABLE IF EXISTS `employees`;

CREATE TABLE `companies`
(
    `company_id`   bigint NOT NULL AUTO_INCREMENT,
    `company_name` varchar(60) DEFAULT NULL,
    PRIMARY KEY (`company_id`)
);

CREATE TABLE `employees`
(
    `employee_id`   bigint NOT NULL AUTO_INCREMENT,
    `first_name` varchar(60) DEFAULT NULL,
    `last_name` varchar(60) DEFAULT NULL,
    `email` varchar(60) DEFAULT NULL,
    `company_id`    bigint NOT NULL,
    PRIMARY KEY (`employee_id`),
    FOREIGN KEY (`company_id`) REFERENCES companies (`company_id`) ON UPDATE CASCADE ON DELETE CASCADE
);