INSERT INTO `orders` (`id`, `order_date`) VALUES (3000, '2021-01-18');
INSERT INTO `orders` (`id`, `order_date`) VALUES (3001, '2021-03-18');
INSERT INTO `orders` (`id`, `order_date`) VALUES (3002, '2020-11-18');
INSERT INTO `orders` (`id`, `order_date`) VALUES (3003, '2021-03-23');

----------------------------------------------------------------------------------------

INSERT INTO `colors` (`id`, `name`) VALUES (2111, 'red');
INSERT INTO `colors` (`id`, `name`) VALUES (2112, 'blue');
INSERT INTO `colors` (`id`, `name`) VALUES (2113, 'yellow');
INSERT INTO `colors` (`id`, `name`) VALUES (2114, 'green');

----------------------------------------------------------------------------------------

INSERT INTO `sizes`(`id`,`name`) VALUES (1000,'XXL');
INSERT INTO `sizes`(`id`,`name`) VALUES (2000,'M');
INSERT INTO `sizes`(`id`,`name`) VALUES (3000,'S');
INSERT INTO `sizes`(`id`,`name`) VALUES (4000,'XL');

----------------------------------------------------------------------------------------

INSERT INTO `countries`(`id`,`name`) VALUES (1000,'ARM');
INSERT INTO `countries`(`id`,`name`) VALUES (2000,'USA');
INSERT INTO `countries`(`id`,`name`) VALUES (3000,'RUS');
INSERT INTO `countries`(`id`,`name`) VALUES (4000,'CHI');

----------------------------------------------------------------------------------------

INSERT INTO `categories`(`id`,`name`,`category_id`) VALUES (1000,'fashion',NULL);
INSERT INTO `categories`(`id`,`name`,`category_id`) VALUES (2000,'furniture',NULL);
INSERT INTO `categories`(`id`,`name`,`category_id`) VALUES (3000,'art',NULL);
INSERT INTO `categories`(`id`,`name`,`category_id`) VALUES (1001,'shoes',1000);
INSERT INTO `categories`(`id`,`name`,`category_id`) VALUES (1002,'jeans',1000);

----------------------------------------------------------------------------------------

INSERT INTO `personal_info`(`id`,`email`,`name`,`phone`) VALUES (1000,'e.heto@mail.ru','ssss', 09855555);
INSERT INTO `personal_info`(`id`,`email`,`name`,`phone`) VALUES (2000,'admin098@mail.com','ssss',05555698);

----------------------------------------------------------------------------------------

INSERT INTO `shipping_info`(`id`,`address_line`,`city`,`country`) VALUES (1000,'home 6','Gyumri','Armenia');
INSERT INTO `shipping_info`(`id`,`address_line`,`city`,`country`) VALUES (2000,'home 7','Gyumri','Armenia');
INSERT INTO `shipping_info`(`id`,`address_line`,`city`,`country`) VALUES (3000,'home 8','Gyumri','Armenia');

--------------------------------------------------------------------------------------

INSERT INTO `shopping_cart`(`id`,`cart_total`) VALUES (1000,0);
-- INSERT INTO `shopping_cart`(`id`,`cart_total`,`user_id`) VALUES (1000,0,1001);
-- INSERT INTO `shopping_cart`(`id`,`cart_total`,`user_id`) VALUES (1000,0,1002);

----------------------------------------------------------------------------------------
INSERT INTO `users` (`id`, `active`, `email`, `password`, `token`, `user_type`, `username`) VALUES (1001, FALSE, 'armyanin098@mail.ru', 'armyanin', '8e4ad650-1a4e-46b4-87f6-0beafe86b90e', 'USER', 'poxosyan' );
INSERT INTO `users` (`id`, `active`, `email`, `password`, `user_type`, `username`) VALUES (1002, TRUE, 'admin098@mail.com', 'armyanin', 'ADMIN', 'poxosyan');
INSERT INTO `users`(`id`,`active`,`email`,`password`,`token`,`user_type`,`username`,`order_id`,`personal_info_id`,`shipping_info_id`, `shopping_cart_id`)
VALUES (1771,TRUE,'e.heto@mail.ru','$2a$10$XP0QElG.rSUzOGPzmHBcZu8KH1xfwD38RAd21CpEVWK11gY3BQmFa','9ce28367-2b6a-4684-876f-dd8e769ecf56','ADMIN','poxos', 3003, 1000, 1000, 1000);

----------------------------------------------------------------------------------------

INSERT INTO `products`(`id`,`description`,`name`,`price`) VALUES (1000,'description','Women Shirt',499);
INSERT INTO `products`(`id`,`description`,`name`,`price`) VALUES (2000,'description','Man Shirt',199);
INSERT INTO `products`(`id`,`description`,`name`,`price`) VALUES (3000,'description','Women Jeans',1222);
INSERT INTO `products`(`id`,`description`,`name`,`price`) VALUES (4000,'description','Women Jeans',1222);

----------------------------------------------------------------------------------------

INSERT INTO `categories_products`(`categories_id`,`products_id`) VALUES (1000,1000);
INSERT INTO `categories_products`(`categories_id`,`products_id`) VALUES (1000,2000);
INSERT INTO `categories_products`(`categories_id`,`products_id`) VALUES (1002,3000);

----------------------------------------------------------------------------------------

INSERT INTO `products_colors`(`products_id`,`colors_id`) VALUES (1000,2111);
INSERT INTO `products_colors`(`products_id`,`colors_id`) VALUES (1000,2112);
INSERT INTO `products_colors`(`products_id`,`colors_id`) VALUES (2000,2111);

----------------------------------------------------------------------------------------

INSERT INTO `products_countries`(`products_id`,`countries_id`) VALUES (1000,1000);
INSERT INTO `products_countries`(`products_id`,`countries_id`) VALUES (1000,2000);
INSERT INTO `products_countries`(`products_id`,`countries_id`) VALUES (2000,1000);

----------------------------------------------------------------------------------------

INSERT INTO `products_sizes`(`products_id`,`sizes_id`) VALUES (1000,2000);
INSERT INTO `products_sizes`(`products_id`,`sizes_id`) VALUES (1000,1000);
INSERT INTO `products_sizes`(`products_id`,`sizes_id`) VALUES (2000,2000);

----------------------------------------------------------------------------------------

INSERT INTO `shopping_cart_products`(`shopping_cart_id`,`products_id`) VALUES (1000,1000);
INSERT INTO `shopping_cart_products`(`shopping_cart_id`,`products_id`) VALUES (1000,2000);
INSERT INTO `shopping_cart_products`(`shopping_cart_id`,`products_id`) VALUES (1000,3000);




