package online.shop.onlineshop.service;


import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.exception.ResourceNotFoundException;
import online.shop.onlineshop.model.Product;
import online.shop.onlineshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceImpl{

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> lastProducts() {
        return productRepository.findLastProducts();
    }

    @Override
    public Product getOne(int id) {
        return productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product with id " + id + " does not exist"));
    }

    @Override
    public List<Product> findByCategory(int id) {
        return productRepository.findByCategory(id);
    }

    @Override
    public List<Product> findByCategoryRandom(int id) {
      return productRepository.randomProducts(id);
    }

    @Override
    public List<Product> findByColors(int id) {
        return productRepository.findByColors(id);
    }

    @Override
    public List<Product> findBySizes(int id) {
        return productRepository.findBySizes(id);
    }

    @Override
    public List<Product> findByCountries(int id) {
        return productRepository.findByCountries(id);
    }

    @Override
    public List<Product> filterByPrice(int min, int max) {
        return productRepository.filterByPrice(min, max);
    }

    @Override
    public List<Product> filterByPriceAndCountries(int id, int min, int max) {
        return productRepository.filterByPriceAndCountries(id, min, max);
    }

    @Override
    public List<Product> filterByPriceAndCategories(int id, int min, int max) {
        return productRepository.filterByPriceAndCategories(id, min, max);
    }

    @Override
    public List<Product> searchProduct(String word) {
        return productRepository.searchProduct(word);
    }

    @Override
    public Product update(Product product, int id) {
        Product productDB = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product with id " + id + " does not exist"));
        product.setId(productDB.getId());
        return productDB;
    }

    @Override
    public void delete(int id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product with id " + id + " does not exist"));
        productRepository.delete(product);
    }
}
