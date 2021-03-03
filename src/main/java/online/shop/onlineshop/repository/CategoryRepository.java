package online.shop.onlineshop.repository;

import online.shop.onlineshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT * FROM categories WHERE category_id IS NULL",
    nativeQuery = true)
    List<Category> getGeneralCategories();

    List<Category> findAllById(int id);

}
