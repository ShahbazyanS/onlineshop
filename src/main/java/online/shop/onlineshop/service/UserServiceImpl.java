package online.shop.onlineshop.service;

import online.shop.onlineshop.model.User;

import java.util.List;

public interface UserServiceImpl {

    public User saveUser(User user);

    public List<User> getAllUsers();

    public User getUser(int id);

    public void deleteUser(int id);

    public User findByEmail(String email);
}
