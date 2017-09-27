DROP DATABASE shopping_cart;
CREATE DATABASE shopping_cart;
CREATE USER 'get_user'@'localhost' IDENTIFIED BY 'get_pwd';
GRANT ALL ON shopping_cart.* TO 'get_user'@'localhost';

USE shopping_cart;

CREATE TABLE Products (
  id INT  PRIMARY KEY,
  name VARCHAR(25),
  img_url VARCHAR(200),
  price DOUBLE
);

INSERT INTO `shopping_cart`.`products` (`id`, `name`, `img_url`, `price`) VALUES (1, 'PandaBag', 'https://i.pinimg.com/736x/7a/d4/36/7ad4369d36efd91734e8abad321bb9eb--pink-backpacks-canvas-backpacks.jpg', 290.50);

INSERT INTO `shopping_cart`.`products` (`id`, `name`, `img_url`, `price`) VALUES (2, 'CutePanda', 'https://i.pinimg.com/736x/7a/d4/36/7ad4369d36efd91734e8abad321bb9eb--pink-backpacks-canvas-backpacks.jpg', 1000.23);
