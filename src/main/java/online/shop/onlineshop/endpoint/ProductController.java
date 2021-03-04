package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.dto.ProductDto;
import online.shop.onlineshop.model.Product;
import online.shop.onlineshop.service.ProductServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;
    private final ModelMapper modelMapper;


    @PostMapping("/add")
    public Product save(@Valid @RequestBody ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return productService.saveProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product product(@PathVariable("id") int id) {
        return productService.getOne(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.allProducts();
    }

    @GetMapping("/category/{id}")
    public List<Product> findByCategory(@PathVariable("id") int id) {
        return productService.findByCategory(id);
    }

    @GetMapping("/colors/{id}")
    public List<Product> findByColor(@PathVariable("id") int id) {
        return productService.findByColors(id);
    }

    @GetMapping("/sizes/{id}")
    public List<Product> findBySizes(@PathVariable("id") int id) {
        return productService.findBySizes(id);
    }

    @GetMapping("/madein/{id}")
    public List<Product> findByCountries(@PathVariable("id") int id) {
        return productService.findByCountries(id);
    }

    @GetMapping("/filter/price/{min}/{max}")
    public List<Product> filterByPrice(@PathVariable("min") int min, @PathVariable("max") int max) {
        return productService.filterByPrice(min, max);
    }

    @GetMapping("/filter/madeinAndPrice/{id}/{min}/{max}")
    public List<Product> filterByMadeInAndPrice(@PathVariable("id") int id, @PathVariable("min") int min, @PathVariable("max") int max) {
        return productService.filterByPriceAndCountries(id, min, max);
    }

    @GetMapping("/filter/categoriesAndPrice/{id}/{min}/{max}")
    public List<Product> filterByCategoriesAndPrice(@PathVariable("id") int id, @PathVariable("min") int min, @PathVariable("max") int max) {
        return productService.filterByPriceAndCategories(id, min, max);
    }

    @GetMapping("/search/{word}")
    public List<Product> filterByCategoriesAndPrice(@PathVariable("word") String word) {
        return productService.searchProduct(word);
    }

    @GetMapping("/randomCategories/{id}")
    public List<Product> randomCategories(@PathVariable("id") int id) {
        return productService.findByCategoryRandom(id);
    }

    @PutMapping("/update/{id}")
    public Product update(@RequestBody Product product, @PathVariable("id") int id) {
        return productService.update(product, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        productService.delete(id);
    }

}
