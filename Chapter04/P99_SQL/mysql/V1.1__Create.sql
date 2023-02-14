/* START */

DROP TABLE IF EXISTS `payment`;
DROP TABLE IF EXISTS `bank_transaction`;
DROP TABLE IF EXISTS `orderdetail`;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `productline`;
DROP TABLE IF EXISTS `top3product`;
DROP TABLE IF EXISTS `productlinedetail`;
DROP TABLE IF EXISTS `office_has_manager`;
DROP TABLE IF EXISTS `manager`;
DROP TABLE IF EXISTS `customerdetail`;
DROP TABLE IF EXISTS `customer`;
DROP TABLE IF EXISTS `sale`;
DROP TABLE IF EXISTS `daily_activity`;
DROP TABLE IF EXISTS `token`;
DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `employee_status`;
DROP TABLE IF EXISTS `department`;
DROP TABLE IF EXISTS `office`;
DROP TABLE IF EXISTS `office_flights`;
DROP TABLE IF EXISTS `sequences`;

DROP FUNCTION IF EXISTS `customer_pgs`;
DROP FUNCTION IF EXISTS `sale_price`;

DROP PROCEDURE IF EXISTS `get_product`;
DROP PROCEDURE IF EXISTS `get_emps_in_office`;
DROP PROCEDURE IF EXISTS `get_avg_price_by_product_line`;
DROP PROCEDURE IF EXISTS `set_counter`;
DROP PROCEDURE IF EXISTS `refresh_top3_product`;

DROP TRIGGER IF EXISTS `product_uid_trigger`;

DROP VIEW IF EXISTS `customer_master`;
DROP VIEW IF EXISTS `office_master`;
DROP VIEW IF EXISTS `product_master`;

-- TABLE OFFICE

CREATE TABLE `office` (
  `office_code`         VARCHAR(10) NOT NULL,
  `city`                VARCHAR(50) DEFAULT NULL,
  `phone`               VARCHAR(50) NOT NULL,
  `address_line_first`  VARCHAR(50) NOT NULL,
  `address_line_second` VARCHAR(50) DEFAULT NULL,
  `state`               VARCHAR(50) DEFAULT NULL,
  `country`             VARCHAR(50) DEFAULT NULL,
  `postal_code`         VARCHAR(15) NOT NULL, 
  `territory`           VARCHAR(10) NOT NULL,
  `location`            POINT       DEFAULT NULL,
  `internal_budget`     INT         NOT NULL,
  CONSTRAINT `office_pk` PRIMARY KEY (`office_code`),
  CONSTRAINT `office_postal_code_uk` UNIQUE (`postal_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE DEPARTMENT

CREATE TABLE `department` (
  `department_id`       BIGINT       NOT NULL AUTO_INCREMENT,
  `name`                VARCHAR(50)  NOT NULL,
  `phone`               VARCHAR(50)  NOT NULL,
  `code`                INT          DEFAULT 1,
  `office_code`         VARCHAR(10)  NOT NULL,
  `topic`               VARCHAR(500) DEFAULT NULL,  
  `dep_net_ipv4`        INT UNSIGNED DEFAULT NULL, -- INSERT INTO `department` (`dep_net_ipv4`) VALUES (INET_ATON("127.0.0.1")); | SELECT INET_NTOA(`dep_net_ipv4`) FROM `department` (or, use VARCHAR(16))
  `local_budget`        FLOAT        DEFAULT NULL,
  `profit`              FLOAT        DEFAULT NULL,
  `forecast_profit`     FLOAT        DEFAULT NULL,
  `cash`                FLOAT        DEFAULT NULL,
  `accounts_receivable` FLOAT        DEFAULT NULL,
  `inventories`         FLOAT        DEFAULT NULL,
  `accounts_payable`    FLOAT        DEFAULT NULL,
  `st_borrowing`        FLOAT        DEFAULT NULL,
  `accrued_liabilities` FLOAT        DEFAULT NULL,
  CONSTRAINT `department_pk` PRIMARY KEY (`department_id`),  
  CONSTRAINT `department_code_uk` UNIQUE (`code`),
  CONSTRAINT `department_office_fk` FOREIGN KEY (`office_code`) REFERENCES `office` (`office_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE EMPLOYEE

CREATE TABLE `employee` (
  `employee_number`  BIGINT       NOT NULL,
  `last_name`        VARCHAR(50)  NOT NULL,
  `first_name`       VARCHAR(50)  NOT NULL,
  `extension`        VARCHAR(10)  NOT NULL,
  `email`            VARCHAR(100) NOT NULL,
  `office_code`      VARCHAR(10)  NOT NULL,
  `salary`           INT          NOT NULL,
  `commission`       INT          DEFAULT NULL,
  `reports_to`       BIGINT       DEFAULT NULL,
  `job_title`        VARCHAR(50)  NOT NULL, 
  `employee_of_year` VARCHAR(500) DEFAULT NULL,
  `monthly_bonus`    VARCHAR(500) DEFAULT NULL,
  CONSTRAINT `employee_pk` PRIMARY KEY (`employee_number`),
  CONSTRAINT `employee_employee_fk` FOREIGN KEY (`reports_to`) REFERENCES `employee` (`employee_number`),
  CONSTRAINT `employee_office_fk` FOREIGN KEY (`office_code`) REFERENCES `office` (`office_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE EMPLOYEE_STATUS

CREATE TABLE `employee_status` (
  `id`              BIGINT      NOT NULL AUTO_INCREMENT,
  `employee_number` BIGINT      NOT NULL,  
  `status`          VARCHAR(50) NOT NULL,  
  `acquired_date`   DATE        NOT NULL,
  CONSTRAINT `id_pk` PRIMARY KEY (`id`),  
  CONSTRAINT `employee_status_employee_fk` FOREIGN KEY (`employee_number`) REFERENCES `employee` (`employee_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE SALE

CREATE TABLE `sale` (
  `sale_id`         BIGINT                              NOT NULL AUTO_INCREMENT, -- in PostgreSQL/Oracle this PK is a sequence 
  `fiscal_year`     INT                                 NOT NULL,  
  `sale`            FLOAT                               NOT NULL,  
  `employee_number` BIGINT                              DEFAULT NULL,  
  `hot`             BOOLEAN                             DEFAULT FALSE,  
  `rate`            ENUM ('SILVER', 'GOLD', 'PLATINUM') DEFAULT NULL,
  `vat`             ENUM ('NONE', 'MIN', 'MAX')         DEFAULT NULL,
  `fiscal_month`    INT                                 NOT NULL,
  `revenue_growth`  FLOAT                               NOT NULL, 
  `trend`           VARCHAR(10)                         DEFAULT NULL,
  CONSTRAINT `sale_pk` PRIMARY KEY (`sale_id`),    
  CONSTRAINT `sale_employee_fk` FOREIGN KEY (`employee_number`) REFERENCES `employee` (`employee_number`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE DAILY_ACTIVITY

CREATE TABLE `daily_activity` (
  `day_id`     BIGINT NOT NULL AUTO_INCREMENT, 
  `day_date`   DATE   NOT NULL,
  `sales`      FLOAT  NOT NULL,  
  `visitors`   FLOAT  NOT NULL,    
  `conversion` FLOAT  NOT NULL,
  CONSTRAINT `daily_activity_pk` PRIMARY KEY (`day_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE TOKEN

CREATE TABLE `token` (
  `token_id`   BIGINT    NOT NULL AUTO_INCREMENT, -- in PostgreSQL/Oracle this PK is a sequence    
  `sale_id`    BIGINT    NOT NULL,
  `amount`     FLOAT     NOT NULL,   
  `updated_on` TIMESTAMP NOT NULL DEFAULT NOW(),
  CONSTRAINT `token_pk` PRIMARY KEY (`token_id`),  
  CONSTRAINT `token_sale_fk` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`sale_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE CUSTOMER

CREATE TABLE `customer` (
  `customer_number`           BIGINT        NOT NULL AUTO_INCREMENT, -- in PostgreSQL/Oracle this PK is a sequence
  `customer_name`             VARCHAR(50)   NOT NULL,
  `contact_last_name`         VARCHAR(50)   NOT NULL,
  `contact_first_name`        VARCHAR(50)   NOT NULL,
  `phone`                     VARCHAR(50)   NOT NULL,
  `sales_rep_employee_number` BIGINT        DEFAULT NULL,
  `credit_limit`              DECIMAL(10,2) DEFAULT NULL,
  `first_buy_date`            INT           DEFAULT NULL,
  CONSTRAINT `customer_pk` PRIMARY KEY (`customer_number`), 
  CONSTRAINT `customer_name_uk` UNIQUE (`customer_name`),
  CONSTRAINT `customer_employee_fk` FOREIGN KEY (`sales_rep_employee_number`) REFERENCES `employee` (`employee_number`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE CUSTOMERDETAIL

CREATE TABLE `customerdetail` (
  `customer_number`     BIGINT      NOT NULL,
  `address_line_first`  VARCHAR(50) NOT NULL,
  `address_line_second` VARCHAR(50) DEFAULT NULL,
  `city`                VARCHAR(50) DEFAULT NULL,
  `state`               VARCHAR(50) DEFAULT NULL,
  `postal_code`         VARCHAR(15) DEFAULT NULL,
  `country`             VARCHAR(50) DEFAULT NULL,
  CONSTRAINT `customerdetail_pk` PRIMARY KEY (`customer_number`),  
  CONSTRAINT `customerdetail_address_line_first_uk` UNIQUE (`address_line_first`),
  CONSTRAINT `customerdetail_customer_fk` FOREIGN KEY (`customer_number`) REFERENCES `customer` (`customer_number`)  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE MANAGER

CREATE TABLE `manager` (
  `manager_id`         BIGINT       NOT NULL AUTO_INCREMENT, -- in PostgreSQL/Oracle this PK is a sequence
  `manager_name`       VARCHAR(50)  NOT NULL DEFAULT "anonymous",
  `manager_detail`     JSON         DEFAULT NULL,
  `manager_evaluation` VARCHAR(500) DEFAULT NULL, 
  CONSTRAINT `manager_pk` PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE OFFICE_HAS_MANAGER

CREATE TABLE `office_has_manager` (
  `offices_office_code` VARCHAR(10) NOT NULL,
  `managers_manager_id` BIGINT      NOT NULL,
  CONSTRAINT `office_manager_uk` UNIQUE (`offices_office_code`, `managers_manager_id`),
  CONSTRAINT `office_fk` FOREIGN KEY (`offices_office_code`) REFERENCES `office` (`office_code`) ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT `manager_fk` FOREIGN KEY (`managers_manager_id`) REFERENCES `manager` (`manager_id`) ON UPDATE NO ACTION ON DELETE NO ACTION  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE PRODUCTLINE

CREATE TABLE `productline` (
  `product_line`     VARCHAR(50) NOT NULL,
  `code`             BIGINT      NOT NULL,
  `text_description` TEXT        DEFAULT NULL,
  `html_description` MEDIUMTEXT  DEFAULT NULL,
  `image`            MEDIUMBLOB  DEFAULT NULL,
  `created_on`       DATE        DEFAULT (CURRENT_DATE),
  CONSTRAINT `productline_pk` PRIMARY KEY (`product_line`,`code`),
  CONSTRAINT `productline_uk` UNIQUE(`product_line`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE PRODUCTLINEDETAIL

CREATE TABLE `productlinedetail` (
  `product_line`  VARCHAR(50) NOT NULL,
  `code`          BIGINT      NOT NULL,
  `line_capacity` VARCHAR(20) NOT NULL,
  `line_type`     INT         DEFAULT 0,
  CONSTRAINT `productlinedetail_pk` PRIMARY KEY (`product_line`,`code`),  
  CONSTRAINT `productlinedetail_uk` UNIQUE(`product_line`),
  CONSTRAINT `productlinedetail_productline_fk` FOREIGN KEY (`product_line`,`code`) REFERENCES `productline` (`product_line`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE PRODUCT

CREATE TABLE `product` (
  `product_id`          BIGINT        NOT NULL AUTO_INCREMENT, -- in PostgreSQL/Oracle this PK is a sequence
  `product_name`        VARCHAR(70)   DEFAULT NULL,
  `product_line`        VARCHAR(50)   DEFAULT NULL,
  `code`                BIGINT        NOT NULL,
  `product_scale`       VARCHAR(10)   DEFAULT NULL,
  `product_vendor`      VARCHAR(50)   DEFAULT NULL,
  `product_description` TEXT          DEFAULT NULL,
  `quantity_in_stock`   INT           DEFAULT 0,
  `buy_price`           DECIMAL(10,2) NOT NULL DEFAULT 0.0,
  `msrp`                DECIMAL(10,2) NOT NULL DEFAULT 0.0,
  `specs`               MEDIUMTEXT    DEFAULT NULL,
  `product_uid`         BIGINT        DEFAULT 10,
  CONSTRAINT `product_pk` PRIMARY KEY (`product_id`),  
  CONSTRAINT `product_productline_fk` FOREIGN KEY (`product_line`,`code`) REFERENCES `productline` (`product_line`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `sequences` (`sequence_name` VARCHAR(50),currval INT);
INSERT INTO `sequences` (`sequence_name`, currval) VALUES ('product_uid_seq',0);

-- TABLE ORDER

CREATE TABLE `order` (
  `order_id`        BIGINT        NOT NULL AUTO_INCREMENT, -- in PostgreSQL/Oracle this PK is a sequence
  `order_date`      DATE          NOT NULL,
  `required_date`   DATE          NOT NULL,
  `shipped_date`    DATE          DEFAULT NULL,
  `status`          VARCHAR(15)   NOT NULL,
  `comments`        TEXT          DEFAULT NULL,
  `customer_number` BIGINT        NOT NULL,
  `amount`          DECIMAL(10,2) NOT NULL,
  CONSTRAINT `order_pk` PRIMARY KEY (`order_id`),
  CONSTRAINT `order_customer_fk` FOREIGN KEY (`customer_number`) REFERENCES `customer` (`customer_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE ORDERDETAIL

CREATE TABLE `orderdetail` (
  `orderdetail_id`    BIGINT        NOT NULL AUTO_INCREMENT,
  `order_id`          BIGINT        NOT NULL,
  `product_id`        BIGINT        NOT NULL,
  `quantity_ordered`  INT           NOT NULL,
  `price_each`        DECIMAL(10,2) NOT NULL,
  `order_line_number` INT           NOT NULL,  
  CONSTRAINT `orderdetail_pk` PRIMARY KEY (`orderdetail_id`),
  CONSTRAINT `orderdetail_uk` UNIQUE KEY (`order_id`, `product_id`),
  CONSTRAINT `orderdetail_order_fk` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
  CONSTRAINT `orderdetail_product_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE TOP3PRODUCT

CREATE TABLE `top3product` (  
  `product_id`   BIGINT      NOT NULL,
  `product_name` VARCHAR(70) DEFAULT NULL,  
  CONSTRAINT `top3product_pk` PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE PAYMENT

CREATE TABLE `payment` (
  `customer_number` BIGINT        NOT NULL,
  `check_number`    VARCHAR(50)   NOT NULL,
  `payment_date`    TIMESTAMP     NOT NULL DEFAULT NOW(),
  `invoice_amount`  DECIMAL(10,2) NOT NULL,
  `caching_date`    TIMESTAMP     DEFAULT NULL,  
  `version`         INT           NOT NULL DEFAULT 0,
  `modified`        TIMESTAMP     NOT NULL DEFAULT NOW(),
  CONSTRAINT `payment_pk` PRIMARY KEY (`customer_number`,`check_number`),
  CONSTRAINT `check_number_uk` UNIQUE (`check_number`),
  CONSTRAINT `payment_customer_fk` FOREIGN KEY (`customer_number`) REFERENCES `customer` (`customer_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE BANK_TRANSACTION

CREATE TABLE `bank_transaction` (
  `transaction_id`  BIGINT        NOT NULL AUTO_INCREMENT,
  `bank_name`       VARCHAR(50)   NOT NULL,
  `bank_iban`       VARCHAR(50)   NOT NULL,  
  `transfer_amount` DECIMAL(10,2) NOT NULL,
  `caching_date`    TIMESTAMP     NOT NULL DEFAULT NOW(),
  `customer_number` BIGINT        NOT NULL,
  `check_number`    VARCHAR(50)   NOT NULL, 
  `card_type`       VARCHAR(50)   NOT NULL, 
  `status`          VARCHAR(50)   NOT NULL DEFAULT 'SUCCESS',   
  CONSTRAINT `bank_transaction_pk` PRIMARY KEY (`transaction_id`),    
  CONSTRAINT `bank_transaction_customer_fk` FOREIGN KEY (`customer_number`,`check_number`) REFERENCES `payment` (`customer_number`,`check_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE OFFICE_FLIGHTS

CREATE TABLE `office_flights` (  
  `depart_town`  VARCHAR(32) NOT NULL,
  `arrival_town` VARCHAR(32) NOT NULL,
  `distance_km`  INT         NOT NULL,
  CONSTRAINT `office_flights_pk` PRIMARY KEY (`depart_town`, `arrival_town`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/* USER-DEFINED FUNCTIONS */

DELIMITER $$

CREATE FUNCTION `customer_pgs`(`credit` DECIMAL(10,2)) 
  RETURNS VARCHAR(20)
  DETERMINISTIC
  BEGIN
    DECLARE `pgs` VARCHAR(20);

    IF `credit` > 50000 THEN
		SET `pgs` = 'PLATINUM';
    ELSEIF (`credit` >= 50000 AND 
			`credit` <= 100000) THEN
        SET `pgs` = 'GOLD';
    ELSEIF `credit` < 10000 THEN
        SET `pgs` = 'SILVER';
    END IF;
	
	RETURN `pgs`;
  END $$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION `sale_price`(`quantity` INT, `list_price` REAL, `fraction_of_price` REAL)
  RETURNS REAL
  DETERMINISTIC
  BEGIN
    RETURN (`list_price` - (`list_price` * `fraction_of_price`)) * `quantity`;    
  END $$
DELIMITER ;

/* USER-DEFINED TRIGGER */

DELIMITER $$
CREATE TRIGGER `product_uid_trigger` BEFORE INSERT ON `product` FOR EACH ROW BEGIN
  UPDATE `sequences` set `currval` = `currval` + 10 where `sequence_name` = 'product_uid_seq';
  SET NEW.`product_uid` = (SELECT `currval` FROM `sequences` WHERE `sequence_name` = 'product_uid_seq');
END $$
DELIMITER ;

/* USER-DEFINED PROCEDURES */

DELIMITER $$
CREATE PROCEDURE `get_product`(IN `pid` BIGINT)
  BEGIN
	SELECT * FROM `product` WHERE `product`.`product_id` = `pid`;
  END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `get_emps_in_office`(IN `in_office_code` VARCHAR(10))
  BEGIN
    SELECT `office`.`city`, `office`.`country`, `office`.`internal_budget`
      FROM `office`
      WHERE `office`.`office_code`=`in_office_code`;

    SELECT `employee`.`employee_number`, `employee`.`first_name`, `employee`.`last_name`
      FROM `employee`
      WHERE `employee`.`office_code`=`in_office_code`;
  END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `get_avg_price_by_product_line` (
    IN `pl` VARCHAR(25), OUT `average` DECIMAL(10, 2))
  BEGIN
	SELECT AVG(`product`.`buy_price`)
	INTO `average`
	FROM `product`
	WHERE `product`.`product_line` = `pl`;
  END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `set_counter`(
	INOUT `counter` INT, IN `inc` INT)
  BEGIN
	SET `counter` = `counter` + `inc`;
  END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `refresh_top3_product`(IN `p_line_in` VARCHAR(50))
  BEGIN
	DELETE FROM `top3product`; 
      INSERT INTO `top3product`
		  (`top3product`.`product_id`, `top3product`.`product_name`)        
        SELECT `orderdetail`.`product_id`, `t`.`product_name` 
		FROM `orderdetail`, 
		LATERAL (SELECT DISTINCT `product`.`product_name` AS `product_name` 
		  FROM `product` WHERE (`orderdetail`.`product_id` = `product`.`product_id` 
		    AND `product`.`product_line` = p_line_in)) AS `t`
        GROUP BY `orderdetail`.`product_id`, `product_name`, `orderdetail`.`quantity_ordered` 
		ORDER BY `orderdetail`.`quantity_ordered` 
		LIMIT 3;         
  END $$
DELIMITER ;

/* USER-DEFINED VIEWS */

CREATE OR REPLACE VIEW `customer_master` AS
SELECT `customer`.`customer_name`,
       `customer`.`credit_limit`,
       `customerdetail`.`city`,
       `customerdetail`.`country`,
       `customerdetail`.`address_line_first`,
       `customerdetail`.`postal_code`,
       `customerdetail`.`state`
FROM `customer`
JOIN `customerdetail` ON `customerdetail`.`customer_number` = `customer`.`customer_number`
WHERE `customer`.`first_buy_date` IS NOT NULL;

CREATE OR REPLACE VIEW `office_master` AS
SELECT `office`.`office_code`,
       `office`.`city`,
       `office`.`country`,
       `office`.`state`,
       `office`.`phone`,
	   `office`.`postal_code`
FROM `office`
WHERE `office`.`city` IS NOT NULL;

CREATE OR REPLACE VIEW `product_master` AS
SELECT `product`.`product_line`,
       `product`.`product_name`,
       `product`.`product_scale`       
FROM `product`;

/* END */

/*
*********************************************************************
http://www.mysqltutorial.org
*********************************************************************
Name: MySQL Sample Database classicmodels
Link: http://www.mysqltutorial.org/mysql-sample-database.aspx
*********************************************************************

This is a modified version of the original schema for MySQL
*/