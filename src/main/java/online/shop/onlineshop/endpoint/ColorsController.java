package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Color;
import online.shop.onlineshop.repository.ColorsRepository;
import online.shop.onlineshop.service.ColorsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/colors")
public class ColorsController {

    private final ColorsServiceImpl colorsService;
    private final ColorsRepository colorsRepository;


    @GetMapping("/all")
    public List<Color> allColors(){
        return colorsService.colors();
    }
}
