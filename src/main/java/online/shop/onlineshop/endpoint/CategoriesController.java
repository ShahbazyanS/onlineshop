package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Category;
import online.shop.onlineshop.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoriesController {

    private final CategoryService categoryService;

    @GetMapping("/general")
    public List<Category> allCategories() {
        return categoryService.generalCategories();
    }

    @GetMapping("/get/{id}")
    public List<Category> categories(@PathVariable("id") int id) {
        return categoryService.findById(id);
    }
}
