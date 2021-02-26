package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Category;
import online.shop.onlineshop.model.Product;
import online.shop.onlineshop.service.CategoryService;
import online.shop.onlineshop.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping("/categories")
    public List<Category> categories(){
        return categoryService.generalCategories();
    }

    @GetMapping("/products")
    public List<Product> products(){
        return productService.lastProducts();
    }
}
