package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.ShoppingCart;
import online.shop.onlineshop.security.CurrentUser;
import online.shop.onlineshop.service.ShoppingCartService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping_cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public ShoppingCart save(@RequestBody ShoppingCart shoppingCart, @AuthenticationPrincipal CurrentUser currentUser){
        currentUser.getUser().setShoppingCart(shoppingCart);
        return shoppingCartService.save(shoppingCart);
    }

    @GetMapping("/get/{id}")
    public ShoppingCart getOne(@PathVariable("id") int id){

        return shoppingCartService.getOne(id);
    }

    @PutMapping("/update/{id}")
    public ShoppingCart update(@RequestBody ShoppingCart shoppingCart, @PathVariable("id") int id){
        return shoppingCartService.save(shoppingCart);
    }

    @GetMapping("/user/cart")
    public ShoppingCart cartByUser(@AuthenticationPrincipal CurrentUser currentUser){
        return shoppingCartService.userCart(currentUser.getUser());
    }
}
