package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Size;
import online.shop.onlineshop.service.SizesServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sizes")
public class SizesController {

    private final SizesServiceImpl sizesService;

    @GetMapping("/all")
    public List<Size> all() {
        return sizesService.allSizes();
    }
}
