package priyanshudev.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import priyanshudev.demo.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category save(Category category);
    Optional<Category> findById(Long id);
    List<Category> findAllByIdIn(List<Long> ids);
}
