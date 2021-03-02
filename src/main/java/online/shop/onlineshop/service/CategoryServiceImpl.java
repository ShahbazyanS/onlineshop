package online.shop.onlineshop.service;

import online.shop.onlineshop.model.Category;

import java.util.List;

public interface CategoryServiceImpl {

    public List<Category> generalCategories();

    public List<Category> findById(int id);
}
