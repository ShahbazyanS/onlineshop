package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.exception.UserNotFoundException;
import online.shop.onlineshop.model.*;
import online.shop.onlineshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ShippingInfoServiceImpl shippingInfoService;
    private final ShoppingCartServiceImpl shoppingCartService;
    private final PersonalInfoServiceImpl personalInfoService;
    private final OrderServiceImpl orderService;

    @Override
    public User saveUser(User user) {
        user.setShippingInfo(shippingInfoService.save(new ShippingInfo(),user));
        user.setOrder(orderService.save(new Order()));
        user.setShoppingCart(shoppingCartService.save(new ShoppingCart()));
        user.setPersonalInfo(personalInfoService.save(new PersonalInfo(), user));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
       return userRepository.findById(id).orElseThrow(
               () -> new UserNotFoundException("user with id " + id + " does not exist"));
    }

    @Override
    public void deleteUser(int id) {
       User user = userRepository.findById(id).orElseThrow(
               () -> new UserNotFoundException("user with id " + id + " does not exist"));
       userRepository.delete(user);
    }

    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UserNotFoundException("user with email " + email + " does not exist"));
    }

}
