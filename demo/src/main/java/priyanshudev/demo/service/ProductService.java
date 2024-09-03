package priyanshudev.demo.service;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import priyanshudev.demo.client.escuelajs.dtos.CreateProxyProductDto;
import priyanshudev.demo.client.escuelajs.dtos.ProxyProductDto;
import priyanshudev.demo.exceptions.NotFoundException;
import priyanshudev.demo.models.Product;

import java.util.List;
import java.util.Optional;
@Service
public interface ProductService {
    Optional<Product> getSingleProduct(Long id) throws NotFoundException;
    List<Product> getAllProducts() throws NotFoundException;
    Product addNewProduct(CreateProxyProductDto productDto) throws NotFoundException;
//    @Modifying
//    @Transactional
//    @Query("update Product p set p.name = :#{#dto.title}, p.price =:#{#dto.price}, p.description = :#{#dto.description} where p.id = :id")
//    Product updateProduct(@Param("id") Long id,@Param("dto") ProxyProductDto dto) throws NotFoundException;
//    void deleteById(Long id);

}
