package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Countrie;
import online.shop.onlineshop.service.CountriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountriesController {

    private final CountriesService countriesService;

    @GetMapping("/all")
    public List<Countrie> allColors() {
        return countriesService.countries();
    }
}
