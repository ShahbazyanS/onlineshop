package online.shop.onlineshop.endpoint;

import lombok.RequiredArgsConstructor;
import online.shop.onlineshop.model.Category;
import online.shop.onlineshop.service.CategoryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoriesController {

    private final CategoryServiceImpl categoryService;

    @GetMapping("/general")
    public List<Category> allCategories() {
        return categoryService.generalCategories();
    }

    @GetMapping("/{id}")
    public List<Category> categories(@PathVariable("id") int id) {
        return categoryService.findById(id);
    }
}
