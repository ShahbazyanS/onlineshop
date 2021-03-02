package online.shop.onlineshop.repository;

import online.shop.onlineshop.model.ShoppingCart;
import online.shop.onlineshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    ShoppingCart findByUser(User user);
}
