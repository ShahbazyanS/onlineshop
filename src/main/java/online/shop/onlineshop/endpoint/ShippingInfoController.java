package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.ShippingInfo;
import online.shop.onlineshop.security.CurrentUser;
import online.shop.onlineshop.service.ShippingInfoService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class ShippingInfoController {

    private final ShippingInfoService shippingInfoService;

    @PostMapping("/add")
    public ShippingInfo save(@RequestBody ShippingInfo shippingInfo, @AuthenticationPrincipal CurrentUser currentUser) {
        return shippingInfoService.save(shippingInfo, currentUser.getUser());
    }

    @PutMapping("/update")
    public ShippingInfo update(@RequestBody ShippingInfo shippingInfo, @AuthenticationPrincipal CurrentUser currentUser) {
        int id = currentUser.getUser().getShippingInfo().getId();
        return shippingInfoService.update(shippingInfo, id);
    }

    @GetMapping("/info")
    public ShippingInfo get(@AuthenticationPrincipal CurrentUser currentUser) {
        int id = currentUser.getUser().getShippingInfo().getId();
        return shippingInfoService.findById(id);
    }
}
