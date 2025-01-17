package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Product;
import online.shop.onlineshop.model.ShoppingCart;
import online.shop.onlineshop.model.User;
import online.shop.onlineshop.repository.ProductRepository;
import online.shop.onlineshop.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    @Override
    public ShoppingCart update(int id, int productId) {
        ShoppingCart cart = shoppingCartRepository.getOne(id);
        Product product = productRepository.getOne(productId);
        List<Product> products = cart.getProducts();
        products.add(product);
        cart.setProducts(products);
        return shoppingCartRepository.save(cart);
    }


    @Override
    public ShoppingCart userCart(User user) {
        return shoppingCartRepository.findByUser(user);
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }
}
