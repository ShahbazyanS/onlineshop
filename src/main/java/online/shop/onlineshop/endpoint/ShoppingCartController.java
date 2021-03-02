package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.ShoppingCart;
import online.shop.onlineshop.security.CurrentUser;
import online.shop.onlineshop.service.ShoppingCartServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping_cart")
public class ShoppingCartController {

    private final ShoppingCartServiceImpl shoppingCartService;


    @GetMapping("/{id}")
    public ShoppingCart getOne(@PathVariable("id") int id) {

        return shoppingCartService.getOne(id);
    }

    @PutMapping("/update/{product_id}")
    public ShoppingCart update(@PathVariable(value = "product_id") int productId,
                               @AuthenticationPrincipal CurrentUser user) {
        return shoppingCartService.update(user.getUser().getShoppingCart().getId(), productId);
    }

    @GetMapping("/user/cart")
    public ShoppingCart cartByUser(@AuthenticationPrincipal CurrentUser currentUser) {
        return shoppingCartService.userCart(currentUser.getUser());
    }
}
