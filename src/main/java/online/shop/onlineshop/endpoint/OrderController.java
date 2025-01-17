package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Order;
import online.shop.onlineshop.security.CurrentUser;
import online.shop.onlineshop.service.OrderServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderServiceImpl orderService;

    @PutMapping("/update")
    public Order update(@RequestBody Order order, @AuthenticationPrincipal CurrentUser currentUser){
        int id = currentUser.getUser().getOrder().getId();
        return orderService.update(order, id);
    }

    @GetMapping("/get")
    public Order get(@AuthenticationPrincipal CurrentUser currentUser){
        int id = currentUser.getUser().getOrder().getId();
        return orderService.get(id);
    }
}
