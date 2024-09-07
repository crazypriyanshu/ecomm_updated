package priyanshudev.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import priyanshudev.demo.exceptions.NotFoundException;
import priyanshudev.demo.models.Product;
import priyanshudev.demo.repositories.ProductRepository;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductMainImplTest {
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private ProductService productService = new ProductMainServiceImpl();
    @Mock
    private ProductRepository productRepository;

    @Test
    public void givenMockingIsDoneByMockito_whenGetEntityIsCalled() throws NotFoundException {
        Product product = new Product();
        product.setTitle("Test Product 1");
        product.setId(221L);
        product.setDescription("Test product description");

        //using lenient when
        Mockito.lenient().when(restTemplate.getForEntity("localhost:8080/products/1", Product.class))
                .thenReturn(new ResponseEntity(product, HttpStatus.OK));
        Mockito.when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        Optional<Product> p = productService.getSingleProduct(221L);
        Assertions.assertTrue(p.isPresent());
        Assertions.assertEquals(product, p.get());
    }
}