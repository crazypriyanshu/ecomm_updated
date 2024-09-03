package priyanshudev.demo.service;

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
    Product updateProduct(Long id, ProxyProductDto dto) throws NotFoundException;
    boolean deleteProduct(Long id);
}
