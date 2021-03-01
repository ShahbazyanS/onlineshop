package online.shop.onlineshop.service;


import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.exception.ResourceNotFoundException;
import online.shop.onlineshop.model.Product;
import online.shop.onlineshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
      return productRepository.randomProducts(id);
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
        Product productDB = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product with id " + id + " does not exist"));
        product.setId(productDB.getId());
//        productDB.setName(product.getName());
//        productDB.setImages(product.getImages());
//        productDB.setColors(product.getColors());
//        productDB.setCountries(product.getCountries());
//        productDB.setPrice(product.getPrice());
//        productDB.setDescription(product.getDescription());
//        productDB.setSizes(product.getSizes());
        return productDB;
    }

    public void delete(int id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product with id " + id + " does not exist"));
        productRepository.delete(product);
    }
}
