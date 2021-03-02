package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.exception.ResourceNotFoundException;
import online.shop.onlineshop.model.Order;
import online.shop.onlineshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order, int id) {
        LocalDate date = LocalDate.parse("yyyy-mm-dd");
        Order orderDB = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order by id " + id + " does not exist"));
        order.setId(orderDB.getId());
        orderDB.setOrderDate(date);
        return orderDB;
    }

    @Override
    public Order get(int id){
       return orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order by id " + id + " does not exist"));
    }

}
