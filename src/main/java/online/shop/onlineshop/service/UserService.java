package online.shop.onlineshop.service;

import online.shop.onlineshop.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(int id);

    void deleteUser(int id);

    User findByEmail(String email);
}
