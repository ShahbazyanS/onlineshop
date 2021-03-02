package online.shop.onlineshop.service;

import online.shop.onlineshop.model.ShoppingCart;
import online.shop.onlineshop.model.User;

public interface ShoppingCartService {

    ShoppingCart update(int id, int productId);

    ShoppingCart getOne(int id);

    ShoppingCart userCart(User user);

    ShoppingCart save(ShoppingCart shoppingCart);
}
