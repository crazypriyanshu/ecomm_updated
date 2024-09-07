package priyanshudev.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import priyanshudev.demo.exceptions.NotFoundException;
import priyanshudev.demo.models.Product;
import priyanshudev.demo.repositories.ProductRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductMainServiceImplTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductMainServiceImpl productService;

    @Spy
    private ProductService productServiceSpy;

    @Captor
    ArgumentCaptor<Long> captor;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getSingleProduct() throws NotFoundException {
        // arrange : setup mock behaviour
        Product mockProduct = new Product();
        mockProduct.setTitle("Mocked Product");
        mockProduct.setPrice(22.00);
        mockProduct.setDescription("Setting a description");
        mockProduct.setId(121L);

        when(productRepository.findById(121L)).thenReturn(Optional.of(mockProduct));
        // act : call the method to be tested
        Optional<Product> product = productService.getSingleProduct(121L);
        // assert : verify that method behaves as expected
        assertNotNull(product);
        assertEquals("Mocked Product", product.get().getTitle());
    }

    @Test
    void testGetProductByIdNotFound() {
        // arrange: setup mock behaviour
        when(productRepository.findById(999L)).thenReturn(Optional.empty());

        // assert and act: check method throws not found exception
        assertThrows(NotFoundException.class, () -> {
            productService.getSingleProduct(999L);
        });
    }

    @Test
    void testGetProductById_ProductFound_Verify() throws NotFoundException {
        Product mockProduct = new Product();
        mockProduct.setTitle("Mocked Product1");
        mockProduct.setPrice(222.00);
        mockProduct.setDescription("Setting a description1");
        mockProduct.setId(111L);
        when(productRepository.findById(111L)).thenReturn(Optional.of(mockProduct));
        // act
        productService.getSingleProduct(111L);
        // Verify that the repository's findById method was called once with the argument 111L
        verify(productRepository, times(1)).findById(111L);
    }

    @Test
    void testSpyOnProductService() throws NotFoundException {
        Product product = new Product();
        product.setTitle("Spied Product11");
        product.setPrice(222.00);
        product.setDescription("Setting a description11");
        product.setId(101L);
        when(productServiceSpy.getSingleProduct(101L)).thenReturn(Optional.of(product));
        Optional<Product> result = productServiceSpy.getSingleProduct(101L);
        assertEquals("Spied Product11", result.get().getTitle());
    }

    @Test
    void testArgumentCaptor() throws NotFoundException {
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(new Product()));
        productService.getSingleProduct(1L);
        verify(productRepository).findById(captor.capture());
        assertEquals(1L, captor.getValue());
    }


}