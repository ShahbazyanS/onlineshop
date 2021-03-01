package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.exception.DuplicateEntityException;
import online.shop.onlineshop.exception.UserNotFoundException;
import online.shop.onlineshop.model.*;
import online.shop.onlineshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ShippingInfoService shippingInfoService;
    private final ShoppingCartService shoppingCartService;
    private final PersonalInfoService personalInfoService;
    private final OrderService orderService;

    public User saveUser(User user) {
       if(userRepository.findByEmail(user.getEmail()).isPresent()){
           throw new DuplicateEntityException("user with email " + user.getEmail() + " already exist");
        }
        user.setShippingInfo(shippingInfoService.save(new ShippingInfo(),user));
        user.setOrder(orderService.save(new Order()));
        user.setShoppingCart(shoppingCartService.save(new ShoppingCart()));
        user.setPersonalInfo(personalInfoService.save(new PersonalInfo(), user));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
       return userRepository.findById(id).orElseThrow(
               () -> new UserNotFoundException("user with id " + id + " does not exist"));

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
