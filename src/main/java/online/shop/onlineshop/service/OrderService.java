package online.shop.onlineshop.service;

import online.shop.onlineshop.model.Order;

public interface OrderService {

    Order save(Order order);

    Order update(Order order, int id);

    Order get(int id);
}


