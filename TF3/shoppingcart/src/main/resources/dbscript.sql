CREATE database shopping_cart;

CREATE USER 'cart_user'@'localhost' IDENTIFIED BY 'get_pwd';
GRANT ALL ON shopping_cart.* TO 'cart_user'@'localhost';

use shopping_cart;

CREATE TABLE product (
  id INT  PRIMARY KEY ,
  name VARCHAR(25),
  price DOUBLE UNSIGNED,
  imageUrl VARCHAR(500)
);

ALTER TABLE product MODIFY id INTEGER NOT NULL AUTO_INCREMENT;

INSERT INTO `shopping_cart`.`Product` (`id`, `name`, `imageUrl`, `price`) VALUES (1, 'Panda', 'http://www.bluemaize.net/im/bags/panda-bag-0.jpg', 290.50);

INSERT INTO `shopping_cart`.`Product` (`id`, `name`, `imageUrl`, `price`) VALUES (2, 'PandaBag', 'http://www.bluemaize.net/im/bags/panda-bag-0.jpg', 200.23);