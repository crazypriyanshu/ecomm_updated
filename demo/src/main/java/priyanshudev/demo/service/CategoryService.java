package priyanshudev.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    String getAllCategories();
    String getCategoryById();

}
