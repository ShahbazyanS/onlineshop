package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Category;
import online.shop.onlineshop.model.Product;
import online.shop.onlineshop.service.CategoryServiceImpl;
import online.shop.onlineshop.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final CategoryServiceImpl categoryService;
    private final ProductServiceImpl productService;

    @GetMapping("/categories")
    public List<Category> categories() {
        return categoryService.generalCategories();
    }

    @GetMapping("/products")
    public List<Product> products() {
        return productService.lastProducts();
    }
}
