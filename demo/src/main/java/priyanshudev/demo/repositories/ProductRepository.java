package priyanshudev.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import priyanshudev.demo.models.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    Optional<Product> findById(Long id);
}
