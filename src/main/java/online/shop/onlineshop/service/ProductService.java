package online.shop.onlineshop.service;


import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.exception.ResourceNotFoundException;
import online.shop.onlineshop.model.Product;
import online.shop.onlineshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    public List<Product> lastProducts() {
        return productRepository.findLastProducts();
    }

    public Product getOne(int id) {
        return productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product with id " + id + " does not exist"));
    }

    public List<Product> findByCategory(int id) {
        return productRepository.findByCategory(id);
    }

    public List<Product> findByCategoryRandom(int id) {
        List<Product> products = new ArrayList<>();
        List<Product> byCategory = productRepository.findByCategory(id);
        for (int i = 0; i < 6; i++) {
            Product product = byCategory.get(new Random().nextInt(byCategory.size()));
            products.add(product);
        }
        return products;
    }

    public List<Product> findByColors(int id) {
        return productRepository.findByColors(id);
    }

    public List<Product> findBySizes(int id) {
        return productRepository.findBySizes(id);
    }

    public List<Product> findByCountries(int id) {
        return productRepository.findByCountries(id);
    }

    public List<Product> filterByPrice(int min, int max) {
        return productRepository.filterByPrice(min, max);
    }

    public List<Product> filterByPriceAndCountries(int id, int min, int max) {
        return productRepository.filterByPriceAndCountries(id, min, max);
    }

    public List<Product> filterByPriceAndCategories(int id, int min, int max) {
        return productRepository.filterByPriceAndCategories(id, min, max);
    }

    public List<Product> searchProduct(String word) {
        return productRepository.searchProduct(word);
    }

    public Product update(Product product, int id) {
        Product product1 = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product with id " + id + " does not exist"));
        product1.setName(product.getName());
        product1.setImages(product.getImages());
        product1.setColors(product.getColors());
        product1.setCountries(product.getCountries());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setSizes(product.getSizes());
        return product1;
    }

    public void delete(int id){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product with id " + id + " does not exist"));
        productRepository.delete(product);
    }
}
