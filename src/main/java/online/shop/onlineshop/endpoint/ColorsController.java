package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Color;
import online.shop.onlineshop.service.ColorsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/colors")
public class ColorsController {

    private final ColorsServiceImpl colorsService;

    @GetMapping("/all")
    public List<Color> allColors(){
        return colorsService.colors();
    }
}
