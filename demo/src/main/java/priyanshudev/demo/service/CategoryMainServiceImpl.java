package priyanshudev.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import priyanshudev.demo.models.Category;
import priyanshudev.demo.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class CategoryMainServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
