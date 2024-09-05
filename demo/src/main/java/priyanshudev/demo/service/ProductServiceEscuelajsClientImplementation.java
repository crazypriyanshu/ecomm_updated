package priyanshudev.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import priyanshudev.demo.client.escuelajs.dtos.CreateProxyProductDto;
import priyanshudev.demo.client.escuelajs.dtos.ProxyProductDto;
import priyanshudev.demo.client.escuelajs.helper.ConvertProxyProductDtoToProduct;
import priyanshudev.demo.client.escuelajs.service.Client;
import priyanshudev.demo.dtos.CreateProductDto;
import priyanshudev.demo.exceptions.NotFoundException;
import priyanshudev.demo.models.Product;
import priyanshudev.demo.utils.CreateProductDtoToProductConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "fakeProductService")
public class ProductServiceEscuelajsClientImplementation implements ProductService {
    private RestTemplateBuilder restTemplateBuilder;
    private Client sourceClient;
    @Autowired
    private ConvertProxyProductDtoToProduct convertProxyProductDtoToProduct;
    @Autowired
    private CreateProductDtoToProductConverter productConverter;

    @Override
    public Optional<Product> getSingleProduct(Long id) throws NotFoundException {
        ProxyProductDto productDto = null;
        try {
            productDto = sourceClient.getSingLeProduct(id);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RestClientException(e.getMessage());
        }
        if (productDto == null) {
            return Optional.empty();
        }
        return Optional.of(convertProxyProductDtoToProduct.convertProxyProductToProduct(productDto));
    }

    @Override
    public List<Product> getAllProducts() throws NotFoundException {
        List<ProxyProductDto> response = sourceClient.getAllProducts();
        List<Product> products = new ArrayList<>();
        for(ProxyProductDto productDto: response) {
            products.add(convertProxyProductDtoToProduct.convertProxyProductToProduct(productDto));
        }
        return products;
    }

    @Override
    public Product addNewProduct(CreateProductDto product) throws NotFoundException {
        Product product1 = productConverter.convertToProduct(product);
        ProxyProductDto productDto = sourceClient.addNewProduct(product1);
        return convertProxyProductDtoToProduct.convertProxyProductToProduct(productDto);
    }


    @Override
    public void deleteById(Long id) {
        deleteById(id);
    }

    @Override
    public List<Product> productWithCategory() {
        return null;
    }
}