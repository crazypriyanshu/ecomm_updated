package priyanshudev.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priyanshudev.demo.models.Category;
import priyanshudev.demo.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/categories")
@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
}
