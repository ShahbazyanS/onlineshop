package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Sizes;
import online.shop.onlineshop.service.SizesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sizes")
public class SizesController {

    private final SizesService sizesService;

    @GetMapping("/all")
    public List<Sizes> all(){
        return sizesService.allSizes();
    }
}
