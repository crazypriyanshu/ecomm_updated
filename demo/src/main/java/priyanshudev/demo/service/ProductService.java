package priyanshudev.demo.service;

import org.springframework.stereotype.Service;
import priyanshudev.demo.dtos.CreateProductDto;
import priyanshudev.demo.exceptions.NotFoundException;
import priyanshudev.demo.models.Product;

import java.util.List;
import java.util.Optional;
@Service
public interface ProductService {
    Optional<Product> getSingleProduct(Long id) throws NotFoundException;
    List<Product> getAllProducts() throws NotFoundException;
    Product addNewProduct(CreateProductDto productDto) throws NotFoundException;
    void deleteById(Long id) throws NotFoundException;
    List<Product> productWithCategory();

}
