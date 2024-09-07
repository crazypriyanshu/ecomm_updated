package priyanshudev.demo.models;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priyanshudev.demo.controllers.ProductController;
import priyanshudev.demo.dtos.CreateProductDto;
import priyanshudev.demo.exceptions.NotFoundException;
import priyanshudev.demo.service.ProductService;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductTest {
    @Autowired
    ProductController productController;
    @Autowired
    ProductService productService;

    @Test
    void getTitle() {
    }

    @Test
    void getAllProductsShouldReturnListAndGetThePrice() throws NotFoundException {
        List<Product> products = productService.getAllProducts();
        assert products.get(0).getPrice() == 11.0;
        assert products.get(0).getTitle().equals("Computer");

    }

    @Test
    void addAProduct() throws NotFoundException {
        CreateProductDto createProductDto = new CreateProductDto();
        createProductDto.setTitle("BrandNewProduct");
        createProductDto.setDescription(" Testing the product description baked at"+ LocalTime.now());
        createProductDto.setPrice(12.00);
        createProductDto.setImages("https://abcd.com/1/qw/22");

        Product newProduct = productService.addNewProduct(createProductDto);
        String description = newProduct.getDescription();
        Long id = newProduct.getId();
        assertTrue (newProduct.getDescription() instanceof String, "Newly created product has an instance of string");

      // delete the created one
        System.out.println("Deleting product id and description "+ description + id);
        productService.deleteById(id);
        assertThrows(NotFoundException.class, () -> {
            productService.getSingleProduct(id);
        }, " verifying the product is empty after deletion");

    }

    @Test
    void setTitle() {
    }

    @Test
    void setPrice() {
    }

    @Test
    void verifyDatatypes() throws NotFoundException {
        Optional<Product> product = productService.getSingleProduct(1L);
        assert product.isPresent() : "Product should be present";
        Product actualProduct = product.get();
        assertTrue(actualProduct.getDescription() instanceof String, "Description is a string value");
        assertTrue(actualProduct.getPrice() instanceof Double, "Price is a double or not");
        assertTrue(actualProduct.getTitle() instanceof String, "Title is a String value");
        assertTrue(actualProduct.getCreatedAt() == null, "Creation Date can be null");
        // Check if the category is not null before accessing it
        if (actualProduct.getCategory() != null) {
            // Verify that the category name is of type String
            assertTrue(actualProduct.getCategory().getName() instanceof String, "Category name should be of type String");
        } else {
            // If category is null, handle accordingly (e.g., log a message or throw an exception)
            System.out.println("Category is null for this product.");
        }
    }
}