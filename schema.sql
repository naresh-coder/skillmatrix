CREATE TABLE `beverage` (
  `idbeverage` int(11) NOT NULL,
  `beverage_name` varchar(45) DEFAULT NULL,
  `beverage_cost` varchar(45) DEFAULT NULL,
  `beverage_status` varchar(45) DEFAULT NULL,
  `beverage_created` varchar(45) DEFAULT NULL,
  `sold_date` datetime DEFAULT NULL,
  `beverage_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idbeverage`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `customer_type` varchar(45) DEFAULT NULL,
  `full_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `order` (
  `order_date` datetime DEFAULT NULL,
  `total_amount` decimal(10,0) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `beverage_id` int(11) DEFAULT NULL,
  `order_id` int(11) NOT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `order_ref` varchar(45) DEFAULT NULL,
  KEY `customer_id_idx` (`customer_id`),
  KEY `beverage_id_idx` (`beverage_id`),
  CONSTRAINT `beverage_id` FOREIGN KEY (`beverage_id`) REFERENCES `beverage` (`idbeverage`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
