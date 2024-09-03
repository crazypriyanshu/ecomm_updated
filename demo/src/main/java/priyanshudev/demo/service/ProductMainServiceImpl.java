package priyanshudev.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import priyanshudev.demo.client.escuelajs.dtos.CreateProxyProductDto;
import priyanshudev.demo.client.escuelajs.dtos.ProxyProductDto;
import priyanshudev.demo.exceptions.NotFoundException;
import priyanshudev.demo.models.Product;
import priyanshudev.demo.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductMainServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> getSingleProduct(Long id) throws NotFoundException {
        Optional<Product> products = productRepository.findById(id);
        if(products.isEmpty()) {
            throw new NotFoundException("Can't fetch product as Id is invalid: "+id);
        }
        return products;
    }

    @Override
    public List<Product> getAllProducts() throws NotFoundException {
        return productRepository.findAll();
    }

    @Override
    public Product addNewProduct(CreateProxyProductDto productDto) throws NotFoundException {
        return productRepository.save(productDto);
    }

//    @Override
//    public Product updateProduct(Long id, ProxyProductDto dto) throws NotFoundException {
//        return productRepository.updateProduct(id, dto);
//    }

//    @Override
//    public void deleteById(Long id) {
//        deleteProductById(id);
//    }
//
//    public void deleteProductById(Long id) {
//        productRepository.deleteById(id);
//        return;
//    }
}
