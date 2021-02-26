package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.exception.ResourceNotFoundException;
import online.shop.onlineshop.model.Product;
import online.shop.onlineshop.model.ShoppingCart;
import online.shop.onlineshop.model.User;
import online.shop.onlineshop.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart save(ShoppingCart shoppingCart) {
        List<Double> prices = new ArrayList<>();
        if (shoppingCart.getProducts() != null) {
            for (Product product : shoppingCart.getProducts()) {
                prices.add(product.getPrice());
            }
            double sum = prices.stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();
            shoppingCart.setCartTotal(sum);
        }

        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart getOne(int id) {
        return shoppingCartRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cart with id " + id + " does not exist"));
    }

    public ShoppingCart userCart(User user) {
        return shoppingCartRepository.findByUser(user);
    }


}
