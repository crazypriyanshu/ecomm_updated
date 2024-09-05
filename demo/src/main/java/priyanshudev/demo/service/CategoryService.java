package priyanshudev.demo.service;

import org.springframework.stereotype.Service;
import priyanshudev.demo.models.Category;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    Optional<Category> getCategoryById(Long id);
    List<Category> getAll();

}
