package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.exception.UserNotFoundException;
import online.shop.onlineshop.model.Order;
import online.shop.onlineshop.model.ShippingInfo;
import online.shop.onlineshop.model.ShoppingCart;
import online.shop.onlineshop.model.User;
import online.shop.onlineshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ShippingInfoService shippingInfoService;
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;

    public User saveUser(User user) {
        user.setShippingInfo(shippingInfoService.save(new ShippingInfo(),user));
        user.setOrder(orderService.save(new Order()));
        user.setShoppingCart(shoppingCartService.save(new ShoppingCart()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
       User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id " + id + " does not exist"));
       return user;
    }
    public void deleteUser(int id) {
       User user = userRepository.findById(id).orElseThrow(
               () -> new UserNotFoundException("user with id " + id + " does not exist"));
       userRepository.delete(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UserNotFoundException("user with email " + email + " does not exist"));
    }

}
