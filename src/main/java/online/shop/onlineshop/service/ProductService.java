package online.shop.onlineshop.service;

import online.shop.onlineshop.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> allProducts();

    List<Product> lastProducts();

    Product getOne(int id);

    List<Product> findByCategory(int id);

    List<Product> findByCategoryRandom(int id);

    List<Product> findByColors(int id);

    List<Product> findBySizes(int id);

    List<Product> findByCountries(int id);

    List<Product> filterByPrice(int min, int max);

    List<Product> filterByPriceAndCountries(int id, int min, int max);

    List<Product> filterByPriceAndCategories(int id, int min, int max);

    List<Product> searchProduct(String word);

    Product update(Product product, int id);

    void delete(int id);
}
