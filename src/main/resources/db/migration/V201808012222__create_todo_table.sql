CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` DATETIME,
  `user_id` INT(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` INT(20) NOT NULL,
  `product_id` INT(20) NOT NULL,
  `count` INT(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;