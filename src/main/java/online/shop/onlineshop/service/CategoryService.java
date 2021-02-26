package online.shop.onlineshop.service;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Category;
import online.shop.onlineshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> generalCategories(){
        return categoryRepository.getGeneralCategories();
    }

    public List<Category> findById(int id){
        return categoryRepository.findCategories(id);
    }
}
