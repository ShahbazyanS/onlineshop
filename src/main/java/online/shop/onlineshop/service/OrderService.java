package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.exception.ResourceNotFoundException;
import online.shop.onlineshop.model.Order;
import online.shop.onlineshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;



    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Order order, int id) {
        LocalDate date = LocalDate.parse("yyyy-mm-dd");
        Order order1 = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order by id " + id + " does not exist"));
        order1.setOrderDate(date);
        order1.setProducts(order.getProducts());
        return order1;
    }

    public Order get(int id){
       return orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order by id " + id + " does not exist"));
    }

}
