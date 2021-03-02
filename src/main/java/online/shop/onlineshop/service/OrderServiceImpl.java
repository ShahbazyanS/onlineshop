package online.shop.onlineshop.service;

import online.shop.onlineshop.model.Order;

public interface OrderServiceImpl {

    public Order save(Order order);

    public Order update(Order order, int id);

    public Order get(int id);
}


