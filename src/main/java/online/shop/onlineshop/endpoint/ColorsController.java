package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Colors;
import online.shop.onlineshop.service.ColorsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/colors")
public class ColorsController {

    private final ColorsService colorsService;

    @GetMapping("/all")
    public List<Colors> allColors(){
        return colorsService.colors();
    }
}
