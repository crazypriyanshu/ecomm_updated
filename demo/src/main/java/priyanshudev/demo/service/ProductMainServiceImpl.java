package priyanshudev.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import priyanshudev.demo.client.escuelajs.dtos.CreateProxyProductDto;
import priyanshudev.demo.client.escuelajs.dtos.ProxyProductDto;
import priyanshudev.demo.dtos.CreateProductDto;
import priyanshudev.demo.exceptions.NotFoundException;
import priyanshudev.demo.models.Product;
import priyanshudev.demo.repositories.ProductRepository;
import priyanshudev.demo.utils.CreateProductDtoToProductConverter;

import java.util.List;
import java.util.Optional;

@Primary
@Service(value = "selfProductService")
public class ProductMainServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CreateProductDtoToProductConverter productConverter;

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
    public Product addNewProduct(CreateProductDto productDto) throws NotFoundException {
        Product product = productConverter.convertToProduct(productDto);
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        try {
            productRepository.deleteById(id);
        }
        catch (Exception e) {
            throw new NotFoundException("Something is wrong and while deleting product with id: "+ id);
        }

    }

    public List<Product> productWithCategory() {
        return productRepository.productWithCategory();
    }
}
