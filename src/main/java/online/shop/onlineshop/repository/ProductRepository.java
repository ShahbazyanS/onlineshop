package online.shop.onlineshop.repository;

import online.shop.onlineshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM products ORDER BY id DESC  LIMIT 9",
            nativeQuery = true)
    List<Product> findLastProducts();


    @Query(value = "SELECT *\n" +
            "FROM products INNER JOIN categories_products\n" +
            "ON categories_products.products_id=products.id\n" +
            "WHERE categories_products.categories_id=:id", nativeQuery = true)
    List<Product> findByCategory(@Param("id") int id);

    @Query(value = "SELECT *\n" +
            "FROM products INNER JOIN products_colors\n" +
            "ON products_colors.products_id=products.id\n" +
            "WHERE products_colors.colors_id=:id", nativeQuery = true)
    List<Product> findByColors(@Param("id") int id);

    @Query(value = "SELECT *\n" +
            "FROM products INNER JOIN products_sizes\n" +
            "ON products_sizes.products_id=products.id\n" +
            "WHERE products_sizes.sizes_id=:id", nativeQuery = true)
    List<Product> findBySizes(@Param("id") int id);

    @Query(value = "SELECT *\n" +
            "FROM products INNER JOIN products_countries\n" +
            "ON products_countries.products_id=products.id\n" +
            "WHERE products_countries.countries_id=:id", nativeQuery = true)
    List<Product> findByCountries(@Param("id") int id);

    @Query(value = "SELECT * FROM products WHERE price>:min AND price<:max", nativeQuery = true)
    List<Product> filterByPrice(@Param("min") int min, @Param("max") int max);

    @Query(value = "SELECT *\n" +
            "FROM products INNER JOIN products_countries\n" +
            "ON products_countries.products_id=products.id\n" +
            "WHERE products_countries.countries_id=:id\n" +
            "AND price>:min AND price<:max", nativeQuery = true)
    List<Product> filterByPriceAndCountries(@Param("id") int id,@Param("min") int min, @Param("max") int max);

    @Query(value = "SELECT *\n" +
            "FROM products INNER JOIN categories_products\n" +
            "ON categories_products.products_id=products.id\n" +
            "WHERE categories_products.categories_id=:id\n" +
            "AND price>:min AND price<:max", nativeQuery = true)
    List<Product> filterByPriceAndCategories(@Param("id") int id,@Param("min") int min, @Param("max") int max);

    @Query(value = "SELECT * FROM products WHERE `name` LIKE %:word% OR description LIKE %:word%", nativeQuery = true)
    List<Product> searchProduct(@Param("word") String word);

    @Query(value = "SELECT * FROM products INNER JOIN `categories_products`\n" +
            "            ON `categories_products`.products_id=products.id\n" +
            "            WHERE `categories_products`.categories_id=:id\n" +
            "             ORDER BY RAND() LIMIT 6\n", nativeQuery = true)
    List<Product> randomProducts(@Param("id") int id);
}
