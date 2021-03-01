package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Product;
import online.shop.onlineshop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public Product save(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product product(@PathVariable("id") int id) {
        return productService.getOne(id);
    }

    @GetMapping("/get")
    public List<Product> getAllProducts() {
        return productService.allProducts();
    }

    @GetMapping("/by_category/{id}")
    public List<Product> findByCategory(@PathVariable("id") int id) {
        return productService.findByCategory(id);
    }

    @GetMapping("/by_colors/{id}")
    public List<Product> findByColor(@PathVariable("id") int id) {
        return productService.findByColors(id);
    }

    @GetMapping("/by_sizes/{id}")
    public List<Product> findBySizes(@PathVariable("id") int id) {
        return productService.findBySizes(id);
    }

    @GetMapping("/made_in/{id}")
    public List<Product> findByCountries(@PathVariable("id") int id) {
        return productService.findByCountries(id);
    }

    @GetMapping("/filter/price/{min}/{max}")
    public List<Product> filterByPrice(@PathVariable("min") int min, @PathVariable("max") int max) {
        return productService.filterByPrice(min, max);
    }

    @GetMapping("/filter/made_in_price/{id}/{min}/{max}")
    public List<Product> filterByMadeInAndPrice(@PathVariable("id") int id, @PathVariable("min") int min, @PathVariable("max") int max) {
        return productService.filterByPriceAndCountries(id, min, max);
    }

    @GetMapping("/filter/categories_price/{id}/{min}/{max}")
    public List<Product> filterByCategoriesAndPrice(@PathVariable("id") int id, @PathVariable("min") int min, @PathVariable("max") int max) {
        return productService.filterByPriceAndCategories(id, min, max);
    }

    @GetMapping("/search/{word}")
    public List<Product> filterByCategoriesAndPrice(@PathVariable("word") String word) {
        return productService.searchProduct(word);
    }

    @GetMapping("/random_categories/{id}")
    public List<Product> randomCategories(@PathVariable("id") int id) {
        return productService.findByCategoryRandom(id);
    }

    @PutMapping("/update/{id}")
    public Product update(@RequestBody Product product, @PathVariable("id") int id) {
        return productService.update(product, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        productService.delete(id);
    }

}
