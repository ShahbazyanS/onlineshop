package online.shop.onlineshop.service;

import online.shop.onlineshop.exception.ResourceNotFoundException;
import online.shop.onlineshop.model.Product;

import java.util.List;

public interface ProductServiceImpl {

    public Product saveProduct(Product product);

    public List<Product> allProducts();

    public List<Product> lastProducts();

    public Product getOne(int id);

    public List<Product> findByCategory(int id);

    public List<Product> findByCategoryRandom(int id);

    public List<Product> findByColors(int id);

    public List<Product> findBySizes(int id);

    public List<Product> findByCountries(int id);

    public List<Product> filterByPrice(int min, int max);

    public List<Product> filterByPriceAndCountries(int id, int min, int max);

    public List<Product> filterByPriceAndCategories(int id, int min, int max);

    public List<Product> searchProduct(String word);

    public Product update(Product product, int id);

    public void delete(int id);
}
