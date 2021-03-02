package online.shop.onlineshop.service;

import online.shop.onlineshop.model.ShoppingCart;
import online.shop.onlineshop.model.User;

public interface ShoppingCartServiceImpl {

    public ShoppingCart update(int id, int productId);

    public ShoppingCart getOne(int id);

    public ShoppingCart userCart(User user);

    public ShoppingCart save(ShoppingCart shoppingCart);
}
