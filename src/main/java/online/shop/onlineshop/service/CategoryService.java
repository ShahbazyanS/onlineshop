package online.shop.onlineshop.service;

import online.shop.onlineshop.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> generalCategories();

    List<Category> findById(int id);
}
