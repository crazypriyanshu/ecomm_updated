package priyanshudev.demo.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import priyanshudev.demo.client.escuelajs.dtos.CreateProxyProductDto;
import priyanshudev.demo.client.escuelajs.dtos.ProxyProductDto;
import priyanshudev.demo.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(CreateProxyProductDto product);
    Optional<Product> findById(Long id);
    List<Product> findAll();

//    @Modifying
//    @Transactional
//    @Query("update Product p set p.name = :#{#dto.name}, p.price = :#{#dto.price}, p.description = :#{#dto.description} WHERE p.id = :id")
//    Product updateProduct(@Param("id") Long id, @Param("dto") ProxyProductDto dto);
//
//    @Modifying
//    @Query("delete from Product p where p.Id = :id")
//    void deleteById(Long id);
}
