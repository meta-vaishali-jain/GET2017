CREATE database shopping_cart;

CREATE USER 'cart_user'@'localhost' IDENTIFIED BY 'get_pwd';
GRANT ALL ON shopping_cart.* TO 'cart_user'@'localhost';

use shopping_cart;

CREATE TABLE Product (
  id INT  PRIMARY KEY,
  name VARCHAR(25),
  price DOUBLE UNSIGNED,
  imageUrl VARCHAR(500)
);

INSERT INTO `shopping_cart`.`Product` (`id`, `name`, `imageUrl`, `price`) VALUES (1, 'Panda', 'https://c.76.my/Malaysia/panda-backpack-canvas-fashion-travelling-bag-school-bag-mvmconcept-1409-17-mvmconcept@14.jpg', 290.50);

INSERT INTO `shopping_cart`.`Product` (`id`, `name`, `imageUrl`, `price`) VALUES (2, 'PandaBag', 'https://c.76.my/Malaysia/panda-backpack-canvas-fashion-travelling-bag-school-bag-mvmconcept-1409-17-mvmconcept@14.jpg', 1000.23);